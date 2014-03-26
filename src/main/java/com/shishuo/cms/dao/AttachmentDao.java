/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.shishuo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shishuo.cms.constant.AttachmentConstant;
import com.shishuo.cms.constant.AttachmentConstant.Kind;
import com.shishuo.cms.constant.AttachmentConstant.Status;
import com.shishuo.cms.constant.AttachmentConstant.Type;
import com.shishuo.cms.entity.Attachment;

@Repository
public interface AttachmentDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * @param att
	 * @return
	 */
	public int addAttachment(Attachment att);

	// ///////////////////////////////
	// ///// 删除 ////////
	// ///////////////////////////////

	/**
	 * @param attachmentId
	 * @return
	 */
	public int deleteAttachment(@Param("attachmentId") long attachmentId);

	// ///////////////////////////////
	// ///// 修改////////
	// ///////////////////////////////

	/**
	 * @param attachmentId
	 * @param status
	 */
	public void updateStatusByAttachmentId(
			@Param("attachmentId") long attachmentId,
			@Param("status") Status status);

	public int updateLinkByAttachmentId(
			@Param("attachmentId") long attachmentId, @Param("link") String link);

	// ///////////////////////////////
	// ///// 查询////////
	// ///////////////////////////////

	/**
	 * @param attachmentId
	 * @return
	 */
	public Attachment getAttachmentById(@Param("attachmentId") long attachmentId);

	/**
	 * @param folderId
	 * @return
	 */
	public int getAttachmentCountByKindId(@Param("kindId") long kindId,
			@Param("kind") AttachmentConstant.Kind kind,
			@Param("status") AttachmentConstant.Status status);

	/**
	 * @param folderId
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<Attachment> getAttachmentListByKindId(
			@Param("kindId") long kindId,
			@Param("kind") AttachmentConstant.Kind kind,
			@Param("status") AttachmentConstant.Status status,
			@Param("offset") int offset, @Param("rows") int rows);

	/**
	 * @param kindId
	 * @param kind
	 * @param type
	 * @param i
	 * @param rows
	 * @return
	 */
	public List<Attachment> getAttachmentListByKindAndType(
			@Param("kindId") long kindId, @Param("kind") Kind kind,
			@Param("type") Type type, @Param("offset") int offset,
			@Param("rows") int rows);

}
