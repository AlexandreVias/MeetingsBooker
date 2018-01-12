package com.test.dao;

import java.util.ArrayList;

import com.test.beans.Lieu;


public interface LieuDao {

    void creer( Lieu Lieu ) throws DAOException;

    Lieu trouver( String nom ) throws DAOException;
    
    ArrayList<Lieu> trouverTous() throws DAOException;


}