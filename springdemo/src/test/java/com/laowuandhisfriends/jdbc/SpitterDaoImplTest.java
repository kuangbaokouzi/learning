package com.laowuandhisfriends.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration({"classpath:Spring-jdbc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpitterDaoImplTest {

    @Resource
    private ApplicationContext context;

    @Test
    public void addSpitter() {
        SpitterDao spitterDao = (SpitterDao) context.getBean("spitterDao");
        Spitter spitter = new Spitter();
        spitter.setUsername("Json");
        spitter.setPassword("123");
        spitter.setFullName("JsonWu");
        spitterDao.addSpitter(spitter);
    }

    @Test
    public void addSpitterAndGetAutoIncreaseId() {
        SpitterDao spitterDao = (SpitterDao) context.getBean("spitterDao");
        Spitter spitter = new Spitter();
        spitter.setUsername("Json");
        spitter.setPassword("123");
        spitter.setFullName("JsonWu");
        System.out.println(spitterDao.addSpitterAndGetAutoIncreaseId(spitter));
    }

    @Test
    public void updateSpitter() {
        SpitterDao spitterDao = (SpitterDao) context.getBean("spitterDao");
        Spitter spitter = new Spitter();
        spitter.setEmail("kouzikaile@gmail.com");
        spitter.setUpdateEmail(false);
        spitterDao.updateSpitter(spitter);
    }

    @Test
    public void getSpitterById() {
        SpitterDao spitterDao = (SpitterDao) context.getBean("spitterDao");
        System.out.println(spitterDao.getSpitterById(2));
    }
}