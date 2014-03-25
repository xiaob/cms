package com.shishuo.cms.entity.vo;

import com.shishuo.cms.entity.Article;

public class ArticleVo extends Article {
	
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
