package com.tareq23.medup.roleuser;



import com.tareq23.medup.auth.entity.UserCredential;
import com.tareq23.medup.role.RoleEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user_roles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** follow https://www.baeldung.com/jpa-many-to-many

	 */
	 
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserCredential users;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleEntity roles;
	
}
