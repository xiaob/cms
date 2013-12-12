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
import com.shishuo.cms.constant.SystemConstant;

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
	 * 父类Id
	 */
	private long fatherId;

	/**
	 * 管理员Id
	 */
	private long adminId;

	/**
	 * 英文名称
	 */
	private String ename;
	
	/**
	 * 文件名称
	 */ 
	private String name;
	
	/**
	 * 文件简介
	 */ 
	private String title;

	/**
	 * 文件内容
	 */
	private String content;
	
	/**
	 * 文件描述
	 */
	private String description;
	
	/**
	 * 密码
	 */ 
	private String password;
	
	/**
	 * 内容类型，同HTTP协议中的Content_Type
	 */ 
	private String contentType;
	
	/**
	 * 大小
	 */
	private int size;
	
	/**
	 * 报价
	 */
	private double price;
	
	/**
	 * 实际价格
	 */
	private double realPrice;
	
	/**
	 * 文件被copy的次数，相当于是商品的库存
	 */
	private int copyCount;
	
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
	private SystemConstant.Type type;

	/**
	 * 文件状态
	 */
	private FileConstant.Status status;

	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 过期时间
	 */
	private Date expireTime;

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

	public SystemConstant.Type getType() {
		return type;
	}

	public void setType(SystemConstant.Type type) {
		this.type = type;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}

	public int getCopyCount() {
		return copyCount;
	}

	public void setCopyCount(int copyCount) {
		this.copyCount = copyCount;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
