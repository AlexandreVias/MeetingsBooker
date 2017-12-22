package com.test.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.test.beans.Lieu;
import com.test.beans.Utilisateur;

import com.test.dao.DAOFactory;
import com.test.dao.LieuDao;
import com.test.dao.UtilisateurDao;


public class ListeLieux extends HttpServlet {

    public static final String CONF_DAO_FACTORY = "daofactory";

    public static final String ATT_LISTLieux         = "listelieux";

    public static final String VUE              = "/listelieux.jsp";


    private LieuDao     lieuDao;


    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Lieu */

        this.lieuDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getLieuDao();

    }


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

       
    	ArrayList<Lieu> listelieux = lieuDao.trouverTous();
    	request.setAttribute( ATT_LISTLieux, listelieux );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

}