/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.cms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "admin/admin";
	}
	
	@ResponseBody
	@RequestMapping(value = "login.json", method = RequestMethod.POST)
	public String login(HttpServletRequest request, ModelMap modelMap) {
		return "admin/admin";
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
	
	@RequestMapping(value = "/{ename}/{fileId}", method = RequestMethod.GET)
	public String detail(@PathVariable long fileId,ModelMap modelMap){
//		String a = "";
		modelMap.addAttribute("fileId", fileId);
		return "default/detail";
	}
	
}
