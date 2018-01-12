package com.test.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.Lieu;
import com.test.dao.DAOFactory;
import com.test.dao.LieuDao;
import com.test.forms.AjoutLieuForm;

public class AjoutLieu extends HttpServlet {

    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String ATT_USER         = "lieu";
    public static final String ATT_FORM         = "form";
    public static final String VUE              = "/AjoutLieu.jsp";
    private LieuDao     lieuDao;


    public void init() throws ServletException {

        this.lieuDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getLieuDao();
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        AjoutLieuForm form = new AjoutLieuForm( lieuDao );

        Lieu lieu = form.AjouterLieu( request );

        request.setAttribute( ATT_FORM, form );

        request.setAttribute( ATT_USER, lieu );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}


