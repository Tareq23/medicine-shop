package com.tareq23.medup.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tareq23.medup.auth.filter.JwtAuthFilter;

import org.springframework.beans.factory.annotation.Autowired;


@Configuration
@EnableWebSecurity
public class AuthConfig {
	
	
	@Autowired
	private JwtAuthFilter jwtAuthFilter;
	
	@Bean
	public UserDetailsService detailsService()
	{
		
		return new CustomUserDetailService();
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		
		
//		return http.csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/auth/**")
//                .permitAll()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/users/all")
//                .hasAnyAuthority("ROLE_MANAGER")
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/departments/**")
//                .hasAnyAuthority("ROLE_TEACHER","ROLE_STUDENT")
//                .and()
//                .addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class)
//                .authenticationProvider(authenticationProvider())
//                .build();
    	
    	http
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .anyRequest().permitAll() // Permit access to all URLs
        )
        .csrf().disable(); // Disable CSRF protection for simplicity (not recommended in production)
    
    return http.build();
    	
	}
	
	@Bean
    PasswordEncoder passwordEncoder()
	{
		 return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		
		authenticationProvider.setUserDetailsService(detailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}
	
	
	

}
