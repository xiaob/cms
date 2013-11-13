package com.shishuo.jiawacms.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.jiawacms.constant.ConfigConstant;
import com.shishuo.jiawacms.entity.Folder;
import com.shishuo.jiawacms.service.FolderService;
import com.shishuo.jiawacms.tag.FilePageTag;
import com.shishuo.jiawacms.tag.FileTag;
import com.shishuo.jiawacms.tag.FolderListTag;

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
			modelMap.addAttribute("folderId", 0);
			modelMap.addAttribute("fatherId", 0);
			return ConfigConstant.getTemplatePath() + "/default";
		} catch (Exception e) {
			return ConfigConstant.getTemplatePath() + "/500";
		}
	}

	@RequestMapping(value = "about.do", method = RequestMethod.GET)
	public String about() {
		return "template/default/about";
	}

	@RequestMapping(value = "folder.do", method = RequestMethod.GET)
	public String folder(@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		Folder folder = folderService.getFolderById(folderId);
		List<Folder> folderList = new ArrayList<Folder>();
		if(folder.getFatherId()==0){
			folderList = folderService
					.getFolderListByFatherId(folderId);
			Folder firstFolder = folderList.get(0);
			modelMap.addAttribute("folderId", firstFolder.getFolderId());
			modelMap.addAttribute("fatherId", folderId);		
		}else{
			modelMap.addAttribute("folderId", folderId);
			modelMap.addAttribute("fatherId", folder.getFatherId());	
		}

		modelMap.addAttribute("pageNum", pageNum);
		if (firstFolder.getType() == 1) {
			return "template/default/folder";
		} else {
			return "template/default/folderList";
		}
	}

	@RequestMapping(value = "filePage.do", method = RequestMethod.GET)
	public String filePage(@RequestParam(value = "pageNum") int pageNum,
			ModelMap modelMap) {
		modelMap.addAttribute("pageNum", pageNum);
		return "template/default/folderList";
	}

	// @RequestMapping(value = "folderId.do", method = RequestMethod.GET)
	// public String folderId(@RequestParam(value = "folderId") long folderId,
	// @RequestParam(value = "fatherId") long fatherId,ModelMap modelMap){
	// Folder folder = folderService.getFolderById(folderId);
	// modelMap.addAttribute("folderId", folderId);
	// modelMap.addAttribute("fathersId", fatherId);
	// modelMap.addAttribute("pageNum", 1);
	// if(folder.getType()==1){
	// return "template/default/folder";
	// }else{
	// return "template/default/folderList";
	// }
	// }

}
