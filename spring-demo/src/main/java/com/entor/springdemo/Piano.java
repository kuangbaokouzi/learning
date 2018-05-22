package com.entor.springdemo;

/**
 * 钢琴
 * 
 * @author Administrator
 *
 */
public class Piano implements Instrument {
	public Piano() {
	}

	@Override
	public void play() {
		System.out.println("钢琴声...");
	}
}
