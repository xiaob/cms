package com.shishuo.jiawacms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.jiawacms.constant.ConfigConstant;
import com.shishuo.jiawacms.service.FolderService;

@Controller
@RequestMapping("/file")
public class FileAction {

	@Autowired
	private FolderService folderService;

	@RequestMapping(value = "{fileId}", method = RequestMethod.GET)
	public String folder(@PathVariable long folderId,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		return ConfigConstant.getTemplatePath() + "/file";
	}
}
