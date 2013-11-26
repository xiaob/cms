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

	public static String KEY_TEMPLATE = "sys_template";

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
