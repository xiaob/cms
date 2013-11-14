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

/**
 * 首页
 * 
 * @author Herbert
 */
@Controller
public class DefaultAction {

	@Autowired
	private FolderService folderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap modelMap) {
		try {
			Folder currentFolder = folderService.getFolderById(1);
			modelMap.addAttribute("currentFolder", currentFolder);
			return ConfigConstant.getTemplatePath() + "/default";
		} catch (Exception e) {
			return ConfigConstant.getTemplatePath() + "/500";
		}
	}

	@RequestMapping(value = "/{ename}", method = RequestMethod.GET)
	public String folder(@PathVariable String ename,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		Folder currentFolder = folderService.getFolderByEname(ename);
		modelMap.addAttribute("currentFolder", currentFolder);
		modelMap.addAttribute("pageNum", pageNum);
		return ConfigConstant.getTemplatePath() + "/"+currentFolder.getTemplate();
	}
}
