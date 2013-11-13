package com.shishuo.jiawacms.action;


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
import com.shishuo.jiawacms.tag.FileListTag;
import com.shishuo.jiawacms.tag.FileTag;
import com.shishuo.jiawacms.tag.FolderByFatherIdTag;
import com.shishuo.jiawacms.tag.FolderTag;

/**
 * 首页
 * @author Herbert
 */
@Controller
public class DefaultAction {

	@Autowired
	private FolderService folderService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap modelMap) {
		try {
			FolderTag folderTag= new FolderTag();
			folderTag.setFolderId(0);
			return ConfigConstant.getTemplatePath() + "/default";
		} catch (Exception e) {
			return ConfigConstant.getTemplatePath() + "/500";
		}
	}
	
	@RequestMapping(value = "about.do", method = RequestMethod.GET)
	public String about(){
		return "template/default/about";
	}
	
	@RequestMapping(value = "folder.do", method = RequestMethod.GET)
	public String folder(@RequestParam(value = "folderId") long folderId){
		Folder folder = folderService.getFolderById(folderId);
		FolderByFatherIdTag folderTag= new FolderByFatherIdTag();
		folderTag.setFolderId(folderId);
		if(folder.getType()==1){
			FileTag fileTag = new FileTag();
			fileTag.setFolderId(folderId);	
			return "template/default/folder";
		}else{
			FileListTag fi = new FileListTag();
			fi.setFolderId(folderId);
			return "template/default/folderList";
		}
		
	}
	
	@RequestMapping(value = "filePage.do", method = RequestMethod.GET)
	public String filePage(@RequestParam(value = "pageNum") int pageNum){
		FileListTag file = new FileListTag();
		file.setPageNum(pageNum);
		return "template/default/folderList";
	}
	
}
