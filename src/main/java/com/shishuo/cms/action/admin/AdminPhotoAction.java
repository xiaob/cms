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

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.util.UploadUtils;

@Controller
@RequestMapping("/admin/picture")
public class AdminPhotoAction extends AdminBaseAction {

	@RequestMapping(value = "/upload.htm", method = RequestMethod.GET)
	public String upload(ModelMap modelMap) {
		modelMap.put("photoList", folderService.getAllFolderByType(SystemConstant.Type.photo));
		modelMap.put("fileList", folderService.getAllFolderByType(SystemConstant.Type.file));
		modelMap.put("shopList", folderService.getAllFolderByType(SystemConstant.Type.shop));
		return "system/photo/upload";
	}

	// @RequestMapping(value = "/upload", method = RequestMethod.GET)
	// public String upload(ModelMap modelMap) {
	// return "system/upload";
	// }

	@ResponseBody
	@RequestMapping(value = "/preview.htm", method = RequestMethod.POST)
	public JsonVo<String> preview(@RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		JsonVo<String> json = new JsonVo<String>();
		String path = "";
		java.io.File source = new java.io.File(path);
		file.transferTo(source);
		return json;
	}

//	@ResponseBody
//	@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
//	public JsonVo<String> uploadPicture(
//			@RequestParam("file") MultipartFile file,
//			@RequestParam("folderId") long folderId,
//			@RequestParam(value = "content") String content,
//			HttpServletRequest request) throws Exception {
//		JsonVo<String> json = new JsonVo<String>();
//		try {
//			// 检测校验结果
//			validate(json);
//			if (UploadUtils.isFileType(file.getName(), UploadUtils.PHOTO_TYPE)) {
//				Admin admin = this.getAdmin(request);
//				File fi = fileService.addFile(folderId, admin.getAdminId(),
//						file.getOriginalFilename(),
//						content, SystemConstant.Type.photo,
//						FileConstant.Status.display);
//				String webroot = System
//						.getProperty(SystemConstant.SHISHUO_CMS_ROOT);
//				String path = webroot + "/upload/" + SystemConstant.Type.photo
//						+ fi.getFileId() + ".jpg";
//				java.io.File source = new java.io.File(path);
//				file.transferTo(source);
//				String picture = configSevice.getConfigByKey("picture_size",
//						true);
//				updatePictureConsTant.updatePicture(fi.getFileId(), path,
//						picture, SystemConstant.Type.photo);
//			} else {
//				String errorMessage = "上传的文件只能是jpg,png,gif的图片格式";
//			}
//		} catch (Exception e) {
//			json.setResult(false);
//			json.setMsg(e.getMessage());
//		}
//		return json;
//	}

	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "p", required = false, defaultValue = "1") int p,
			HttpServletRequest request, ModelMap modelMap) {
		PageVo<com.shishuo.cms.entity.vo.FileVo> filePage = fileService
				.getAllFileByTypeAndStatusPage(SystemConstant.Type.photo,
						FileConstant.Status.display, p);
		modelMap.addAttribute("filePage", filePage);
		return "system/picturelist";
	}

}
