package com.entor.proxy.staticproxy;

import org.springframework.stereotype.Component;

/**
 * 目标类
 * 
 * @author Administrator
 *
 */
@Component
public class UserDao implements IUserDao {

	@Override
	public void save() {
		System.out.println("----已经保存数据!----");
	}
}
