package com.user.UserManagement.userService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.UserManagement.model.MyUserDetails;
import com.user.UserManagement.model.User;
import com.user.UserManagement.userRepository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Inside load");
		Optional<User> user= userRepository.findUserByUserName(userName);
		user.orElseThrow(()->new UsernameNotFoundException("Not Found : "+userName));
		return new MyUserDetails(user.get());
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		System.out.println("Inside load");
		Optional<User> user= userRepository.findUserByUserName(userName);
		return user.get();
		
	}
	
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user= userRepository.findById(id);
		return user.get();
		
	}
	


}
