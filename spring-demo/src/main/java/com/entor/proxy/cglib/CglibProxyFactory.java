package com.entor.proxy.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

@Component
public class CglibProxyFactory implements MethodInterceptor {

	@Autowired
	private UserDao userDao;

	// 给目标对象创建一个代理对象
	public Object getProxyInstance() {
		// 1.工具类
		Enhancer en = new Enhancer();
		// 2.设置父类
		en.setSuperclass(userDao.getClass());
		// 3.设置回调函数
		en.setCallback(this);
		// 4.创建子类(代理对象)
		return en.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		System.out.println(method.getName());
		System.out.println(Arrays.toString(args));
		System.out.println("开始事务3");
		// 执行目标对象方法
		Object returnValue = method.invoke(userDao, args);
		System.out.println("提 交事务3");
		return returnValue;
	}

}
