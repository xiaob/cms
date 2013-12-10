package com.shishuo.cms.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Herbert
 * 
 */
public class UploadUtils {

	/**
	 * 文件允许格式
	 */
	public static String[] FILE_TYPE = { ".rar", ".doc", ".docx", ".zip",
			".pdf", ".txt", ".swf", ".wmv" };

	/**
	 * 图片允许格式
	 */
	public static String[] PHOTO_TYPE = { ".gif", ".png", ".jpg", ".jpeg",
			".bmp" };

	public static boolean isFileType(String fileName, String[] typeArray) {
		for (String type : typeArray) {
			if (fileName.toLowerCase().endsWith(type)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 递归获得目录的所有地址
	 * 
	 * @param realpath
	 * @param files
	 * @param fileType
	 * @return
	 */
	public static List<File> getFiles(String realpath, List<File> files,
			String[] fileType) {
		File realFile = new File(realpath);
		if (realFile.isDirectory()) {
			File[] subfiles = realFile.listFiles();
			for (File file : subfiles) {
				if (file.isDirectory()) {
					getFiles(file.getAbsolutePath(), files, fileType);
				} else {
					if (isFileType(file.getName(), fileType)) {
						files.add(file);
					}
				}
			}
		}
		return files;
	}

	public static String getFolder(String realpath) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		realpath += "/" + formater.format(new Date());
		File dir = new File(realpath);
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				return "";
			}
		}
		return realpath;
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	public static String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

}
