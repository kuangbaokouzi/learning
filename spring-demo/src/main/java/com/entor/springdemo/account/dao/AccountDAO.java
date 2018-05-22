package com.entor.springdemo.account.dao;

public interface AccountDAO {

	void in(Integer id, double money);

	void out(Integer id, double money);
}
