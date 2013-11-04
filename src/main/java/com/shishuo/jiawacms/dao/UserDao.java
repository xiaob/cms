/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.shishuo.com/jiawacms/licenses
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.jiawacms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shishuo.jiawacms.entity.User;
import com.shishuo.jiawacms.entity.vo.PageVo;

/**
 * 用户服务
 * 
 * @author Herbert
 * 
 */

@Repository
public interface UserDao {

	/**
	 * 增加用户
	 * 
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 根据Id得到用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserById(@Param("userId") long userId);
	
	/**
	 * 得到所有用户数据
	 * 
	 * @return
	 */
	public List<User> getUserList(@Param("offset") long offset,@Param("rows") long rows);
	
	/**
	 * 得到用户数量
	 * 
	 * @param userId
	 */
	public int getUserListCount();
	
	/**
	 * 删除用户
	 * 
	 * @param userId
	 */
	public int deleteUserById(User user);
	
	/**
	 * 更新用户数据
	 * 
	 * @param userId
	 */
	public int updateUser(User user);
	
}
