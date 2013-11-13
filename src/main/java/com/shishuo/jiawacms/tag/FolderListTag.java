package com.shishuo.jiawacms.tag;

import java.io.IOException;
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
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

/**
 * @author Administrator folder标签
 */
@Service
public class FolderListTag implements TemplateDirectiveModel {

	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		Integer fatherId = Integer.parseInt(params.get("fatherId").toString());

		// 获得目录列表
		List<Folder> list = folderService.getFolderListByFatherId(fatherId);
		if (list == null) {
			fatherId = Integer.parseInt(params.get("fatherId").toString());
			List<Folder> li = folderService.getFolderListByFatherId(fatherId);
			env.setVariable("folderList", DEFAULT_WRAPPER.wrap(li));
		} else {
			env.setVariable("folderList", DEFAULT_WRAPPER.wrap(list));
		}
		body.render(env.getOut());
	}

}
