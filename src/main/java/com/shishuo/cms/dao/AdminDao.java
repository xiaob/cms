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

import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.entity.vo.AdminVo;

/**
 * 管理员
 * @author Zhangjiale
 */

@Repository
public interface AdminDao {

	/**
	 * 添加管理员
	 * @param Admin
	 * @return Integer
	 *
	 */
	public int addAdmin(Admin admin);

	/**
	 * 获取所有管理员列表
	 * @param offset
	 * @param rows
	 * @return List<Admin>
	 *
	 */
	public List<Admin> getAllList(@Param("offset") long offset,
			@Param("rows") long rows);

	/**
	 * 获取所有管理员的数量
	 * @return Integer
	 *
	 */
	public int getAllListCount();

	/**
	 * 修改管理员资料
	 * @param Adin
	 * @return Integer
	 *
	 */
	public int updateAdmin(Admin admin);

	/**
	 * 删除管理员
	 * @param adminId
	 * @return Integer
	 *
	 */
	public int deleteAdmin(@Param("adminId") long adminId);

	/**
	 * 通过Id获得指定管理员资料
	 * @param adminId
	 * @return Admin
	 */
	public Admin getAdminById(@Param("adminId") long adminId);

	/**
	 * 通过email获得指定的管理员
	 * @param email
	 * @return Admin
	 *
	 */
	public AdminVo getAdminByEmail(@Param("email") String email);
}
