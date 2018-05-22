package com.entor.springdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entor.proxy.staticproxy.StaticProxyConfig;
import com.entor.proxy.staticproxy.UserDaoProxy;

@ContextConfiguration(classes = { StaticProxyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticProxyTest {

	@Resource
	private UserDaoProxy userDaoProxy;

	@Test
	public void testSave() {
		userDaoProxy.save();
	}
}
