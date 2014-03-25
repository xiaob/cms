/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.shishuo.cms.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.ArticleConstant;
import com.shishuo.cms.dao.ArticleDao;
import com.shishuo.cms.dao.FolderDao;
import com.shishuo.cms.entity.Article;
import com.shishuo.cms.entity.vo.ArticleVo;
import com.shishuo.cms.entity.vo.FolderVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.exception.ArticleNotFoundException;
import com.shishuo.cms.exception.FolderNotFoundException;

/**
 * 
 * 文章服务
 * 
 * @author Zhangjiale
 * 
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private AdminService adminService;

	@Autowired
	private FolderService folderService;

	@Autowired
	private FolderDao folderDao;

	@Autowired
	private AttachmentService attachmentService;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加文件
	 * 
	 * @param folderId
	 * @param adminId
	 * @param picture
	 *            {@link:FileConstant.PICTURE}
	 * @param name
	 * @param content
	 * @param type
	 * @param status
	 * @param createTime
	 * @return
	 * @throws FolderNotFoundException
	 */
	@CacheEvict(value = "article", allEntries = true)
	public Article addArticle(long folderId) throws FolderNotFoundException {
		FolderVo folder = folderService.getFolderById(folderId);
		Article article = new Article();
		Date now = new Date();
		article.setFirstFolderId(folder.getFirstFolderId());
		article.setSecondFolderId(folder.getSecondFolderId());
		article.setThirdFolderId(folder.getThirdFolderId());
		article.setFourthFolderId(folder.getFourthFolderId());
		article.setCreateTime(now);
		article.setUpdateTime(now);
		article.setExpireTime(now);
		articleDao.addArticle(article);
		return articleDao.getArticleById(article.getArticleId());
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除文件
	 * 
	 * @param fileId
	 * @return boolean
	 */
	@CacheEvict(value = "article", allEntries = true)
	public boolean deleteFileByArticleId(long articleId) {
		return articleDao.deleteArticle(articleId);
	}

	public int deleteArticleListByStatus(ArticleConstant.Status status) {
		return articleDao.deleteArticleListByStatus(status);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改文件
	 * 
	 * @param fileId
	 * @param folderId
	 * @param adminId
	 * @param picture
	 * @param name
	 * @param content
	 * @param type
	 * @param status
	 * @return
	 */
	@CacheEvict(value = "article", allEntries = true)
	public Article updateFileByFileId(long fileId, long folderId,long adminId, String name, String content,
			String title, String description,ArticleConstant.Status status) {
		Article article = articleDao.getArticleById(fileId);
		FolderVo folder = folderDao.getFolderById(folderId);
		article.setFirstFolderId(folder.getFirstFolderId());
		article.setSecondFolderId(folder.getSecondFolderId());
		article.setThirdFolderId(folder.getThirdFolderId());
		article.setFourthFolderId(folder.getFourthFolderId());
		article.setAdminId(adminId);
		article.setName(name);
		article.setContent(content);
		article.setTitle(title);
		article.setDescription(description);
		article.setViewCount(0);
		article.setCommentCount(0);
		article.setStatus(status);
		article.setUpdateTime(new Date());
		articleDao.updateArticle(article);
		return article;
	}

	/**
	 * 修改文件的状态
	 * 
	 * @param fileId
	 * @param status
	 * @return boolean
	 * 
	 */
	public void updateStatusByFileId(long articleId,
			ArticleConstant.Status status) {
		articleDao.updateStatusByArticleId(articleId, status);
	}

	/**
	 * 更新浏览人数
	 * 
	 * @param fileId
	 * @param viewCount
	 * 
	 */
	public void updateViewCount(long articleId, int nowViewCount) {
		articleDao.updateViewCount(articleId, nowViewCount + 1);
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到文件
	 * 
	 * @param fileId
	 * @return File
	 * @throws ArticleNotFoundException
	 */
	@Cacheable(value = "article", key = "'getArticleById_'+#articleId")
	public ArticleVo getArticleById(long articleId)
			throws ArticleNotFoundException {
		ArticleVo articleVo = articleDao.getArticleById(articleId);
		if (articleVo == null) {
			throw new ArticleNotFoundException(articleId + " 文件，不存在");
		} else {
			return articleVo;
		}
	}

	/**
	 * 得到目录的显示的文件分页
	 * 
	 * @param folderId
	 * @return pageVo
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "article", key = "'getArticlePageByFolderId_'+#folderId+'_'+#pageNum+'_'+#rows")
	public PageVo<Article> getArticlePageByFolderId(long folderId,
			int pageNum, int rows) throws FolderNotFoundException {
		PageVo<Article> pageVo = new PageVo<Article>(pageNum);
		FolderVo folder = folderService.getFolderById(folderId);
		pageVo.setRows(rows);
		pageVo.setCount(this.getArticleCountByFoderIdPath(
				folder.getFirstFolderId(), folder.getSecondFolderId(),
				folder.getThirdFolderId(), folder.getFourthFolderId(),
				ArticleConstant.Status.display));
		List<Article> articlelist = this.getArticleListByFoderIdPath(
				folder.getFirstFolderId(), folder.getSecondFolderId(),
				folder.getThirdFolderId(), folder.getFourthFolderId(),
				ArticleConstant.Status.display, pageVo.getOffset(),
				pageVo.getRows());
		pageVo.setList(articlelist);
		return pageVo;
	}

	public PageVo<Article> getArticlePageByFoderIdPath(long folderId,
			int pageNum) throws FolderNotFoundException {
		PageVo<Article> pageVo = new PageVo<Article>(pageNum);
		pageVo.setRows(10);
		FolderVo folder = folderService.getFolderById(folderId);
		List<Article> list = this.getArticleListByFoderIdPath(
				folder.getFirstFolderId(), folder.getSecondFolderId(),
				folder.getThirdFolderId(), folder.getFourthFolderId(), null,
				pageVo.getOffset(), pageVo.getRows());
		Collections.reverse(list);
		pageVo.setList(list);
		pageVo.setCount(this.getArticleCountByFoderIdPath(
				folder.getFirstFolderId(), folder.getSecondFolderId(),
				folder.getThirdFolderId(), folder.getFourthFolderId(), null));
		return pageVo;
	}

	/**
	 * 得到目录下的文件
	 * 
	 * @param foderId
	 * @return
	 * @throws FolderNotFoundException
	 */
	public List<Article> getArticleListByFoderIdPath(long firstFolderId,
			long secondFolderId, long thirdFolderId, long fourthFolderId,
			ArticleConstant.Status status, long offset, long rows)
			throws FolderNotFoundException {
		List<Article> articlelist = articleDao.getArticleListByFoderIdPath(
				firstFolderId, secondFolderId, thirdFolderId, fourthFolderId,
				status, offset, rows);
		return articlelist;
	}

	/**
	 * 得到目录的某种文件的数量
	 * 
	 * @param folderId
	 * @param type
	 * @param status
	 * @return Integer
	 */
	public int getArticleCountByFoderIdPath(long firstFolderId,
			long secondFolderId, long thirdFolderId, long fourthFolderId,
			ArticleConstant.Status status) {
		return articleDao.getArticleCountByFoderIdPath(firstFolderId,
				secondFolderId, thirdFolderId, fourthFolderId, status);
	}

	/**
	 * @param firstFolderId
	 * @param secondFolderId
	 * @param thirdFolderId
	 * @param fourthFolderId
	 * @return
	 */
	public int getArticleCountByFoderId(long firstFolderId,
			long secondFolderId, long thirdFolderId, long fourthFolderId) {
		return articleDao.getArticleCountByFoderId(firstFolderId,
				secondFolderId, thirdFolderId, fourthFolderId);
	}

	/**
	 * 获取某种文件的分页
	 * 
	 * @param type
	 * @param status
	 * @param pageNum
	 * @return PageVo<File>
	 * @throws FolderNotFoundException
	 * 
	 */
	public PageVo<Article> getArticlePageByTypeAndStatusPage(long folderId,
			ArticleConstant.Status status, int pageNum)
			throws FolderNotFoundException {
		PageVo<Article> pageVo = new PageVo<Article>(pageNum);
		pageVo.setRows(20);
		pageVo.getArgs().put("status", status.name());
		List<Article> list = new ArrayList<Article>();
		int count = 0;
		if (folderId == 0) {
			list = this.getArticleListByStatus(0, 0, 0, 0, status,
					pageVo.getOffset(), pageVo.getRows());
			count = this.getArticleCountByStatus(0, 0, 0, 0, status);
		} else {
			FolderVo folder = folderService.getFolderById(folderId);
			list = this.getArticleListByStatus(folder.getFirstFolderId(),
					folder.getSecondFolderId(), folder.getThirdFolderId(),
					folder.getFourthFolderId(), status, pageVo.getOffset(),
					pageVo.getRows());
			count = this.getArticleCountByStatus(folder.getFirstFolderId(),
					folder.getSecondFolderId(), folder.getThirdFolderId(),
					folder.getFourthFolderId(), status);
		}
		pageVo.setList(list);
		pageVo.setCount(count);
		return pageVo;
	}

	/**
	 * 获取不同类型的文件的列表
	 * 
	 * @param type
	 * @param status
	 * @param offset
	 * @param rows
	 * @return List<File>
	 * 
	 */
	public List<Article> getArticleListByStatus(long firstFolderId,
			long secondFolderId, long thirdFolderId, long fourthFolderId,
			ArticleConstant.Status status, long offset, long rows) {
		return articleDao.getArticleListByStatus(firstFolderId, secondFolderId,
				thirdFolderId, fourthFolderId, status, offset, rows);
	}

	/**
	 * 获取不同类型的文件的数量
	 * 
	 * @param type
	 * @param status
	 * @param Integer
	 * 
	 */
	public int getArticleCountByStatus(long firstFolderId, long secondFolderId,
			long thirdFolderId, long fourthFolderId,
			ArticleConstant.Status status) {
		return articleDao.getArticleCountByStatus(firstFolderId,
				secondFolderId, thirdFolderId, fourthFolderId, status);
	}

}
