package com.revature.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

	private static final long serialVersionUID = 8154117081788566281L;

	private int user_id;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String email;
	private int role_id;
	private Reimbursement[] reimbArr;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String first_name, String last_name, String username, String password, String email,
			int role_id) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", password=" + password + ", email=" + email + ", role_id=" + role_id + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Reimbursement[] getReimbArr() {
		return reimbArr;
	}
	public void setReimbArr(Reimbursement[] reimbArr) {
		this.reimbArr = reimbArr;
	}

	
}