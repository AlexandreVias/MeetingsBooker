package com.test.beans;



public class Utilisateur {

	private String login;
	private String mdp;
	
	public Utilisateur(String plogin, String pmotdepasse) {
		
		this.login=plogin;
		this.mdp=pmotdepasse;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
}