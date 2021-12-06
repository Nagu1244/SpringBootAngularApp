package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.User;

public interface RegisterRepository extends JpaRepository<User, Integer> {
	
	User findByEmailId(String emailId);
    User findByEmailIdAndPassword(String emailId,String password);
    
}
