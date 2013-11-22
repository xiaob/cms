package com.shishuo.cms.action.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.service.ConfigService;

/**
 * 网站配置action
 * @author Herbert
 * 
 */
@Controller
@RequestMapping("/admin/config")
public class AdminConfigAction extends AdminBaseAction {

	/**
	 * 网站配置
	 * @author Administrator
	 *
	 */
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public String basic(ModelMap modelMap) {
		List<String> templateList = this.getTemplate();
		modelMap.addAttribute("templateList", templateList);
		return "admin/config/basic";
	}

	/**
	 * 修改网站配置
	 * @author Administrator
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/basic.json", method = RequestMethod.POST)
	public JsonVo<String> basicSubmit(
			@RequestParam(value = "sitename") String sitename,
			@RequestParam(value = "sitedesc") String sitedesc,
			@RequestParam(value = "siteurl") String siteurl,
			@RequestParam(value = "template") String template,
			@RequestParam(value = "functionPhoto", required = false) String functionPhoto,
			@RequestParam(value = "functionDownload", required = false) String functionDownload,
			@RequestParam(value = "functionShop", required = false) String functionShop,
			ModelMap modelMap) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			String function_photo = "off";
			String function_download = "off";
			String function_shop = "off";

			if (StringUtils.isBlank(sitename)) {
				json.getErrors().put("sitename", "网站名称不能为空");
			}
			if (StringUtils.isBlank(sitedesc)) {
				json.getErrors().put("sitedesc", "网站描述不能为空");
			}
			if (StringUtils.isBlank(siteurl)) {
				json.getErrors().put("siteurl", "网站网址不能为空");
			}
			if (StringUtils.isBlank(template)) {
				json.getErrors().put("template", "网站模板不能为空");
			}

			if (StringUtils.isNotBlank(functionPhoto)
					&& functionPhoto.equalsIgnoreCase("on")) {
				function_photo = "on";
			}
			if (StringUtils.isNotBlank(functionDownload)
					&& functionDownload.equalsIgnoreCase("on")) {
				function_download = "on";
			}
			if (StringUtils.isNotBlank(functionShop)
					&& functionShop.equalsIgnoreCase("on")) {
				function_shop = "on";
			}
			
			// 检测校验结果
			validate(json);
			
			configSevice.updagteConfigByKey("sitename", sitename);
			configSevice.updagteConfigByKey("sitedesc", sitedesc);
			configSevice.updagteConfigByKey("siteurl", siteurl);
			configSevice.updagteConfigByKey("template", template);
			configSevice.updagteConfigByKey("function_photo", function_photo);
			configSevice.updagteConfigByKey("function_download",
					function_download);
			configSevice.updagteConfigByKey("function_shop", function_shop);

			configSevice.refreshConfigMap();
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	private List<String> getTemplate() {
		List<String> templateList = new ArrayList<String>();
		String templatePath = System
				.getProperty(SystemConstant.SHISHUO_CMS_ROOT) + "/WEB-INF/ftl";
		File dir = new File(templatePath);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory() && !file.getName().equals("admin")) {
				templateList.add(file.getName());
			}
			logger.debug(file.getName());
		}
		return templateList;
	}
}
