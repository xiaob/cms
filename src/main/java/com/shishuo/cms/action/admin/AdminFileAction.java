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
import com.shishuo.cms.constant.UpdatePictureConstant;
import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.entity.vo.PageVo;

@Controller
@RequestMapping("/admin/file")
public class AdminFileAction extends AdminBaseAction {
	
	@Autowired
	protected UpdatePictureConstant updatePictureConstant;
	
	/**
	 * @author 进入文章列表分页的首页
	 * 
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String articlePage(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "status", defaultValue = "display") FileConstant.Status status,
			@RequestParam(value = "type", defaultValue = "article") FileConstant.Type type,
			ModelMap modelMap) {
		PageVo<File> pageVo = fileService.getAllFileByTypePage(FileConstant.Type.article, status, pageNum);
		modelMap.put("pageVo", pageVo);
		modelMap.put("folderList", folderService.getAllList());
		return "admin/article/list";
	}
	
	/**
	 * @author 彻底删除文件
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteFile(@RequestParam(value = "fileId") long fileId) {
		fileService.deleteFileByFileId(fileId);
		return "redirect:/admin/file/status/update";
	}
	
	/**
	 * 放进回收站，还原
	 */
	@RequestMapping(value = "/status/update", method = RequestMethod.GET)
	public String updateModify(@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "status",defaultValue="hidden") FileConstant.Status status) {
		fileService.updateStatusByFileId(fileId, status);
		return "redirect:/admin/file/page";
	}
	
	/**
	 * 图片上传
	 */
	@ResponseBody
	@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
	public JsonVo<String> upload(
			@RequestParam(value ="file") MultipartFile file,
			@RequestParam(value ="type") FileConstant.Type type,
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
						FileConstant.Type.article, FileConstant.Status.display,article.getTemplate());
				String path = webroot+"/upload/"+type+"/"+article.getFileId()+".jpg";
				java.io.File source = new java.io.File(path);
				file.transferTo(source);
				updatePictureConstant.updatePicture(article.getFileId(), path);
			json.setResult(true);
			
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
}
