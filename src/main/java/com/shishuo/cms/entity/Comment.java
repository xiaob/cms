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

import com.shishuo.cms.constant.CommentConstant;

/**
 * 评论实体
 * 
 * @author Administrator
 * 
 */

public class Comment {

	/**
	 * 评论Id
	 */
	private long commentId;
	/**
	 * 所属用户Id
	 */
	private long userId;
	/**
	 * 父亲Id
	 */
	private long fatherId;
	/**
	 * 所属种类的Id
	 */
	private long kindId;
	/**
	 * 所属种类
	 */
	private CommentConstant.kind kind;
	/**
	 * 评论名称
	 */
	private String name;
	/**
	 * 所属用户email
	 */
	private String email;
	/**
	 * 评论者网址
	 */
	private String url;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 所属Ip
	 */
	private String ip;
	/**
	 * 所属phone
	 */
	private long phone;

	/**
	 * 审核状态
	 */
	private CommentConstant.Status status;
	/**
	 * 时间
	 */
	private Date createTime;

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getKindId() {
		return kindId;
	}

	public void setKindId(long kindId) {
		this.kindId = kindId;
	}

	public CommentConstant.kind getKind() {
		return kind;
	}

	public void setKind(CommentConstant.kind kind) {
		this.kind = kind;
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

	public CommentConstant.Status getStatus() {
		return status;
	}

	public void setStatus(CommentConstant.Status status) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
