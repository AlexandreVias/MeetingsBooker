package com.test.beans;

public class Categorie {

	private String numCateg;
	private String libelle;
	
	public Categorie(String pnum, String plibelle) {
		this.numCateg=pnum;
		this.libelle=plibelle;
	}
	
	public String getNumCateg() {
		return numCateg;
	}
	public void setNumCateg(String numCateg) {
		this.numCateg = numCateg;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
