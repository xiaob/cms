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
package com.shishuo.cms.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.ConfigConstant;
import com.shishuo.cms.dao.ConfigDao;
import com.shishuo.cms.entity.Config;
import com.shishuo.cms.util.MemcacheMapUtil;

/**
 * 网站配置
 * 
 * @author Zhangjiale
 * 
 */
@Service
public class ConfigService {

	@Autowired
	private ConfigDao configDao;

	/**
	 * 得到当前模板路径
	 * 
	 * @return
	 */
	public String getTemplatePath() {
		String template = this.getConfigByKey(ConfigConstant.SYS_TEMPLATE,
				false);
		if (StringUtils.isBlank(template)) {
			return "/" + ConfigConstant.DEFAUTL_TEMPLATE;
		} else {
			return "/" + template;
		}
	}

	/**
	 * 增加配置
	 * 
	 * @param key
	 * @param value
	 * @return Config
	 */
	public Config addConfig(String key, String value) {
		Config config = new Config();
		config.setKey(key);
		config.setValue(value);
		config.setCreateTime(new Date());
		configDao.addConfig(config);
		return config;
	}

	/**
	 * 删除配置
	 * 
	 * @param key
	 * @return Integer
	 */

	public int deleteConfigByKey(String key) {
		return configDao.deleteConfig(key);
	}

	/**
	 * 更新配置
	 * 
	 * @param key
	 * @param value
	 * @return Config
	 */
	public Config updagteConfigByKey(String key, String value) {
		Config config = configDao.getConfigByKey(key);
		config.setValue(value);
		configDao.updateConfig(config);
		this.getConfigByKey(key, true);
		return config;
	}

	/**
	 * @param key
	 * @return
	 */
	public String getConfigByKey(String key, boolean refresh) {
		String value = (String) MemcacheMapUtil.get(MemcacheMapUtil.createKey(
				"config_", key));
		if (StringUtils.isBlank(value) || refresh) {
			Config config = configDao.getConfigByKey(key);
			if (config == null) {
				value = "";
			} else {
				value = config.getValue();
				MemcacheMapUtil.set(key, config);
			}
		}
		return value;

	}

}
