package com.jisheng.po;

public class Role {
	private int role_id;
	private int user_id;
	private String role_name;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Role() {
	}

	@Override
	public String toString() {
		return "Role{" +
				"user_id=" + user_id +
				", role_id=" + role_id +
				", role_name='" + role_name + '\'' +
				'}';
	}

	public Role(int user_id, String role_name) {
		this.user_id = user_id;
		this.role_name = role_name;
	}
}
