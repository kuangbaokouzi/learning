package com.laowuandhisfriends.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.laowuandhisfriends.Dept_8001_StartSpringCloudApplication;
import com.laowuandhisfriends.api.Dept;

@SpringBootTest(classes = Dept_8001_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDeptServiceTest {

	@Resource
	private IDeptService deptService;

	@Test
	public void testGet() {
		System.out.println(this.deptService.get(1));
	}

	@Test
	public void testAdd() {
		Dept dept = new Dept();
		dept.setDname("Test-" + System.currentTimeMillis());
		dept.setLoc("Location-" + System.currentTimeMillis());
		System.out.println(this.deptService.add(dept));
	}

	@Test
	public void testList() {
		System.out.println(this.deptService.list());
	}

}
