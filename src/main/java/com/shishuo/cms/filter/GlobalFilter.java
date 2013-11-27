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
package com.shishuo.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shishuo.cms.constant.ConfigConstant;
import com.shishuo.cms.service.ConfigService;
import com.shishuo.cms.util.HttpUtils;

/**
 * @author Herbert
 *
 */
@Component
public class GlobalFilter implements Filter {
	
	@Autowired
	private ConfigService configService;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
//		String path = request.getContextPath();
//		String basePath = request.getScheme() + "://" + request.getServerName()
//				+ ":" + request.getServerPort() + path;
//		request.setAttribute("basePath", basePath);
//		request.setAttribute("SYS_FUNCTION_DOWNLOAD", configService.getConfigByKey(ConfigConstant.SYS_FUNCTION_DOWNLOAD));
//		request.setAttribute("SYS_FUNCTION_PHOTO", configService.getConfigByKey(ConfigConstant.SYS_FUNCTION_PHOTO));
//		request.setAttribute("SYS_FUNCTION_SHOP", configService.getConfigByKey(ConfigConstant.SYS_FUNCTION_SHOP));
//		request.setAttribute("SYS_SITEDESC", configService.getConfigByKey(ConfigConstant.SYS_SITEDESC));
//		request.setAttribute("SYS_SITENAME", configService.getConfigByKey(ConfigConstant.SYS_SITENAME));
//		request.setAttribute("SYS_TEMPLATE", configService.getConfigByKey(ConfigConstant.SYS_TEMPLATE));
//		MDC.put("ip", HttpUtils.getIp(request));
		chain.doFilter(request, response);
//		MDC.remove("ip");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
