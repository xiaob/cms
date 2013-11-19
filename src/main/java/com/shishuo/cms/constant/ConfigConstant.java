package com.shishuo.cms.constant;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.shishuo.cms.exception.ConfigIsNullException;
import com.shishuo.cms.service.ConfigService;

/**
 * 系统配置常量
 * 
 * @author Herbert
 */
@Component
public class ConfigConstant {

	/**
	 * 默认的模板
	 */
	public static String DEFAUTL_TEMPLATE = "defalut";

	public static String KEY_TEMPLATE = "template";

	/**
	 * 得到当前模板路径
	 * 
	 * @return
	 */
	public static String getTemplatePath() {
		try {
			return "/" + getConfigValueByKey(KEY_TEMPLATE);
		} catch (ConfigIsNullException e) {
			return "/" + DEFAUTL_TEMPLATE;
		}
	}

	/**
	 * 根据key，获得对应的系统配置的值
	 * 
	 * @param key
	 * @return
	 * @throws ConfigIsNullException
	 */
	public static String getConfigValueByKey(String key)
			throws ConfigIsNullException {
		String value = ConfigService.CONFIG_MAP.get(key);
		if (StringUtils.isBlank(value)) {
			throw new ConfigIsNullException(key + " is NULL");
		} else {
			return value;
		}
	}
}
