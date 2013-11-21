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
 * 用户action
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserAction extends AdminBaseAction{

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String addUser(ModelMap modelMap){
		modelMap.put("userName", "");
		return "admin/user/addUser";
	}
	
//	@RequestMapping(value = "/addNew",method = RequestMethod.POST)
//	public String addNewUser(@RequestParam(value = "userName") String userName){
//		userService.addUser(userName);
//		return "redirect:/admin/user/allList";
//	}
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
	
	@RequestMapping(value = "/allList",method = RequestMethod.GET)
	public String allList(@RequestParam(value = "pageNum",defaultValue="1") int pageNum,
			ModelMap modelMap){
		modelMap.put("pageVo", userService.getUserPage(pageNum));
		return "admin/user/allUser";
	}
	
	@RequestMapping(value = "/one",method = RequestMethod.GET)
	public String oneAdmin(@RequestParam(value = "userId") long userId,
			ModelMap modelMap){
		modelMap.put("user", userService.getUserById(userId));
		return "admin/user/updateUser";
	}
	
//	@RequestMapping(value = "/update",method = RequestMethod.POST)
//	public String updateAdmin(@RequestParam(value = "userName") String userName,
//			@RequestParam(value = "userId") long userId,
//			@RequestParam(value = "type") int type){
//		userService.updateUser(userId, type, userName);
//		return "redirect:/admin/user/allList";
//	}
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
	
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteUser(@RequestParam(value = "userId") long userId){
		userService.deleteUserById(userId);
		return "redirect:/admin/user/allList";
	}

}
