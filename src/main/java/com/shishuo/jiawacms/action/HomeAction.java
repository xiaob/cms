package com.shishuo.jiawacms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shishuo.jiawacms.constant.ConfigConstant;

/**
 * 首页
 * 
 * @author Herbert
 * 
 */
@Controller
public class HomeAction {

	@RequestMapping(value = "default.do", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap modelMap) {
		try {
			return ConfigConstant.getTemplatePath() + "/home";
		} catch (Exception e) {
			return ConfigConstant.getTemplatePath() + "/500";
		}
	}
}
