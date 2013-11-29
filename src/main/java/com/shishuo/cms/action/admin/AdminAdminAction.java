/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.shishuo.com/jiawacms/licenses
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

import com.shishuo.cms.constant.AdminConstant;
import com.shishuo.cms.entity.vo.JsonVo;


/**
 * 管理员action
 * @author Zhangjiale
 *
 */
@Controller
@RequestMapping("/admin/admin")
public class AdminAdminAction extends AdminBaseAction {

	/**
	 * 进入addAdmin页面
	 *
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(ModelMap modelMap) {
		modelMap.put("adminName", "");
		modelMap.put("email", "");
		return "admin/admin/add";
	}

	/**
	 * 添加Admin
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/addNew.json", method = RequestMethod.POST)
	public JsonVo<String> addNewUser(
			@RequestParam(value = "adminName") String adminName,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if (adminName.equals("")) {
				json.getErrors().put("adminName", "管理员名称不能为空");
			}
			if (email.equals("")) {
				json.getErrors().put("email", "管理员邮箱不能为空");
			}
			// 检测校验结果
			validate(json);
			adminService.addAdmin(email, adminName, password,AdminConstant.Status.INIT);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	/**
	 * 进入管理员列表页面
	 *
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String allList(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			ModelMap modelMap) {
		modelMap.put("pageVo", adminService.getAllListPage(pageNum));
		return "admin/admin/all";
	}

	/**
	 * 进入单个admmin页面
	 *
	 */
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public String oneAdmin(@RequestParam(value = "adminId") long adminId,
			ModelMap modelMap) {
		modelMap.put("admin", adminService.getAdminById(adminId));
		return "admin/admin/update";
	}

	/**
	 * 修改指定的admin资料
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<String> updateAdmin(
			@RequestParam(value = "adminName") String adminName,
			@RequestParam(value = "password",defaultValue="-1") String password,
			@RequestParam(value = "adminId") long adminId,
			@RequestParam(value = "status") AdminConstant.Status status) {

		JsonVo<String> json = new JsonVo<String>();
		try {
			if (adminName.equals("")) {
				json.getErrors().put("adminName", "管理员名称不能为空");
			}
			// 检测校验结果
			validate(json);
			if(password.equals("-1")){
				adminService.updateAdmin(adminId, adminName, "", status);
			}else{
				adminService.updateAdmin(adminId, adminName, password, status);
			}
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	/**
	 * 删除管理员
	 *
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAdmin(@RequestParam(value = "adminId") long adminId) {
		adminService.deleteAdmin(adminId);
		return "redirect:/admin/admin/all";
	}
}
