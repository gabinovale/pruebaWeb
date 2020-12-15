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

import dao.TipoDeAtraccionDao;
import model.TipoDeAtraccion;

/**
 * Servlet implementation class TiposDeAtraccionesServlet
 */
@WebServlet("/tipo-de-atracciones")
public class TiposDeAtraccionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TipoDeAtraccionDao tipoDeAtraccionDao;

	public void init() {
		tipoDeAtraccionDao = new TipoDeAtraccionDao();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		try {
			List<TipoDeAtraccion> tipoDeAtracciones = tipoDeAtraccionDao.all();
			request.setAttribute("tiposDeAtraccion", tipoDeAtracciones);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/new-tipo-atraccion.jsp");
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
