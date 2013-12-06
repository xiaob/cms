package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/ueditor")
public class AdminUEditorAction extends AdminBaseAction {

	@ResponseBody
	@RequestMapping(value = "/imageManager.htm", method = RequestMethod.GET)
	public String imageManager() {
		return "";
	}
}
