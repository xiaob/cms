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
import com.shishuo.cms.entity.vo.PageVo;

/**
 * @author 文件action
 * 
 */

@Controller
@RequestMapping("/admin/article")
public class AdminArticleAction extends AdminBaseAction {

	/**
	 * @author 进入文章列表分页的首页
	 * 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String allFolder(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			ModelMap modelMap) {
		PageVo<File> pageVo = fileService.getFileListByTypePage(FileConstant.Type.article, FileConstant.Status.display, pageNum);
		modelMap.put("pageVo", pageVo);
		return "admin/article/list";
	}

	/**
	 * @author 进入修改文章页面
	 * 
	 */
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public String one(
			@RequestParam(value = "fileId", defaultValue = "1") long fileId,
			ModelMap modelMap) {
		File file = fileService.getFileById(fileId);
		if (file.getFolderId() == 0) {
			modelMap.put("folderName", "未分类");
		} else {
			Folder folder = folderService.getFolderById(file.getFolderId());
			modelMap.put("folderName", folder.getName());
		}
		modelMap.put("file", file);
		modelMap.put("folderAll", folderService.getAllFolder());
		return "admin/article/update";
	}

	/**
	 * @author 进入添加文章页面
	 * 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addArticle(ModelMap modelMap) {
		modelMap.put("allFolderList", folderService.getAllFolder());
		return "admin/article/add";
	}

	/**
	 * @author 添加新文章
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<String> addArticle(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "picture") FileConstant.Picture picture,
			@RequestParam(value = "content") String content,
			HttpServletRequest request) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if (StringUtils.isBlank(name)) {
				json.getErrors().put("name", "文章名称不能为空");
			}
			if(StringUtils.isBlank(picture.toString())){
				picture=FileConstant.Picture.no_exist;
			}
			// 检测校验结果
			validate(json);
			fileService.addFile(folderId, this.getAdmin(request).getAdminId(),
					picture, name, content,
					FileConstant.Type.article, FileConstant.Status.display);
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
			@RequestParam(value = "url") String url,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "images") String images,
			@RequestParam(value = "content") String content) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if (fileName.equals("")) {
				json.getErrors().put("fileName", "文章名称不能为空");
			}
			if (url.equals("")) {
				json.getErrors().put("url", "文章链接不能为空");
			}
			if (images.equals("")) {
				json.getErrors().put("images", "文章图片不能为空");
			}
			if (content.equals("")) {
				json.getErrors().put("content", "文章内容不能为空");
			}

			// 检测校验结果
			validate(json);
			// fileService.updateFileById(fileId, folderId, fileName, url,
			// images,
			// description, 0);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	/**
	 * @author 放进回收站，还原
	 * 
	 */
	@RequestMapping(value = "/recycle", method = RequestMethod.GET)
	public String recycle(@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "status") FileConstant.Status status) {
		fileService.recycle(fileId, status);
		return "redirect:/admin/acticle/list";
	}

	/**
	 * @author 进入回收站页面
	 * 
	 */
	@RequestMapping(value = "/recycle", method = RequestMethod.GET)
	public String recycleList(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			ModelMap modelMap) {
		modelMap.put("pageVo", fileService.getFileListByTypePage(FileConstant.Type.article, FileConstant.Status.hidden, pageNum));
		return "admin/article/recycle";
	}

	/**
	 * @author 彻底删除文件
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteFile(@RequestParam(value = "fileId") long fileId) {
		fileService.deleteFileById(fileId);
		return "redirect:/admin/file/recycle";
	}

}
