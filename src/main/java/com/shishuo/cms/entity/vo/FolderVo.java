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

import com.shishuo.cms.entity.Folder;

public class FolderVo extends Folder {

	private List<FolderVo> folderList = new ArrayList<FolderVo>();

	private List<String> folderPathList = new ArrayList<String>();

	public List<String> getFolderPathList() {
		return folderPathList;
	}

	public void setFolderPathList(List<String> folderPathList) {
		this.folderPathList = folderPathList;
	}

	public List<FolderVo> getFolderList() {
		return folderList;
	}

	public void setFolderList(List<FolderVo> folderList) {
		this.folderList = folderList;
	}

	public long getFirstFolderId() {
		return Long.parseLong(this.getFolderId(1));
	}

	public long getSecondFolderId() {
		return Long.parseLong(this.getFolderId(2));
	}

	public long getThirdFolderId() {
		return Long.parseLong(this.getFolderId(3));
	}

	public long getFourthFolderId() {
		return Long.parseLong(this.getFolderId(4));
	}

	private String getFolderId(int level) {
		String[] ids = this.getPath().split("#");
		if (ids.length < level) {
			return "0";
		} else {
			return ids[level - 1];
		}
	}
}
