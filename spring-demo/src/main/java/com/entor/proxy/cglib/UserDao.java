package com.entor.proxy.cglib;

import org.springframework.stereotype.Component;

/**
 * 目标类
 * 
 * @author Administrator
 *
 */
@Component
public class UserDao {

	public void save() {
		System.out.println("----已经保存数据!----");
	}
}
