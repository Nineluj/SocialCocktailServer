package com.boost.SocialCocktailJavaServer.repositories;

import com.boost.SocialCocktailJavaServer.models.Bartender;
import com.boost.SocialCocktailJavaServer.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BartenderRepository extends CrudRepository<Bartender, Integer> {
    @Query("SELECT user FROM User user WHERE user.username = :username")
    public User findByUsername(@Param("username") String username);
}
