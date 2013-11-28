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
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.service.ConfigService;
import com.shishuo.cms.service.FileService;
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
	private FileService fileService;

	@Autowired
	private ConfigService configService;

	/**
	 * 首页
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		try {
			modelMap.addAttribute("ename", "");
			modelMap.addAttribute("pageNum", pageNum);
			return configService.getTemplatePath() + "/default";
		} catch (Exception e) {
			return configService.getTemplatePath() + "/500";
		}
	}

	/**
	 * 目录页
	 * 
	 * @param ename
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{ename}", method = RequestMethod.GET)
	public String folder(@PathVariable String ename,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		Folder currentFolder = folderService.getFolderByEname(ename);
		modelMap.addAttribute("currentFolder", currentFolder);
		modelMap.addAttribute("ename", ename);
		modelMap.addAttribute("pageNum", pageNum);
		return configService.getTemplatePath() + "/"
				+ currentFolder.getTemplate();
	}

	/**
	 * 文件页
	 * 
	 * @param fileId
	 * @param ename
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{ename}/{fileId}", method = RequestMethod.GET)
	public String file(@PathVariable long fileId, @PathVariable String ename,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		File file = fileService.getFileById(fileId);
		fileService.updateViewCount(fileId, file.getViewCount());
		modelMap.addAttribute("fileId", fileId);
		modelMap.addAttribute("ename", ename);
		modelMap.addAttribute("pageNum", pageNum);
		return configService.getTemplatePath() + "/" + file.getTemplate();
	}

}
