package cn.hassan.site.bo.impl;

import cn.hassan.site.bo.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with idea
 * Author: hss
 * Date: 2020/8/21 10:27
 * Description:
 */

public class UserTest {

	private UserService userService;

	@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = context.getBean(UserService.class);
	}

	@Test
	public void testPropagation() {
		userService.A();
	}
}
