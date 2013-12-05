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
package com.shishuo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shishuo.cms.entity.User;

/**
 * 用户服务
 * 
 * @author Zhang jiale
 * 
 */

@Repository
public interface UserDao {

	// ///////////////////////////////
	// /////       增加                          ////////
	// ///////////////////////////////
	
	/**
	 * 增加用户
	 * 
	 * @param User
	 * @return Integer
	 */
	public int addUser(User user);

	// ///////////////////////////////
	// /////       刪除                         ////////
	// ///////////////////////////////
	
	/**
	 * 删除用户
	 * 
	 * @param User
	 * @return Integer
	 */
	public int deleteUserById(@Param("userId") long userId);

	// ///////////////////////////////
	// /////       修改                          ////////
	// ///////////////////////////////
	
	/**
	 * 更新用户数据
	 * 
	 * @param userId
	 * @return Integer
	 */
	public int updateUser(User user);

	// ///////////////////////////////
	// /////       查詢                          ////////
	// ///////////////////////////////
	
	/**
	 * 根据Id得到用户信息
	 * 
	 * @param userId
	 * @return User
	 */
	public User getUserById(@Param("userId") long userId);

	/**
	 * 得到用户数据的列表
	 * 
	 * @param long,long
	 * @return List<User>
	 */
	public List<User> getUserList(@Param("offset") long offset,
			@Param("rows") long rows);

	/**
	 * 得到用户数量
	 * 
	 * @param userId
	 * @return Integer
	 */
	public int getUserListCount();

}
