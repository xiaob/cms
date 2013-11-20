package com.shishuo.cms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.dao.CommentDao;
import com.shishuo.cms.service.CommentService;

@Controller
public class CommentAction {
	@Autowired
	private CommentService commentService;	
	
	@RequestMapping(value = "/comment/add", method = RequestMethod.POST)
	public String add(@RequestParam("name") String name,
			          @RequestParam("email") String email,
			          @RequestParam("fileId") long fileId,
			          @RequestParam("content") String content
			          ){
		commentService.addComment(fileId,  email, name, "", content);
		return "default/detail";
	}
}
