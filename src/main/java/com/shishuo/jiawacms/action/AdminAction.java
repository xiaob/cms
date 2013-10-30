/*
 * 
 *	Copyright 漏 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	闀挎矙甯傚笀璇寸綉缁滅鎶�湁闄愬叕鍙�鐗堟潈鎵�湁
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
package com.shishuo.jiawacms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shishuo.jiawacms.service.AdminService;

@Controller
public class AdminAction {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HttpServletRequest request;
}
