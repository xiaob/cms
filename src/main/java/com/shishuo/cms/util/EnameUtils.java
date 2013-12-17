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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnameUtils {
	 
	 public static boolean test(String str){
		 boolean result = false;
		  int count = 0; 
		  String regEx = "[\\u4e00-\\u9fa5]"; 
		  Pattern p = Pattern.compile(regEx); 
		  Matcher m = p.matcher(str); 
		  while (m.find()) { 
		   for (int i = 0; i <= m.groupCount(); i++) { 
		    count = count + 1; 
		   	} 
		  } 
		  if(count==0){
			  result=true;
			  return result;
		  }else{
			  return result;
		  }
	 } 
}
