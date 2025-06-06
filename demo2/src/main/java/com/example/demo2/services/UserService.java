package com.example.demo2.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo2.entities.User;
import com.example.demo2.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
		this.passwordEncoder=new BCryptPasswordEncoder();
	}
	
	public User userRegister(User user) {
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new RuntimeException("Username is alrady taken");
		}
		
		if(userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("Email is already registered");
		}
		
		String ppwd=user.getPassword();
		String epwd=passwordEncoder.encode(ppwd);
		user.setPassword(epwd);
		
		// user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
	}
}
