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
		comment.setStatus(1);
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
	public int updateCommentStatus(long commentId,int status){
		Comment comment = this.getCommentById(commentId);
		comment.setStatus(status);
		return commentDao.updateCommentStatus(comment);
	}
	
	public Comment getCommentById(long commentId){
		return commentDao.getCommentById(commentId);
	}
	
	public List<CommentVo> getAllList(long offset, long rows){
		return commentDao.getAllList(offset, rows);
	}
	
	public int getAllListCount(){
		return commentDao.getAllListCount();
	}
	
	public PageVo<CommentVo> getAllListPage(int pageNum){
		PageVo<CommentVo> pageVo = new PageVo<CommentVo>(pageNum);
		pageVo.setUrl("/CMS/admin/comment/all?");
		pageVo.setRows(5);
		List<CommentVo> list = this.getAllList(pageVo.getOffset(), pageVo.getRows());
		for(CommentVo commentVo:list){
			if(commentVo.getStatus()==1){
				commentVo.setAuditing(CommentConstant.STATUS[1]);
			}else{
				commentVo.setAuditing(CommentConstant.STATUS[0]);
			}
		}
		pageVo.setList(list);
		pageVo.setCount(this.getAllListCount());
		return pageVo;
	}
}
