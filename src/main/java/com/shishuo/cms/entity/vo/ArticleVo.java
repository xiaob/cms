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
package com.shishuo.cms.entity.vo;

import java.util.ArrayList;
import java.util.List;

import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.entity.Article;
import com.shishuo.cms.entity.Folder;

/**
 * @author Herbert
 * 
 */
public class ArticleVo extends Article {

	private Admin admin;

	private FolderVo folder;

	private List<AttachmentVo> attachmentList = new ArrayList<AttachmentVo>();

	private List<Folder> folderPathList = new ArrayList<Folder>();

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public FolderVo getFolder() {
		return folder;
	}

	public void setFolder(FolderVo folder) {
		this.folder = folder;
	}

	public List<AttachmentVo> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentVo> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Folder> getFolderPathList() {
		return folderPathList;
	}

	public void setFolderPathList(List<Folder> folderPathList) {
		this.folderPathList = folderPathList;
	}

	public long getFolderId() {
		if (this.getFourthFolderId() != 0) {
			return this.getFourthFolderId();
		} else if (this.getThirdFolderId() != 0) {
			return this.getThirdFolderId();
		} else if (this.getSecondFolderId() != 0) {
			return this.getSecondFolderId();
		} else {
			return this.getFirstFolderId();
		}
	}

}
