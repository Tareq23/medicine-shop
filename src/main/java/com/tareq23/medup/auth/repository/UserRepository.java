package com.tareq23.medup.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tareq23.medup.auth.entity.UserCredential;

public interface UserRepository extends JpaRepository<UserCredential, Long>{

	Optional<UserCredential> findByEmail(String email);
	
}
