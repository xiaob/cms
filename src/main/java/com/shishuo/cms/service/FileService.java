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

import com.shishuo.cms.constant.CommentConstant;
import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.dao.FileDao;
import com.shishuo.cms.dao.FolderDao;
import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.FileVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.exception.FileNotFoundException;

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

	@Autowired
	private FolderService folderService;
	
	@Autowired
	private FolderDao folderDao;

	@Autowired
	private CommentService commentService;

	// ///////////////////////////////
	// /////       增加        ////////
	// ///////////////////////////////
	
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
	public File addFile(long folderId, long fatherId,long adminId,double size,
			String name,String title, String content,
			SystemConstant.Type type, FileConstant.Status status) {
		File file = new File();
		file.setFolderId(folderId);
		file.setFatherId(fatherId);
		file.setEname("");
		file.setSize(size);
		file.setAdminId(adminId);
		file.setName(name);
		file.setTitle(title);
		file.setContent(content);
		file.setViewCount(0);
		file.setCommentCount(0);
		file.setType(type);
		file.setStatus(status);
		file.setCreateTime(new Date());
		fileDao.addFile(file);
		Folder folder = folderDao.getFolderById(folderId);
		if(folderId != 0){
			folderDao.updateCount(folderId, folder.getCount()+1);
		}
		return file;
	}

	// ///////////////////////////////
	// /////       刪除        ////////
	// ///////////////////////////////
	
	/**
	 * 删除文件
	 * 
	 * @param fileId
	 * @return boolean
	 */
	public boolean deleteFileByFileId(long fileId) {
		return fileDao.deleteFile(fileId,FileConstant.Status.hidden);
	}

	// ///////////////////////////////
	// /////       修改        ////////
	// ///////////////////////////////
	
	/**
	 * 修改文件
	 * 
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
	public File updateFileByFileId(long fileId, long folderId,long fatherId, long adminId,
			String name, String content,String password,String title, String description,
			SystemConstant.Type type, FileConstant.Status status) {
		File file = fileDao.getFileById(fileId);
		file.setFolderId(folderId);
		file.setFatherId(fatherId);
		file.setAdminId(adminId);
		file.setName(name);
		file.setContent(content);
		file.setTitle(title);
		file.setDescription(description);
		file.setPassword(password);
		file.setViewCount(0);
		file.setCommentCount(0);
		file.setType(type);
		file.setStatus(status);
		file.setUpdateTime(new Date());
		fileDao.updateFile(file);
		return file;
	}

	public File updateFileByFileIdAndCreateTime(long fileId, long folderId, long fatherId,long adminId,
			String name, String content,String title, String description, String password,
			SystemConstant.Type type, FileConstant.Status status) {
		File file = fileDao.getFileById(fileId);
		file.setFolderId(folderId);
		file.setFatherId(fatherId);
		file.setAdminId(adminId);
		file.setName(name);
		file.setContent(content);
		file.setTitle(title);
		file.setDescription(description);
		file.setPassword(password);
		file.setViewCount(0);
		file.setCommentCount(0);
		file.setType(type);
		file.setStatus(status);
		file.setCreateTime(new Date());
		fileDao.updateFile(file);
		return file;
	}
	/**
	 * 修改文件的状态
	 * @param fileId
	 * @param status
	 * @return boolean
	 * 
	 */
	public void updateStatusByFileId(long fileId, FileConstant.Status status) {
		fileDao.updateStatusByFileId(fileId,status);
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
	 * @param fileId
	 */
	public void updateCommentCount(long fileId) {
		int commentCount = commentService.getCommentCountByFatherId(fileId, 0,
				CommentConstant.Status.display);
		fileDao.updateCommentCount(fileId, commentCount);
	}

	// ///////////////////////////////
	// /////       查詢        ////////
	// ///////////////////////////////
	
	/**
	 * 得到文件
	 * 
	 * @param fileId
	 * @return File
	 * @throws FileNotFoundException 
	 */

	public FileVo getFileByFileId(long fileId) throws FileNotFoundException {

		FileVo file = fileDao.getFileById(fileId);
		if (file == null) {
			throw new FileNotFoundException(fileId  +" 文件，不存在");
		} else {
			Admin admin = adminService.getAdminById(file.getAdminId());
			if(file.getFolderId()==0){
				Folder folder = new Folder();
				folder.setEname("weifenlei");
				file.setFolder(folder);
			}else{
				file.setFolder(folderDao.getFolderById(file.getFolderId()));
			}
			if(file.getTitle()==null){
				file.setTitle("无");
			}
			if(file.getDescription()==null){
				file.setDescription("无");
			}
			file.setAdmin(admin);
			file.setPhoto(this.getFileListByFatherIdAndType(fileId, SystemConstant.Type.photo));
			file.setFile(this.getFileListByFatherIdAndType(fileId, SystemConstant.Type.file));
			return file;
		}
	}

	/**
	 * 得到目录的显示的文件分页
	 * 
	 * @param folderId
	 * @return pageVo
	 */

	public PageVo<FileVo> getFilePageByFolderId(long folderId, int pageNum,
			SystemConstant.Type type, int rows) {
		PageVo<FileVo> pageVo = new PageVo<FileVo>(pageNum);
		Folder folder = folderService.getFolderById(folderId);
		if (folder == null) {
			pageVo.setUrl(SystemConstant.BASE_PATH + "/?");
		} else {
			pageVo.setUrl(SystemConstant.BASE_PATH + "/" + folder.getEname()
					+ "?");
		}
		pageVo.setRows(rows);
		pageVo.setCount(this.getFileCountByFolderId(folderId,type,FileConstant.Status.display));
		List<FileVo> list = this.getFileListByTypeAndFoderId(folderId,FileConstant.Status.display,type,
				pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		return pageVo;
	}

	/**
	 * 得到目录下的文件
	 * 
	 * @param foderId
	 * @return
	 */

	public List<FileVo> getFileListByTypeAndFoderId(long folderId,FileConstant.Status status,
			SystemConstant.Type type, long offset, long rows) {
		List<FileVo> list = fileDao.getFileListByTypeAndFoderId(type,folderId,status,
				offset, rows);
		for (FileVo file : list) {
			Admin admin = adminService.getAdminById(file.getAdminId());
			Folder folder = folderService.getFolderById(file.getFolderId());
			file.setAdmin(admin);
			file.setFolder(folder);
		}
		return list;
	}
	
	/**
	 * 得到目录的某种文件的数量
	 * 
	 * @param folderId
	 * @param type
	 * @param status
	 * @return Integer
	 */
	public int getFileCountByFolderId(long folderId,SystemConstant.Type type,FileConstant.Status status) {
		return fileDao.getFileCountByTypeAndFoderId(type,folderId,status);
	}
	
	public int getFileCountByFolderId(long folderId) {
		return fileDao.getFileCountByFolderId(folderId);
	}

	/**
	 * 获取某种文件的分页
	 * 
	 * @param type
	 * @param status
	 * @param pageNum
	 * @return PageVo<File>
	 * 
	 */
	public PageVo<FileVo> getAllFileByTypeAndStatusPage(SystemConstant.Type type,
			FileConstant.Status status, int pageNum) {
		PageVo<FileVo> pageVo = new PageVo<FileVo>(pageNum);
		pageVo.setRows(5);
		pageVo.setUrl(SystemConstant.BASE_PATH+"/admin/file/page.htm?status="+status+"&type="+type+"&");
		List<FileVo> list = this.getAllFileByTypeAndStatus(type,
				status, pageVo.getOffset(), pageVo.getRows());
		Folder folder = new Folder();
		folder.setName("weifenlei");
		folder.setEname("weifenlei");
		for(FileVo fileVo :list){
			if(fileVo.getFolderId()==0){
				fileVo.setFolder(folder);
			}else{
				fileVo.setFolder(folderDao.getFolderById(fileVo.getFolderId()));
			}
			if(fileVo.getUpdateTime()!=null){
				fileVo.setCreateTime(fileVo.getUpdateTime());
				fileVo.setTimeType("最后更新");
			}else{
				fileVo.setTimeType("已发布");
			}
		}
		pageVo.setList(list);
		pageVo.setCount(this.getFileCountByTypeAndStatus(type,status));

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
	public List<FileVo> getAllFileByTypeAndStatus(SystemConstant.Type type,
			FileConstant.Status status, long offset, long rows) {
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
	public int getFileCountByType(SystemConstant.Type type) {
		return fileDao.getFileCountByType(type);
	}
	
	/**
	 * 获取不同类型的文件的数量
	 * 
	 * @param type
	 * @param status
	 * @param Integer
	 * 
	 */
	public int getFileCountByTypeAndStatus(SystemConstant.Type type,FileConstant.Status status) {
		return fileDao.getFileCountByTypeAndStatus(type,status);
	}
	
	public List<FileVo> getFileListByStatusNotinHidden(SystemConstant.Type type,long offset,long rows){
		return fileDao.getFileListByStatusNotinHidden(type,FileConstant.Status.hidden, offset, rows);
	}
	
	public int getFileCountByStatusNotinHidden(SystemConstant.Type type){
		return fileDao.getFileCountByStatusNotinHidden(type, FileConstant.Status.hidden);
	}
	
	public PageVo<FileVo> getFilePageByStatusNotinHidden(SystemConstant.Type type,int pageNum){
		PageVo<FileVo> pageVo = new PageVo<FileVo>(pageNum);
		pageVo.setRows(5);
		pageVo.setUrl(SystemConstant.BASE_PATH+"/admin/file/type/page.htm?&type="+type+"&");
		List<FileVo> list = this.getFileListByStatusNotinHidden(type,
				pageVo.getOffset(), pageVo.getRows());
		Folder folder = new Folder();
		folder.setName("weifenlei");
		folder.setEname("weifenlei");
		for(FileVo fileVo :list){
			if(fileVo.getFolderId()==0){
				fileVo.setFolder(folder);
			}else{
				fileVo.setFolder(folderDao.getFolderById(fileVo.getFolderId()));
			}
			if(fileVo.getUpdateTime()!=null){
				fileVo.setCreateTime(fileVo.getUpdateTime());
				fileVo.setTimeType("最后更新");
			}else{
				fileVo.setTimeType("已发布");
			}
		}
		pageVo.setList(list);
		pageVo.setCount(this.getFileCountByStatusNotinHidden(type));
		return pageVo;
	}
	
	public List<File> getFileListByFatherIdAndType(long fatherId,SystemConstant.Type type){
		return fileDao.getFileListByFatherIdAndType(type,fatherId);
	}
	
}
