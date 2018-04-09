package com.laowuandhisfriends.aop;

import com.laowuandhisfriends.di.Performer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration({"classpath:Spring-AOP-Annotation.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AOPTAnnoTest {
    @Resource
    private ApplicationContext context;

    @Test
    public void testAOPOnPerformer() {
        Performer kenny = (Performer) context.getBean("kenny");
        kenny.perform();
    }

    @Test
    public void testAOPOnMagician() {
        Volunteer volunteer = (Volunteer) context.getBean("volunteer");
        volunteer.thinkOfSomething("Queen of Hearts");
        Assert.assertEquals("Queen of Hearts", ((Magician) context.getBean("magician")).getThoughts());
    }
}