/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.shishuo.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shishuo.cms.constant.FolderConstant;
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

	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private FolderDao folderDao;

	// ///////////////////////////////
	// ///// 增加 ////////
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
	 * @throws FolderNotFoundException
	 */
	@CacheEvict(value = "folder", allEntries = true)
	@Transactional
	public Folder addFolder(long fatherId, String name,
			FolderConstant.Status status, String ename,
			FolderConstant.Rank rank, FolderConstant.Type type)
			throws FolderNotFoundException {
		Folder folder = new Folder();
		folder.setFatherId(fatherId);
		if (fatherId == 0) {
			folder.setLevel(1);
		} else {
			Folder fatherFolder = this.getFolderById(fatherId);
			folder.setLevel(fatherFolder.getLevel() + 1);
		}
		folder.setEname(ename.trim());
		folder.setName(name);
		folder.setPath("");
		folder.setCount(0);
		folder.setStatus(status);
		folder.setSort(1);
		folder.setRank(rank);
		folder.setType(type);
		folder.setContent("");
		folder.setCreateTime(new Date());
		folder.setOwner(FolderConstant.Owner.app);
		folderDao.addFolder(folder);
		if (fatherId == 0) {
			this.updatePath(folder.getFolderId(), folder.getFolderId() + "");
		} else {
			Folder fatherFolder = this.getFolderById(fatherId);
			this.updatePath(folder.getFolderId(), fatherFolder.getPath() + "#"
					+ folder.getFolderId());
		}
		return folder;
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除目录
	 * 
	 * @param folderId
	 * @return boolean
	 */
	@CacheEvict(value = "folder", allEntries = true)
	public boolean deleteFolderById(long folderId) {
		return folderDao.deleteFolder(folderId);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
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
	@CacheEvict(value = "folder", allEntries = true)
	public void updateFolderById(long folderId, String ename, String name,String content) {
		folderDao.updateFolder(folderId, name, ename, content);
	}

	/**
	 * 通过指定Id修改其目录的序列
	 * 
	 * @param folderId
	 * @param sort
	 * @return Integer
	 */
	@CacheEvict(value = "folder", allEntries = true)
	public int updateSort(long folderId, int sort) {
		return folderDao.updateSort(folderId, sort);
	}

	/**
	 * 通过指定Id修改其目录的路径
	 * 
	 * @param folderId
	 * @param path
	 * @return Integer
	 */
	public int updatePath(long folderId, String path) {
		return folderDao.updatePath(folderId, path);
	}

	/**
	 * @param folderId
	 * @param count
	 * @return
	 */
	public int updateCount(long folderId, int count) {
		return folderDao.updateCount(folderId, count);
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到指定目录
	 * 
	 * @param folderId
	 * @return Folder
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "folder", key = "'getFolderById_'+#folderId")
	public FolderVo getFolderById(long folderId) throws FolderNotFoundException {
		FolderVo folder = folderDao.getFolderById(folderId);
		if (folder == null) {
			throw new FolderNotFoundException("");
		} else {
			return folder;
		}
	}

	/**
	 * 得到所有子目录
	 * 
	 * @param fatherId
	 * @return List<Folder>
	 */
	public List<Folder> getFolderListByFatherId(long fatherId,
			FolderConstant.Status status) {
		return folderDao.getFolderListByFatherId(fatherId, status);
	}

	/**
	 * 通过ename和fatherId获得目录
	 * 
	 * @param ename
	 * @param fatherId
	 * @return
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "folder", key = "'getFolderByEnameAndFatherId_'+#ename+'_'+#fatherId")
	public Folder getFolderByEnameAndFatherId(String ename, long fatherId)
			throws FolderNotFoundException {
		Folder folder = folderDao
				.getFolderByEnameAndFatherId(ename, fatherId);
		if (folder == null) {
			throw new FolderNotFoundException(ename + " 目录，不存在");
		} else {
			return folder;
		}
	}

	/**
	 * 得到目录的Path
	 * 
	 * @param folderId
	 * @return
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "folder", key = "'getFolderPathListByFolderId_'+#folderId")
	public List<Folder> getFolderPathListByFolderId(long folderId)
			throws FolderNotFoundException {
		List<Folder> list = new ArrayList<Folder>();
		if (folderId == 0) {
			return list;
		} else {
			Folder folder = this.getFolderById(folderId);
			String[] str = folder.getPath().split("#");
			for (int i = 0; i < folder.getLevel(); i++) {
				Folder fold = this.getFolderById(Long.parseLong(str[i]));
				list.add(fold);
			}
			return list;
		}
	}

	@CacheEvict(value = "folder", allEntries = true)
	public void updateType(long folderId, FolderConstant.Type type) {
		folderDao.updateType(folderId, type);
	}

	@CacheEvict(value = "folder", allEntries = true)
	public void updateStatus(long folderId, FolderConstant.Status status) {
		folderDao.updateStatus(folderId, status);
	}

}
