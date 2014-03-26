package com.shishuo.cms.plugin;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.shishuo.cms.exception.UploadException;

/**
 * 仓库插件
 * 
 * @author Herbert
 * 
 */
public abstract class StoragePlugin extends ApplicationObjectSupport implements
		Plugin {
	private static String storagePlugin = "defaultStoragePlugin";

	public StoragePlugin getStoragePlugin() {
		return (StoragePlugin) this.getApplicationContext().getBean(
				storagePlugin);
	}

	/**
	 * 存储文件
	 * 
	 * @param multipartFile
	 *            文件信息
	 * @return
	 */
	public abstract String save(MultipartFile multipartFile)throws UploadException ;
}
