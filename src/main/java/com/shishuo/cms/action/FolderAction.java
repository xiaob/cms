/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */
package com.shishuo.cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.entity.Folder;

/**
 * @author Herbert
 * 
 */
@Controller
@RequestMapping("/folder")
public class FolderAction extends BaseAction {

	@RequestMapping(value = "/{folderId}.htm", method = RequestMethod.GET)
	public String folder(@PathVariable long folderId,
			@RequestParam(value = "p", defaultValue = "1") long p,
			ModelMap modelMap) {
		try {
			Folder folder = folderService.getFolderById(folderId);
			modelMap.addAttribute("p", p);
			modelMap.addAttribute("folder", folder);
			return themeService.getFolderTemplate(folder.getFolderId());
		} catch (Exception e) {
			return themeService.get404();
		}
	}
}
