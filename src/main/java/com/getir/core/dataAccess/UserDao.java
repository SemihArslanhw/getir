package com.getir.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getir.core.entities.User;



public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmail(String email);

	
}
