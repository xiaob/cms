/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.shishuo.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.CommentConstant;
import com.shishuo.cms.entity.vo.CommentVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.service.CommentService;

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
public class CommentPageTag implements TemplateDirectiveModel {

	@Autowired
	private CommentService commentService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Integer fileId = Integer.parseInt(params.get("fileId").toString());
		Integer pageNum = Integer.parseInt(params.get("pageNum").toString());
		Integer rows = Integer.parseInt(params.get("rows").toString());
		PageVo<CommentVo> commentPage = commentService.getCommentPage(fileId,
				CommentConstant.kind.article, pageNum, rows);
		env.setVariable("tag_comment_page", BEANS_WRAPPER.wrap(commentPage));
		body.render(env.getOut());
	}

}
