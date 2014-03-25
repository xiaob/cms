package com.shishuo.cms.plugin;

import org.springframework.web.multipart.MultipartFile;

/**
 * 仓库插件
 * 
 * @author Herbert
 * 
 */
public interface StoragePlugin {

	/**
	 * 存储文件
	 * 
	 * @param multipartFile
	 *            文件信息
	 * @param path
	 *            文件路径
	 * @return
	 */
	public boolean save(MultipartFile multipartFile, String path);
}
