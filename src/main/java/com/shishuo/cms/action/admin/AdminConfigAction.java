package com.shishuo.cms.action.admin;

import java.io.File;
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
		String templatePath = System
				.getProperty(SystemConstant.WEB_APP_ROOT_KEY) + "/WEB-INF/ftl";
		File dir = new File(templatePath);
		File[] files = dir.listFiles();
		for (File file : files) {
			logger.debug(file.getName());
		}
		return null;
	}
}
