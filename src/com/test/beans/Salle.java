package com.test.beans;

public class Salle {
	
	private String numSalle;
	private Lieu lieu;
	private double largeur;
	private double longueur;
	private double hauteur;
	private double surface;
	private double tarif;
	private String photo;
	
	public Salle(String pNumSalle, Lieu pLieu, double pLargeur, double pLongueur, double pHauteur,
					double pSurface, double pTarif, String pPhoto) {
		numSalle = pNumSalle;
		lieu = pLieu;
		largeur = pLargeur;
		longueur = pLongueur;
		hauteur = pHauteur;
		surface = pSurface;
		tarif = pTarif;
		photo = pPhoto;
	}
	
	public String getNumSalle() {
		return numSalle;
	}
	public void setNumSalle(String pNumSalle) {
		numSalle = pNumSalle;
	}
	
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu pLieu) {
		lieu = pLieu;
	}
	
	public double getLargeur() {
		return largeur;
	}
	public void setLargeur(double pLargeur) {
		largeur = pLargeur;
	}
	
	public double getLongueur() {
		return longueur;
	}
	public void setLongueur(double pLongueur) {
		longueur = pLongueur;
	}
	
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double pHauteur) {
		hauteur = pHauteur;
	}
	
	public double getSurface() {
		return surface;
	}
	public void setSurface(double pSurface) {
		surface = pSurface;
	}
	
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double pTarif) {
		tarif = pTarif;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String pPhoto) {
		photo = pPhoto;
	}

}
