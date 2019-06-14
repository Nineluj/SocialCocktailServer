package com.boost.SocialCocktailJavaServer.models;


import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
	@JsonView(JacksonView.freeContext.class)
	private String username;
	@JsonView(JacksonView.freeContext.class)
	private String password;
	@JsonView(JacksonView.freeContext.class)
	private RoleType role;
	@JsonView(JacksonView.freeContext.class)
	private String email;
	@JsonView(JacksonView.freeContext.class)
	private String phoneNum;
	
	@ManyToMany
	@JsonView(JacksonView.withCocktailContext.class)
	private List<Cocktail> likedCocktails;

	@OneToMany
	@JsonView(JacksonView.withCommentContext.class)
	private List<Comment> userComments;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JacksonView.freeContext.class)
	private int id;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public List<Cocktail> getLikedCocktails() {
		return likedCocktails;
	}

	public void setLikedCocktails(List<Cocktail> likedCocktails) {
		this.likedCocktails = likedCocktails;
	}

	public List<Comment> getUserComments() {
		return userComments;
	}

	public void setUserComments(List<Comment> userComments) {
		this.userComments = userComments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
