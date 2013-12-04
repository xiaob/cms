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

import com.shishuo.cms.constant.FolderConstant;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.FolderVo;

/**
 * 目录服务
 * 
 * @author Harbored
 * 
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

	/**
	 * 通过ename获得指定目录
	 * @param ename
	 * @return Folder
	 */
	public Folder getFolderByEname(String ename);
	
	/**
	 * 得到所有目录的列表
	 *@return List<Folder>
	 */
	public List<Folder> getAllList();
	
	/**
	 * 得到所有目录的列表的分页
	 *@return List<Folder>
	 */
	public List<Folder> getAllListPage(@Param("offset") long offset,@Param("rows") long rows);
	
	/**
	 * 得到所有目录的数量
	 * @return Integer
	 *
	 */
	public long getAllListPageCount();
	
	/**
	 * 得到fatherId下的所有子目录包括子目录的子目录
	 * @param fatherId
	 * @return List<FolderVo>
	 */
	public List<FolderVo> getFolderVoListByFatherId(@Param("fatherId") long fatherId);
	
	public int updateSort(@Param("folderId") long folderId,@Param("sort") int sort);
	
	public int updatePath(@Param("folderId") long folderId,@Param("path") String path);
	
	public List<FolderVo> getAllFolderByType(@Param("type") FolderConstant.Type type);
	
}
