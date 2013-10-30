package com.shishuo.jiawacms.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ConfigServiceTest {

	@Test
	public void testAddConfig() {
	}

	@Test
	public void testDeleteConfigByKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdagteConfigByKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConfigPage() {
		fail("Not yet implemented");
	}

}
