package com.shishuo.cms.entity.vo;

import com.shishuo.cms.entity.File;
import com.shishuo.cms.entity.User;

public class FileVo extends File{
    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
