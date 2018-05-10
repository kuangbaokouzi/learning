package com.laowuandhisfriends.service;

import java.util.List;

import com.laowuandhisfriends.api.Dept;

public interface IDeptService {
	Dept get(long id);
    boolean add(Dept dept);
    List<Dept> list();
}
