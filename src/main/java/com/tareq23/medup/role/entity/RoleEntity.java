package com.tareq23.medup.role.entity;

import java.util.Set;

import com.tareq23.medup.roleuser.entity.UserRoleEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3)
	@Column(columnDefinition = "varchar(50)")
	private String name;
	private String description;
	
	
	@OneToMany(mappedBy = "roles")
	private Set<UserRoleEntity> userRoles;
	
}
