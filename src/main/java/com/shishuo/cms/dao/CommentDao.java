/*
 * 
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
	
	/**
	 * 获得某篇文章下某条评论的回复
	 * @param fileId
	 * @param fatherId
	 * @return List<Comment>
	 */
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
	
	/**
	 * 获得所有评论
	 * @param offset
	 * @param rows
	 * @return List<CommentVo>
	 */
	public List<CommentVo> getAllList(@Param("offset") long offset,@Param("rows") long rows);
	
	/**
	 * 获得所有评论的数量
	 * @return Integer
	 */
	public int getAllListCount();
	
	/**
	 * 获得某状态下的评论列表
	 * @param offset
	 * @param rows
	 * @param status
	 * @return Integer
	 */
	public List<CommentVo> getCommentByStatus(@Param("offset") long offset,@Param("rows") long rows,@Param("status")int status);
	
	/**
	 * 获得某状态下的评论数量
	 * @param status
	 * @return Integer
	 */
	public int getCommentByStatusCount(@Param("status")int status);
	  
}
