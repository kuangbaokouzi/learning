package com.laowuandhisfriends.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laowuandhisfriends.api.Dept;
import com.laowuandhisfriends.dao.IDeptDAO;
import com.laowuandhisfriends.service.IDeptService;

@Service
public class IDeptServiceImpl implements IDeptService {

	@Resource
	private IDeptDAO deptDAO;

	@Override
	public Dept get(long id) {
		return this.deptDAO.findById(id);
	}

	@Override
	public boolean add(Dept dept) {
		return this.deptDAO.createDept(dept);
	}

	@Override
	public List<Dept> list() {
		return this.deptDAO.findAll();
	}

}
