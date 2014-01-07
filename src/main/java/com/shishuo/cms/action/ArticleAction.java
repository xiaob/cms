package com.shishuo.cms.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.entity.Article;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.exception.ArticleNotFoundException;
import com.shishuo.cms.exception.FolderNotFoundException;
import com.shishuo.cms.exception.TemplateNotFoundException;

/**
 * @author Herbert
 * 
 */
@Controller
public class ArticleAction extends BaseAction {

	/**
	 * 一级目录页
	 * 
	 * @param ename
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{firstFolderEname}/{fileId}.htm", method = RequestMethod.GET)
	public String firstFolder(@PathVariable String firstFolderEname,
			@PathVariable long fileId,
			@RequestParam(value = "p", defaultValue = "1") long p,
			ModelMap modelMap) {
		return fourthFolder(firstFolderEname, null, null, null, fileId, p,
				modelMap);
	}

	
	/**
	 * 二级目录页
	 * 
	 * @param ename
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{firstFolderEname}/{secondFolderEname}/{fileId}.htm", method = RequestMethod.GET)
	public String secondFolder(@PathVariable String firstFolderEname,
			@PathVariable String secondFolderEname, @PathVariable long fileId,
			@RequestParam(value = "p", defaultValue = "1") long p,
			ModelMap modelMap) {
		return fourthFolder(firstFolderEname, secondFolderEname, null, null,
				fileId, p, modelMap);
	}

	/**
	 * 三级目录页
	 * 
	 * @param ename
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{firstFolderEname}/{secondFolderEname}/{thirdFolderEname}/{fileId}.htm", method = RequestMethod.GET)
	public String thirdFolder(@PathVariable String firstFolderEname,
			@PathVariable String secondFolderEname,
			@PathVariable String thirdFolderEname, @PathVariable long fileId,
			@RequestParam(value = "p", defaultValue = "1") long p,
			ModelMap modelMap) {
		return fourthFolder(firstFolderEname, secondFolderEname,
				thirdFolderEname, null, fileId, p, modelMap);
	}

	/**
	 * 四级目录页
	 * 
	 * @param ename
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{firstFolderEname}/{secondFolderEname}/{thirdFolderEname}/{fourthFolderEname}/{fileId}.htm", method = RequestMethod.GET)
	public String fourthFolder(@PathVariable String firstFolderEname,
			@PathVariable String secondFolderEname,
			@PathVariable String thirdFolderEname,
			@PathVariable String fourthFolderEname, @PathVariable long fileId,
			@RequestParam(value = "p/../o8i", defaultValue = "1") long p,
			ModelMap modelMap) {
		try {
			List<Folder> folderPathList = packageFolderByEname(
					firstFolderEname, secondFolderEname, thirdFolderEname,
					fourthFolderEname, modelMap);
			Article article = fileService.getArticleByArticleId(fileId);
			modelMap.addAttribute("p", p);
			modelMap.addAttribute("article", article);
			return themeService.getArticleTemplate(folderPathList, fileId);
		} catch (FolderNotFoundException e) {
			logger.fatal(e.getMessage());
			return themeService.getTemplatePath("404");
		} catch (TemplateNotFoundException e) {
			logger.fatal(e.getMessage());
			return themeService.getTemplatePath("404");
		} catch (ArticleNotFoundException e) {
			logger.fatal(e.getMessage());
			return themeService.getTemplatePath("404");
		}
	}
}
