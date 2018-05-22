package com.entor.springdemo;

/**
 * 舞台类
 * 
 * @author Administrator
 *
 */
public class Stage {
	private Stage() {
		System.out.println("私有构造器");
	}

	private static class StageSingletonHolder {
		static Stage instance = new Stage();
	}

	// 通过getInstance方法进行注入
	public static Stage getInstance() {
		System.out.println("getInstance");
		return StageSingletonHolder.instance;
	}
}
