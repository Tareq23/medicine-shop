package com.tareq23.SpringAuthPratice.config;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tareq23.SpringAuthPratice.entity.UserCredential;
import com.tareq23.SpringAuthPratice.repository.UserRepository;


@Component
public class CustomUserDetailService implements UserDetailsService {
	
	
	@Autowired
	private UserRepository repository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("============== load user by username method ====================");
		
	    Optional<UserCredential> user =	repository.findByEmail(username);
		
	    
	    
	    return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username+" is not found"));
	    
	    
		// TODO Auto-generated method stub
//		return null;
	}

}
