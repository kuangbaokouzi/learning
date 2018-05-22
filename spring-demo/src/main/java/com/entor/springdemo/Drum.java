package com.entor.springdemo;

/**
 * 架子鼓
 * 
 * @author Administrator
 *
 */
public class Drum implements Instrument {
	public Drum() {
	}

	@Override
	public void play() {
		System.out.println("鼓声...");
	}
}
