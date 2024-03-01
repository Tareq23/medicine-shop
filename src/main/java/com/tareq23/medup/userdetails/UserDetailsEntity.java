package com.tareq23.medup.userdetails;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import com.tareq23.medup.auth.entity.UserCredential;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String fullName;
	@NotBlank
	private String city;
	private Date dob;
	

	@NotBlank
	@Size(max = 11, min = 11, message = "mobile length must be 11")
	private String mobile;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserCredential user;

}
