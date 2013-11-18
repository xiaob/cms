package com.shishuo.cms.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.shishuo.cms.util.PropertyIsNullException;

/**
 * 属性工具类
 * 
 * @author Herbert
 *
 */
public class PropertyUtils extends PropertyPlaceholderConfigurer {

	public static final Logger logger = Logger.getLogger(PropertyUtils.class);

	private static Map<String, String> propertyMap;

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		propertyMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			propertyMap.put(keyStr, value);
		}
	}

	public static String getValue(String name) throws PropertyIsNullException {
		String value = propertyMap.get(name);
		if (StringUtils.isBlank(value)) {
			String error = "属性[" + name + "]的值为空";
			logger.fatal(error);
			throw new PropertyIsNullException(error);
		} else {
			return value;
		}
	}
}
