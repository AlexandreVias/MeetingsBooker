package com.test.forms;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.test.beans.Station;
import com.test.dao.DAOException;
import com.test.dao.StationDao;

public final class StationForm {
    private static final String CHAMP_NOM  = "nom";
    private static final String CHAMP_ADRESSE  = "adresse";
    private static final String CHAMP_VILLE  = "ville";
    private static final String CHAMP_CODEPOSTAL  = "codepostal";
    private static final String CHAMP_NBPLACES  = "nbplaces";

    private String              resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    private StationDao          stationDAO;

    public StationForm(StationDao stationDAO) {
        this.stationDAO= stationDAO;
    }
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    public String getResultat() {
        return resultat;
    }

    public Station creerStation(HttpServletRequest request) {
        String nom = getValeurChamp(request, CHAMP_NOM);
        String adresse = getValeurChamp(request, CHAMP_ADRESSE);
        String ville = getValeurChamp(request, CHAMP_VILLE);
        String codepostal = getValeurChamp(request, CHAMP_CODEPOSTAL);
        String nbplaces = getValeurChamp(request, CHAMP_NBPLACES);
        Station station = new Station();
        try {
            traiterNom( nom, station);
            traiterAdresse(adresse, station);
            traiterVille( ville, station);
            traiterCodePostal(codepostal, station);
            traiterNbPlaces( nbplaces, station);
            if ( erreurs.isEmpty() ) {
                stationDAO.creer(station);
                resultat = "Succès de l'ajout.";
            } else {
                resultat = "Échec de l'ajout.";
            }
        } catch (DAOException e) {
            resultat = "Échec de l'ajout : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return station;
    }

    private void traiterNom(String nom, Station station) {
        try {
            validationNom(nom);
        } catch (FormValidationException e) {
            setErreur( CHAMP_NOM, e.getMessage());
        }
        station.setNom(nom);
    }
    private void traiterAdresse(String adresse, Station station) {
        try {
            validationAdresse(adresse);
        } catch (FormValidationException e) {
            setErreur( CHAMP_ADRESSE, e.getMessage());
        }
        station.setAdresse(adresse);
    }
    private void traiterVille(String ville, Station station) {
        try {
            validationVille(ville);
        } catch (FormValidationException e) {
            setErreur( CHAMP_VILLE, e.getMessage());
        }
        station.setVille(ville);
    }
    private void traiterCodePostal(String codepostal, Station station) {
        try {
            validationCodePostal(codepostal);
        } catch (FormValidationException e) {
            setErreur( CHAMP_CODEPOSTAL, e.getMessage());
        }
        station.setCodePostal(codepostal);
    }
    private void traiterNbPlaces(String nbplaces, Station station) {
        try {
            validationNbPlaces(nbplaces);
        } catch (FormValidationException e) {
            setErreur( CHAMP_NBPLACES, e.getMessage());
        }
        station.setNbPlaces(nbplaces);
    }

    private void validationNom(String nom) throws FormValidationException {
        if (nom != null && nom.length() < 3) {
            throw new FormValidationException( "Le nom de la station doit contenir au moins 3 caractères." );
        }
    }
    private void validationAdresse(String adresse) throws FormValidationException {
        if (adresse != null && adresse.length() < 3) {
            throw new FormValidationException( "L'adresse de la station doit contenir au moins 3 caractères." );
        }
    }
    private void validationVille(String ville) throws FormValidationException {
        if (ville != null && ville.length() < 2) {
            throw new FormValidationException( "La ville de la station doit contenir au moins 3 caractères." );
        }
    } 
    private void validationCodePostal(String codepostal) throws FormValidationException {
        if (codepostal != null && (codepostal.length() < 4 || codepostal.length() > 5) ) {
            throw new FormValidationException( "Le code postal de la station doit contenir entre 4 et 5 caractères." );
        }
    }
    private void validationNbPlaces(String nbplaces) throws FormValidationException {
        if (nbplaces != null && nbplaces.length() > 2) {
            throw new FormValidationException( "Le nombre de places de la station doit contenir entre 1 et 2 caractères." );
        }
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }
}
