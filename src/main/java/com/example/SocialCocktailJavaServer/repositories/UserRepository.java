package com.example.SocialCocktailJavaServer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.SocialCocktailJavaServer.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    @Query("SELECT user FROM User user WHERE user.username = :username AND user.password = :password") 
	public User findByUsernameAndPassword(String username, String password);
    
    @Query("SELECT user FROM User user WHERE user.username = :username")
    public User findByUsername(String username);
}
