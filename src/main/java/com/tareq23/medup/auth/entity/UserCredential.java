package com.tareq23.medup.auth.entity;

import java.util.Set;

import com.tareq23.medup.roleuser.entity.UserRoleEntity;
import com.tareq23.medup.userdetails.entity.UserDetailsEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCredential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String email;

	@Column(nullable = false, columnDefinition = "varchar(15)")
	private String mobile;

	@Column(nullable = false, columnDefinition = "boolean default false")
	private boolean isVarified;

	@OneToOne(mappedBy = "user")
	private UserDetailsEntity userDetails;
	
	@OneToMany(mappedBy = "users")
	private Set<UserRoleEntity> userRoles;

}
