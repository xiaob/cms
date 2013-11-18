package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.PageVo;

@Controller
@RequestMapping("/admin/file")
public class AdminFileAction extends AdminBaseAction{

	@RequestMapping(value = "/articleList.do",method = RequestMethod.GET)
	public String allFolder(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,ModelMap modelMap){
		PageVo<File> pageVo = fileService.getFileListByTypePage(0, pageNum);
		modelMap.put("pageVo", pageVo);
		return "admin/articleList";
	}
	
}
