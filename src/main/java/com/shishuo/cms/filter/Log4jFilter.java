package com.shishuo.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.MDC;

import com.shishuo.cms.util.HttpUtils;

public class Log4jFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String ip = HttpUtils.getIp(request);
		MDC.put("ip", ip);
		chain.doFilter(servletRequest, servletResponse);
		MDC.remove("ip");
	}

	@Override
	public void destroy() {

	}

}
