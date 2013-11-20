package com.shishuo.cms.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.FolderVo;
import com.shishuo.cms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;


/**
 * folder标签
 * 
 * @author lqq
 *
 */
@Service
public class FolderListTag implements TemplateDirectiveModel { 
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
	//	System.out.println("#########"+params.get("fatherId"));
		// 获取页面的参数
		Integer fatherId = Integer.parseInt(params.get("fatherId").toString());

		// 获得目录列表
		List<Folder> list = folderService.getFolderListByFatherId(fatherId);
		env.setVariable("folderList", DEFAULT_WRAPPER.wrap(list));
		body.render(env.getOut());
	}

}
