package com.ibm.todo.pojo;

public class Login {
	
	private String email;
	private String password;
	
	public Login() {
	}
		
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
