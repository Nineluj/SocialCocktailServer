package com.example.SocialCocktailJavaServer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.SocialCocktailJavaServer.models.Cocktail;

public interface CocktailRepository extends CrudRepository<Cocktail, Integer> {
	
}
