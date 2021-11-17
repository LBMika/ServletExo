package fr.mika.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String email;
	private List<Article> articles;
	private String role;
	
	public User() {
	}
	
	public User(String username, String email, String role) {
		super();
		this.username = username;
		this.email = email;
		this.role = role;
		articles = new ArrayList<Article>();
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
