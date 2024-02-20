package com.tareq23.SpringAuthPratice.service;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.tareq23.SpringAuthPratice.config.CustomUserDetailService;
import com.tareq23.SpringAuthPratice.dto.AuthRequest;
import com.tareq23.SpringAuthPratice.dto.AuthSuccess;
import com.tareq23.SpringAuthPratice.entity.UserCredential;
import com.tareq23.SpringAuthPratice.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public Object addUser(UserCredential userCredential)
	{
		
		if(userCredential.getPassword().length() < 8) {
			return ResponseEntity.badRequest().body("Password must be greater than 8 character");	
		}
	
		Object obj = repository.findByEmail(userCredential.getEmail());
		
		if(!ObjectUtils.isEmpty(obj)) {
			System.out.println("=====================================================>"+obj);	
			return ResponseEntity.status(409)
					                    .body(userCredential.getEmail()+" email already exists ");
		}
		
		userCredential.setPassword(encoder.encode(userCredential.getPassword()));
		repository.save(userCredential);
		return ResponseEntity.ok().body("You are successfully registered");
	}
	
	public Object getAllUser()
	{
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	
	public Object login(AuthRequest authRequest)
	{
		
		System.out.println(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		
		System.out.println(authentication.getDetails());
		if(!authentication.isAuthenticated()) {
			return ResponseEntity.status(HttpStatusCode.valueOf(401)).body("Bad Credentials");
		}
		
		String token = jwtService.generateToken(authRequest.getEmail());
		
		return  ResponseEntity.status(200).body(token);
		
	}
	
	

}
