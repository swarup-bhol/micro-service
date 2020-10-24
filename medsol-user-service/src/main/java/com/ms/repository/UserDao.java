package com.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	
	User findByUserEmail(String email);


}
