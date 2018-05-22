package com.entor.bms.role.entity;

import java.util.HashSet;
import java.util.Set;

import com.entor.bms.user.entity.UserInfo;

public class Roles {
	private Integer rid;// 角色id
	private String roleName;// 角色名称
	
	// 与用户多对多，一个角色可以对应多个用户
	private Set<UserInfo> users = new HashSet<>();
	// 与权限菜单多对多，一个角色可以对应多个菜单
	private Set<Limits> limits = new HashSet<>();
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}
	public Set<Limits> getLimits() {
		return limits;
	}
	public void setLimits(Set<Limits> limits) {
		this.limits = limits;
	}
	
	
}
