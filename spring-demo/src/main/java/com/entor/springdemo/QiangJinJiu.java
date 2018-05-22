package com.entor.springdemo;

public class QiangJinJiu implements Poem {

	public static final String[] lines = { //
			"君不见黄河之水天上来，奔流到海不复回。", //
			"君不见高堂明镜悲白发，朝如青丝暮成雪。", //
			"人生得意须尽欢，莫使金樽空对月。", //
			"天生我材必有用，千金散尽还复来。", //
			"烹羊宰牛且为乐，会须一饮三百杯。", //
			"岑夫子，丹丘生，将进酒，杯莫停。" };

	public QiangJinJiu() {
	}

	@Override
	public void revict() {
		for (String string : lines) {
			System.out.println(string);
		}
	}
}
