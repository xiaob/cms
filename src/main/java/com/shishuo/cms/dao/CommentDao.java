package com.shishuo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shishuo.cms.entity.Comment;
import com.shishuo.cms.entity.vo.CommentVo;

/**
 *	文章评论
 */
@Repository
public interface CommentDao {
	
	/**
	 * 添加评论
	 * @param comment
	 * @return Integer
	 */
	public int addComment(Comment comment);
	
	/**
	 * 获取某文章下的所有评论
	 * @param fileId
	 * @return List<Comment>
	 */
	public List<Comment> getCommentList(@Param("fileId") long fileId);
	
	public List<Comment> getChildCommentList(@Param("fileId") long fileId,@Param("fatherId") long fatherId);
	
	/**
	 * 评论审核
	 * @param comment
	 * @return Integer
	 */
	public int updateCommentStatus(Comment comment);
	
	/**
	 * 获得评论
	 * @param commentId
	 * @return Comment
	 */
	public Comment getCommentById(@Param("commentId") long commentId);
	
	public List<CommentVo> getAllList(@Param("offset") long offset,@Param("rows") long rows);
	
	public int getAllListCount();
	
	public List<CommentVo> getCommentByStatus(@Param("offset") long offset,@Param("rows") long rows,@Param("status")int status);
	
	public int getCommentByStatusCount(@Param("status")int status);
	  
}
