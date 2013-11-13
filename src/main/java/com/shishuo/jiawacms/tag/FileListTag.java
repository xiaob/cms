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
 * @author Administrator
 * 	fileList标签
 *
 */
@Service
public class FileListTag implements TemplateDirectiveModel{

	private static long folderId;
	
	private static int pageNum = 1;
	
	
	public static int getPageNum() {
		return pageNum;
	}

	public static void setPageNum(int pageNum) {
		FileListTag.pageNum = pageNum;
	}

	public static long getFolderId() {
		return folderId;
	}

	public static void setFolderId(long folderId) {
		FileListTag.folderId = folderId;
	}

	@Autowired
	private FileService fileService;
	
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		PageVo<File> pageVo = fileService.getFilePageByFoderId(folderId, 1);
		env.setVariable("pageVo", BEANS_WRAPPER.wrap(pageVo));
		body.render(env.getOut());	
	}
	
}
