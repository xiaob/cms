package com.shishuo.jiawacms.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

/**
 * @author Administrator
 * 	fileList标签
 *
 */
@Service
public class FileListTag implements TemplateDirectiveModel{

	@Autowired
	private FileService fileService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("4");
		list.add("5");
		list.add("6");
		env.setVariable("list", DEFAULT_WRAPPER.wrap(list));
		body.render(env.getOut());	
	}
	
	
}
