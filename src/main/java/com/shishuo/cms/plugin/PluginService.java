package com.shishuo.cms.plugin;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;


/**
 * @author Herbert
 * 
 */
@Service
public class PluginService extends ApplicationObjectSupport{
	
	private StoragePlugin storagePlugin;

	public StoragePlugin getStoragePlugin() {
		if(storagePlugin==null){
			storagePlugin = (StoragePlugin) this.getApplicationContext().getBean("defaultStoragePlugin");
		}
		return storagePlugin;
	}

	public void setStoragePlugin(StoragePlugin storagePlugin) {
		this.storagePlugin = storagePlugin;
	}
	
}
