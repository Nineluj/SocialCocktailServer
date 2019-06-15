package com.boost.SocialCocktailJavaServer.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
