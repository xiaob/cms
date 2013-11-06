package com.shishuo.jiawacms.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class FolderServiceTest {

	@Autowired
	private FolderService folderService;
	
	@Test
	public void testGetFolderById() {
		assertEquals(2, folderService.getFolderById(2).getFolderId());
	}
	
	@Test
	public void testAddFolder(){
		assertEquals(1,folderService.addFolder(2, "werg", 32, 1, 2, 3, "segs").getFolderId());
	}
	
	@Test
	public void testDeleteFolderById(){
		assertEquals(true, folderService.deleteFolderById(5));
	}
	
	@Test
	public void testUpdateFolderById(){
		assertEquals(1, folderService.updateFolderById(1, 1, "uyt", 3, 43, 12, 43, "dtghfg").getFatherId());
	}
	
	@Test
	public void testGetFolderListByFatherId(){
		
	}
	

}
