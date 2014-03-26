package com.shishuo.cms.plugin;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.shishuo.cms.util.SSUtils;

import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModelException;

@Service
public abstract class TagPlugin extends ApplicationObjectSupport implements
		TemplateDirectiveModel,Plugin {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@PostConstruct
	public void init() throws TemplateModelException {
		String className = this.getClass().getName()
				.substring(this.getClass().getName().lastIndexOf(".") + 1);
		String beanName = StringUtils.uncapitalize(className);
		String tagName = "shishuocms_" + SSUtils.toUnderline(beanName);
		logger.info(tagName);
		freeMarkerConfigurer.getConfiguration().setSharedVariable(tagName,
				this.getApplicationContext().getBean(beanName));
	}

}
