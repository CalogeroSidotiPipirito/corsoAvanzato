package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CreateDAO;
import DAO.DeleteDAO;
import DAO.ReadDAO;
import DAO.UpdateDAO;
import model.Artista;

/**
 * Servlet implementation class CreateArtistServlet
 */
@WebServlet("/CRUDArtist")
public class CRUDArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDArtistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String scelta = request.getParameter("scelta");
		Artista a = new Artista();

		

		if (scelta.equals("aggiungiArtista")) {

			String nomeArtista = request.getParameter("nomeArtista");

			a.setNome(nomeArtista);

			
			try {
				CreateDAO.insert(a);
				request.setAttribute("messaggio", "Artista inserito in DB con successo");
				request.getServletContext().getRequestDispatcher("/esitoOperazioneDB.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if(scelta.equals("selezionaArtista")) {
			
			String idTemp = request.getParameter("IDArtista");
			int idArtista = Integer.parseInt(idTemp);
			
			
			a.setArtistaID(idArtista);
			
			try {
				ReadDAO.getByCode(a.getArtistaID());
				request.setAttribute("messaggio", "ID artista: " + a.getArtistaID() + "/t" + "Nome artista: " + a.getNome());
				request.getServletContext().getRequestDispatcher("/esitoOperazioneDB.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else if(scelta.equals("modificaArtista")) {
			
			String nomeArtista = request.getParameter("nomeArtista");
			String idTemp = request.getParameter("IDArtista");
			int idArtista = Integer.parseInt(idTemp);
			
			a.setArtistaID(idArtista);
			a.setNome(nomeArtista);
			
			try {
				UpdateDAO.update(a);
				request.setAttribute("messaggio", "Artista modificato con successo");
				request.getServletContext().getRequestDispatcher("/esitoOperazioneDB.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(scelta.equals("eliminaArtista")) {
			
			String idTemp = request.getParameter("IDArtista");
			int idArtista = Integer.parseInt(idTemp);
			
			a.setArtistaID(idArtista);
			
			
			try {
				DeleteDAO.delete(idArtista);
				request.setAttribute("messaggio", "Artista eliminato dal DB con successo");
				request.getServletContext().getRequestDispatcher("/esitoOperazioneDB.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
