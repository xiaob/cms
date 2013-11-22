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

/**
 * 评论实体
 * @author Administrator
 *
 */

public class Comment {
	
	/**
	 * 评论Id
	 */
    private long commentId;
    /**
	 * 所属文件Id
	 */
    private long fileId;
    /**
	 * 所属用户Id
	 */
    private long userId;
    /**
	 * 所属用户email
	 */
	private String email;
	/**
	 * 评论名称
	 */
    private String name;
    /**
	 * 评论内容
	 */
    private String content;
    /**
	 * 所属Ip
	 */
    private String ip;
    /**
	 * 父亲Id
	 */
    private long fatherId;
    /**
	 * 审核状态
	 */
    private int status;
    /**
	 * 时间
	 */
    private Date createTime;
    
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getFatherId() {
		return fatherId;
	}
	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    public long getUserId() {
		return userId;
		}
   public void setUserId(long userId) {
		this.userId = userId;
		}
	
}
