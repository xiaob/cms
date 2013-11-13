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
 */package com.shishuo.jiawacms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.jiawacms.dao.FileDao;
import com.shishuo.jiawacms.entity.File;
import com.shishuo.jiawacms.entity.vo.PageVo;

/**
 * 
 * 文件服务
 * 
 * @author Zhangjiale
 * 
 */
@Service
public class FileService {

	/**
	 * 得到目录
	 * 
	 * @param fileId
	 * @return
	 */
	@Autowired
	private FileDao fileDao;

	public File getFileById(long fileId) {
		return fileDao.getFileById(fileId);
	}

	/**
	 * 得到目录的所有文件分页
	 * 
	 * @param folderId
	 * @return pageVo
	 */

	public PageVo<File> getFilePageByFoderId(long folderId, int pageNum) {
		PageVo<File> pageVo = new PageVo<File>(pageNum);
		pageVo.setUrl("filePage.do?");
		List<File> list = this.getFileListByFoderId(folderId,
				pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setPageCount(this.getFileListByFoderIdCount(folderId));
		return pageVo;
	}

	/**
	 * 得到目录的所有文件
	 * 
	 * @param foderId
	 * @return
	 */

	public List<File> getFileListByFoderId(long folderId, long offset, long rows) {
		return fileDao.getFileListByFoderId(folderId, offset, rows);
	}

	/**
	 * 得到目录的所有文件的数量
	 * 
	 * @return Integer
	 */
	public int getFileListByFoderIdCount(long folderId) {
		return fileDao.getFileListByFoderIdCount(folderId);
	}

	/**
	 * 增加文件
	 * 
	 * @return Integer
	 */

	public File addFile(long folderId, String name, String url, String images,
			String description, int type) {
		File file = new File();
		file.setFolderId(folderId);
		file.setName(name);
		file.setUrl(url);
		file.setImages(images);
		file.setDescription(description);
		file.setType(type);
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
	 * 更新文件
	 * 
	 * @param fileId
	 * @return file
	 */
	public File updateFileById(long fileId, long folderId, String name,
			String url, String images, String description, int type) {
		File file = fileDao.getFileById(fileId);
		file.setFolderId(folderId);
		file.setName(name);
		file.setUrl(url);
		file.setImages(images);
		file.setDescription(description);
		file.setType(type);
		fileDao.updateFile(file);
		return file;
	}
	
	public File getFolderId(long folderId){
		return fileDao.getFolderId(folderId);
	}
}
