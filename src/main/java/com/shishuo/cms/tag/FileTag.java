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
package com.shishuo.cms.tag;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.vo.FileVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.exception.FileNotFoundException;
import com.shishuo.cms.service.FileService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

/**
 * @author Administrator file标签
 */
@Service
public class FileTag implements TemplateDirectiveModel {

	@Autowired
	private FileService fileService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		Integer fileId = Integer.parseInt(params.get("fileId").toString());
		// 获取指定的文件
		FileVo file;
		try {
			file = fileService.getFileByFileId(fileId);
			env.setVariable("file", BEANS_WRAPPER.wrap(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		body.render(env.getOut());
	}
}
