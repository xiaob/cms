package com.shishuo.cms.util;

import java.util.Arrays;
import java.util.Iterator;

public class UploadUtils {

	// 文件允许格式
	private static String[] fileType = { ".rar", ".doc", ".docx", ".zip", ".pdf",".txt", 
					".swf", ".wmv"};
	private static String[] photoType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
	
	public static boolean checkPhotoType(String fileName) {
		Iterator<String> type = Arrays.asList(UploadUtils.photoType).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(UploadUtils.fileType).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}
	
}
