package com.entor.springdemo.account.service;

public interface AccountService {

	/**
	 * 转账
	 * @param in 进账
	 * @param out 出账
	 * @param money 金额
	 */
	void transfer(Integer in, Integer out, double money);
}
