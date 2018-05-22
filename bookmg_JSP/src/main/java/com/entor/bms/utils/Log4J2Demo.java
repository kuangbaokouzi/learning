package com.entor.bms.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4J2Demo {
	// 创建日志对象
	private static final Logger LOGGER = LogManager.getLogger();

	public static void main(String... args) {
		String arguments = null;
		String thing = arguments != null ? arguments : "world";
		LOGGER.info("Hello, {}!", thing);
		LOGGER.debug("Got calculated value only if debug enabled: {}", doSomeCalculation());
	}

	private static String doSomeCalculation() {
		return "doSomeCalculation invoked!";
	}
}
