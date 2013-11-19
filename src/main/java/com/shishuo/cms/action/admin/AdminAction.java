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

/**
 * @author lqq
 * @author 进入网站后台首页
 *
 */

@Controller
@RequestMapping("/admin")
public class AdminAction extends AdminBaseAction{

	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap modelMap){
		modelMap.put("articleCount", fileService.getFileListByTypeCount(0,1));
		modelMap.put("downloadCount", fileService.getFileListByTypeCount(1,1));
		modelMap.put("commodityCount", fileService.getFileListByTypeCount(2,1));
		modelMap.put("userCount", userService.getUserListCount());
		return "admin/default";
	}	
	
}
