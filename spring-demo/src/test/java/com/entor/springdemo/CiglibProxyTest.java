package com.entor.springdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entor.proxy.cglib.CglibProxyConfig;
import com.entor.proxy.cglib.CglibProxyFactory;
import com.entor.proxy.cglib.UserDao;

@ContextConfiguration(classes = { CglibProxyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class CiglibProxyTest {

	@Resource
	private CglibProxyFactory cglibProxyFactory;

	@Test
	public void testSave() {
		UserDao userDao = (UserDao) cglibProxyFactory.getProxyInstance();
		System.out.println(userDao.getClass());
		userDao.save();
	}
}
