package com.test.beans;

public class Lieu {

	private String numLieu;
	private Categorie laCateg;
	private Utilisateur leLoueur;
	private String nom;
	private String adresse;
	private String ville;
	private String codepostal;
	private String coordonnees;
	private String descriptif;
	private boolean annulationgratuite;
	private int note;
	
	public String getNumLieu() {
		return numLieu;
	}
	public void setNumLieu(String numLieu) {
		this.numLieu = numLieu;
	}
	public Categorie getLaCateg() {
		return laCateg;
	}
	public void setLaCateg(Categorie laCateg) {
		this.laCateg = laCateg;
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
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	public String getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public boolean isAnnulationgratuite() {
		return annulationgratuite;
	}
	public void setAnnulationgratuite(boolean annulationgratuite) {
		this.annulationgratuite = annulationgratuite;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Utilisateur getLeLoueur() {
		return leLoueur;
	}
	public void setLeLoueur(Utilisateur leLoueur) {
		this.leLoueur = leLoueur;
	}
	

	
}