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

import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.FileVo;

/**
 * 文件服务
 * 
 * @author Harbored
 * 
 */
@Repository
public interface FileDao {

	// ///////////////////////////////
	// /////       增加                          ////////
	// ///////////////////////////////
	
	/**
	 * 增加文件
	 * 
	 * @return Integer
	 */
	public int addFile(File file);

	// ///////////////////////////////
	// /////       刪除                         ////////
	// ///////////////////////////////
	
	/**
	 * 删除文件
	 * 
	 * @return boolean
	 */
	public boolean deleteFile(@Param("fileId") long fileId,
			@Param("status") FileConstant.Status status);

	// ///////////////////////////////
	// /////       修改                          ////////
	// ///////////////////////////////
	
	/**
	 * 修改文件
	 * 
	 * @param file
	 * @return Integer
	 */
	public int updateFile(File file);

	/**
	 * 放进回收站或者还原
	 * 
	 * @param File
	 * @return Integer
	 */
	public int updateStatusByFileId(@Param("fileId") long fileId,
			@Param("status") FileConstant.Status status);

	/**
	 * 更新浏览人数
	 * 
	 * @param FileId
	 * @param viewCount
	 * @return int
	 */
	public int updateViewCount(@Param("fileId") long fileId,
			@Param("viewCount") int viewCount);

	/**
	 * 更新评论数
	 * 
	 * @param FileId
	 * @param commentCount
	 * @return int
	 */

	public int updateCommentCount(@Param("fileId") long fileId,
			@Param("commentCount") int commentCount);

	// ///////////////////////////////
	// /////       查詢                          ////////
	// ///////////////////////////////
	
	/**
	 * 得到文件
	 * 
	 * @param fileId
	 * @return File
	 */
	public FileVo getFileById(@Param("fileId") long fileId);

	/**
	 * 得到目录的文件的列表
	 * 
	 * @param foderId
	 * @return List<FileVo>
	 */
	public List<FileVo> getFileListByTypeAndFoderId(@Param("type") SystemConstant.Type type,@Param("folderId") long folderId,
			@Param("status") FileConstant.Status status,
			@Param("offset") long offset, @Param("rows") long rows);

	/**
	 * 得到目录的所有文件的数量
	 * 
	 * @param foderId
	 * @return Integer
	 */
	public int getFileCountByTypeAndFoderId(@Param("type")SystemConstant.Type type,@Param("folderId") long folderId,
			@Param("status") FileConstant.Status status);

	
	/**
	 * 得到某种显示的文件的列表
	 * 
	 * @param foderId
	 * @return List<FileVo>
	 */
	public List<FileVo> getFileListByType(@Param("type") SystemConstant.Type type,
			@Param("status") FileConstant.Status status,
			@Param("offset") long offset, @Param("rows") long rows);

	/**
	 * 得到某种文件的数量
	 * 
	 * @param foderId
	 * @return Integer
	 */
	public int getFileCountByType(@Param("type") SystemConstant.Type type);
	
	/**
	 * 得到某个目录下的文件的数量
	 * 
	 * @param foderId
	 * @return Integer
	 */
	public int getFileCountByFolderId(@Param("folderId") long folderId);
	
	public int getFileCountByTypeAndStatus(@Param("type") SystemConstant.Type type,@Param("status") FileConstant.Status status);
	

}
