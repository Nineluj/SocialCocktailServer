package com.boost.SocialCocktailJavaServer.services;

import com.boost.SocialCocktailJavaServer.models.User;
import com.boost.SocialCocktailJavaServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
