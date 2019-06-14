package com.boost.SocialCocktailJavaServer.services;

import com.boost.SocialCocktailJavaServer.models.Cocktail;
import com.boost.SocialCocktailJavaServer.repositories.CocktailRepository;
import com.boost.SocialCocktailJavaServer.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {
	@Autowired
	private CocktailRepository cocktailRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	public boolean createCocktail(Cocktail cocktail) {
		if (this.cocktailRepository.existsById(cocktail.getId())) {
			return false;
		}
		this.cocktailRepository.save(cocktail);
		return true;
	}

	public Cocktail findCocktailById(int cocktailId) {
		return this.cocktailRepository.findById(cocktailId).orElse(null);
	}
}
