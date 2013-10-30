package com.shishuo.jiawacms.service;

import com.shishuo.jiawacms.entity.File;
import com.shishuo.jiawacms.entity.vo.PageVo;

/**
 * 
 * 文件服务
 * @author Herbert
 *
 */
public class FileService {

	/**
	 * 得到目录
	 * 
	 * @param fileId
	 * @return
	 */
	public File getFileById(long fileId) {
		return null;
	}

	/**
	 * 得到目录的所有文件
	 * 
	 * @param foderId
	 * @return
	 */
	public PageVo<File> getFilePageByFoderId(long foderId) {
		return null;
	}

	/**
	 * 增加文件
	 * 
	 * @return
	 */
	public File addFile() {
		return null;
	}

	/**
	 * 删除文件
	 * 
	 * @param fileId
	 * @return
	 */
	public boolean deleteFileById(long fileId) {
		return false;
	}

	/**
	 * 更新文件
	 * 
	 * @param fileId
	 * @return
	 */
	public File updateFileById(long fileId) {
		return null;
	}
}
