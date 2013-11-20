package com.shishuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishuo.cms.constant.AdminConstant;
import com.shishuo.cms.entity.vo.JsonVo;

@Controller
@RequestMapping("/admin/admin")
public class AdminAdminAction extends AdminBaseAction {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(ModelMap modelMap) {
		modelMap.put("adminName", "");
		return "admin/admin/addAdmin";
	}

	// @RequestMapping(value = "/addNew",method = RequestMethod.POST)
	// public String addNewUser(@RequestParam(value = "adminName") String
	// adminName){
	// adminService.addAdmin(adminName, AdminConstant.PASS_WORD, 0);
	// return "redirect:/admin/admin/allList.do";
	// }
	@ResponseBody
	@RequestMapping(value = "/addNew.json", method = RequestMethod.POST)
	public JsonVo<String> addNewUser(
			@RequestParam(value = "adminName") String adminName) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if (adminName.equals("")) {
				json.getErrors().put("adminName", "管理员名称不能为空");
			}

			// 检测校验结果
			validate(json);
			adminService.addAdmin("email", adminName, "1234567");
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	@RequestMapping(value = "/allList", method = RequestMethod.GET)
	public String allList(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			ModelMap modelMap) {
		modelMap.put("pageVo", adminService.getAllListPage(pageNum));
		return "admin/admin/allAdmin";
	}

	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public String oneAdmin(@RequestParam(value = "adminId") long adminId,
			ModelMap modelMap) {
		modelMap.put("admin", adminService.getAdminById(adminId));
		return "admin/admin/updateAdmin";
	}

	// @RequestMapping(value = "/update",method = RequestMethod.POST)
	// public String updateAdmin(@RequestParam(value = "adminName") String
	// adminName,
	// @RequestParam(value = "password") String password,
	// @RequestParam(value = "adminId") long adminId,
	// @RequestParam(value = "status") int status){
	// adminService.updateAdmin(adminId, adminName, password, status);
	// return "redirect:/admin/admin/allList";
	// }
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<String> updateAdmin(
			@RequestParam(value = "adminName") String adminName,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "adminId") long adminId,
			@RequestParam(value = "status", defaultValue = "-1") int status) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if (adminName.equals("")) {
				json.getErrors().put("adminName", "管理员名称不能为空");
			}
			if (password.equals("")) {
				json.getErrors().put("password", "密码不能为空");
			}
			if (status == -1) {
				json.getErrors().put("status", "状态不能为空");
			}

			// 检测校验结果
			validate(json);
			adminService.updateAdmin(adminId, adminName, password, status);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAdmin(@RequestParam(value = "adminId") long adminId) {
		adminService.deleteAdmin(adminId);
		return "redirect:/admin/admin/allList";
	}
}
