package com.boost.SocialCocktailJavaServer.controllers;

import com.boost.SocialCocktailJavaServer.models.Cocktail;
import com.boost.SocialCocktailJavaServer.services.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class CocktailController {
	@Autowired
	private CocktailService cocktailService;
	
	@PostMapping("/api/cocktails")
	public ResponseEntity createCocktail(@RequestBody Cocktail cocktail) {
		if (this.cocktailService.createCocktail(cocktail)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.CONFLICT);
	}
}
