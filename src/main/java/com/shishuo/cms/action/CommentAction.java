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
package com.shishuo.cms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.service.CommentService;
import com.shishuo.cms.service.FileService;
import com.shishuo.cms.util.HttpUtils;

/**
 * @author Herbert
 * 
 */
@Controller
@RequestMapping("/comment")
public class CommentAction {
	@Autowired
	private CommentService commentService;

	@Autowired
	private FileService fileService;

	/**
	 * @param name
	 * @param email
	 * @param fileId
	 * @param content
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public JsonVo<String> add(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("fileId") long fileId,
			@RequestParam("content") String content,
			HttpServletRequest request, ModelMap modelMap) {
		commentService.addComment(fileId, email, name,
				HttpUtils.getIp(request), HtmlUtils.htmlEscape(content));
		fileService.updateCommentCount(fileId);
		JsonVo<String> json = new JsonVo<String>();
		json.setResult(true);
		return json;
	}
}
