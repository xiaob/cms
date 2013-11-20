package com.shishuo.cms.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.entity.File;
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
		File file = fileService.getFileById(fileId);
		env.setVariable("file", BEANS_WRAPPER.wrap(file));
		body.render(env.getOut());
	}
}
