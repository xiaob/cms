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
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.FileVo;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.exception.FileNotFoundException;
import com.shishuo.cms.util.UpdatePictureUtils;

@Controller
@RequestMapping("/admin/file")
public class AdminFileAction extends AdminBaseAction {
	
	@Autowired
	protected UpdatePictureUtils updatePictureConstant;
	
	/**
	 * @author 进入某种文件的列表分页的首页
	 * 
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String articlePage(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "status", defaultValue = "display") FileConstant.Status status,
			@RequestParam(value = "type", defaultValue = "article") SystemConstant.Type type,
			ModelMap modelMap) {
		PageVo<FileVo> pageVo = fileService.getAllFileByTypePage(type, status, pageNum);
		modelMap.put("pageVo", pageVo);
		modelMap.put("folderList", folderService.getAllFolderByType(type));
		if(status.equals(FileConstant.Status.hidden)){
			return "system/"+type+"/recycle";
		}else{
			return "system/"+type+"/list";
		}
	}
	
	/**
	 * @author 彻底删除文件
	 * @throws FileNotFoundException 
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public JsonVo<String> deleteFile(@RequestParam(value = "fileId") long fileId) throws FileNotFoundException {
		JsonVo<String> json = new JsonVo<String>();
		fileService.deleteFileByFileId(fileId);
		json.setResult(true);
		return json;
	}
	
	/**
	 * 放进回收站，还原
	 */
	@ResponseBody
	@RequestMapping(value = "/status/update.json", method = RequestMethod.POST)
	public JsonVo<String> updateModify(@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "status") FileConstant.Status status) {
		JsonVo<String> json = new JsonVo<String>();
		fileService.updateStatusByFileId(fileId, status);
		json.setResult(true);
		return json;
	}
	
	/**
	 * 图片上传
	 */
	@ResponseBody
	@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
	public JsonVo<String> upload(
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
						FileConstant.Picture.exist, article.getName(), article.getContent(),
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
}
