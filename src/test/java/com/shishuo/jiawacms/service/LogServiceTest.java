package com.shishuo.jiawacms.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class LogServiceTest {

	@Autowired
	private LogService logService;
	
	@Test
	public void testAddLog() {
		assertEquals("sdef", logService.addLog("sdef").getDescription());
	}
	
	@Test
	public void testGetLogPage(){
		assertEquals(2, logService.getLogPage(1).getList().size());
	}

}
