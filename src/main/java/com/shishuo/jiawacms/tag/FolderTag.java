package com.shishuo.jiawacms.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.jiawacms.entity.Folder;
import com.shishuo.jiawacms.entity.vo.FolderVo;
import com.shishuo.jiawacms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

/**
 * @author Administrator
 * folder标签
 */
@Service
public class FolderTag implements TemplateDirectiveModel {

	@Autowired
	private static long folderId;
	

	public static long getFolderId() {
		return folderId;
	}

	public static void setFolderId(long folderId) {
		FolderTag.folderId = folderId;
	}

	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		List<Folder> list = folderService.getFolderListByFatherId(folderId);
		env.setVariable("folderList", DEFAULT_WRAPPER.wrap(list));
		body.render(env.getOut());
	}

}
