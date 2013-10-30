package com.shishuo.jiawacms.entity.vo;

import java.util.ArrayList;
import java.util.List;

import com.shishuo.jiawacms.entity.Folder;

public class FolderVo extends Folder {
	List<FolderVo> fileList = new ArrayList<FolderVo>();

	public List<FolderVo> getFileList() {
		return fileList;
	}

	public void setFileList(List<FolderVo> fileList) {
		this.fileList = fileList;
	}

}
