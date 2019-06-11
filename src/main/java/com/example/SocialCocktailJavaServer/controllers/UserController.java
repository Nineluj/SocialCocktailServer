package com.example.SocialCocktailJavaServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SocialCocktailJavaServer.models.User;
import com.example.SocialCocktailJavaServer.services.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/users/login")
	public ResponseEntity authenticateUser(@RequestBody User user) {
		if (this.userService.authenticateUser(user) != null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/api/users/register")
	public ResponseEntity registerUser(@RequestBody User user) {
		if (this.userService.registerUser(user) != null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
}
