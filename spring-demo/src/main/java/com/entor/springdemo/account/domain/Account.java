package com.entor.springdemo.account.domain;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 4552508546250509807L;

	public Account() {
	}

	private Integer id;
	private String name;
	private Double money;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
