package com.shishuo.cms.entity.vo;

import com.shishuo.cms.entity.Folder;

public class FolderVo extends Folder {
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
