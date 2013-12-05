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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.constant.UserConstant;
import com.shishuo.cms.dao.UserDao;
import com.shishuo.cms.entity.User;
import com.shishuo.cms.entity.vo.PageVo;

/**
 * 用户服务
 * 
 * @author Zhangjiale
 * 
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	// ///////////////////////////////
	// /////       增加                          ////////
	// ///////////////////////////////
	
	/**
	 * 增加用户
	 * 
	 * @param name
	 * @return User
	 */
	public User addUser(String name) {
		User user = new User();
		user.setOpenId(0);
		user.setType(UserConstant.Type.SHISHUO);
		user.setName(name);
		user.setCreateTime(new Date());
		userDao.addUser(user);
		return user;
	}

	// ///////////////////////////////
	// /////       刪除                         ////////
	// ///////////////////////////////
	
	/**
	 * 删除用户
	 * 
	 * @param userId
	 */
	public int deleteUserById(long userId) {
		return userDao.deleteUserById(userId);
	}

	// ///////////////////////////////
	// /////       修改                          ////////
	// ///////////////////////////////
	
	/**
	 * 更新用户数据
	 * 
	 * @param userId
	 * @return user
	 */
	public User updateUser(long userId, long openId,UserConstant.Type type, String name) {
		User user = this.getUserById(userId);
		user.setType(type);
		user.setOpenId(openId);
		user.setName(name);
		userDao.updateUser(user);
		return user;
	}

	// ///////////////////////////////
	// /////       查詢                          ////////
	// ///////////////////////////////
	
	/**
	 * 根据Id得到用户信息
	 * 
	 * @param userId
	 * @return User
	 */
	public User getUserById(long userId) {
		return userDao.getUserById(userId);
	}

	/**
	 * 得到用户数据分页
	 * 
	 * @param pageNum
	 * @return pageVo
	 */
	public PageVo<User> getUserPage(int pageNum) {
		PageVo<User> pageVo = new PageVo<User>(pageNum);
		pageVo.setRows(5);
		pageVo.setUrl(SystemConstant.BASE_PATH+"/admin/user/page?");
		List<User> list = this
				.getUserList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getUserListCount());
		return pageVo;
	}

	/**
	 * 得到所有用户数据
	 * 
	 * @param offset
	 *            ,rows
	 * @return List<User>
	 */
	public List<User> getUserList(long offset, long rows) {
		return userDao.getUserList(offset, rows);
	}

	/**
	 * 所有用户数据的数量
	 * 
	 * @return Integer
	 */
	public int getUserListCount() {
		return userDao.getUserListCount();
	}
}
