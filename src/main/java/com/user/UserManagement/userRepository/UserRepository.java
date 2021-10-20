package com.user.UserManagement.userRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.UserManagement.model.User;
public interface UserRepository extends JpaRepository<User, Integer>  {
	
	Optional<User> findUserByUserName(String userName);
	
	

}
