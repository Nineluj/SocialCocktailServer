package com.example.SocialCocktailJavaServer.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/users/login")
	public ResponseEntity authenticateUser(@RequestBody User user, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		User retrievedUser = this.userService.authenticateUser(user);
		if (retrievedUser != null) {
			session.setAttribute("userId", retrievedUser.getId());
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/api/users/register")
	public ResponseEntity registerUser(@RequestBody User user, HttpSession session) {
		User retrievedUser = this.userService.registerUser(user);
		if (retrievedUser != null) {
			session.setAttribute("userId", retrievedUser.getId());
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
	
	// Get the currently logged in User.
	@GetMapping("/api/user")
	public User getLoggedInUser(HttpSession session, HttpServletResponse response) {
		if (session.getAttribute("userId") != null) {
			return this.userService.getLoggedInUser((Integer)session.getAttribute("userId"));
		}
		response.setStatus(404);
		return null;
	}
	
	// Logout the currently logged in User, invalidating the HttpSession.
	@GetMapping("/api/user/logout")
	public ResponseEntity logoutUser(HttpSession session) {
		if (session.getAttribute("userId") != null) {
			session.invalidate();
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
}
