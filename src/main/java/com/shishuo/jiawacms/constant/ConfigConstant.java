package com.shishuo.jiawacms.constant;

/**
 * 系统配置常量
 * @author Herbert
 */
public class ConfigConstant {

	/**
	 * 默认的模板
	 */
	public static String DEFAUTL_TEMPLATE = "default";

	/**
	 * 得到当前模板路径
	 * @return
	 */
	public static String getTemplatePath() {
		return "/template/" + DEFAUTL_TEMPLATE;
	}
}
