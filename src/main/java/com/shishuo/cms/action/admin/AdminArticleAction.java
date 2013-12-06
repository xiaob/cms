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
package com.shishuo.cms.action.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.constant.SystemConstant;;

/**
 * @author 文件action
 * 
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleAction extends AdminFileAction {

	@Autowired
	private AdminConfigAction adminConfigAction;

	/**
	 * @author 进入修改文章页面
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "fileId", defaultValue = "1") long fileId,
			ModelMap modelMap) throws Exception {
		File file = fileService.getFileByFileId(fileId);
		if (file.getFolderId() == 0) {
			modelMap.put("folderName", "未分类");
		} else {
			Folder folder = folderService.getFolderById(file.getFolderId());
			modelMap.put("folderName", folder.getName());
		}
		modelMap.put("file", file);
		modelMap.put("folderAll", folderService.getAllFolderByType(SystemConstant.Type.article));
		return "system/article/update";
	}

	/**
	 * @author 进入添加文章页面
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addArticle(ModelMap modelMap) throws Exception {
		modelMap.put("allFolderList", folderService.getAllFolderByType(SystemConstant.Type.article));
		modelMap.put("folderEname", "");
		modelMap.put("articleId","");
		return "system/article/add";
	}

	/**
	 * @author 添加新文章
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<String> add(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "content") String content,
			HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			if (StringUtils.isBlank(name)) {
				json.getErrors().put("name", "文章名称不能为空");
			}
			if (StringUtils.isBlank(content)) {
				json.getErrors().put("content", "文章内容不能为空");
			}
			// 检测校验结果
			validate(json);
			File file = fileService.addFile(folderId, this.getAdmin(request).getAdminId(),
			FileConstant.Picture.no_exist, name, content,
			SystemConstant.Type.article, FileConstant.Status.display);
			json.setT(file.getFileId()+"");
			json.setResult(true);
			
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	/**
	 * @author 修改文章资料
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<String> updateArticle(
			@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "adminId") long adminId,
			@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "picture") FileConstant.Picture picture,
			@RequestParam(value = "status") FileConstant.Status status,
			@RequestParam(value = "content") String content) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if (fileName.equals("")) {
				json.getErrors().put("fileName", "文章名称不能为空");
			}
			if (content.equals("")) {
				json.getErrors().put("content", "文章内容不能为空");
			}

			// 检测校验结果
			validate(json);
			 fileService.updateFileByFileId(fileId, folderId, adminId,picture,fileName,
			 content, SystemConstant.Type.article,status);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

}
