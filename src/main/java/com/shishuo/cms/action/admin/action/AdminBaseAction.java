package com.shishuo.cms.action.admin.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shishuo.cms.service.ConfigService;
import com.shishuo.cms.service.FileService;
import com.shishuo.cms.service.FolderService;
import com.shishuo.cms.service.LogService;
import com.shishuo.cms.service.UserService;



@Controller
public class AdminBaseAction {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	protected ConfigService configSevice;
	@Autowired
	protected FolderService folderService;
	@Autowired
	protected FileService fileService;
	@Autowired
	protected LogService logService;
	@Autowired
	protected UserService userService;
	String root = "admin";
	
//	protected boolean getPower(long adminId,String actionName){
//		boolean result = false;
//		AdminActionBean action = adminActionBeanService.getByName(actionName);
//		Power power = powerService.getPower(adminId, action.getActionId());
//		if(power == null){
//			
//		}else{
//			result = true;
//		}
//		return result;
//	}
//	
//	protected Admin getAdmin(HttpServletRequest request) {
//		Admin admin = (Admin) request.getSession().getAttribute("admin");
//		return admin;
//	}
}
