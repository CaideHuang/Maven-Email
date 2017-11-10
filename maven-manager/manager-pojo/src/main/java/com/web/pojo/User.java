package com.web.pojo;

public class User {
	
	private int id;
	private String email;
	private String password;
	private String code;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public User(int id, String email, String password, String code, int state) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.code = code;
		this.state = state;
	}
	public User() {
	}
	
	
	
	

}
