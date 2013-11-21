package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/comment")
public class AdminCommentAction extends AdminBaseAction{

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String allComment(ModelMap modelMap,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum){
		modelMap.put("pageVo", commentService.getAllListPage(pageNum));
		return "admin/allComment";
	}
}
