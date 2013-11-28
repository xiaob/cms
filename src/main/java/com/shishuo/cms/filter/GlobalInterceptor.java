package com.shishuo.cms.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shishuo.cms.constant.ConfigConstant;
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

		// 系统配置参数
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path;
		modelAndView.addObject("basePath", basePath);
		modelAndView.addObject("SYS_FUNCTION_DOWNLOAD", configService
				.getConfigByKey(ConfigConstant.SYS_FUNCTION_DOWNLOAD, true));
		modelAndView.addObject("SYS_FUNCTION_PHOTO", configService
				.getConfigByKey(ConfigConstant.SYS_FUNCTION_PHOTO, true));
		modelAndView.addObject("SYS_FUNCTION_SHOP", configService
				.getConfigByKey(ConfigConstant.SYS_FUNCTION_SHOP, true));
		modelAndView
				.addObject("SYS_SITEDESC", configService.getConfigByKey(
						ConfigConstant.SYS_SITEDESC, true));
		modelAndView
				.addObject("SYS_SITENAME", configService.getConfigByKey(
						ConfigConstant.SYS_SITENAME, true));
		modelAndView
				.addObject("SYS_TEMPLATE", configService.getConfigByKey(
						ConfigConstant.SYS_TEMPLATE, true));
		MDC.put("ip", HttpUtils.getIp(request));
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
