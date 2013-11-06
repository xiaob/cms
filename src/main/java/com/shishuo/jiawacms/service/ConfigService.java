/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.shishuo.com/jiawacms/licenses
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.jiawacms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.jiawacms.dao.ConfigDao;
import com.shishuo.jiawacms.entity.Config;
import com.shishuo.jiawacms.entity.vo.PageVo;

/**
 * 网站配置
 * 
 * @author Herbert
 * 
 */
@Service
public class ConfigService {
	
	@Autowired
	private ConfigDao configDao;
	
	/**
	 * 增加配置
	 * 
	 * @param key
	 * @param value
	 * @return Integer
	 */
	public int addConfig(String key,String value) {
		Config config = new Config();
		config.setKey(key);
		config.setValue(value);
		config.setCreateTime(new Date());
		return configDao.addConfig(config);
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
	 * @return config
	 */
	public Config updagteConfigByKey(String key, String value) {
		Config config = configDao.getConfigByKey(key);
		config.setValue(value);
		configDao.updateConfig(config);
		return config;
	}

	/**
	 * 配置项目分页
	 * @param pageNum
	 * @return pageVo
	 */
	public PageVo<Config> getConfigPage(int pageNum) {
		PageVo<Config> pageVo = new PageVo<Config>(pageNum);
		pageVo.setUrl("");
		List<Config> list = this.allConfig(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setPageCount(this.allConfigCount());
		return pageVo;
	}
	
	/**
	 * 所有配置
	 * 
	 * @return List<Config>
	 */
	public List<Config> allConfig(long offset, long rows){
		return configDao.allConfig(offset, rows);
	}
	
	/**
	 * 所有配置的数量
	 * 
	 * @return Integer
	 */
	public int allConfigCount(){
		return (int)configDao.allConfigCount();
	}
}
