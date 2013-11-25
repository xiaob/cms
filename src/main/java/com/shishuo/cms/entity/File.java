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
package com.shishuo.cms.entity;

import java.util.Date;

import com.shishuo.cms.constant.FileConstant;

/**
 * 文件实体
 * 
 * @author zsy
 * 
 */

public class File {

	/**
	 * 文件Id
	 */
	private long fileId;

	/**
	 * 所属目录Id
	 */
	private long folderId;

	/**
	 * 管理员Id
	 */
	private long adminId;
	/**
	 * 是否有固定图片
	 */
	private FileConstant.Picture picture;

	/**
	 * 文件名称
	 */
	private String name;

	/**
	 * 文件内容
	 */
	private String content;

	/**
	 * 浏览人数
	 */
	private int viewCount;

	/**
	 * 评论人数
	 */
	private int commentCount;

	/**
	 * 文件类型
	 */
	private FileConstant.Type type;

	/**
	 * 文件状态
	 */
	private FileConstant.Status status;

	/**
	 * 时间
	 */
	private Date createTime;

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public FileConstant.Status getStatus() {
		return status;
	}

	public void setStatus(FileConstant.Status status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public FileConstant.Picture getPicture() {
		return picture;
	}

	public void setPicture(FileConstant.Picture picture) {
		this.picture = picture;
	}

	public FileConstant.Type getType() {
		return type;
	}

	public void setType(FileConstant.Type type) {
		this.type = type;
	}
	
	
}
