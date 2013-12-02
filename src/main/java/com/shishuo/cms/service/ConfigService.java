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
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.ConfigConstant;
import com.shishuo.cms.dao.ConfigDao;
import com.shishuo.cms.entity.Config;
import com.shishuo.cms.entity.vo.PageVo;
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
		return "/themes/" + template;
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
	 * 配置项目分页
	 * 
	 * 
	 * @param int
	 * @return PageVo
	 */
	public PageVo<Config> getConfigPage(int pageNum) {
		PageVo<Config> pageVo = new PageVo<Config>(pageNum);
		pageVo.setUrl("");
		List<Config> list = this
				.getConfig(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setPageCount(this.allConfigCount());
		return pageVo;
	}

	/**
	 * 所有配置
	 * 
	 * @param long,long
	 * @return List<Config>
	 */
	public List<Config> getConfig(long offset, long rows) {
		return configDao.getConfig(offset, rows);
	}

	/**
	 * 所有配置的数量
	 * 
	 * @return Integer
	 */
	public int allConfigCount() {
		return configDao.allConfigCount();

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
