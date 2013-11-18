package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.PageVo;

/**
 * @author 文件action
 *
 */

@Controller
@RequestMapping("/admin/file")
public class AdminFileAction extends AdminBaseAction{

	@RequestMapping(value = "/articleList.do",method = RequestMethod.GET)
	public String allFolder(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,ModelMap modelMap){
		PageVo<File> pageVo = fileService.getFileListByTypePage(0,1, pageNum);
		modelMap.put("pageVo", pageVo);
		return "admin/articleList";
	}
	
	@RequestMapping(value = "/oneFile.do",method = RequestMethod.GET)
	public String oneFile(@RequestParam(value = "fileId", defaultValue = "1") long fileId,ModelMap modelMap){
		File file = fileService.getFileById(fileId);
		modelMap.put("file", file);
		modelMap.put("folderAll", folderService.getAllList());
		return "admin/updateArticle";
	}
	
	@RequestMapping(value = "/addArticle.do",method = RequestMethod.GET)
	public String addArticle(ModelMap modelMap){
		modelMap.put("folderAll", folderService.getAllList());
		return "admin/addArticle";
	}
	
	@RequestMapping(value = "/addNewArticle.do",method = RequestMethod.POST)
	public String addNewArticle(@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "url") String url,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "images") String images,
//			@RequestParam(value = "type") int type,
			@RequestParam(value = "description") String description){
		fileService.addFile(folderId, fileName, url, images, description, 0,1);
		return "redirect:/admin/file/articleList.do";
	}
	/**
	 * @author 放进回收站，还原
	 *
	 */
	@RequestMapping(value = "/recycle.do",method = RequestMethod.GET)
	public String recycle(@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "status") int status){
		fileService.recycle(fileId,status);
		return "redirect:/admin/file/articleList.do";
	}
	
	@RequestMapping(value = "/recycleList.do",method = RequestMethod.GET)
	public String recycleList(@RequestParam(value = "pageNum",defaultValue="1") int pageNum,ModelMap modelMap){
		modelMap.put("pageVo", fileService.getFileListByTypePage(0, 0, pageNum));
		return "admin/articleRecycle";
	}
	
	@RequestMapping(value = "/deleteFile.do",method = RequestMethod.GET)
	public String deleteFile(@RequestParam(value = "fileId") long fileId){
		fileService.deleteFileById(fileId);
		return "redirect:/admin/file/recycleList.do";
	}
	
}
