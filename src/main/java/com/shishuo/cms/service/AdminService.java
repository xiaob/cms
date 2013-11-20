package com.shishuo.cms.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.AdminConstant;
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.dao.AdminDao;
import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.exception.AdminLoginException;
import com.shishuo.cms.exception.AuthException;
import com.shishuo.cms.util.AuthUtils;

/**
 * 管理员
 * 
 * @author Administrator
 * 
 */
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public Admin addAdmin(String email, String name, String password)
			throws AuthException {
		Admin admin = new Admin();
		admin.setName(name);
		admin.setStatus(AdminConstant.STATUS_INIT);
		admin.setCreateTime(new Date());
		admin.setPassword(AuthUtils.getPassword(password, email, admin
				.getCreateTime().getTime() + ""));
		adminDao.addAdmin(admin);
		return admin;
	}

	public void adminLogin(String email, String password,
			HttpServletRequest request) throws AuthException {
		Admin admin = adminDao.getAdminByEmail(email);
		if (admin == null) {
			throw new AuthException("没有此用户");
		}
		String loginPassword = AuthUtils.getPassword(password, email, admin
				.getCreateTime().getTime() + "");
		if (loginPassword.equals(admin.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute(SystemConstant.SESSION_ADMIN_ID,
					admin.getAdminId());
		} else {
			throw new AuthException("密码不正确");
		}
	}

	public Admin getAdminById(long adminId) {
		return adminDao.getAdminById(adminId);
	}

	public List<Admin> getAllList(long offset, long rows) {
		return adminDao.getAllList(offset, rows);
	}

	public int getAllListCount() {
		return (int) adminDao.getAllListCount();
	}

	public PageVo<Admin> getAllListPage(int pageNum) {
		PageVo<Admin> pageVo = new PageVo<Admin>(pageNum);
		pageVo.setRows(5);
		pageVo.setUrl("/CMS/admin/admin/allList.do?");
		List<Admin> list = this
				.getAllList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getAllListCount());
		return pageVo;
	}

	public Admin updateAdmin(long adminId, String name, String password,
			int status) {
		Admin admin = this.getAdminById(adminId);
		admin.setName(name);
		admin.setPassword(password);
		admin.setStatus(status);
		adminDao.updateAdmin(admin);
		return admin;
	}

	public int deleteAdmin(long adminId) {
		return adminDao.deleteAdmin(adminId);
	}
}
