package com.shishuo.cms.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.constant.ConfigConstant;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.service.ConfigService;
import com.shishuo.cms.service.FolderService;

/**
 * 首页
 * 
 * @author Herbert
 */
@Controller
public class DefaultAction {

	@Autowired
	private FolderService folderService;
	@Autowired
	private ConfigService configService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,HttpServletRequest request, ModelMap modelMap) {
		try {
			Folder currentFolder = folderService.getFolderById(1);
			modelMap.addAttribute("currentFolder", currentFolder);
			modelMap.addAttribute("pageNum", pageNum);
			return ConfigConstant.getTemplatePath() + "/default";
		} catch (Exception e) {
			return ConfigConstant.getTemplatePath() + "/500";
		}
	}
	
	@RequestMapping(value = "admin.do", method = RequestMethod.GET)
	public String admin(HttpServletRequest request, ModelMap modelMap) {
		return "admin/login";
	}

	@RequestMapping(value = "/{ename}", method = RequestMethod.GET)
	public String folder(@PathVariable String ename,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		Folder currentFolder = folderService.getFolderByEname(ename);
		modelMap.addAttribute("currentFolder", currentFolder);
		modelMap.addAttribute("pageNum", pageNum);
		System.out.println("###############"+ConfigConstant.DEFAUTL_TEMPLATE);
		return ConfigConstant.getTemplatePath() + "/"+currentFolder.getTemplate();
	}
	
}
