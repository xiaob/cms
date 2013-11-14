package com.shishuo.cms.constant;

import java.util.HashMap;
import java.util.List;

import com.shishuo.cms.entity.Config;
import com.shishuo.cms.service.ConfigService;

/**
 * 系统配置常量
 * 
 * @author Herbert
 */
public class ConfigConstant {

	private ConfigService configService;
	/**
	 * 默认的模板
	 */
	public static String DEFAUTL_TEMPLATE = "default";
	
	public static HashMap<String,String> configHashMap = new HashMap<String,String>();
	
	public ConfigConstant(){
		List<Config>  configList = configService.allConfig(0,100);
		for(Config config:configList){
			configHashMap.put(config.getKey(), config.getValue());
		}
		DEFAUTL_TEMPLATE = configHashMap.get("template");
	}
	/**
	 * 得到当前模板路径
	 * 
	 * @return
	 */
	public static String getTemplatePath() {
		return "/template/" + DEFAUTL_TEMPLATE;
	}
}
