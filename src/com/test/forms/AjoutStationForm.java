package com.test.forms;

//Validation du formulaire d'ajouter

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.test.beans.Station;
import com.test.dao.DAOException;
import com.test.dao.StationDao;

public final class AjoutStationForm {
 private static final String CHAMP_NOM = "nom";
 private static final String CHAMP_ADRESS = "adresse";
 private static final String CHAMP_VILLE = "ville";
 private static final String CHAMP_CP = "codepostal";
 private static final String CHAMP_NB = "nbPlaces";

 private String              resultat;
 private Map<String, String> erreurs          = new HashMap<String, String>();
 private StationDao      stationDao;

 public AjoutStationForm( StationDao stationDao ) {
     this.stationDao = stationDao;
 }

 public Map<String, String> getErreurs() {
     return erreurs;
 }

 public String getResultat() {
     return resultat;
 }

 public Station AjouterStation( HttpServletRequest request ) {
	 String nom = getValeurChamp( request, CHAMP_NOM );
     String adresse = getValeurChamp( request, CHAMP_ADRESS );
     String ville = getValeurChamp( request, CHAMP_VILLE );
     String codepostal = getValeurChamp( request, CHAMP_CP );
     String nbPlaces = getValeurChamp( request, CHAMP_NB );

     Station station = new Station();
     try {
			traiterNom( nom, station );
         traiterAdresse( adresse, station );
         traiterVille( ville, station );
		  traiterCodePostal(codepostal, station);
		  traiterNBPlaces(nbPlaces, station);

         if ( erreurs.isEmpty() ) {
             stationDao.creer( station );
             resultat = "Succès de l'ajout.";
         } else {
             resultat = "Échec de l'ajout.";
         }
     } catch ( DAOException e ) {
         resultat = "Échec de l'ajout : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
         e.printStackTrace();
     }

     return station;
}

 private void traiterNom( String nom,Station station) {
	 try {
		 validationNom(nom);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_NOM, e.getMessage());
	 }
	 station.setNom(nom);
 }
 
 private void traiterVille( String ville,Station station) {
	 try {
		 validationVille(ville);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_VILLE, e.getMessage());
	 }
	 station.setVille(ville);
 }
 
 private void traiterAdresse( String adresse,Station station) {
	 try {
		 validationAdresse(adresse);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_ADRESS, e.getMessage());
	 }
	 station.setAdresse(adresse);
 }
 
 private void traiterCodePostal( String codepostal,Station station) {
	 try {
		 validationCP(codepostal);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_CP, e.getMessage());
	 }
	 station.setCodepostal(codepostal);
 }
 
 private void traiterNBPlaces( String nbPlaces,Station station) {
	 try {
		 validationNB(nbPlaces);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_NB, e.getMessage());
	 }
	 station.setNbPlaces(Integer.parseInt(nbPlaces));
 }
 
 
 
 /* Validation du nom */
 private void validationNom( String nom ) throws FormValidationException {
     if ( nom != null && nom.length() < 4 ) {
         throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 4 caractères." );
     }
 }
	
	/* Validation de l'adresse */
 private void validationAdresse( String adresse ) throws FormValidationException {
     if ( adresse != null && adresse.length() < 10 ) {
         throw new FormValidationException( "L'adresse doit contenir au moins 10 caractères." );
     }
 }
	
	/* Validation de la ville */
 private void validationVille( String ville ) throws FormValidationException {
     if ( ville != null && ville.length() < 3 ) {
         throw new FormValidationException( "La ville doit contenir au moins 3 caractères." );
     }
 }
	
	/* Validation du CP */
 private void validationCP( String codepostal ) throws FormValidationException {
     if ( codepostal != null && codepostal.length() < 4 ) {
         throw new FormValidationException( "Le code postal doit contenir au moins 4 caractères." );
     }
 }
	
	/* Validation du nombre de places */
 private void validationNB( String nbPlaces ) throws FormValidationException {
     if ( nbPlaces != null && nbPlaces.length() < 1 ) {
         throw new FormValidationException( "Le nombre de places doit contenir au moins 1 caractères." );
     }
 }
	
 /* Ajoute un message correspondant au champ spécifié à la map des erreurs.*/
 private void setErreur( String champ, String message ) {
     erreurs.put( champ, message );
 }

 /* Méthode utilitaire qui retourne null si un champ est vide, et son contenu
  * sinon.*/
 private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
     String valeur = request.getParameter( nomChamp );
     if ( valeur == null || valeur.trim().length() == 0 ) {
         return null;
     } else {
         return valeur;
     }
 }
}

