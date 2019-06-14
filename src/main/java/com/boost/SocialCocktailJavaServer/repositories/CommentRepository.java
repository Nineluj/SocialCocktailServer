package com.boost.SocialCocktailJavaServer.repositories;

import com.boost.SocialCocktailJavaServer.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> { }
