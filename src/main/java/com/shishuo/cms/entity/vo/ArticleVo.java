package com.shishuo.cms.entity.vo;

import java.util.List;

import com.shishuo.cms.entity.Article;
import com.shishuo.cms.entity.Folder;

public class ArticleVo extends Article {
	
	private Folder folder;
	
	private List<Folder> folderPathList;

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
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
