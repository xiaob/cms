package com.shishuo.cms.entity;

import java.util.Date;

public class Comment {
	
    private long commentId;
    private long fileId; 
    private long userId;
	private String email;
    private String name;
    private String content;
    private String ip;
    private long fatherId;
    private int status;
    private Date createTime;
    
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getFatherId() {
		return fatherId;
	}
	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    public long getUserId() {
		return userId;
		}
   public void setUserId(long userId) {
		this.userId = userId;
		}
	
}
