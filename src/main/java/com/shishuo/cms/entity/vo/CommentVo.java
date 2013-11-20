package com.shishuo.cms.entity.vo;

import java.util.ArrayList;
import java.util.List;

import com.shishuo.cms.entity.Comment;
import com.shishuo.cms.entity.User;

public class CommentVo extends Comment{
	
	/**
	 * 子评论
	 */
    private	List<Comment> childComment = new ArrayList<Comment>();
    
    /**
	 * 评论用户
	 */
    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<Comment> childComment) {
		this.childComment = childComment;
	}
	
}
