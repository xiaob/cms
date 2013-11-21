package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "admin/comment/allComment";
	}
	
	@RequestMapping(value = "/auditing/list", method = RequestMethod.GET)
	public String auditingList(ModelMap modelMap,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum){
		modelMap.put("pageVo", commentService.getCommentByStatusPage(pageNum, 0));
		return "admin/comment/auditingList";
	}
	
	@RequestMapping(value = "/auditing", method = RequestMethod.POST)
	public String auditingComment(
			@RequestParam(value="commentId") long commentId){
		commentService.updateCommentStatus(commentId, 1);
		return "redirect:/admin/comment/all";
	}
	
	@RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
	public String comment(@PathVariable long commentId,ModelMap modelMap){
		modelMap.put("comment", commentService.getCommentById(commentId));
		return "admin/comment/comment";
	}
	
	@RequestMapping(value = "/cancel/{commentId}", method = RequestMethod.GET)
	public String cancelAuditing(@PathVariable long commentId){
		commentService.updateCommentStatus(commentId, 0);
		return "redirect:/admin/comment/all";
	}
}
