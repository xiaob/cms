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

import com.shishuo.cms.entity.vo.JsonVo;

/**
 * 用户action
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserAction extends AdminBaseAction{

	/**
	 * 进入添加用户页面
	 * @author Administrator
	 *
	 */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String addUser(ModelMap modelMap){
		modelMap.put("userName", "");
		return "admin/user/addUser";
	}
	/**
	 * 添加用户
	 * @author Administrator
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/addNew.json",method = RequestMethod.POST)
	public JsonVo<String> addNewUser(@RequestParam(value = "userName") String userName){
		JsonVo<String> json = new JsonVo<String>();	
		try {
			if(userName.equals("")){
				json.getErrors().put("userName", "用户名称不能为空");
			}
			
			// 检测校验结果
			validate(json);
			userService.addUser(userName);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	/**
	 * 所有用户列表页面
	 * @author Administrator
	 *
	 */
	@RequestMapping(value = "/allList",method = RequestMethod.GET)
	public String allList(@RequestParam(value = "pageNum",defaultValue="1") int pageNum,
			ModelMap modelMap){
		modelMap.put("pageVo", userService.getUserPage(pageNum));
		return "admin/user/allUser";
	}
	
	/**
	 * 用户详细资料页面
	 * @author Administrator
	 *
	 */
	@RequestMapping(value = "/one",method = RequestMethod.GET)
	public String oneAdmin(@RequestParam(value = "userId") long userId,
			ModelMap modelMap){
		modelMap.put("user", userService.getUserById(userId));
		return "admin/user/updateUser";
	}
	
	/**
	 * 修改用户资料
	 * @author Administrator
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json",method = RequestMethod.POST)
	public JsonVo<String> updateAdmin(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "userId") long userId,
			@RequestParam(value = "type",defaultValue="-1") int type){
		
		JsonVo<String> json = new JsonVo<String>();	
		try {
			if(userName.equals("")){
				json.getErrors().put("userName", "用户名称不能为空");
			}
			if(type==-1){
				json.getErrors().put("type", "用户类型不能为空");
			}
			
			// 检测校验结果
			validate(json);
			userService.updateUser(userId, type, userName);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	/**
	 * 删除用户
	 * @author Administrator
	 *
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteUser(@RequestParam(value = "userId") long userId){
		userService.deleteUserById(userId);
		return "redirect:/admin/user/allList";
	}

}
