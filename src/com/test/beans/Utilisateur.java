package com.test.beans;



public class Utilisateur {

	private String login;
	private String motDePasse;
	
	public Utilisateur(String pLogin, String pMotDePasse) {
		this.login=pLogin;
		this.motDePasse=pMotDePasse;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
}