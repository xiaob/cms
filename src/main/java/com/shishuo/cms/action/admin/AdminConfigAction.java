package com.shishuo.cms.action.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shishuo.cms.constant.SystemConstant;

/**
 * @author Herbert
 * 
 */
@Controller
@RequestMapping("/admin/config")
public class AdminConfigAction extends AdminBaseAction {

	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		this.getTemplate();
		return "admin/config/basic";
	}

	private List<String> getTemplate() {
		List<String> templateList = new ArrayList<String>();
		String templatePath = System
				.getProperty(SystemConstant.SHISHUO_CMS_ROOT) + "/WEB-INF/ftl";
		File dir = new File(templatePath);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory() && !file.getName().equals("admin")) {
				templateList.add(file.getName());
			}
			logger.debug(file.getName());
		}
		return null;
	}
}
