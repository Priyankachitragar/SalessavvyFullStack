package com.example.demo2.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dtos.LoginDTO;
import com.example.demo2.entities.User;
import com.example.demo2.services.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//	
//	
//	AuthService authService;
//	
//	public AuthController(AuthService authService) {
//		this.authService=authService;
//	}
//	@PostMapping("/login")
//	public void loginUser(@RequestBody LoginDTO usercred) {
//		try {
//			User user= authService.authenticate(usercred.getUsername(), usercred.getpassword());
//			String token=authService.generateToken(user);
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//}


@RestController 
@CrossOrigin
(origins = "http://localhost:5174", allowCredentials = "true") 

@RequestMapping("/api/auth") 

public class AuthController { 
	private final AuthService authService;
	public AuthController(AuthService authService) {
		this.authService = authService;
		} 
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO usercred, HttpServletResponse response) { 
		try { 
			User user = authService.authenticate(LoginDTO.getUsername(), LoginDTO.getPassword()); 
			String token = authService.generateToken(user); 
			Cookie cookie = new Cookie("authToken", token);
			cookie.setHttpOnly(true); 
			cookie.setSecure(false); // Set to true if using HTTPS cookie.setPath("/"); 
			cookie.setMaxAge(3600); // 1 hour 
			
			
			cookie.setDomain("localhost"); 
			response.addCookie(cookie); // Optional but useful
			response.addHeader("Set-Cookie", String.format("authToken=%s;Secure; HttpOnly; Path=/; Max-Age=3600; SameSite=None", token));
			Map<String, Object> responseBody = new HashMap<>();
			responseBody.put("message", "Login successful");
			responseBody.put("role", user.getRole().name());
			responseBody.put("username", user.getUsername()); 
			return ResponseEntity.ok(responseBody);
			}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", e.getMessage())); } 
		} 
		}
//@PostMapping("/logout")
//public ResponseEntity<Map<String, String>> logout(HttpServletRequest request,HttpServletResponse response) { 
//	try { 
//		User user=(User) request.getAttribute("authenticatedUser"); 
//		authService.logout(user); 
//		Cookie cookie = new Cookie("authToken", null); 
//		cookie.setHttpOnly(true); 
//		cookie.setMaxAge(0);
//		cookie.setPath("/"); 
//		response.addCookie(cookie);
//		Map<String, String> responseBody = new HashMap<>(); 
//		responseBody.put("message", "Logout successful"); 
//		return ResponseEntity.ok(responseBody); 
//		}
//	catch (RuntimeException e) { 
//		Map<String, String> errorResponse = new HashMap<>(); 
//		errorResponse.put("message", "Logout failed"); 
//		return ResponseEntity.status(500).body(errorResponse);
//	}
//}