package com.shishuo.cms.plugins;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class FilterPlugins {

	private static HashMap<String, String> filterMap = new HashMap<String, String>();

	public void addFilter(String name, String method) {
		filterMap.put(name, method);
	}
}
