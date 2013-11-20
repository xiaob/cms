package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.constant.AdminConstant;

@Controller
@RequestMapping("/admin/admin")
public class AdminAdminAction extends AdminBaseAction{

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String addUser(ModelMap modelMap){
		
		return "admin/admin/addAdmin";
	}
	
	@RequestMapping(value = "/addNew",method = RequestMethod.POST)
	public String addNewUser(@RequestParam(value = "adminName") String adminName){
		adminService.addAdmin(adminName, AdminConstant.PASS_WORD, 0);
		return "redirect:/admin/admin/allList.do";
	}
	
	@RequestMapping(value = "/allList",method = RequestMethod.GET)
	public String allList(@RequestParam(value = "pageNum",defaultValue="1") int pageNum,
			ModelMap modelMap){
		modelMap.put("pageVo", adminService.getAllListPage(pageNum));
		return "admin/admin/allAdmin";
	}
	
	@RequestMapping(value = "/one",method = RequestMethod.GET)
	public String oneAdmin(@RequestParam(value = "adminId") long adminId,
			ModelMap modelMap){
		modelMap.put("admin", adminService.getAdminById(adminId));
		return "admin/admin/updateAdmin";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateAdmin(@RequestParam(value = "adminName") String adminName,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "adminId") long adminId,
			@RequestParam(value = "status") int status){
		adminService.updateAdmin(adminId, adminName, password, status);
		return "redirect:/admin/admin/allList";
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteAdmin(@RequestParam(value = "adminId") long adminId){
		adminService.deleteAdmin(adminId);
		return "redirect:/admin/admin/allList";
	}
}
