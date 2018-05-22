package com.entor.bms.user.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.entor.bms.role.entity.Roles;

/**
 * 用户信息
 */
public class UserInfo {
	private Integer uid;// 编号
	private String name;// 姓名
	private String password;// 密码
	private String idCard;// 证件号
	private List<Integer> rentBooks = new LinkedList<>();// 租赁书籍id信息
	private Integer status;// 状态，0表示冻结，1表示普通用户，2表示管理员
	private String pic;// 相片地址

	// 与角色多对多，一个用户可以对应多个角色
	private Set<Roles> roles = new HashSet<>();

	public UserInfo() {
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public List<Integer> getRentBooks() {
		return rentBooks;
	}

	public void setRentBooks(List<Integer> rentBooks) {
		this.rentBooks = rentBooks;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserInfo userInfo = (UserInfo) o;
		return Objects.equals(uid, userInfo.uid);
	}

	@Override
	public int hashCode() {

		return Objects.hash(uid);
	}

	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", name=" + name + ", password=" + password + ", idCard=" + idCard
				+ ", rentBooks=" + rentBooks + ", status=" + status + ", pic=" + pic + ", roles=" + roles + "]";
	}

}
