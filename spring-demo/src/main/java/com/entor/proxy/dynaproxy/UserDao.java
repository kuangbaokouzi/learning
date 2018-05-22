package com.entor.proxy.dynaproxy;

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
