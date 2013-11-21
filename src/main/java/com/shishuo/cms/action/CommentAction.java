package com.shishuo.cms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishuo.cms.dao.CommentDao;
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.service.CommentService;
import com.shishuo.cms.service.FileService;

@Controller
public class CommentAction {
	@Autowired
	private CommentService commentService;	
	
	@Autowired
	private FileService fileService;	
	
	@ResponseBody
	@RequestMapping(value = "comment/add", method = RequestMethod.POST)
	public JsonVo<String> add(@RequestParam("name") String name,
			          @RequestParam("email") String email,
			          @RequestParam("fileId") long fileId,
			          @RequestParam("content") String content,
			          ModelMap modelMap
			          ){
		commentService.addComment(fileId,  email, name, "", content);
		File file = fileService.getFileById(fileId);
		fileService.updateCommentCount(fileId, file.getCommentCount());
		JsonVo<String>  json = new JsonVo<String>();
		json.setResult(true);
		return json;
	}
}
