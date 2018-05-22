package com.entor.springdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entor.springdemo.account.TransactionConfig;
import com.entor.springdemo.account.service.AccountService;

//@ContextConfiguration(locations = { "classpath:spring-transaction.xml" })
@ContextConfiguration(classes = { TransactionConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionTest {

	@Resource
	private AccountService accountService;

	@Test
	public void testTransfer() {
		accountService.transfer(1, 2, 1000);
	}
}
