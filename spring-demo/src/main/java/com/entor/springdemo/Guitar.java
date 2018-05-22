package com.entor.springdemo;

/**
 * 吉他
 * 
 * @author Administrator
 *
 */
public class Guitar implements Instrument {
	public Guitar() {
	}

	@Override
	public void play() {
		System.out.println("吉他声...");
	}
}
