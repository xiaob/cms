/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.shishuo.cms.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shishuo.cms.constant.AttachmentConstant;
import com.shishuo.cms.dao.AttachmentDao;
import com.shishuo.cms.entity.Attachment;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.exception.UploadException;
import com.shishuo.cms.plugin.StoragePlugin;
import com.shishuo.cms.util.AttachmentUtils;

@Service
public class AttachmentService {

	@Autowired
	private AttachmentDao attachmentDao;

	@Autowired
	private StoragePlugin storagePlugin;

	/*
	 * 上传附件
	 */
	@CacheEvict(value = "article", allEntries = true)
	public Attachment addUploadFile(MultipartFile multipartFile,
			String fileName, long kindId, AttachmentConstant.Kind kind,
			AttachmentConstant.Status status) throws IllegalStateException,
			IOException, UploadException {
		AttachmentConstant.Type type = AttachmentConstant.Type.photo;
		if (AttachmentUtils.isFileType(fileName, AttachmentUtils.PHOTO_TYPE)) {
			type = AttachmentConstant.Type.photo;
		} else if (AttachmentUtils.isFileType(fileName, AttachmentUtils.FILE_TYPE)) {
			type = AttachmentConstant.Type.file;
		} else {
			throw new UploadException("文件类型有误");
		}
		Date now = new Date();
		String path = storagePlugin.getStoragePlugin().save(multipartFile);
		Attachment attachment = new Attachment();
		attachment.setKindId(kindId);
		attachment.setDescription("");
		attachment.setName(fileName);
		attachment.setPath(path);
		attachment.setType(type);
		attachment.setLink("javascript:void(0);");
		attachment.setSize(multipartFile.getSize());
		attachment.setKind(kind);
		attachment.setStatus(status);
		attachment.setCreateTime(now);
		attachmentDao.addAttachment(attachment);
		return attachment;
	}

	/**
	 * 
	 * 删除附件通过附件ID
	 */
	@CacheEvict(value = "article", allEntries = true)
	public void deleteAttachment(long attachmentId, String path) {
		attachmentDao.deleteAttachment(attachmentId);
		AttachmentUtils.deleteFile(path);
	}

	/**
	 * @param attachmentId
	 * @param articleId
	 * @param name
	 * @param path
	 * @param size
	 * @param type
	 * @param status
	 * @return
	 */
	@CacheEvict(value = "article", allEntries = true)
	public boolean updateStatusByAttachmentId(long attachmentId,
			AttachmentConstant.Status status) {
		attachmentDao.updateStatusByAttachmentId(attachmentId, status);
		return true;

	}

	/**
	 * @param attachmentId
	 * @return
	 */
	@Cacheable("article")
	public Attachment getAttachmentById(long attachmentId) {
		return attachmentDao.getAttachmentById(attachmentId);
	}

	/**
	 * @param attachmentId
	 * @param link
	 * @return
	 */
	@CacheEvict(value = "article", allEntries = true)
	public int updateLinkByAttachmentId(long attachmentId, String link) {
		return attachmentDao.updateLinkByAttachmentId(attachmentId, link);
	}

	/**
	 * @param folderId
	 * @return
	 */
	@Cacheable("article")
	public PageVo<Attachment> getAttachmentPageByKindId(long kindId,
			AttachmentConstant.Kind kind, int rows, int pageNum) {
		PageVo<Attachment> pageVo = new PageVo<Attachment>(pageNum);
		pageVo.setRows(rows);
		pageVo.setCount(attachmentDao.getAttachmentCountByKindId(kindId, kind,
				AttachmentConstant.Status.display));
		pageVo.setList(attachmentDao.getAttachmentListByKindId(kindId, kind,
				AttachmentConstant.Status.display, pageVo.getOffset(),
				pageVo.getRows()));
		return pageVo;
	}

	/**
	 * @param kindId
	 * @param kind
	 * @param stauts
	 * @return
	 */
	@Cacheable("article")
	public List<Attachment> getAttachmentListByKindId(long kindId,
			AttachmentConstant.Kind kind, AttachmentConstant.Status status,
			int rows) {
		return attachmentDao.getAttachmentListByKindId(kindId, kind, status, 0,
				rows);

	}

	/**
	 * @param kindId
	 * @param kind
	 * @param stauts
	 * @return
	 */
	@Cacheable("article")
	public List<Attachment> getAttachmentListByKindAndType(long kindId,
			AttachmentConstant.Kind kind, AttachmentConstant.Type type, int rows) {
		return attachmentDao.getAttachmentListByKindAndType(kindId, kind, type, 0, rows);

	}
}
