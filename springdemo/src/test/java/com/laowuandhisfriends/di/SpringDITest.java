package com.laowuandhisfriends.di;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration({"classpath:config/Spring-DI-SpEL.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringDITest {

    @Resource
    private ApplicationContext context;

    @Test
    public void testSetCount() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        Assert.assertEquals(5, springDI.getCount());
    }

    @Test
    public void testSetMessage() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        Assert.assertEquals("The value is 5", springDI.getMessage());
    }

    @Test
    public void testSetFrequency() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        Assert.assertEquals(89, springDI.getFrequency(), 2);
    }

    @Test
    public void testSetCapacity() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        Assert.assertEquals(10000, springDI.getCapacity());
    }

    @Test
    public void testSetName() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        Assert.assertEquals("Chuck", springDI.getName());
    }

    @Test
    public void testSetEnabled() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        Assert.assertEquals(false, springDI.isEnabled());
    }

    @Test
    public void testSetInstrument() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        System.out.println(springDI.getInstrument());
    }

    @Test
    public void testCarl() {
        Instrumentalist carl = (Instrumentalist) context.getBean("carl");
        carl.perform();
    }

    @Test
    public void testSetMultiplier() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        System.out.println(springDI.getMultiplier());
    }

    @Test
    public void testSetRandomNumber() {
        SpringDI springDI = (SpringDI) context.getBean("springDI");
        System.out.println(springDI.getRandomNumber());
    }
}