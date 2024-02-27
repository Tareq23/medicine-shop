package com.tareq23.medup.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tareq23.medup.auth.dto.AuthRequest;
import com.tareq23.medup.auth.entity.UserCredential;
import com.tareq23.medup.auth.service.AuthService;
import com.tareq23.medup.auth.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService service;
	
	@Autowired
	private JwtService jwtService;
	
	
	@PostMapping("/register")
	public Object addUser(@RequestBody UserCredential user)
	{
		return service.addUser(user);
	}
	
	
	@PostMapping("/login")
	public Object checkUser(@RequestBody AuthRequest authRequest)
	{
		return service.login(authRequest);
		
	}
	
	@GetMapping("/all/users")
	public Object getAll()
	{
		return service.getAllUser();
	}
	
	
	
}
