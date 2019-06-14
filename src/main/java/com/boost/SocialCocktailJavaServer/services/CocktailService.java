package com.example.SocialCocktailJavaServer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SocialCocktailJavaServer.models.Cocktail;
import com.example.SocialCocktailJavaServer.repositories.CocktailRepository;

@Service
public class CocktailService {
	@Autowired
	private CocktailRepository cocktailRepository;
	
	public boolean createCocktail(Cocktail cocktail) {
		if (this.cocktailRepository.existsById(cocktail.getId())) {
			return false;
		}
		this.cocktailRepository.save(cocktail);
		return true;
	}
}
