package com.laowuandhisfriends.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.laowuandhisfriends.api.Dept;

@Mapper
public interface IDeptDAO {
	Dept findById(Long id);

	boolean createDept(Dept dept);

	List<Dept> findAll();
}
