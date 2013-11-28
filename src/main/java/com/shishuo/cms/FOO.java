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

package com.shishuo.cms;

import java.io.File;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;


/**
 * 
 * 
 * @author Herbert
 * 
 */
public class FOO {

	// public static void main(String[] args) {
	// System.out.println("欢迎来到Java的世界，欢迎使用师说CMS。");
	//
	//
	// }
	
	public static void main(String[] args) throws Exception
	  {
	    XmlMapper xmlMapper = new XmlMapper();
	    Object entries = xmlMapper.readValue(new File("/Users/Herbert/git/CMS/src/main/webapp/WEB-INF/ftl/default/template.xml"), Object.class);

	    ObjectMapper jsonMapper = new ObjectMapper();
	    String json = jsonMapper.writeValueAsString(entries);
	    System.out.println(json);
	    // [{"name":"AXL","time":"19-07","price":"11.34"},{"name":"AIK","time":"19-07","price":"13.54"},{"name":"ALO","time":"19-07","price":"16.32"},{"name":"APO","time":"19-07","price":"13.56"}]
	  }
}
