package com.shishuo.cms.plugin;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.exception.UploadException;
import com.shishuo.cms.util.AttachmentUtils;

/**
 * @author Herbert
 * 
 * 
 */
@Service
public class DefaultStoragePlugin extends StoragePlugin {

	@Override
	public String save(MultipartFile multipartFile) throws UploadException {
		String path = AttachmentUtils.getPath(multipartFile.getOriginalFilename());
		File file = new File(SystemConstant.SHISHUO_CMS_ROOT + "WEB-INF/"
				+ path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			multipartFile.transferTo(file);
			return path;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadException(path);
		}
	}

	@Override
	public void init() throws Exception {
		
	}

}
