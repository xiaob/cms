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

import com.shishuo.jiawacms.entity.Folder;

/**
 * 目录服务
<<<<<<< HEAD
 * 
 * @author Harbored
 * 
=======
 * @author Harbored
 *
>>>>>>> refs/remotes/origin/master
 */
@Repository
public interface FolderDao {

	/**
	 * 得到目录
	 * 
	 * @param folderId
	 * @return Folder
	 */
	public Folder getFolderById(@Param("folderId") long folderId);

	/**
	 * 得到所有子目录
	 * 
	 * @param fatherId
	 * @return List<Folder>
	 */
	public List<Folder> getFolderListByFatherId(@Param("fatherId") long fatherId);

	/**
	 * 增加目录
	 * 
	 * @return Integer
	 */
	public int addFolder(Folder folder);

	/**
	 * 删除目录
	 * 
	 * @param folder
	 * @return boolean
	 */
	public boolean deleteFolder(Folder folder);

	/**
	 * 更新目录
	 * 
	 * @param folder
	 * @return Integer
	 */
	public int updateFolder(Folder folder);
}
