package com.example.SocialCocktailJavaServer.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	private String username;
	private String password;
	private RoleType role;
	private String email;
	private String phoneNum;
	
	@ManyToMany
	private List<Cocktail> likedCocktails;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
