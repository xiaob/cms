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
package com.shishuo.cms.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.shishuo.cms.exception.AuthException;

/**
 * 授权相关的工具类
 * 
 * @author Herbert
 * 
 */
public class AuthUtils {

	/**
	 * 生产密文密码
	 * 
	 * @param password
	 *            明文密码
	 * @param email
	 *            邮箱
	 * @param time
	 *            创建时间戳
	 * @return
	 * @throws AuthException
	 */
	public static String getPassword(String password, String email, String time)
			throws AuthException {
		if (StringUtils.isBlank(password) || StringUtils.isBlank(email)
				|| StringUtils.isBlank(email)) {
			throw new AuthException("值不能为空");
		}
		char[] passwordMD5Char = DigestUtils.md5Hex(password).toUpperCase()
				.toCharArray();
		char[] emailMD5SChar = DigestUtils.md5Hex(email).toUpperCase()
				.toCharArray();
		char[] timeMD5SChar = DigestUtils.md5Hex(time).toUpperCase()
				.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 32; i++) {
			sb.append(passwordMD5Char[i]);
			sb.append(emailMD5SChar[i]);
			sb.append(timeMD5SChar[i]);
		}

		return DigestUtils.md5Hex(
				Base64.encodeBase64String(sb.toString().getBytes()))
				.toUpperCase();
	}
}
