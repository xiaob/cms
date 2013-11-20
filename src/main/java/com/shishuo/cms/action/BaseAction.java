package com.shishuo.cms.action;

import org.apache.log4j.Logger;

import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.exception.ValidateException;

/**
 * 
 * @author Herbert
 *
 */
public class BaseAction {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 参数校验
	 * 
	 * @param json
	 *            json数据Bean
	 * @throws ValidateException
	 */
	protected <T> void validate(JsonVo<T> json) throws ValidateException {
		if (json.getErrors().size() > 0) {
			json.setResult(false);
			throw new ValidateException("有错误发生");
		}else{
			json.setResult(true);
		}
	}
}
