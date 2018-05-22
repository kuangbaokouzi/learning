package com.entor.bms.role.entity;

import java.util.HashSet;
import java.util.Set;

public class Limits {
	private Integer limitId;// 菜单id
	private String limitName;// 菜单名
	private String url;// 跳转url
	private Integer pid;// 父节点id
	private Integer type;// url类型，跳转或不跳转

	// 与角色多对多，一个菜单可以对应多个角色
	private Set<Roles> roles = new HashSet<>();

	public Integer getLimitId() {
		return limitId;
	}

	public void setLimitId(Integer limitId) {
		this.limitId = limitId;
	}

	public String getLimitName() {
		return limitName;
	}

	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

}
