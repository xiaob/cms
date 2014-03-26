/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.shishuo.cms.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.FolderConstant;
import com.shishuo.cms.entity.vo.FolderVo;
import com.shishuo.cms.plugin.TagPlugin;
import com.shishuo.cms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * folder标签
 * 
 * @author lqq
 * 
 */
@Service
public class FolderListLevel2Tag extends TagPlugin {
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		try {
			// 获取页面的参数
			Integer fatherId = Integer.parseInt(params.get("fatherId")
					.toString());
			FolderVo folder = folderService.getFolderById(fatherId);
			FolderVo firstFolder = folderService.getFolderById(folder.getFirstFolderId());
			// 获得目录列表
			List<FolderVo> list = folderService.getFolderListByFatherId(
					folder.getFirstFolderId(), FolderConstant.status.display);
			env.setVariable("tag_folder_list", DEFAULT_WRAPPER.wrap(list));
			env.setVariable("tag_folder", DEFAULT_WRAPPER.wrap(firstFolder));
			body.render(env.getOut());
		} catch (Exception e) {

		}
	}

}
