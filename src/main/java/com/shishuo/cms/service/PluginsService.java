package com.shishuo.cms.service;

import groovy.lang.GroovyClassLoader;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import com.shishuo.cms.plugins.FilePlugins;

/**
 * @author Herbert
 * 
 */
public class PluginsService {

	public static void main(String args[]) throws CompilationFailedException,
			IOException, InstantiationException, IllegalAccessException {
		ClassLoader cl = PluginsService.class.getClassLoader();
		GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
		Class groovyClass = groovyCl
				.parseClass(new File(
						"/Users/Herbert/Documents/workspace/Copyright/src/com/shishuo/cms/plugins/File.groovy"));

		FilePlugins f = (FilePlugins) groovyClass.newInstance();
		com.shishuo.cms.entity.File file = new com.shishuo.cms.entity.File();
		file.setContent("dsfasdfasdf");
		f.doFile(file);
		System.out.println(file.getContent());
	}
}
