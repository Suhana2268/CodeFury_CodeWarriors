package com.webapp.models;

import java.sql.Timestamp;

public class User {

	private int userId;
	private String name;
	private String email;
	private String phone;
	private int credit;
	private String role;
	private int active;
	private Timestamp lastlogin;
	
	//constructors
	public User() {
		super();	
	}
	
	public User(String name, String email, String phone, String role) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}
	
	public User(int userId, String name, String email, String phone, int credit, String role, int active,
			Timestamp  lastlogin) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.credit = credit;
		this.role = role;
		this.active = active;
		this. lastlogin= lastlogin;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	public Timestamp getLastLogin() {
		return  lastlogin;
	}
	public void setLastLogin(Timestamp  lastlogin) {
		this. lastlogin =  lastlogin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", credit="
				+ credit + ", role=" + role + ", active=" + active + ", lastlogin=" + lastlogin + "]";
	}
	
}
