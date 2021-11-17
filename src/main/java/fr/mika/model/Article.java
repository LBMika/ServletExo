package fr.mika.model;

public class Article {

	// private User user;
	private String titre;
	private String contenu;
	private String username;
	
	public Article() {
		
	}

	public Article(String username, String titre, String contenu) {
		super();
		this.username = username;
		this.titre = titre;
		this.contenu = contenu;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String username) {
		this.username = username;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
