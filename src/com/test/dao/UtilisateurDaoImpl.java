package com.test.dao;

import static com.test.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.test.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

    private static final String SQL_SELECT_PAR_ID = "SELECT id, motdepasse FROM Utilisateur WHERE login = ?";
    private static final String SQL_SELECT = "SELECT id, motdepasse FROM Utilisateur";
    private static final String SQL_INSERT = "INSERT INTO Utilisateur (motdepasse) VALUES (?)";

    private DAOFactory daoFactory;

    UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Utilisateur trouver( String login ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, login );
    }
    
    @Override
    public ArrayList<Utilisateur> trouverTous() throws DAOException {
    	  	return trouverTous( SQL_SELECT);
    }

    @Override
    public void creer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getLogin(), utilisateur.getMotDePasse());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Echec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                utilisateur.setLogin( valeursAutoGenerees.getString( 1 ) );
            } else {
                throw new DAOException( "Echec de la création de l'utilisateur en base, aucun login auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    private Utilisateur trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return utilisateur;
    }

    private ArrayList<Utilisateur> trouverTous( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;
        ArrayList<Utilisateur> listeutilisateurs=new ArrayList<Utilisateur>();

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                utilisateur = map( resultSet );
                System.out.println("login:"+ utilisateur.getLogin());
                listeutilisateurs.add(utilisateur);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return listeutilisateurs;
    }

    private static Utilisateur map( ResultSet resultSet ) throws SQLException {
        Utilisateur utilisateur = new Utilisateur(resultSet.getString("login"), resultSet.getString("motdepasse"));
        return utilisateur;
    }

}
