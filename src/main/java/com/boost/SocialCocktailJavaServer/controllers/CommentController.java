package com.boost.SocialCocktailJavaServer.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boost.SocialCocktailJavaServer.models.Comment;
import com.boost.SocialCocktailJavaServer.services.CommentService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/api/comments/recent/{numPosts}")
	public List<Comment> getRecentComments(@PathVariable("numPosts") Integer numPosts) {
		return this.commentService.getRecentComments(numPosts);
	}
	
	@PostMapping("/api/cocktail/{cocktailId}/comments")
	public ResponseEntity<Comment> createComment(@PathVariable("cocktailId") Integer cocktailId, @RequestBody Comment comment, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return new ResponseEntity<Comment>(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<Comment>(this.commentService.createComment(cocktailId, (Integer) session.getAttribute("userId"), comment), HttpStatus.OK);
	}
	
	@GetMapping("/api/cocktail/{cocktailId}/comments")
	public List<Comment> findCommentsByCocktailId(@PathVariable("cocktailId") Integer cocktailId) {
		return this.commentService.findCommentsByCocktailId(cocktailId);
	}
}
