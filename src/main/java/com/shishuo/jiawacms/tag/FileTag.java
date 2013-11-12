package com.shishuo.jiawacms.tag;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.jiawacms.entity.File;
import com.shishuo.jiawacms.service.FileService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

/**
 * @author Administrator
 *	file标签
 */
@Service
public class FileTag implements TemplateDirectiveModel{

	@Autowired
	private FileService fileService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		File file = new File();
		file.setFileId(1);
		file.setName("23423");
		env.setVariable("file", BEANS_WRAPPER.wrap(file));
		body.render(env.getOut());
	}
}
