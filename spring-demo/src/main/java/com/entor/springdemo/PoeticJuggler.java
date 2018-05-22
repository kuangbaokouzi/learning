package com.entor.springdemo;

/**
 * 会朗诵诗歌的杂技演员
 * 
 * @author Administrator
 *
 */
public class PoeticJuggler extends Juggler {

	// 依赖诗歌
	private Poem poem;

	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}

	public PoeticJuggler(int beanBages, Poem poem) {
		super(beanBages);
		this.poem = poem;
	}

	@Override
	public void perform() {
		super.perform();
		poem.revict();
	}
}
