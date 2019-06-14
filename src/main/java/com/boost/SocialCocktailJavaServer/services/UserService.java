package com.boost.SocialCocktailJavaServer.services;

import com.boost.SocialCocktailJavaServer.models.Cocktail;
import com.boost.SocialCocktailJavaServer.models.User;
import com.boost.SocialCocktailJavaServer.repositories.CocktailRepository;
import com.boost.SocialCocktailJavaServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CocktailRepository cocktailRepository;
	
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
	
	public User findUserById(Integer id) {
		if (this.userRepository.findById(id).isPresent()) {
			return this.userRepository.findById(id).get();
		}
		return null;
	}
	
	public User updateUser(User user) {
		return this.userRepository.save(user);
	}
	
	public void addLikedCocktail(Integer cocktailId, Integer userId) {
		User curUser = this.userRepository.findById(userId).get();
		List<Cocktail> likedCocktails = curUser.getLikedCocktails();
		likedCocktails.add(this.cocktailRepository.findById(cocktailId).get());
		curUser.setLikedCocktails(likedCocktails);
		this.userRepository.save(curUser);
	}
}
