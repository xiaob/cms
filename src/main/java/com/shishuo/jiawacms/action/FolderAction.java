package com.shishuo.jiawacms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shishuo.jiawacms.constant.ConfigConstant;

@Controller
@RequestMapping("/folder")
public class FolderAction {

	@RequestMapping(value = "default.do", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap modelMap) {
		try {
			return ConfigConstant.getTemplatePath() + "/folder";
		} catch (Exception e) {
			return ConfigConstant.getTemplatePath() + "/500";
		}
	}
}
