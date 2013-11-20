package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.PageVo;

/**
 * @author 文件action
 *
 */

@Controller
@RequestMapping("/admin/file")
public class AdminFileAction extends AdminBaseAction{

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
	public String oneFile(@RequestParam(value = "fileId", defaultValue = "1") long fileId,ModelMap modelMap){
		File file = fileService.getFileById(fileId);
		if(file.getFolderId()==0){
			modelMap.put("folderName", "未分类");
		}else{
			Folder folder = folderService.getFolderById(file.getFolderId());
			modelMap.put("folderName", folder.getName());
		}
		modelMap.put("file", file);
		modelMap.put("folderAll", folderService.getAllList());
		return "admin/update";
	}
	/**
	 * @author 进入添加文章页面
	 *
	 */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String addArticle(ModelMap modelMap){
		modelMap.put("folderAll", folderService.getAllList());
		return "admin/add";
	}
	
	/**
	 * @author 添加新文章
	 *
	 */
	@RequestMapping(value = "/addNew",method = RequestMethod.POST)
	public String addNewArticle(@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "url") String url,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "images") String images,
//			@RequestParam(value = "type") int type,
			@RequestParam(value = "description") String description){
		fileService.addFile(folderId, fileName, url, images, description, 0,1);
		return "redirect:/admin/file/articleList";
	}
	
	/**
	 * @author 修改文章资料
	 *
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateArticle(@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "url") String url,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "fileId") long fileId,
			@RequestParam(value = "images") String images,
//			@RequestParam(value = "type") int type,
			@RequestParam(value = "description") String description){
		fileService.updateFileById(fileId, folderId, fileName, url, images, description, 0);
		return "redirect:/admin/file/articleList";
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
