package com.shishuo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shishuo.cms.entity.Comment;

@Repository
public interface CommentDao {
	
	 public int addComment(Comment comment);
	 
	 public List<Comment> getCommentList(@Param("fileId") long fileId);
	 
	 public List<Comment> getChildCommentList(@Param("fileId") long fileId,@Param("fatherId") long fatherId);
	 
	 
}
