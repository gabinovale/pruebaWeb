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

import dao.CompraDao;
import dao.ItinerarioDao;
import model.Compra;
import model.Usuario;

/**
 * Servlet implementation class ListaItinerarios
 */
@WebServlet("/listaItinerarios")
public class ListaItinerarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ItinerarioDao itinerarioDao;
	private CompraDao compraDao;

	public void init() {
		itinerarioDao = new ItinerarioDao();
		compraDao = new CompraDao();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		try {
			
			Usuario user = (Usuario) request.getSession().getAttribute("actual");
			//List<Itinerario> itinerarios = itinerarioDao.allByUser(user);
			//List<Itinerario> itinerarios = itinerarioDao.all();
			List<Compra> compras = compraDao.allByUser(user);
			request.setAttribute("compras", compras);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/usuarios/lista-itinerarios.jsp");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
}
