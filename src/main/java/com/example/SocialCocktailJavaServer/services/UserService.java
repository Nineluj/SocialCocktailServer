package com.example.SocialCocktailJavaServer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SocialCocktailJavaServer.models.User;
import com.example.SocialCocktailJavaServer.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// Authenticate that a correct username password pair was entered.
	public User authenticateUser(User user) {
		return this.userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	// Register a user.
	public User registerUser(User user) {
		if (this.userRepository.findByUsername(user.getUsername()) == null) {
			return this.userRepository.save(user);
		}
		return null;
	}
	
	public User getLoggedInUser(Integer userId) {
		if (this.userRepository.findById(userId).isPresent()) {
			return this.userRepository.findById(userId).get();
		}
		return null;
	}
	
	public User updateUser(User user) {
		return this.userRepository.save(user);
	}
}
