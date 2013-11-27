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
import com.shishuo.cms.entity.vo.AdminVo;
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

	/**
	 * 添加管理员
	 * 
	 * @param email
	 * @param name
	 * @param password
	 * @return Admin
	 */
	public Admin addAdmin(String email, String name, String password,
			AdminConstant.Status status) throws AuthException {
		email = email.toLowerCase();
		Admin admin = new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setStatus(status);
		admin.setCreateTime(new Date());
		admin.setPassword(AuthUtils.getPassword(password, email));
		adminDao.addAdmin(admin);
		return admin;
	}

	/**
	 * 管理员登陆
	 * 
	 * @param email
	 * @param password
	 * @param request
	 */
	public void adminLogin(String email, String password,
			HttpServletRequest request) throws AuthException {
		AdminVo admin = adminDao.getAdminByEmail(email);
		if (admin == null) {
			throw new AuthException("没有此用户");
		}
		admin.setFaceUrl(AuthUtils.getFaceUrl(admin.getEmail()));
		String loginPassword = AuthUtils.getPassword(password, email);
		if (loginPassword.equals(admin.getPassword())) {
			HttpSession session = request.getSession();
			admin.setPassword("");
			session.setAttribute(SystemConstant.SESSION_ADMIN, admin);
		} else {
			throw new AuthException("密码不正确");
		}
	}

	/**
	 * 通过Id获得指定管理员资料
	 */
	public Admin getAdminById(long adminId) {
		return adminDao.getAdminById(adminId);
	}

	/**
	 * 获得所有管理员
	 * 
	 * @param offset
	 * @param rows
	 * @return List<Admin>
	 */
	public List<Admin> getAllList(long offset, long rows) {
		return adminDao.getAllList(offset, rows);
	}

	/**
	 * 获得所有管理员的数量
	 * 
	 * @return Integer
	 */
	public int getAllListCount() {
		return adminDao.getAllListCount();
	}

	/**
	 * 获得所有管理员的分页
	 * 
	 * @param Integer
	 * @return PageVo<Admin>
	 */
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

	/**
	 * 修改管理员资料
	 * 
	 * @param adminId
	 * @param name
	 * @param password
	 * @param status
	 * @return Admin
	 * @throws AuthException 
	 */
	public Admin updateAdmin(long adminId, String name, String password,
			AdminConstant.Status status) throws AuthException {
		Admin admin = this.getAdminById(adminId);
		admin.setName(name);
		if(password.equals("")){
			admin.setPassword(AuthUtils.getPassword(password, admin.getEmail()));
		}
		admin.setStatus(status);
		adminDao.updateAdmin(admin);
		return admin;
	}

	/**
	 * 删除管理员
	 * 
	 * @param adminId
	 * @return Integer
	 */
	public int deleteAdmin(long adminId) {
		return adminDao.deleteAdmin(adminId);
	}
}
