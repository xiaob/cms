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
package com.shishuo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shishuo.cms.entity.Config;

/**
 * 网站配置
 * 
 * @author Zhangjiale
 * 
 */

@Repository
public interface ConfigDao {

	/**
	 * 增加配置
	 * 
	 * @return Integer
	 */
	public int addConfig(Config config);

	/**
	 * 删除配置
	 * 
	 * return Integer
	 */
	public int deleteConfig(@Param("key") String key);

	/**
	 * 查看所有配置
	 * 
	 * @param offset
	 * @param rows
	 * 
	 * @return List<Config>
	 */
	public List<Config> getConfig(@Param("offset") long offset,
			@Param("rows") long rows);

	/**
	 * 得到所有配置
	 * 
	 * @return
	 */
	public List<Config> getAllConfig();

	/**
	 * 查看所有配置的数量
	 * 
	 * return Integer
	 */
	public int allConfigCount();

	/**
	 * 更新配置
	 * 
	 * @return Integer
	 */
	public int updateConfig(Config config);

	/**
	 * 查看配置
	 * 
	 * @return Config
	 */
	public Config getConfigByKey(@Param("key") String key);
}
