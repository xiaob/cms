/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.shishuo.com/jiawacms/licenses
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.jiawacms.entity;

import java.util.Date;

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
	 * 文件名称
	 */
	private String name;
	
	/**
	 * 文件外部URL
	 */
	private String url;
	
	/**
	 * 文件描述图片
	 */
	private String images;
	
	/**
	 * 文件描述
	 */
	private String description;
	
	/**
	 * 文件类型
	 */
	private int type;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
