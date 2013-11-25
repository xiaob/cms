/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.constant.CommentConstant;

/**
 * 评论action
 * @author Zhangjiale
 *
 */
@Controller
@RequestMapping("/admin/comment")
public class AdminCommentAction extends AdminBaseAction{

	/**
	 * @author 进入所有评论列表页面
	 *
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String allComment(ModelMap modelMap,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum){
		modelMap.put("pageVo", commentService.getAllListPage(pageNum));
		return "admin/comment/allComment";
	}
	/**
	 * 进入审核列表页面
	 * @author Administrator
	 *
	 */
	@RequestMapping(value = "/auditing/list", method = RequestMethod.GET)
	public String auditingList(ModelMap modelMap,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum){
		modelMap.put("pageVo", commentService.getCommentByStatusPage(pageNum, 0));
		return "admin/comment/auditingList";
	}
	
	/**
	 * 审核通过
	 * @author Administrator
	 *
	 */
	@RequestMapping(value = "/auditing", method = RequestMethod.POST)
	public String auditingComment(
			@RequestParam(value="commentId") long commentId){
		commentService.updateCommentStatus(commentId, CommentConstant.Status.DISPLAY);
		return "redirect:/admin/comment/all";
	}
	
	/**
	 * @author 进入指定的comment页面
	 *
	 */
	@RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
	public String comment(@PathVariable long commentId,ModelMap modelMap){
		modelMap.put("comment", commentService.getCommentById(commentId));
		return "admin/comment/comment";
	}
	
	/**
	 * @author 审核未通过
	 *
	 */
	@RequestMapping(value = "/cancel/{commentId}", method = RequestMethod.GET)
	public String cancelAuditing(@PathVariable long commentId){
		commentService.updateCommentStatus(commentId, CommentConstant.Status.DISABLE);
		return "redirect:/admin/comment/all";
	}
}
