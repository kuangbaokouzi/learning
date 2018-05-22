package com.entor.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.entor.springdemo")
public class ApplicationContext5Config {

	/*@Bean("saxophone")
	public Instrument getSaxophone() {
		return new Saxophone();
	}*/
}
