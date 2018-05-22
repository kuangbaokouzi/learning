package com.entor.springdemo.account.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entor.springdemo.account.dao.AccountDAO;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void in(Integer id, double money) {
		this.jdbcTemplate.update("update Account set money = money + ? where id = ?", money, id);
	}

	@Override
	public void out(Integer id, double money) {
		this.jdbcTemplate.update("update Account set money = money - ? where id = ?", money, id);
	}

}
