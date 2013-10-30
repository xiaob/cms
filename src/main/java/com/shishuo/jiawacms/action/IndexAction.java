package com.shishuo.jiawacms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shishuo.jiawacms.service.AdminService;

@Controller
public class IndexAction {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("list", adminService.allAdmin());
		return "admin";
	}
}
