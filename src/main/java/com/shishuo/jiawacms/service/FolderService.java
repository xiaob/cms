package com.shishuo.jiawacms.service;

import java.util.List;

import com.shishuo.jiawacms.entity.Folder;
import com.shishuo.jiawacms.entity.vo.FolderVo;

/**
 * 目录服务
 * @author Herbert
 *
 */
public class FolderService {
	/**
	 * 得到目录
	 * 
	 * @param folderId
	 * @return
	 */
	public Folder getFolderById(long folderId) {
		return null;
	}

	/**
	 * 得到所有子目录
	 * 
	 * @param fatherId
	 * @return
	 */
	public List<Folder> getFolderListByFatherId(long fatherId) {
		return null;
	}

	/**
	 * 得到所有子目录，包括子目录的子目录
	 * 
	 * @param fatherId
	 * @return
	 */
	public List<FolderVo> getFolderVoListByFatherId(long fatherId) {
		return null;
	}

	/**
	 * 增加目录
	 * 
	 * @return
	 */
	public Folder addFolder() {
		return null;
	}

	/**
	 * 删除目录
	 * 
	 * @param folderId
	 * @return
	 */
	public boolean deleteFolderById(long folderId) {
		return false;
	}

	/**
	 * 更新目录
	 * 
	 * @param folderId
	 * @return
	 */
	public Folder updateFolderById(long folderId) {
		return null;
	}
}
