package com.shishuo.jiawacms.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstAction {

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String test(){
		return "folder";
	}
}
