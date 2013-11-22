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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.ConfigConstant;
import com.shishuo.cms.dao.FolderDao;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.FolderVo;
import com.shishuo.cms.entity.vo.PageVo;

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
	public List<FolderVo> getFolderVoListByFatherIdPage(long fatherId) {
		List<Folder> list = this.getFolderListByFatherId(fatherId);
		List<FolderVo> allList = new ArrayList<FolderVo>();
		for (Folder folder : list) {
			List<Folder> folderList = this.getFolderListByFatherId(folder
					.getFolderId());
			for (Folder f : folderList) {
				FolderVo foderVo = new FolderVo();
				BeanUtils.copyProperties(f, foderVo);
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
	 * @param ename
	 * @param status
	 * @param type
	 * @return Folder
	 */
	public Folder addFolder(long fatherId, String name, int status, String ename,
			int type) {
		Folder folder = new Folder();
		folder.setFatherId(fatherId);
		folder.setEname(ename);
		folder.setName(name);
		folder.setCount(0);
		folder.setStatus(status);
		folder.setType(type);
		folder.setTemplate(ConfigConstant.DEFAUTL_TEMPLATE);
		folder.setSort(1);
		folder.setRank(0);
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
	 * @param ename
	 * @param name
	 * @param status
	 * @param type
	 * @param sort
	 * @return folder
	 */
	public Folder updateFolderById(long folderId, long fatherId, String ename,String name,
			int status, int type, int sort) {
		Folder folder = this.getFolderById(folderId);
		folder.setFatherId(fatherId);
		folder.setEname(ename);
		folder.setName(name);
		folder.setStatus(status);
		folder.setType(type);
		folder.setSort(sort);
		folderDao.updateFolder(folder);
		return folder;
	}

	/**
	 * 通过ename获得目录
	 * @param ename
	 * @return Folder
	 *
	 */
	public Folder getFolderByEname(String ename) {
		Folder folder = folderDao.getFolderByEname(ename);
		return folder;
	}
	
	/**
	 * 获得无参的所有的目录列表
	 * @return List<Folder>
	 *
	 */
	public List<Folder> getAllList(){
		return folderDao.getAllList();
	}
	
	/**
	 * 获得分页的所有目录的列表
	 * @param offset
	 * @param rows
	 * @return List<Folder>
	 *
	 */
	public List<Folder> getAllListPage(long offset, long rows){
		return folderDao.getAllListPage(offset, rows);
	}
	
	/**
	 * 获得所有目录的数量
	 * @return Integer
	 *
	 */
	public int getAllListPageCount(){
		return (int)folderDao.getAllListPageCount();
	}
	
	/**
	 * 获得所有目录的分页
	 * @param Integer
	 * @return PageVo<Folder>
	 *
	 */
	public PageVo<Folder> getAllListPageByNum(int pageNum){
		PageVo<Folder> pageVo = new PageVo<Folder>(pageNum);
		pageVo.setUrl("/CMS/admin/folder/allFolder.do?");
		pageVo.setRows(5);
		List<Folder> list = folderDao.getAllListPage(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getAllListPageCount());
		return pageVo;
	}
	
	public List<FolderVo> getAllFolder(){
		List<FolderVo>  allFolderList = new ArrayList<FolderVo>();
		this.getFolderList(allFolderList,0);
		return allFolderList;
	}
	
	private void getFolderList(List<FolderVo> allFolderList,long fatherId){
		List<FolderVo>  folderList = folderDao.getFolderVoListByFatherId(fatherId);
		Collections.sort(folderList, new ComparatorFolderList());
		for(FolderVo folder:folderList){
			allFolderList.add(folder);
			this.getFolderList(allFolderList,folder.getFolderId());
		}
	}
	
	class ComparatorFolderList implements Comparator<Object>{

		public int compare(Object arg0, Object arg1) {
			FolderVo folderVo1 = (FolderVo)arg0;
			FolderVo folderVo2 = (FolderVo)arg1;
			String str1=folderVo1.getSort()+"";
			String str2=folderVo2.getSort()+"";
			return str1.compareTo(str2);		
		}
	}
	
	public List<FolderVo> getFolderVoListByFatherId(long fatherId){
		return folderDao.getFolderVoListByFatherId(fatherId);
	}
}
