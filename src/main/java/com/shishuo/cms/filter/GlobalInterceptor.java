package com.shishuo.cms.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
		modelAndView.addObject("basePath", basePath);
		modelAndView.addObject("contextPath", contextPath);
		modelAndView.addObject("SYS_SITEDESC",
				configService.getConfigByKey(ConfigConstant.SYS_SITEDESC));
		modelAndView.addObject("SYS_SITENAME",
				configService.getConfigByKey(ConfigConstant.SYS_SITENAME));
		modelAndView.addObject("SYS_TEMPLATE",
				configService.getConfigByKey(ConfigConstant.SYS_THEME));
		modelAndView.addObject("TEMPLATE_PATH", basePath + "/themes/"
				+ configService.getConfigByKey(ConfigConstant.SYS_THEME));
		MDC.put("ip", HttpUtils.getIp(request));

		if (StringUtils.isBlank(SystemConstant.BASE_PATH)) {
			SystemConstant.BASE_PATH = basePath;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
