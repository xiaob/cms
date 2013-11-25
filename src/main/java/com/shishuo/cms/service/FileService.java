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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.dao.FileDao;
import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.User;
import com.shishuo.cms.entity.vo.FileVo;
import com.shishuo.cms.entity.vo.PageVo;

/**
 * 
 * 文件服务
 * 
 * @author Zhangjiale
 * 
 */
@Service
public class FileService {

	@Autowired
	private FileDao fileDao;

	@Autowired
	private AdminService adminService;

	/**
	 * 得到目录
	 * 
	 * @param fileId
	 * @return File
	 */
	public FileVo getFileById(long fileId) {
		FileVo file = fileDao.getFileById(fileId);
		Admin admin = adminService.getAdminById(file.getAdminId());
		file.setAdmin(admin);
		return file;
	}

	/**
	 * 得到目录的所有文件分页
	 * 
	 * @param folderId
	 * @return pageVo
	 */

	public PageVo<FileVo> getFilePageByFoderId(long folderId, int pageNum) {
		PageVo<FileVo> pageVo = new PageVo<FileVo>(pageNum);
		pageVo.setUrl("/CMS/folder/" + folderId + "?");
		pageVo.setRows(1);
		List<FileVo> list = this.getFileListByFoderId(folderId,
				pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getFileListByFoderIdCount(folderId));
		return pageVo;
	}

	/**
	 * 得到目录的所有文件
	 * 
	 * @param foderId
	 * @return
	 */

	public List<FileVo> getFileListByFoderId(long folderId, long offset,
			long rows) {
		List<FileVo> list = fileDao
				.getFileListByFoderId(folderId, offset, rows);
		for (FileVo file : list) {
			Admin admin = adminService.getAdminById(file.getAdminId());
			file.setAdmin(admin);
		}
		return list;
	}

	/**
	 * 得到目录的所有文件的数量
	 * 
	 * @param folderId
	 * @return Integer
	 */
	public int getFileListByFoderIdCount(long folderId) {
		return fileDao.getFileListByFoderIdCount(folderId);
	}

	/**
	 * 增加文件
	 * 
	 * @param folderId
	 * @param adminId
	 * @param picture
	 *            {@link:FileConstant.PICTURE}
	 * @param name
	 * @param content
	 * @param type
	 * @param status
	 * @return
	 */
	public File addFile(long folderId, long adminId,
			FileConstant.Picture picture, String name, String content,
			FileConstant.Type type, FileConstant.Status status) {
		File file = new File();
		file.setFolderId(folderId);
		file.setAdminId(adminId);
		file.setBigPicture(picture);
		file.setSmallPicture(picture);
		file.setName(name);
		file.setContent(content);
		file.setViewCount(0);
		file.setCommentCount(0);
		file.setType(type);
		file.setStatus(status);
		file.setCreateTime(new Date());
		fileDao.addFile(file);
		return file;
	}

	/**
	 * 删除文件
	 * 
	 * @param fileId
	 * @return boolean
	 */
	public boolean deleteFileById(long fileId) {
		File file = fileDao.getFileById(fileId);
		return fileDao.deleteFile(file);
	}

	/**
	 * @param fileId
	 * @param folderId
	 * @param adminId
	 * @param picture
	 * @param name
	 * @param content
	 * @param type
	 * @param status
	 * @return
	 */
	public File updateFileById(long fileId, long folderId, long adminId,
			FileConstant.Picture picture, String name, String content,
			FileConstant.Type type, FileConstant.Status status) {
		File file = fileDao.getFileById(fileId);
		file.setFolderId(folderId);
		file.setAdminId(adminId);
		file.setBigPicture(picture);
		file.setName(name);
		file.setContent(content);
		file.setViewCount(0);
		file.setCommentCount(0);
		file.setType(type);
		file.setStatus(status);
		fileDao.updateFile(file);
		return file;
	}

	/**
	 * 所有文件列表
	 * 
	 * @param offset
	 * @param rows
	 * @return List<File>
	 * 
	 */
	public List<File> getAllList(long offset, long rows) {
		return fileDao.getAllList(offset, rows);
	}

	/**
	 * 获取所有文件的数量
	 * 
	 * @return Integer
	 * 
	 */
	public int getAllListCount() {
		return (int) fileDao.getAllListCount();
	}

	/**
	 * 获取所有文件的分页
	 * 
	 * @param Integer
	 * @return PageVo<File>
	 * 
	 */
	public PageVo<File> getAllListPage(int pageNum) {
		PageVo<File> pageVo = new PageVo<File>(pageNum);
		pageVo.setRows(5);
		pageVo.setUrl("");
		List<File> list = this.getAllList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getAllListCount());
		return pageVo;
	}

	/**
	 * 获取不同文件类型的分页
	 * 
	 * @param type
	 * @param status
	 * @param pageNum
	 * @return PageVo<File>
	 * 
	 */
	public PageVo<File> getFileListByTypePage(int type, int status, int pageNum) {
		PageVo<File> pageVo = new PageVo<File>(pageNum);
		pageVo.setRows(5);
		pageVo.setUrl("");
		List<File> list = this.getFileListByType(type, status,
				pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getFileListByTypeCount(type, status));
		return pageVo;
	}

	/**
	 * 获取不同类型的文件的列表
	 * 
	 * @param type
	 * @param status
	 * @param offset
	 * @param rows
	 * @return List<File>
	 * 
	 */
	public List<File> getFileListByType(int type, int status, long offset,
			long rows) {
		return fileDao.getFileListByType(type, status, offset, rows);
	}

	/**
	 * 获取不同类型的文件的数量
	 * 
	 * @param type
	 * @param status
	 * @param Integer
	 * 
	 */
	public int getFileListByTypeCount(int type, int status) {
		return (int) fileDao.getFileListByTypeCount(type, status);
	}

	/**
	 * 放进回收站或者从回收站中还原
	 * 
	 * @param fileId
	 * @param status
	 * @return boolean
	 * 
	 */
	public boolean recycle(long fileId, int status) {
		boolean result = false;
//		File file = this.getFileById(fileId);
//		file.setStatus(status);
//		fileDao.getRecycle(file);
		result = true;
		return result;
	}

	public List<File> getUserImageList(long userId, int type, long offset,
			long rows) {
		return fileDao.getUserImageList(userId, type, offset, rows);
	}

	public int getUserImageCount(long userId, int type) {
		return fileDao.getUserImageCount(userId, type);
	}

	public PageVo<File> getUserImagePage(long userId, int type, int pageNum) {
		PageVo<File> pageVo = new PageVo<File>(pageNum);
		pageVo.setRows(20);
		pageVo.setUrl("");
		List<File> list = this.getUserImageList(userId, type,
				pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getUserImageCount(userId, type));
		return pageVo;
	}

	public int updateImage(long folderId, long fileId, long userId) {
		return fileDao.updateImage(folderId, fileId, userId);
	}

	/**
	 * 更新浏览人数
	 * 
	 * @param fileId
	 * @param viewCount
	 * 
	 */
	public void updateViewCount(long fileId, int nowViewCount) {
		fileDao.updateViewCount(fileId, nowViewCount + 1);
	}

	/**
	 * 更新评论数
	 * 
	 * @param FileId
	 * @param commentCount
	 * @return void
	 */
	public void updateCommentCount(long fileId, int commentCount) {
		fileDao.updateCommentCount(fileId, commentCount + 1);
	}

}
