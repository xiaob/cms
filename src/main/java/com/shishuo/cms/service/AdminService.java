package com.shishuo.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.dao.AdminDao;
import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.entity.vo.PageVo;

/**
 * 管理员
 * @author Administrator
 *
 */
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public Admin addAdmin(String name,String password,int status){
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);
		admin.setStatus(status);
		admin.setCreateTime(new Date());
		adminDao.addAdmin(admin);
		return admin;
	}
	
	public Admin getAdminById(long adminId){
		return adminDao.getAdminById(adminId);
	}
	
	public List<Admin> getAllList(long offset,long rows){
		return adminDao.getAllList(offset, rows);
	}
	
	public int getAllListCount(){
		return (int)adminDao.getAllListCount();
	}
	
	public PageVo<Admin> getAllListPage(int pageNum){
		PageVo<Admin> pageVo = new PageVo<Admin>(pageNum);
		pageVo.setRows(5);
		pageVo.setUrl("/CMS/admin/admin/allList.do?");
		List<Admin> list = this.getAllList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getAllListCount());
		return pageVo;
	}
	
	public Admin updateAdmin(long adminId,String name,String password,
			int status){
		Admin admin = this.getAdminById(adminId);
		admin.setName(name);
		admin.setPassword(password);
		admin.setStatus(status);
		adminDao.updateAdmin(admin);
		return admin;
	}
	
	public int deleteAdmin(long adminId){
		return adminDao.deleteAdmin(adminId);
	}
}
