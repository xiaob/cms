package com.shishuo.jiawacms.tag;

import static freemarker.template.ObjectWrapper.*;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.jiawacms.entity.File;
import com.shishuo.jiawacms.entity.vo.PageVo;
import com.shishuo.jiawacms.service.FileService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author Administrator fileList标签
 * 
 */
@Service
public class FilePageTag implements TemplateDirectiveModel {

	@Autowired
	private FileService fileService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		Integer folderId = Integer.parseInt(params.get("folderId").toString());
		Integer pageNum = Integer.parseInt(params.get("pageNum").toString());
		// 获取文件的分页
		PageVo<File> pageVo = fileService.getFilePageByFoderId(folderId,
				pageNum);
		env.setVariable("pageVo", BEANS_WRAPPER.wrap(pageVo));
		body.render(env.getOut());
	}

}
