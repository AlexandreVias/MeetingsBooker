package com.test.dao;

import static com.test.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.test.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.beans.Station;
import com.test.beans.Utilisateur;

public class StationDaoImpl implements StationDao {

    private static final String SQL_SELECT_PAR_NOM = "SELECT id, nom, adresse, ville, codepostal, nbplaces FROM StationWHERE nom = ?";
    private static final String SQL_SELECT = "SELECT id, nom, adresse, ville, codepostal, nbplaces FROM Station";
    private static final String SQL_INSERT           = "INSERT INTO Station (nom, adresse, ville, codepostal, nbplaces) VALUES (?, ?, ?, ?, ?)";

    private DAOFactory          daoFactory;

    StationDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public Station trouver( String nom ) throws DAOException {
        return trouver( SQL_SELECT_PAR_NOM, nom );
    }
 
    public ArrayList<Station> trouverTous() throws DAOException {
    	  	return trouverTous( SQL_SELECT);
    }

    public void creer( Station station ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, station.getNom(), station.getAdresse(), station.getVille(), station.getCodePostal(), Integer.parseInt(station.getNbPlaces()));
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de la station, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                station.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de la station en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    private Station trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Station station = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                station = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return station;
    }

    private ArrayList<Station> trouverTous( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Station station = null;
        ArrayList<Station> listestations=new ArrayList<Station>();

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                station = map( resultSet );
                System.out.println("nom:"+ station.getNom());
                listestations.add(station);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return listestations;
    }

    private static Station map( ResultSet resultSet ) throws SQLException {
        Station station = new Station();
        station.setId( resultSet.getLong( "id" ) );
        station.setNom( resultSet.getString( "nom" ) );
        station.setAdresse( resultSet.getString( "adresse" ) );
        station.setVille( resultSet.getString( "ville" ) );
        station.setCodePostal( resultSet.getString( "codepostal" ) );
        station.setNbPlaces( resultSet.getString( "nbplaces" ) );
        return station;
    }
}
