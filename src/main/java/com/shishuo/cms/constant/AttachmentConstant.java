package com.shishuo.cms.constant;

/**
 * 附件
 * 
 * @author Herbert
 * 
 */
public class AttachmentConstant {

	/**
	 * 类型<br>
	 * photo：照片<br>
	 * file：文件<br>
	 * 
	 * @author Herbert
	 * 
	 */
	public static enum Type {
		/**
		 * 相册
		 */
		photo, /**
		 * 文件
		 */
		file
	}

	/**
	 * 种类
	 * 
	 * @author Herbert
	 * 
	 */
	public static enum Kind {
		folder, article
	}

	public static enum Status {
		/**
		 * 隐藏是嵌入文章的
		 */
		hidden, /**
		 * 没有嵌入文章的
		 */
		display
	}
}
