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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.constant.FolderConstant;
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.dao.FolderDao;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.FolderVo;
import com.shishuo.cms.exception.FolderNotFoundException;

/**
 * 目录服务
 * 
 * @author Zhangjiale
 * 
 */
@Service
public class FolderService {

	@Autowired
	private FolderDao folderDao;

	// ///////////////////////////////
	// /////       增加                          ////////
	// ///////////////////////////////
	
	/**
	 * 增加目录
	 * 
	 * @param fatherId
	 * @param name
	 * @param ename
	 * @param status
	 * @param type
	 * @return Folder
	 */
	public Folder addFolder(long fatherId, String name,
			FolderConstant.Status status, String ename,
			SystemConstant.Type type, FolderConstant.Rank rank) {
		Folder folder = new Folder();
		Folder fatherFolder = this.getFolderById(fatherId);
		folder.setFatherId(fatherId);
		if (fatherId == 0) {
			folder.setLevel(1);
		} else {
			folder.setLevel(fatherFolder.getLevel() + 1);
		}
		folder.setEname(ename.trim());
		folder.setName(name);
		folder.setPath("");
		folder.setCount(0);
		folder.setStatus(status);
		folder.setType(type);
		folder.setSort(1);
		folder.setRank(rank);
		folder.setCreateTime(new Date());
		folderDao.addFolder(folder);
		if(fatherId==0){
			this.updatePath(folder.getFolderId(), folder.getFolderId()+"");
		}else{
			this.updatePath(folder.getFolderId(), fatherFolder.getPath()+"#"+folder.getFolderId());
		}
		return folder;
	}

	// ///////////////////////////////
	// /////       刪除                         ////////
	// ///////////////////////////////
	
	/**
	 * 删除目录
	 * 
	 * @param folderId
	 * @return boolean
	 */
	public boolean deleteFolderById(long folderId) {
		return folderDao.deleteFolder(folderId);
	}

	// ///////////////////////////////
	// /////       修改                          ////////
	// ///////////////////////////////
	
	/**
	 * 更新目录
	 * 
	 * @param folderId
	 * @param fatherId
	 * @param ename
	 * @param name
	 * @param status
	 * @param type
	 * @param sort
	 * @return folder
	 */
	public Folder updateFolderById(long folderId, long fatherId, String ename,
			String name, FolderConstant.Status status,
			SystemConstant.Type type, FolderConstant.Rank rank, int sort) {
		Folder folder = this.getFolderById(folderId);
		Folder fatherFolder = this.getFolderById(fatherId);
		if(fatherId==0){
			folder.setPath(folder.getFolderId()+"");
		}else{
			folder.setPath(fatherFolder.getPath()+"#"+folder.getFolderId());
		}
		folder.setFatherId(fatherId);
		folder.setEname(ename);
		folder.setName(name);
		folder.setStatus(status);
		folder.setType(type);
		folder.setRank(rank);
		folder.setSort(sort);
		folderDao.updateFolder(folder);
		return folder;
	}

	/**
	 * 通过指定Id修改其目录的序列
	 * @param folderId
	 * @param sort
	 * @return Integer
	 */
	public int updateSort(long folderId,int sort){
		return folderDao.updateSort(folderId, sort);
	}

	/**
	 * 通过指定Id修改其目录的路径
	 * @param folderId
	 * @param path
	 * @return Integer
	 */
	public int updatePath(long folderId,String path){
		return folderDao.updatePath(folderId, path);
	}
	
	public int updateCount(long folderId, int count){
		return folderDao.updateCount(folderId, count);
	}

	// ///////////////////////////////
	// /////       查詢                          ////////
	// ///////////////////////////////
	
	/**
	 * 得到指定目录
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
	public List<FolderVo> getFolderListByFatherId(long fatherId) {
		return folderDao.getFolderListByFatherId(fatherId);
	}

	/**
	 * 通过ename获得目录
	 * 
	 * @param ename
	 * @return Folder
	 * @throws FolderNotFoundException
	 * 
	 */
	public Folder getFolderByEname(String ename) throws FolderNotFoundException {
		Folder folder = folderDao.getFolderByEname(ename);
		if (folder == null) {
			throw new FolderNotFoundException(ename + " 目录，不存在");
		} else {
			return folder;
		}
	}

	/**
	 * 获得所有目录并通过递归实现目录树
	 * 
	 * @return List<FolderVo>
	 */
	public List<FolderVo> getAllFolder() {
		List<FolderVo> allFolderList = new ArrayList<FolderVo>();
		this.getFolderList(allFolderList, 0);
		return allFolderList;
	}

	/**
	 * 实现目录树的递归方法
	 */
	private void getFolderList(List<FolderVo> allFolderList, long fatherId) {
		List<FolderVo> folderList = folderDao
				.getFolderListByFatherId(fatherId);
		Collections.sort(folderList, new ComparatorFolderList());
		for (FolderVo folder : folderList) {
			allFolderList.add(folder);
			this.getFolderList(allFolderList, folder.getFolderId());
		}
	}

	/**
	 * 获得某种类型的目录集合
	 */
	public List<FolderVo> getAllFolderByType(SystemConstant.Type type){
		return folderDao.getAllFolderByType(type);
	}
	
	/**
	 * 实现同级目录排序的内部类
	 */
	class ComparatorFolderList implements Comparator<Object> {
		public int compare(Object arg0, Object arg1) {
			FolderVo folderVo1 = (FolderVo) arg0;
			FolderVo folderVo2 = (FolderVo) arg1;
			String str1 = folderVo1.getSort() + "";
			String str2 = folderVo2.getSort() + "";
			return str1.compareTo(str2);
		}
	}
	
}
