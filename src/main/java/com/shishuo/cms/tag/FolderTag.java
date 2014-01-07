package com.shishuo.cms.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.entity.vo.FolderVo;
import com.shishuo.cms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service
public class FolderTag implements TemplateDirectiveModel {

	@Autowired
	private FolderService folderService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		Integer folderId = Integer.parseInt(params.get("folderId").toString());

		FolderVo folder = folderService.getFolderById(folderId);
		folder.setFolderList(folderService.getAllFolderList(
				folder.getFolderId(), null));
		env.setVariable("tag_folder", DEFAULT_WRAPPER.wrap(folder));
		body.render(env.getOut());
	}

}
