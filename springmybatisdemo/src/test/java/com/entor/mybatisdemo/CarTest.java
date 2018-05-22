package com.entor.mybatisdemo;

import com.entor.mybatisdemo.mapper.CarMapper;
import com.entor.mybatisdemo.mapper.HumanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CarTest {
    @Resource
    private CarMapper carMapper;

    @Test
    public void testGetById() {
        System.out.println(carMapper.getById(1).getHuman());
    }

    @Test
    public void testGetCarsByUid() {
        System.out.println(carMapper.getCarsByHumanId(2).get(0).getHuman());
    }

}
