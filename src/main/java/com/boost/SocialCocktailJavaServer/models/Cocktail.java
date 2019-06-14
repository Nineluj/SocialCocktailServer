package com.boost.SocialCocktailJavaServer.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Cocktail {
	
	@Id
	private Integer id;
	private String name;
	
	@ManyToMany
	private List<User> usersLikedBy;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsersLikedBy() {
		return usersLikedBy;
	}
	public void setUsersLikedBy(List<User> usersLikedBy) {
		this.usersLikedBy = usersLikedBy;
	}
}
