package com.example.demo2.controllers;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entities.User;
import com.example.demo2.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		
		try {
			User registeredUser=userService.userRegister(user);
			return ResponseEntity.ok(Map.of("message", "User registered successfully","user" , registeredUser));
		}
		
		catch(Exception e) {
			return ResponseEntity.badRequest().body(Map.of("ERROR",e.getMessage()));
		}
	}
}
