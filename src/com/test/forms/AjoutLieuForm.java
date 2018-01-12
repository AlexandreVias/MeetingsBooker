package com.test.forms;

//Validation du formulaire d'ajouter

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.test.beans.Lieu;
import com.test.dao.DAOException;
import com.test.dao.LieuDao;

public final class AjoutLieuForm {
 private static final String CHAMP_NOM = "nom";
 private static final String CHAMP_ADRESS = "adresse";
 private static final String CHAMP_VILLE = "ville";
 private static final String CHAMP_CP = "codepostal";
 private static final String CHAMP_COOR = "coordonnees";
 private static final String CHAMP_DES = "descriptif";
 private static final String CHAMP_ANNUL = "annulationgratuite";
 private static final String CHAMP_NOTE = "note";


 private String              resultat;
 private Map<String, String> erreurs          = new HashMap<String, String>();
 private LieuDao      lieuDao;

 public AjoutLieuForm( LieuDao lieuDao ) {
     this.lieuDao = lieuDao;
 }

 public Map<String, String> getErreurs() {
     return erreurs;
 }

 public String getResultat() {
     return resultat;
 }

 public Lieu AjouterLieu( HttpServletRequest request ) {
	 String nom = getValeurChamp( request, CHAMP_NOM );
     String adresse = getValeurChamp( request, CHAMP_ADRESS );
     String ville = getValeurChamp( request, CHAMP_VILLE );
     String codepostal = getValeurChamp( request, CHAMP_CP );
     String coordonnees = getValeurChamp( request, CHAMP_COOR );
     String descriptif = getValeurChamp( request, CHAMP_DES );
     boolean annulationgratuite = getValeurChampBoo( request, CHAMP_ANNUL );
     int note = getValeurChampInt( request, CHAMP_NOTE );

     Lieu lieu = new Lieu();
     try {
			traiterNom( nom, lieu );
         traiterAdresse( adresse, lieu );
         traiterVille( ville, lieu );
		  traiterCodePostal(codepostal, lieu);
		  traiterCoordonnees(coordonnees, lieu);
		  traiterDescriptif(descriptif, lieu);
		  traiterAnnulationGratuite(annulationgratuite, lieu);
		  traiterNote(note, lieu);

         if ( erreurs.isEmpty() ) {
             lieuDao.creer( lieu );
             resultat = "Succès de l'ajout.";
         } else {
             resultat = "Échec de l'ajout.";
         }
     } catch ( DAOException e ) {
         resultat = "Échec de l'ajout : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
         e.printStackTrace();
     }

     return lieu;
}

 private void traiterNom( String nom,Lieu lieu) {
	 try {
		 validationNom(nom);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_NOM, e.getMessage());
	 }
	 lieu.setNom(nom);
 }
 
 private void traiterVille( String ville,Lieu lieu) {
	 try {
		 validationVille(ville);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_VILLE, e.getMessage());
	 }
	 lieu.setVille(ville);
 }
 
 private void traiterAdresse( String adresse,Lieu lieu) {
	 try {
		 validationAdresse(adresse);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_ADRESS, e.getMessage());
	 }
	 lieu.setAdresse(adresse);
 }
 
 private void traiterCodePostal( String codepostal,Lieu lieu) {
	 try {
		 validationCP(codepostal);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_CP, e.getMessage());
	 }
	 lieu.setCodepostal(codepostal);
 }
 
 private void traiterCoordonnees( String coordonnees,Lieu lieu) {
	 try {
		 validationCoor(coordonnees);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_COOR, e.getMessage());
	 }
	 lieu.setCoordonnees(coordonnees);
 }
 
 private void traiterDescriptif( String descriptif,Lieu lieu) {
	 try {
		 validationDES(descriptif);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_DES, e.getMessage());
	 }
	 lieu.setDescriptif(descriptif);
 }
 
 private void traiterAnnulationGratuite( boolean annulationgratuite,Lieu lieu) {
	 try {
		 validationAnnu(annulationgratuite);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_ANNUL, e.getMessage());
	 }
	 lieu.setAnnulationgratuite(annulationgratuite);
 }
 
 private void traiterNote( int note,Lieu lieu) {
	 try {
		 validationNote(note);
	 }catch (FormValidationException e ) {
		 setErreur (CHAMP_NOTE, e.getMessage());
	 }
	 lieu.setNote(note);
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
	
	/* Validation des coordonnees */
 private void validationCoor( String coordonnees ) throws FormValidationException {
     if ( coordonnees != null && coordonnees.length() < 1 ) {
         throw new FormValidationException( "Les coordonnes doivent contenir au moins 1 caractère." );
     }
 }
 
	/* Validation du descriptif */
private void validationDES( String descriptif ) throws FormValidationException {
  if ( descriptif != null && descriptif.length() < 10 ) {
      throw new FormValidationException( "Le descriptif doit contenir au moins 10 caractère." );
  }
}

/* Validation de l'annulation gratuite */
private void validationAnnu( boolean annulationgratuite ) throws FormValidationException {
 if ( annulationgratuite != Boolean.parseBoolean(null) ) {
     throw new FormValidationException( "L'annulation gratuite doit contenir une valeur." );
 }
}

/* Validation de la notes */
private void validationNote( int note ) throws FormValidationException {
 if ( note != Integer.parseInt(null) && note >= 0 && note <= 5 ) {
     throw new FormValidationException( "Les coordonnes doivent contenir 1 caractère." );
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
 
 private static boolean getValeurChampBoo( HttpServletRequest request, String nomChamp ) {
     boolean valeur = Boolean.parseBoolean(request.getParameter( nomChamp ));
     if ( valeur == Boolean.parseBoolean(null) ) {
         return Boolean.parseBoolean(null);
     } else {
         return valeur;
     }
 }
 
 private static int getValeurChampInt( HttpServletRequest request, String nomChamp ) {
     int valeur = Integer.parseInt(request.getParameter( nomChamp ));
     if ( valeur == Integer.parseInt(null)) {
         return Integer.parseInt(null);
     } else {
         return valeur;
     }
 }
 
}

