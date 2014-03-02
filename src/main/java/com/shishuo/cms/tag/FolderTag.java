/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.shishuo.cms.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.FolderConstant;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.FolderVo;
import com.shishuo.cms.exception.FolderNotFoundException;
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

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		Integer folderId = Integer.parseInt(params.get("folderId").toString());

		try {
			FolderVo folder = folderService.getFolderById(folderId);
			folder.setFolderList(folderService.getAllFolderList(
					folder.getFolderId(), FolderConstant.Status.display));
			env.setVariable("tag_folder", DEFAULT_WRAPPER.wrap(folder));
		} catch (FolderNotFoundException e) {
			env.setVariable("tag_folder", DEFAULT_WRAPPER.wrap(new Folder()));
		}

		body.render(env.getOut());
	}

}
