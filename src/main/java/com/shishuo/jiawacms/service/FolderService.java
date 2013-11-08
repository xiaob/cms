
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.jiawacms.dao.FolderDao;
import com.shishuo.jiawacms.entity.Folder;
import com.shishuo.jiawacms.entity.vo.FolderVo;

/**
 * 目录服务
 * @author Zhangjiale
 *
 */
@Service
public class FolderService {
	
	@Autowired
	private FolderDao folderDao;
	
	/**
	 * 得到目录
	 * 
	 * @param folderId
	 * @return Folder
	 */
	public Folder getFolderById(long folderId) {
		return folderDao.getFolderById(folderId);
	}

	/**
	 * 得到所有子目录
	 * 
	 * @param fatherId
	 * @return List<Folder>
	 */
	public List<Folder> getFolderListByFatherId(long fatherId) {
		return folderDao.getFolderListByFatherId(fatherId);
	}

	/**
	 * 得到所有子目录，包括子目录的子目录
	 * 
	 * @param fatherId
	 * @return List<FolderVo>
	 */
	public List<FolderVo> getFolderVoListByFatherId(long fatherId) {
		List<Folder> list = this.getFolderListByFatherId(fatherId);
		List<FolderVo> allList = new ArrayList<FolderVo>();
		for(Folder folder:list){
			List<Folder>  folderList = this.getFolderListByFatherId(folder.getFolderId());
			for(Folder f :folderList){
				FolderVo foderVo = new FolderVo();
				BeanUtils.copyProperties(f, foderVo);;
				allList.add(foderVo);
			}
		}
		return allList;
	}

	/**
	 * 增加目录
	 * 
	 * @param fatherId
	 * @param name
	 * @param count
	 * @param status
	 * @param type
	 * @param login
	 * @param template
	 * @return folder
	 */
	public Folder addFolder(long fatherId,String name,int count,int status,
			int type,int login,String template) {
		Folder folder = new Folder();
		folder.setFatherId(fatherId);
		folder.setName(name);
		folder.setCount(count);
		folder.setStatus(status);
		folder.setType(type);
		folder.setLogin(login);
		folder.setTemplate(template);
		folder.setCreateTime(new Date());
		folderDao.addFolder(folder);
		return folder;
	}

	/**
	 * 删除目录
	 * 
	 * @param folderId
	 * @return boolean
	 */
	public boolean deleteFolderById(long folderId) {
		Folder folder = this.getFolderById(folderId);
		return folderDao.deleteFolder(folder);
	}

	/**
	 * 更新目录
	 * 
	 * @param folderId
	 * @param fatherId
	 * @param name
	 * @param count
	 * @param status
	 * @param type
	 * @param login
	 * @param template
	 * @return folder
	 */
	public Folder updateFolderById(long folderId,long fatherId,String name,int count,
			int status,int type,int login,String template) {
		Folder folder = this.getFolderById(folderId);
		folder.setFatherId(fatherId);
		folder.setName(name);
		folder.setCount(count);
		folder.setStatus(status);
		folder.setType(type);
		folder.setLogin(login);
		folder.setTemplate(template);
		folderDao.updateFolder(folder);
		return folder;
	}
}
