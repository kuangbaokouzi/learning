package com.entor.proxy.staticproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 代理类
 * 
 * @author Administrator
 *
 */
@Component
public class UserDaoProxy implements IUserDao {

	@Autowired
	private UserDao userDao;

	@Override
	public void save() {
		System.out.println("开始事务...");
		userDao.save();// 调用目标对象
		System.out.println("提交事务...");
	}

}
