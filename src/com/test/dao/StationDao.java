package com.test.dao;

import java.util.ArrayList;

import com.test.beans.Station;
import com.test.beans.Utilisateur;

public interface StationDao {

    void creer( Station station ) throws DAOException;

    Station trouver( String nom ) throws DAOException;
    
    ArrayList<Station> trouverTous() throws DAOException;

}