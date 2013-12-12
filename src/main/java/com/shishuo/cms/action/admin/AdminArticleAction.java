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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
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
	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String addArticle(ModelMap modelMap,HttpServletRequest request) throws Exception {
//		File file = fileService.addFile(0, this.getAdmin(request).getAdminId(),"自动草稿", "", SystemConstant.Type.article, FileConstant.Status.hidden);
		File file = fileService.getFileByFileId(83);
		modelMap.put("article", file);
		modelMap.put("allFolderList", folderService.getAllFolderByType(SystemConstant.Type.article));
		modelMap.put("name", "");
		modelMap.put("content","");
		modelMap.put("title","");
		return "system/article/add";
	}
	
	/**
	 * 图片上传
	 */
	@ResponseBody
	@RequestMapping(value = "/upload/picture.json", method = RequestMethod.POST)
	public JsonVo<String> uploadPicture(
			@RequestParam(value ="file") MultipartFile file,
			@RequestParam(value ="type") SystemConstant.Type type,
			@RequestParam(value ="fileId") long fileId,
			HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			// 检测校验结果
			validate(json);
			File article = fileService.getFileByFileId(fileId);
				String webroot = System.getProperty(SystemConstant.SHISHUO_CMS_ROOT);
				fileService.updateFileByFileId(fileId,article.getFolderId(), this.getAdmin(request).getAdminId(),
						article.getName(), article.getContent(),null,
						SystemConstant.Type.article, FileConstant.Status.display);
				String path = webroot+"/upload/"+type+"/"+fileId+".jpg";
				java.io.File source = new java.io.File(path);
				file.transferTo(source);
				String picture = configSevice.getConfigByKey("article_picture_size", true);
				updatePictureConstant.updateArticlePicture(article.getFileId(), path,picture);
			json.setResult(true);
			
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	/**
	 * @author 发布新文章
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<String> addArticle(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "password" ,defaultValue="") String password,
			@RequestParam(value = "status") FileConstant.Status status,
			HttpServletRequest request) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if(name.equals("")){
				json.getErrors().put("name","文章标题不能为空");
			}
			// 检测校验结果
			validate(json);
			fileService.updateFileByFileIdAndCreateTime(fileId,folderId, this.getAdmin(request).getAdminId(),name,
			content,password, SystemConstant.Type.article,status);
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
			@RequestParam(value = "name") String name,
			@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "password" ,defaultValue="") String password,
			@RequestParam(value = "status") FileConstant.Status status,
			HttpServletRequest request) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if(name.equals("")){
				json.getErrors().put("name","文章标题不能为空");
			}
			if(content.equals("")){
				json.getErrors().put("content","文章内容不能为空");
			}
			// 检测校验结果
			validate(json);
			fileService.updateFileByFileId(fileId,folderId, this.getAdmin(request).getAdminId(),name,
			content,password, SystemConstant.Type.article,status);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

}
