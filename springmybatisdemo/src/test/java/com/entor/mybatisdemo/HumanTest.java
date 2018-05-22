package com.entor.mybatisdemo;

import com.entor.mybatisdemo.mapper.CarMapper;
import com.entor.mybatisdemo.mapper.HumanMapper;
import com.entor.mybatisdemo.po.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class HumanTest {

    @Resource
    private HumanMapper humanMapper;

    @Test
    public void testGetById() {
        for (Car car : humanMapper.getById(1).getCars()) {
           System.out.println(car.getMark() + " of " + car.getHuman());
        }
    }
}
