package com.shishuo.cms.action.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.exception.ValidateException;
import com.shishuo.cms.service.ConfigService;
import com.shishuo.cms.service.FileService;
import com.shishuo.cms.service.FolderService;
import com.shishuo.cms.service.LogService;
import com.shishuo.cms.service.UserService;

/**
 * @author 所有action的父类
 * 
 */
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

	/**
	 * 参数校验
	 * 
	 * @param json
	 *            json数据Bean
	 * @throws ValidateException
	 */
	protected <T> void validate(JsonVo<T> json) throws ValidateException {
		if (json.getErrors().size() > 0) {
			throw new ValidateException("有错误发生");
		}
	}
	// protected boolean getPower(long adminId,String actionName){
	// boolean result = false;
	// AdminActionBean action = adminActionBeanService.getByName(actionName);
	// Power power = powerService.getPower(adminId, action.getActionId());
	// if(power == null){
	//
	// }else{
	// result = true;
	// }
	// return result;
	// }
	//
	// protected Admin getAdmin(HttpServletRequest request) {
	// Admin admin = (Admin) request.getSession().getAttribute("admin");
	// return admin;
	// }
}
