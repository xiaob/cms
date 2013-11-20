package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.entity.vo.PageVo;


/**
 * @author 目录action
 *
 */
@RequestMapping("/admin/folder")
@Controller
public class AdminFolderAction extends AdminBaseAction{

	/**
	 * @author 进入添加目录页面
	 *
	 */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String login(ModelMap modelMap){
		modelMap.put("folderAll", folderService.getAllList());
		modelMap.put("folderName", "");
		modelMap.put("folderEname", "");
		return "admin/folder";
	}
	
	/**
	 * @author 添加新的目录
	 *
	 */	
	@ResponseBody
	@RequestMapping(value = "/addNew.json",method = RequestMethod.POST)
	public JsonVo<String> addNewFolder(
			@RequestParam(value = "fatherId", defaultValue = "0") long fatherId,
			@RequestParam(value = "folderName") String folderName,
			@RequestParam(value = "folderEname") String folderEname,
			@RequestParam(value = "type",defaultValue = "0") int type,
			@RequestParam(value = "status",defaultValue = "1") int status,
			ModelMap modelMap) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			if(folderName.equals("")){
				json.getErrors().put("folderName", "目录名称不能为空");
			}
			if(folderEname.equals("")){
				json.getErrors().put("folderEname", "英文名称不能为空");
			}
			// 检测校验结果
			validate(json);
			folderService.addFolder(fatherId, folderName, status, folderEname, type);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	
	/**
	 * @author 所有目录列表分页
	 *
	 */
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public String allFolder(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,ModelMap modelMap){
		PageVo<Folder> pageVo = folderService.getAllListPageByNum(pageNum);
		modelMap.put("pageVo", pageVo);
		return "admin/allFolder";
	}
	
	/**
	 * @author 进入修改目录资料页面
	 *
	 */
	@RequestMapping(value = "/one",method = RequestMethod.GET)
	public String oneFolder(@RequestParam(value = "folderId", defaultValue = "1") long folderId,ModelMap modelMap){
		Folder folder = folderService.getFolderById(folderId);
		if(folder.getFatherId()==0){
			modelMap.put("fatherFolderName","未分类");
		}else{
			Folder fatherFolder = folderService.getFolderById(folder.getFatherId());
			modelMap.put("fatherFolderName", fatherFolder.getName());
		}
		modelMap.put("folderAll", folderService.getAllList());
		modelMap.put("folder", folder);
		return "admin/updateFolder";
	}
	
	/**
	 * @author 修改目录资料
	 *
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateFolder(@RequestParam(value = "fatherId", defaultValue = "0") long fatherId,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "folderName") String folderName,
			@RequestParam(value = "folderEname") String folderEname,
			@RequestParam(value = "type") int type,
			@RequestParam(value = "sort") int sort,
			@RequestParam(value = "status") int status){
		folderService.updateFolderById(folderId, fatherId, folderEname, folderName,status, type, sort);
		return "redirect:/admin/folder/all";
	}
}
