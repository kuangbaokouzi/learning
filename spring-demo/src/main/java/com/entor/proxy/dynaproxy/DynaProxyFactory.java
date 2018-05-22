package com.entor.proxy.dynaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DynaProxyFactory {

	@Autowired
	private UserDao userDao;

	// 给目标对象生成代理对象
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(method.getName());
						System.out.println(Arrays.toString(args));
						System.out.println("开始事务2");
						// 执行目标对象方法
						Object returnValue = method.invoke(userDao, args);
						System.out.println("提 交事务2");
						// System.out.println(proxy);
						return returnValue;
					}
				});
	}
}
