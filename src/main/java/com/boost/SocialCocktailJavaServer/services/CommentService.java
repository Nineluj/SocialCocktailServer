package com.boost.SocialCocktailJavaServer.services;

import com.boost.SocialCocktailJavaServer.models.Comment;
import com.boost.SocialCocktailJavaServer.repositories.CocktailRepository;
import com.boost.SocialCocktailJavaServer.repositories.CommentRepository;
import com.boost.SocialCocktailJavaServer.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CocktailRepository cocktailRepository;
    
    public List<Comment> getRecentComments(Integer numPosts) {
    	return this.commentRepository.getRecentComments(numPosts);
    }
    
    public Comment createComment(Integer cocktailId, Integer userId, Comment comment) {
		comment.setAuthor(this.userRepository.findById(userId).get());
		comment.setCocktail(this.cocktailRepository.findById(cocktailId).get()); //unsafe get call for now
		this.userRepository.save(this.userRepository.findById(userId).get());
		return this.commentRepository.save(comment);
    }
    
    public List<Comment> findCommentsByCocktailId(Integer cocktailId) {
    	return this.commentRepository.findCommentsByCocktail_Id(cocktailId);
    }
}