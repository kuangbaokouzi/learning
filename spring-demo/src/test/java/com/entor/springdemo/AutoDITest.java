package com.entor.springdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:applicationContext3.xml", "classpath:applicationContext4.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AutoDITest {

	@Resource
	private ApplicationContext ac;

	@Test
	public void testAutoDI() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext2.xml");
		Instrumentalist laowang = (Instrumentalist) ac.getBean("laowang");
		System.out.println(laowang.getInstrument());

		Instrumentalist laozhang = (Instrumentalist) ac.getBean("laozhang");
		System.out.println(laozhang.getInstrument());

		Instrumentalist laoli = (Instrumentalist) ac.getBean("laoli");
		System.out.println(laoli.getInstrument());
		
		ac.close();
	}

	@Test
	public void testAnnotaionDI() {
		Instrument saxophone = (Instrument) ac.getBean("saxophone");
		System.out.println(saxophone);

		Instrument instrument = (Instrument) ac.getBean("saxophone2");
		System.out.println(instrument);

		Instrumentalist laowang = (Instrumentalist) ac.getBean("laowang");
		System.out.println(laowang.getInstrument());
	}

	@Test
	public void testComponents() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext4.xml");
		Instrumentalist laowang = (Instrumentalist) ac.getBean("laowang");
		Instrumentalist laowang2 = (Instrumentalist) ac.getBean("laowang");
		System.out.println(laowang == laowang2);
		laowang.perform();
	}

	@Test
	public void testAnnotationConfig() {
		AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext();
		annotation.register(ApplicationContext5Config.class);
		annotation.refresh();
		Instrumentalist laowang = (Instrumentalist) annotation.getBean("laowang");
		laowang.perform();

		Instrument saxophone = (Instrument) annotation.getBean("saxophone");
		System.out.println(saxophone);
		
		annotation.close();
	}

	@Test
	public void testSpringJunit() {
		Instrumentalist laowang = (Instrumentalist) ac.getBean("laowang");
		laowang.perform();
	}
}
