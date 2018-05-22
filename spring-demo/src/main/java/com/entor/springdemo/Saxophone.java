package com.entor.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Scope("prototype")
public class Saxophone implements Instrument {

	public Saxophone() {
		System.out.println("Saxophone构造器被调用...");
	}

	@Override
	public void play() {
		System.out.println("萨克斯管声...");
	}

	public void begin() {
		System.out.println("全局Saxophone初始化...");
	}

	public void close() {
		System.out.println("全局Saxophone销毁...");
	}

	@PostConstruct
	public void init() {
		System.out.println("Saxophone初始化...");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Saxophone销毁...");
	}
}
