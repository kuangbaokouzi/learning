package com.entor.springdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@ContextConfiguration(locations = { "classpath:spring-aop.xml" })
@ContextConfiguration(classes = { AOPConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class AOPTest {

	@Resource
	private Performer laowang;

	@Test
	public void testPerform() {
		laowang.perform("aaaaaaaaaaaaaaaaaaaaa");
	}
}
