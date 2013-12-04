package com.shishuo.cms.util;

import org.springframework.web.multipart.MultipartFile;

import com.shishuo.cms.constant.UploadConstant;

public class UploadUtils {

	public static boolean checkUploadFile(MultipartFile file,UploadConstant.Type type) {
		if (file.isEmpty()) {
			return false;
		}
		switch (type) {
		case photo:
			if (file.getContentType().equals("image/jpg")
					|| file.getContentType().equals("image/png")
					|| file.getContentType().equals("image/jpeg")
					|| file.getContentType().equals("image/gif")) {
				return true;
			} else {
				return false;
			}
		case file:
			if (file.getContentType().equals("zip")) {
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}
}
