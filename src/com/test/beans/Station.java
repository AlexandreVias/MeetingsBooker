package com.test.beans;

public class Station {

	private long id;
	private String nom;
	private String adresse;
	private String ville;
	private String codePostal;
	private String nbPlaces;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(String nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
}
