package com.shishuo.cms.plugins

import java.util.logging.Filter;

import com.shishuo.cms.plugins.FilePlugins;
import com.shishuo.cms.plugins.FilterPlugins;

class Copyright  implements Plugins {

	public void add() {
		FilterPlugins filter = new FilterPlugins();
		filter.addFilter("the_content", "doFile");
	}
	
	public String run(String content) {
		return content + "师说CMS，版权所有";
	}
}
