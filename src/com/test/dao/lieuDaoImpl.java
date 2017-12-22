package com.test.dao;


//DAO

import static com.test.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.test.dao.DAOUtilitaire.initialisationRequetePreparee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.beans.Categorie;
import com.test.beans.Lieu;
import com.test.beans.Utilisateur;


public class lieuDaoImpl implements LieuDao {

private static final String SQL_SELECT_PAR_NOM = "SELECT numlieu, numcateg, login, nom, adresse, codepostal, ville, coordonneesgeo, descriptif, annulationgratuite, note FROM lieu";
private static final String SQL_SELECT = "SELECT numlieu, lieu.numcateg, libelle, lieu.login, motdepasse, nom, adresse, codepostal, ville, coordonneesgeo, descriptif, annulationgratuite, note FROM lieu, categorie, utilisateur WHERE lieu.numcateg=categorie.numcateg AND lieu.login = utilisateur.login";
private static final String SQL_INSERT           = "INSERT INTO lieu (numlieu, numcateg, login, nom, adresse, codepostal, ville, coordonneesgeo, descriptif, annulationgratuite, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

private DAOFactory          daoFactory;

lieuDaoImpl( DAOFactory daoFactory ) {
   this.daoFactory = daoFactory;
}




/* Implémentation de la méthode définie dans l'interface lieuDao */
@Override
public void creer( Lieu lieu ) throws DAOException {
   Connection connexion = null;
   PreparedStatement preparedStatement = null;
   ResultSet valeursAutoGenerees = null;

   try {
       connexion = daoFactory.getConnection();
       preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, lieu.getNumLieu(), lieu.getLaCateg(), lieu.getLeLoueur(), lieu.getNom(), lieu.getAdresse(), lieu.getVille(), lieu.getCodepostal(), lieu.getCoordonnees(), lieu.getDescriptif(), lieu.isAnnulationgratuite(), lieu.getNote() );
       int statut = preparedStatement.executeUpdate();
       if ( statut == 0 ) {
           throw new DAOException( "Échec de la création de la lieu, aucune ligne ajoutée dans la table." );
       }
       valeursAutoGenerees = preparedStatement.getGeneratedKeys();
       if ( valeursAutoGenerees.next() ) {
           lieu.setNumLieu( valeursAutoGenerees.getString( 1 ) );
       } else {
           throw new DAOException( "Échec de la création de la lieu en base, aucun ID auto-généré retourné." );
       }
   } catch ( SQLException e ) {
       throw new DAOException( e );
   } finally {
       fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
   }
}

/* Implémentation de la méthode définie dans l'interface lieuDao */
@Override
public Lieu trouver( String nom ) throws DAOException {
    return trouver( SQL_SELECT_PAR_NOM, nom );
}

public ArrayList<Lieu> trouverTous() throws DAOException {
  	return trouverTous( SQL_SELECT);
}


/*
* Méthode générique utilisée pour retourner un lieu depuis la base
* de données, correspondant à la requête SQL donnée prenant en paramètres
* les objets passés en argument.
*/
private Lieu trouver( String sql, Object... objets ) throws DAOException {
   Connection connexion = null;
   PreparedStatement preparedStatement = null;
   ResultSet resultSet = null;
   Lieu lieu = null;

   try {
       /* Récupération d'une connexion depuis la Factory */
       connexion = daoFactory.getConnection();
       preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
       resultSet = preparedStatement.executeQuery();
       /* Parcours de la ligne de données retournée dans le ResultSet */
       if ( resultSet.next() ) {
           lieu = map( resultSet );
       }
   } catch ( SQLException e ) {
       throw new DAOException( e );
   } finally {
       fermeturesSilencieuses( resultSet, preparedStatement, connexion );
   }

   return lieu;
}

private ArrayList<Lieu> trouverTous( String sql, Object... objets ) throws DAOException {
    Connection connexion = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Lieu lieu = null;
    ArrayList<Lieu> listelieux=new ArrayList<Lieu>();

    try {
        /* Récupération d'une connexion depuis la Factory */
        connexion = daoFactory.getConnection();
        /*
         * Préparation de la requête avec les objets passés en arguments
         * (ici, uniquement une adresse email) et exécution.
         */
        preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
        resultSet = preparedStatement.executeQuery();
        /* Parcours de la ligne de données retournée dans le ResultSet */
        while ( resultSet.next() ) {
        	
            lieu = map( resultSet );
            System.out.println("nom:"+ lieu.getNom());
            listelieux.add(lieu);
        }
    } catch ( SQLException e ) {
        throw new DAOException( e );
    } finally {
        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
    }

    return listelieux;
}



/*
* Simple méthode utilitaire permettant de faire la correspondance (le
* mapping) entre une ligne issue de la table des lieux (un
* ResultSet) et un bean lieu.
*/
private static Lieu map( ResultSet resultSet ) throws SQLException {
	Lieu lieu = new Lieu();
	lieu.setNumLieu( resultSet.getString( "numlieu" ) );
	lieu.setLaCateg(new Categorie(resultSet.getString("numCateg" ),resultSet.getString("libelle")));
	lieu.setLeLoueur(new Utilisateur(resultSet.getString( "login" ), resultSet.getString( "motdepasse" )) );
   lieu.setNom( resultSet.getString( "nom" ) );
   lieu.setAdresse( resultSet.getString( "adresse" ) );
   lieu.setVille( resultSet.getString( "ville" ) );
   lieu.setCodepostal( resultSet.getString( "codepostal" ) );
   lieu.setCoordonnees( resultSet.getString( "coordonnees" ) );
   lieu.setDescriptif( resultSet.getString( "descriptif" ) );
   lieu.setAnnulationgratuite( resultSet.getBoolean( "annulation" ) );
   lieu.setNote( resultSet.getInt( "note" ) );

   return lieu;
}

}