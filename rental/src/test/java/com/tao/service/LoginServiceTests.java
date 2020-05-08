package com.tao.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("File:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LoginServiceTests {
	@Setter(onMethod_ = { @Autowired })
	private LoginService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}

	@Test
	public void testLogin() {
		assertTrue(service.checkLogin("admin", "1234"));
		log.info("testLoginTrue(admin, 1234) : " + service.checkLogin("admin","1234"));
		assertFalse(service.checkLogin("admin", "0000"));
		log.info("testLoginFalse(admin, 0000) : " + service.checkLogin("admin","0000"));
		assertFalse(service.checkLogin("user","1234"));
		log.info("testLoginFalse(user, 1234) : " + service.checkLogin("user","1234"));
	}
}
