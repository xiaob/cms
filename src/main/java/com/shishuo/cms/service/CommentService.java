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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.CommentConstant;
import com.shishuo.cms.dao.CommentDao;
import com.shishuo.cms.entity.Comment;
import com.shishuo.cms.entity.vo.CommentVo;
import com.shishuo.cms.entity.vo.PageVo;

/**
 * 评论服务
 * @author Administrator
 *
 */
@Service
public class CommentService {
		
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 增加评论
	 * @param fileId
	 * @param fatherId
	 * @param email
	 * @param name
	 * @param ip
	 * @param content
	 * @return Comment
	 * 
	 */
	public Comment addComment(long fileId,String email,
			              String name,String ip,String content){
		Comment comment = new Comment();
		comment.setFileId(fileId);
		comment.setFatherId(0);
		comment.setEmail(email);
		comment.setStatus(CommentConstant.Status.DISABLE);
		comment.setContent(content);
		comment.setCreateTime(new Date());
		comment.setIp(ip);
		comment.setName(name);
		commentDao.addComment(comment);
		return comment;
		
	}
	
	/**
	 * 获得评论
	 * @param fileId
	 * @return list
	 */
	public List<CommentVo> getComment(long fileId){
		 List<Comment> commentList = commentDao.getCommentList(fileId);
		 List<CommentVo> commentVoList = new ArrayList<CommentVo>();
		 if(commentList != null){
			 for(Comment comment :commentList){
			    CommentVo commentVo = new CommentVo();
			    BeanUtils.copyProperties(comment, commentVo);
				List<Comment> childComment = commentDao.getChildCommentList(fileId, comment.getCommentId());
				 if(childComment != null){
					 commentVo.setChildComment(childComment); 
				 }
				commentVoList.add(commentVo);
			 }
		 }
		return commentVoList;
	}
	
	/**
	 * 评论审核
	 * @param commentId
	 * @param status
	 * @return Integer
	 */
	public int updateCommentStatus(long commentId,CommentConstant.Status status){
		Comment comment = this.getCommentById(commentId);
		comment.setStatus(status);
		return commentDao.updateCommentStatus(comment);
	}
	
	/**
	 * 通过id获得指定评论
	 * @param commentId
	 * @return Comment
	 */
	public Comment getCommentById(long commentId){
		return commentDao.getCommentById(commentId);
	}
	
	/**
	 * 获得所有评论
	 * @param offset
	 * @param rows
	 * @return List<CommentVo>
	 */
	public List<CommentVo> getAllList(long offset, long rows){
		return commentDao.getAllList(offset, rows);
	}
	
	/**
	 * 获得所有评论的数量
	 * @return Integer
	 */
	public int getAllListCount(){
		return commentDao.getAllListCount();
	}
	
	/**
	 * 获得所有评论的分页
	 * @param pageNum
	 * @return PageVo<CommentVo>
	 */
	public PageVo<CommentVo> getAllListPage(int pageNum){
		PageVo<CommentVo> pageVo = new PageVo<CommentVo>(pageNum);
		pageVo.setUrl("/CMS/admin/comment/all?");
		pageVo.setRows(5);
		List<CommentVo> list = this.getAllList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getAllListCount());
		return pageVo;
	}
	
	/**
	 * 获得某状态下的所有评论
	 * @param offset
	 * @param rows
	 * @param status
	 * @return List<CommentVo>
	 */
	public List<CommentVo> getCommentByStatus(long offset,long rows, int status){
		return commentDao.getCommentByStatus(offset, rows, status);
	}
	
	/**
	 * 获得某状态下的评论的数量
	 * @param status
	 * @return Integer
	 */
	public int getCommentByStatusCount(int status){
		return commentDao.getCommentByStatusCount(status);
	}
	
	/**
	 * 获得某状态下的评论的分页
	 * @param pageNum
	 * @param status
	 * @return PageVo<CommentVo>
	 */
	public PageVo<CommentVo> getCommentByStatusPage(int pageNum,int status){
		PageVo<CommentVo> pageVo =  new PageVo<CommentVo>(pageNum);
		pageVo.setUrl("");
		pageVo.setRows(5);
		List<CommentVo> list = this.getCommentByStatus(pageVo.getOffset(), pageVo.getRows(), status);
		pageVo.setList(list);
		pageVo.setCount(this.getCommentByStatusCount(status));
		return pageVo;
	}
}
