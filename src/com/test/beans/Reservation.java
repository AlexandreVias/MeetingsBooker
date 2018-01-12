package com.test.beans;

import java.sql.Date;

public class Reservation {

	private String numResa;
	private Date dateResa;
	private int nbConvives;
	private String duree;
	private double prixTotal;
	
	public Reservation(String pNumResa, Date pDateResa, int pNbConvives, String pDuree, double pPrixTotal) {
		numResa = pNumResa;
		dateResa = pDateResa;
		nbConvives = pNbConvives;
		duree = pDuree;
		prixTotal = pPrixTotal;
	}
	
	public String getNumResa() {
		return numResa;
	}
	public void setNumResa(String pNumResa) {
		numResa = pNumResa;
	}
	public Date getDateResa() {
		return dateResa;
	}
	public void setDateResa(Date pDateResa) {
		dateResa = pDateResa;
	}
	public int getNbConvives() {
		return nbConvives;
	}
	public void setNbConvives(int pNbConvives) {
		nbConvives = pNbConvives;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String pDuree) {
		duree = pDuree;
	}
	public double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(double pPrixTotal) {
		prixTotal = pPrixTotal;
	}
	
}
