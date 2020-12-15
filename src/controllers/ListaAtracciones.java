package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.AtraccionDao;
import dao.UsuarioDao;
import model.Atraccion;
import model.Usuario;

/**
 * Servlet implementation class ListaAtracciones
 */
@WebServlet("/admin-atracciones")
public class ListaAtracciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AtraccionDao atraccionDao;

	public void init() {
		atraccionDao = new AtraccionDao();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		try {
			List<Atraccion> atracciones = atraccionDao.all();
			request.setAttribute("atracciones", atracciones);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/new-atraccion.jsp");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
