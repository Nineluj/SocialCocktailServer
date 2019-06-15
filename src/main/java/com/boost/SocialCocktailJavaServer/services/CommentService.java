package com.boost.SocialCocktailJavaServer.services;

import com.boost.SocialCocktailJavaServer.models.Comment;
import com.boost.SocialCocktailJavaServer.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired

    private CommentRepository commentRepository;
//    private CocktailService
//
//    public List<Comment> getCommentsForCocktail(int cocktailId) {
//        return null;
//    }
    
    public List<Comment> getRecentComments(Integer numPosts) {
    	return this.commentRepository.getRecentComments(numPosts);
    }
}