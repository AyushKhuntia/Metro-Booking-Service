package com.moveinsync.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_data")
public class UserInfo {
	
	@Id
	@Column(name="username",length=20,nullable=false)
	private String username;
	
	@Column(name="password",length=100,nullable=false)
	private String password;
	
	@Column(name="role",length=20)
	private String role;
	

	@Column(name="enabled")
	private short enabled;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	public UserInfo(String username, String password, String role, short enabled) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;

		this.enabled = enabled;
	}
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
	
	 
	