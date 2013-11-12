package com.shishuo.jiawacms.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.jiawacms.entity.Folder;
import com.shishuo.jiawacms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author Administrator
 * 
 *         folder标签
 * 
 */
@Service
public class FolderDirective implements TemplateDirectiveModel {

	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		List<Folder> list = folderService.getFolderListByFatherId(1);
		env.setVariable("list", DEFAULT_WRAPPER.wrap(list));

//		List<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		list.add("4");
//		list.add("5");
//		list.add("6");
//		list.add("7");
//		env.setVariable("list", DEFAULT_WRAPPER.wrap(list));
		body.render(env.getOut());

	}
}
