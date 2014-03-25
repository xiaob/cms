/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.shishuo.cms.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shishuo.cms.constant.ConfigConstant;
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.service.ConfigService;
import com.shishuo.cms.util.HttpUtils;

/**
 * @author Herbert
 * 
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {

	@Autowired
	private ConfigService configService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (null == modelAndView) {
			return;
		}
		Admin admin = (Admin) request.getSession().getAttribute(
				SystemConstant.SESSION_ADMIN);
		if (admin == null) {
			modelAndView.addObject("isAdmin", false);
		} else {
			modelAndView.addObject("isAdmin", true);
		}
		// 系统配置参数
		String basePath = HttpUtils.getBasePath(request);
		String contextPath = HttpUtils.getContextPath(request);
		modelAndView.addObject("BASE_PATH", basePath);
		modelAndView.addObject("contextPath", contextPath);
		modelAndView.addObject("SYS_SITEDESC",
				configService.getConfigByKey(ConfigConstant.SYS_SITEDESC));
		modelAndView.addObject("SYS_SITENAME",
				configService.getConfigByKey(ConfigConstant.SYS_SITENAME));
		modelAndView.addObject("SYS_TEMPLATE",
				configService.getConfigByKey(ConfigConstant.SYS_THEME));
		modelAndView.addObject(
				"STATIC_THEME_PATH",
				basePath
						+ "/static/themes/"
						+ configService
								.getConfigByKey(ConfigConstant.SYS_THEME));
		modelAndView.addObject("STATIC_SYSTEM_PATH", basePath
				+ "/static/system/");
		MDC.put("ip", HttpUtils.getIp(request));
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
