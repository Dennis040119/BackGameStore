package com.example.demo.security;

import lombok.Data;

@Data
public class JWTRequest {

	private String username;
	private String password;
}
