package com.entor.springdemo;

/**
 * 杂技演员
 * 
 * @author Administrator
 *
 */
public class Juggler implements Performer {

	// 豆袋，默认可以抛出3个
	private int beanBages = 3;

	public Juggler() {
	}

	public Juggler(int beanBages) {
		this.beanBages = beanBages;
	}

	public void setBeanBages(int beanBages) {
		this.beanBages = beanBages;
	}

	@Override
	public void perform() {
		System.out.println("正在表演杂技，一次性抛出" + beanBages + "个豆袋!");
	}
}
