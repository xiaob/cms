/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
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
		return adminDao.getAllListCount();
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
