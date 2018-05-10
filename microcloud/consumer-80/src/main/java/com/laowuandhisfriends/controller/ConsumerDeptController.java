package com.laowuandhisfriends.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.laowuandhisfriends.api.Dept;

@RestController
public class ConsumerDeptController {

	private static String DEPT_GET_URL = "http://localhost:8001/dept/get";
	private static String DEPT_LIST_URL = "http://localhost:8001/dept/list";
	private static String DEPT_ADD_URL = "http://localhost:8001/dept/add";

	@Resource
	private RestTemplate restTemplate;
	@Resource
	private HttpHeaders headers;

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Object getDept(@PathVariable long id) {
		return this.restTemplate
				.exchange(DEPT_GET_URL + "/" + id, HttpMethod.GET, new HttpEntity<Object>(this.headers), Dept.class)
				.getBody();
	}

	@RequestMapping(value = "/consumer/dept/list")
	public Object listDepts() {
		return this.restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET, new HttpEntity<Object>(this.headers),
				List.class);
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Object addDept(Dept dept) {
		return this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST, new HttpEntity<Object>(dept, this.headers),
				Boolean.class);
	}
}
