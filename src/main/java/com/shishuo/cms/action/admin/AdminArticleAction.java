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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.entity.vo.PageVo;

/**
 * @author 文件action
 *
 */

@Controller
@RequestMapping("/admin/file")
public class AdminArticleAction extends AdminBaseAction{

	/**
	 * @author 进入文章列表分页的首页
	 *
	 */
	@RequestMapping(value = "/articleList",method = RequestMethod.GET)
	public String allFolder(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,ModelMap modelMap){
		PageVo<File> pageVo = fileService.getFileListByTypePage(0,1, pageNum);
		modelMap.put("pageVo", pageVo);
		return "admin/articleList";
	}
	
	/**
	 * @author 进入修改文章页面
	 *
	 */
	@RequestMapping(value = "/one",method = RequestMethod.GET)
	public String one(@RequestParam(value = "fileId", defaultValue = "1") long fileId,ModelMap modelMap){
		File file = fileService.getFileById(fileId);
		if(file.getFolderId()==0){
			modelMap.put("folderName", "未分类");
		}else{
			Folder folder = folderService.getFolderById(file.getFolderId());
			modelMap.put("folderName", folder.getName());
		}
		modelMap.put("file", file);
		modelMap.put("folderAll", folderService.getAllFolder());
		return "admin/updateArticle";
	}
	/**
	 * @author 进入添加文章页面
	 *
	 */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String addArticle(ModelMap modelMap){
		modelMap.put("folderAll", folderService.getAllFolder());
		modelMap.put("fileName", "");
		modelMap.put("url", "");
		modelMap.put("images", "");
		modelMap.put("description", "");
		return "admin/addArticle";
	}
	
	/**
	 * @author 添加新文章
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/addNew.json",method = RequestMethod.POST)
	public JsonVo<String> addNewArticle(@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "url") String url,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "images") String images,
			@RequestParam(value = "description") String description){
		
		JsonVo<String> json = new JsonVo<String>();	
		try {
			if(fileName.equals("")){
				json.getErrors().put("fileName", "文章名称不能为空");
			}
			if(url.equals("")){
				json.getErrors().put("url", "文章链接不能为空");
			}
			if(images.equals("")){
				json.getErrors().put("images", "文章图片不能为空");
			}
			if(description.equals("")){
				json.getErrors().put("description", "文章内容不能为空");
			}
			// 检测校验结果
			validate(json);
			fileService.addFile(folderId, fileName, url, images, description, 0,1);
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
	@RequestMapping(value = "/update.json",method = RequestMethod.POST)
	public JsonVo<String> updateArticle(@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "url") String url,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "images") String images,
			@RequestParam(value = "description") String description){
		
		JsonVo<String> json = new JsonVo<String>();	
		try {
			if(fileName.equals("")){
				json.getErrors().put("fileName", "文章名称不能为空");
			}
			if(url.equals("")){
				json.getErrors().put("url", "文章链接不能为空");
			}
			if(images.equals("")){
				json.getErrors().put("images", "文章图片不能为空");
			}
			if(description.equals("")){
				json.getErrors().put("description", "文章内容不能为空");
			}
			
			// 检测校验结果
			validate(json);
			fileService.updateFileById(fileId, folderId, fileName, url, images, description, 0);
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
	@RequestMapping(value = "/recycle.do",method = RequestMethod.GET)
	public String recycle(@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "status") int status){
		fileService.recycle(fileId,status);
		return "redirect:/admin/file/articleList";
	}
	/**
	 * @author 进入回收站页面
	 *
	 */
	@RequestMapping(value = "/recycleList",method = RequestMethod.GET)
	public String recycleList(@RequestParam(value = "pageNum",defaultValue="1") int pageNum,ModelMap modelMap){
		modelMap.put("pageVo", fileService.getFileListByTypePage(0, 0, pageNum));
		return "admin/articleRecycle";
	}
	
	/**
	 * @author 彻底删除文件
	 *
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteFile(@RequestParam(value = "fileId") long fileId){
		fileService.deleteFileById(fileId);
		return "redirect:/admin/file/recycleList";
	}
	
}
