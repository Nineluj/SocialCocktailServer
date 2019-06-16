package com.boost.SocialCocktailJavaServer.controllers;

import com.boost.SocialCocktailJavaServer.models.Cocktail;
import com.boost.SocialCocktailJavaServer.models.JacksonView;
import com.boost.SocialCocktailJavaServer.models.User;
import com.boost.SocialCocktailJavaServer.services.CocktailService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


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

	@GetMapping("/api/cocktails/{cocktailId}")
	@JsonView(JacksonView.forCocktailRequest.class)
	public ResponseEntity<Cocktail> findCocktailById(@PathVariable("cocktailId") int cocktailId) {
		Cocktail response = this.cocktailService.findCocktailById(cocktailId);

		if (response == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@PostMapping("/api/cocktails/{cocktailId}/likes")
	public ResponseEntity userLikeCocktail(@PathVariable("cocktailId") int cocktailId, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		} else {
			if (this.cocktailService.likeCocktail(cocktailId, (Integer) session.getAttribute("userId"))) {
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
		}
	}

	@GetMapping("/api/cocktails/{cocktailId}/likes")
	@JsonView(JacksonView.forUserRequest.class)
	public List<User> findCocktailUsersLikes(@PathVariable("cocktailId") int cocktailId) {
		return this.cocktailService.findCocktailUsersLikes(cocktailId);
	}

//	@GetMapping("/api/cocktail/{cocktailId}/comments")
//	public List<Comment> findCommentsByCocktailId(@PathVariable("cocktailId") Integer cocktailId) {
//		return this.commentService.findCommentsByCocktailId(cocktailId);
//	}
}
