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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishuo.cms.constant.CommentConstant;
import com.shishuo.cms.entity.Comment;
import com.shishuo.cms.entity.vo.JsonVo;

/**
 * 评论action
 * 
 * @author Zhangjiale
 * 
 */
@Controller
@RequestMapping("/admin/comment")
public class AdminCommentAction extends AdminBaseAction {

	/**
	 * @author 进入所有评论列表页面
	 * 
	 */
	@RequestMapping(value = "/page.htm", method = RequestMethod.GET)
	public String allComment(
			ModelMap modelMap,
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "status", required = false, defaultValue = "hidden") CommentConstant.Status status) {
		modelMap.put("pageVo",
				commentService.getCommentListPage(pageNum, status));
		int displayCount = commentService
				.getCommentByStatusCount(CommentConstant.Status.display);
		int hiddenCount = commentService
				.getCommentByStatusCount(CommentConstant.Status.hidden);
		int trashCount = commentService
				.getCommentByStatusCount(CommentConstant.Status.trash);
		int allCount = trashCount + hiddenCount + displayCount;
		modelMap.put("statusType", status);
		modelMap.put("displayCount", displayCount);
		modelMap.put("hiddenCount", hiddenCount);
		modelMap.put("trashCount", trashCount);
		modelMap.put("allCount", allCount);
		return "system/comment/all";
	}

	/**
	 * @author 进入指定的comment页面
	 * 
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String comment(@RequestParam(value = "commentId") long commentId,
			ModelMap modelMap) {
		modelMap.put("comment", commentService.getCommentById(commentId));
		return "system/comment/detail";
	}

	/**
	 * @author 垃圾评论
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/update/status.json", method = RequestMethod.POST)
	public JsonVo<Comment> cancelAuditing(
			@RequestParam(value = "commentId") long commentId,
			CommentConstant.Status status) {
		JsonVo<Comment> json = new JsonVo<Comment>();
		json.setResult(true);
		commentService.updateCommentStatus(commentId,status);
		return json;
	}
}
