package com.shishuo.jiawacms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.jiawacms.constant.ConfigConstant;
import com.shishuo.jiawacms.entity.Folder;
import com.shishuo.jiawacms.service.FolderService;

@Controller
@RequestMapping("/folder")
public class FolderAction {

	@Autowired
	private FolderService folderService;

	@RequestMapping(value = "{folderId}", method = RequestMethod.GET)
	public String folder(@PathVariable long folderId,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		Folder folder = folderService.getFolderById(folderId);
		modelMap.addAttribute("folderId", folderId);
		modelMap.addAttribute("fatherId", fatherId);
		modelMap.addAttribute("pageNum", pageNum);
		if (folder.getType() == 1) {
			return "template/default/folder";
		} else {
			return "template/default/folderList";
		}
	}
	
	@RequestMapping(value = "{fatherId}/{folderId}", method = RequestMethod.GET)
	public String folder(@PathVariable long fatherId,@PathVariable long folderId,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		Folder folder = folderService.getFolderById(folderId);
		modelMap.addAttribute("folderId", folderId);
		modelMap.addAttribute("fatherId", fatherId);
		modelMap.addAttribute("pageNum", pageNum);
		if (folder.getType() == 1) {
			return "template/default/folder";
		} else {
			return "template/default/folderList";
		}
	}

	@RequestMapping(value = "default.do", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap modelMap) {
		try {
			return ConfigConstant.getTemplatePath() + "/folder";
		} catch (Exception e) {
			return ConfigConstant.getTemplatePath() + "/500";
		}
	}
	// @RequestMapping(value = "default.do", method = RequestMethod.GET)
}
