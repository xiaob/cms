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
package com.shishuo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shishuo.cms.entity.File;

/**
 * 文件服务
 * 
 * @author Harbored
 * 
 */

@Repository
public interface FileDao {

	/**
	 * 得到文件
	 * 
	 * @param fileId
	 * @return File
	 */
	public File getFileById(@Param("fileId") long fileId);

	/**
	 * 得到目录的所有文件
	 * 
	 * @param foderId
	 * @return List<File>
	 */
	public List<File> getFileListByFoderId(@Param("folderId") long folderId,
			@Param("offset") long offset, @Param("rows") long rows);

	/**
	 * 得到目录的所有文件的数量
	 * 
	 * @param foderId
	 * @return Integer
	 */
	public int getFileListByFoderIdCount(@Param("folderId") long folderId);

	/**
	 * 增加文件
	 * 
	 * @return Integer
	 */
	public int addFile(File file);

	/**
	 * 删除文件
	 * 
	 * @return boolean
	 */
	public boolean deleteFile(File file);

	/**
	 * 修改文件
	 * 
	 * @param file
	 * @return Integer
	 */
	public int updateFile(File file);

	public File getFolderId(@Param("folderId") long folderId);
	
	public List<File> getAllList(@Param("offset") long offset, @Param("rows") long rows);
	
	public long getAllListCount();
	
	public List<File> getFileListByType(@Param("type") int type,
			@Param("offset") long offset, @Param("rows") long rows);
	
	public long getFileListByTypeCount(@Param("type") int type);
	

	/**
	 * 获取用户图片
	 * @return list
	 */
	public List<File> getUserImageList(@Param("userId") long userId, @Param("type") int type,
			@Param("offset") long offset, @Param("rows") long rows);
	
	/**
	 * 获取用户图片的数量
	 * @return int
	 */
	public int getUserImageCount(@Param("userId") long userId, @Param("type") int type);
	
	
	/**
	 * 修改用户图片
	 * @return int
	 */
	public int  updateImage(@Param("folderId") long folderId, @Param("fileId") long fileId,@Param("userId") long userId);
}
