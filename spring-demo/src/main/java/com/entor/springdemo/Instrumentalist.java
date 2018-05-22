package com.entor.springdemo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 奏者
 * 
 * @author Administrator
 *
 */
@Component("laowang")
public class Instrumentalist implements Performer {
	public Instrumentalist() {
	}

	public Instrumentalist(Instrument instrument) {
		this.instrument = instrument;
	}

	@Value("凉凉")
	private String song;

	@Resource
	private Instrument instrument;

	public void setSong(String song) {
		this.song = song;
	}

	public String getSong() {
		return song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public void perform() {
		System.out.println("使用" + instrument + "演奏" + song);
		// throw new RuntimeException("萨克斯管爆炸了...");
	}

	@Override
	public void perform(String args) {
		System.out.println("使用" + instrument + "演奏" + song + ", " + args);
		// throw new RuntimeException("萨克斯管爆炸了...");
	}
}
