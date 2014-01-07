/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

package com.shishuo.cms.action.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shishuo.cms.constant.ArticleConstant;
import com.shishuo.cms.constant.FolderConstant;
import com.shishuo.cms.entity.vo.ArticleVo;

/**
 * @author lqq
 * @author 进入网站后台首页
 * 
 */

@Controller
@RequestMapping("/admin")
public class AdminAction extends AdminBaseAction {

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("articleCount", 0);
		modelMap.put("downloadCount", 0);
		modelMap.put("userCount", 0);
		modelMap.put("folderAll", folderService.getAllFolderList(0,
				FolderConstant.Status.display));
		List<ArticleVo> articleList = articleService.getArticleListByStatus(
				ArticleConstant.Status.display, 0, 10);
		for (ArticleVo articleVo : articleList) {
			articleVo.setFolder(folderService.getFolderById(articleVo
					.getFolderId()));
			if (articleVo.getFirstFolderId() != 0) {
				articleVo.getFolderPathList().add(
						folderService.getFolderById(articleVo
								.getFirstFolderId()));
			}
			if (articleVo.getSecondFolderId() != 0) {
				articleVo.getFolderPathList().add(
						folderService.getFolderById(articleVo
								.getSecondFolderId()));
			}
			if (articleVo.getThirdFolderId() != 0) {
				articleVo.getFolderPathList().add(
						folderService.getFolderById(articleVo
								.getThirdFolderId()));
			}
			if (articleVo.getFourthFolderId() != 0) {
				articleVo.getFolderPathList().add(
						folderService.getFolderById(articleVo
								.getFourthFolderId()));
			}
		}
		modelMap.put("articleList", articleList);
		return "system/index";
	}

}
