package com.entor.springdemo.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entor.springdemo.account.dao.AccountDAO;
import com.entor.springdemo.account.service.AccountService;

@Service("accountService")
// 注解业务类
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	// 注解业务方法
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void transfer(Integer in, Integer out, double money) {
		accountDAO.in(in, money);
		System.out.println(1 / 0);
		accountDAO.out(out, money);
	}

}
