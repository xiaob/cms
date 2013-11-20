package com.shishuo.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.entity.vo.CommentVo;
import com.shishuo.cms.service.CommentService;
import com.shishuo.cms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * 评论标签
 * 
 * @author lqq
 *
 */
@Service
public class CommentTag implements TemplateDirectiveModel{
	
	@Autowired
	private CommentService commentService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// TODO Auto-generated method stub
		Integer fileId = Integer.parseInt(params.get("fileId").toString());
		List<CommentVo> commentVoList = commentService.getComment(fileId);
		env.setVariable("commentVoList", BEANS_WRAPPER.wrap(commentVoList));
		body.render(env.getOut());
	}
  
}
