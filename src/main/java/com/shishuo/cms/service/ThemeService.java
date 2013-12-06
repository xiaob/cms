package com.shishuo.cms.service;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shishuo.cms.constant.ConfigConstant;
import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.constant.FolderConstant;
import com.shishuo.cms.constant.SystemConstant;

/**
 * 模板工具类
 * 
 * @author Herbert
 * 
 */
@Component
public class ThemeService {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ConfigService configService;

	/**
	 * 首页（默认页）模板启用顺序
	 */
	private String[] defatulDisplay = { "default", "home" };

	/**
	 * 文件夹模板启用顺序
	 */
	private String[] folderDisplay = { "folder-{ename}", "folder-{type}",
			"folder", "default" };
	

	/**
	 * 文件模板启用顺序
	 */
	private String[] fileDisplay = { "file-{ename}-{type}", "file-{type}",
			"file", "default" };

	/**
	 * 得到首页（默认页）模板
	 * 
	 * @return
	 */
	public String getDefaultTheme() {
		for (String theme : defatulDisplay) {
			if (this.isExist(theme)) {
				return this.getTheme(theme);
			}
		}
		return this.getTheme(defatulDisplay[defatulDisplay.length-1]);
	}

	/**
	 * 得到文件夹模板
	 * 
	 * @param ename
	 * @param type
	 * @return
	 */
	public String getFolderTheme(String ename, SystemConstant.Type type) {
		for (String theme : folderDisplay) {
			theme = theme.replace("{ename}", ename).replace("{type}",
					type.name());
			if (this.isExist(theme)) {
				return this.getTheme(theme);
			}
		}
		return this.getTheme(folderDisplay[folderDisplay.length-1]);
	}
	
	/**
	 * 得到文件夹模板
	 * 
	 * @param ename
	 * @param type
	 * @return
	 */
	public String getFileTheme(String ename, SystemConstant.Type type) {
		for (String theme : fileDisplay) {
			theme = theme.replace("{ename}", ename).replace("{type}",
					type.name());
			if (this.isExist(theme)) {
				return this.getTheme(theme);
			}
		}
		return this.getTheme(fileDisplay[fileDisplay.length-1]);
	}

	/**
	 * 得到当前请求需要渲染的模板相对路径
	 * 
	 * @param theme
	 * @return
	 */
	private String getTheme(String theme) {
		return "/themes/"
				+ configService.getConfigByKey(ConfigConstant.SYS_TEMPLATE,
						false) + "/" + theme;
	}

	/**
	 * 模板物理地址是否存在
	 * 
	 * @param theme
	 * @return
	 */
	private boolean isExist(String theme) {
		String themePath = System.getProperty(SystemConstant.SHISHUO_CMS_ROOT)
				+ "/themes/"
				+ configService.getConfigByKey(ConfigConstant.SYS_TEMPLATE,
						false) + "/" + theme + ".ftl";
		File file = new File(themePath);
		if (file.exists()) {
			return true;
		} else {
			logger.info("模板存在："+themePath);
			return false;
		}
	}
}
