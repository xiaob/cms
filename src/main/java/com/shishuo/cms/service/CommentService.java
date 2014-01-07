/*

 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.CommentConstant;
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.dao.CommentDao;
import com.shishuo.cms.entity.Comment;
import com.shishuo.cms.entity.vo.CommentVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.util.AuthUtils;

/**
 * 评论服务
 * 
 * @author Administrator
 * 
 */
@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private UserService userService;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加评论
	 * 
	 * @param fileId
	 * @param fatherId
	 * @param email
	 * @param name
	 * @param ip
	 * @param content
	 * @return Comment
	 * 
	 */
	public Comment addComment(long kindId, CommentConstant.kind kind,
			long phone, String email, String name, String ip, String content) {
		Comment comment = new Comment();
		comment.setKindId(kindId);
		comment.setFatherId(0);
		comment.setEmail(email);
		comment.setStatus(CommentConstant.Status.display);
		comment.setContent(content);
		comment.setCreateTime(new Date());
		comment.setIp(ip);
		comment.setName(name);
		comment.setKind(kind);
		comment.setPhone(phone);
		commentDao.addComment(comment);
		return comment;

	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改评论状态
	 * 
	 * @param commentId
	 * @param status
	 * @return Integer
	 */
	public int updateCommentStatus(long commentId, CommentConstant.Status status) {
		Comment comment = this.getCommentById(commentId);
		comment.setStatus(status);
		return commentDao.updateCommentStatus(comment);
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 获得评论分页
	 * 
	 * @param fileId
	 * @param pageNum
	 * @return
	 */
	public PageVo<CommentVo> getCommentPage(long kindId,
			CommentConstant.kind kind, int pageNum, int rows) {
		PageVo<CommentVo> pageVo = new PageVo<CommentVo>(pageNum);
		pageVo.setRows(rows);
		pageVo.setCount(this.getCommentCountByFatherId(kindId, kind, 0,
				CommentConstant.Status.display));
		List<CommentVo> commentList = this.getCommentListByFatherId(kindId,
				kind, 0, CommentConstant.Status.display, pageVo.getOffset(),
				pageVo.getRows());
		for (CommentVo comment : commentList) {
			List<CommentVo> childComment = this.getCommentListByFatherId(
					kindId, kind, comment.getCommentId(),
					CommentConstant.Status.display, 0, 50);
			comment.setChildComment(childComment);
		}
		pageVo.setList(commentList);
		return pageVo;
	}

	public int getCommentCountByFatherId(long kindId,
			CommentConstant.kind kind, long fatherId,
			CommentConstant.Status status) {
		return commentDao.getCommentCountByFatherId(kindId, kind, 0, status);
	}

	public List<CommentVo> getCommentListByFatherId(long kindId,
			CommentConstant.kind kind, long fatherId,
			CommentConstant.Status status, long offset, long rows) {
		List<CommentVo> commentList = commentDao.getCommentListByFatherId(
				kindId, kind, fatherId, status, offset, rows);
		for (CommentVo comment : commentList) {
			comment.setFaceUrl(AuthUtils.getFaceUrl(comment.getEmail()));
		}
		return commentList;
	}

	/**
	 * 通过id获得指定评论
	 * 
	 * @param commentId
	 * @return Comment
	 */
	public Comment getCommentById(long commentId) {
		return commentDao.getCommentById(commentId);
	}

	/**
	 * 获得所有评论
	 * 
	 * @param offset
	 * @param rows
	 * @return List<CommentVo>
	 */
	public List<CommentVo> getCommentList(long offset, long rows) {
		return commentDao.getAllList(offset, rows);
	}

	/**
	 * 获得所有评论的数量
	 * 
	 * @return Integer
	 */
	public int getCommentListCount() {
		return commentDao.getAllListCount();
	}

	/**
	 * 获得所有评论的分页
	 * 
	 * @param pageNum
	 * @return PageVo<CommentVo>
	 */
	public PageVo<CommentVo> getCommentListPage(int pageNum,
			CommentConstant.Status status) {
		PageVo<CommentVo> pageVo = new PageVo<CommentVo>(pageNum);
		List<CommentVo> list = new ArrayList<CommentVo>();
		pageVo.setRows(5);
		if (status == null) {
			list = this.getCommentList(pageVo.getOffset(), pageVo.getRows());
			pageVo.setCount(this.getCommentListCount());
		} else {
			list = this.getCommentByStatus(pageVo.getOffset(),
					pageVo.getRows(), status);
			pageVo.setCount(this.getCommentByStatusCount(status));
		}
		pageVo.setList(list);
		return pageVo;
	}

	/**
	 * 获得某状态下的所有评论
	 * 
	 * @param offset
	 * @param rows
	 * @param status
	 * @return List<CommentVo>
	 */
	public List<CommentVo> getCommentByStatus(long offset, long rows,
			CommentConstant.Status status) {
		return commentDao.getCommentByStatus(offset, rows, status);
	}

	/**
	 * 获得某状态下的评论的数量
	 * 
	 * @param status
	 * @return Integer
	 */
	public int getCommentByStatusCount(CommentConstant.Status status) {
		return commentDao.getCommentByStatusCount(status);
	}

	// /**
	// * 获得某状态下的评论的分页
	// *
	// * @param pageNum
	// * @param status
	// * @return PageVo<CommentVo>
	// */
	// public PageVo<CommentVo> getCommentByStatusPage(int pageNum,
	// CommentConstant.Status status) {
	// PageVo<CommentVo> pageVo = new PageVo<CommentVo>(pageNum);
	// pageVo.setUrl(SystemConstant.BASE_PATH +
	// "admin/comment/auditing/list.htm");
	// pageVo.setRows(5);
	// List<CommentVo> list = this.getCommentByStatus(pageVo.getOffset(),
	// pageVo.getRows(), status);
	// pageVo.setList(list);
	// pageVo.setCount(this.getCommentByStatusCount(status));
	// return pageVo;
	// }
}
