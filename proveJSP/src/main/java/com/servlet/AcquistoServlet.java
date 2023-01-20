package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseAccessObject_DAO.ArticoloDAO;
import model.Articolo;

/**
 * Servlet implementation class AcquistoServlet
 */
@WebServlet("/acquisto")
public class AcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcquistoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String scelta = request.getParameter("scelta");
		ArticoloDAO aDao = new ArticoloDAO();
		
		
        	
		if (scelta.equals("modificaDescrizione")) {

			String descrizioneArticolo = request.getParameter("descrizioneArticolo");
			String idTemp = request.getParameter("idArticolo");
			int idArticolo = Integer.parseInt(idTemp);

			Articolo a = new Articolo();
			a.setDescrizione(descrizioneArticolo);
			a.setCodice(idArticolo);

			try {
				aDao.update(a);
				request.setAttribute("idArticolo", a.getCodice());
				request.setAttribute("descrizioneArticolo", a.getDescrizione());
				request.getServletContext().getRequestDispatcher("/paginaRisposta.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
