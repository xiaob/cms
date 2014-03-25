package com.shishuo.cms.plugin;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shishuo.cms.constant.SystemConstant;

/**
 * @author Herbert
 * 
 */
@Service
public class DefaultStoragePlugin implements StoragePlugin {

	@Override
	public boolean save(MultipartFile multipartFile, String path) {
		File file = new File(SystemConstant.SHISHUO_CMS_ROOT + "WEB-INF/upload"
				+ path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			multipartFile.transferTo(file);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
