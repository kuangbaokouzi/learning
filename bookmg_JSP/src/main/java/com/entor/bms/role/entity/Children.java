package com.entor.bms.role.entity;

import java.util.List;

/**
 * easyui-tree对应的属性
 * 
 * @author Administrator
 *
 */
public class Children {
	private Integer id;
	private String text;
	private String href;
	private Integer type;
	private List<Children> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}

}
