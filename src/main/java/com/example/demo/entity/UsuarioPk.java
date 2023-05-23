package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class UsuarioPk implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;
	
	

	public UsuarioPk() {
		super();
	}

	public UsuarioPk(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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


}
