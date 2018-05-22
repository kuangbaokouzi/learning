package com.entor.springdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entor.proxy.dynaproxy.DynaProxyConfig;
import com.entor.proxy.dynaproxy.DynaProxyFactory;
import com.entor.proxy.dynaproxy.IUserDao;

@ContextConfiguration(classes = { DynaProxyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class JDKProxyTest {

	@Resource
	private DynaProxyFactory dynaProxyFactory;

	@Test
	public void testSave() {
		IUserDao iUserDao = (IUserDao) dynaProxyFactory.getProxyInstance();
		System.out.println(iUserDao.getClass());
		iUserDao.save();
	}
}
