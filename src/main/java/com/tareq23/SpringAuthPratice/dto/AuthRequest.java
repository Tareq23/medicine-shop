package com.tareq23.SpringAuthPratice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthRequest {
	
	private String email;
	private String password;
	
	
	

}
