package com.test.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.Station;
import com.test.dao.DAOFactory;
import com.test.dao.StationDao;
/*import com.test.forms.InscriptionForm;*/
import com.test.forms.StationForm;

public class AjoutStation extends HttpServlet {

    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String ATT_STAT         = "station";
    public static final String ATT_FORM         = "form";
    public static final String VUE              = "/ajoutStation.jsp";
    private StationDao stationDAO;

    public void init() throws ServletException {
        this.stationDAO = ((DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getStationDao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StationForm form = new StationForm(stationDAO);
        Station station= form.creerStation(request);
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_STAT, station);
        this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
    }
}
