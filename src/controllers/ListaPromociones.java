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

import dao.PromocionDao;
import model.Promocion;

/**
 * Servlet implementation class ListaPromociones
 */
@WebServlet("/promociones")
public class ListaPromociones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PromocionDao promocionDao;

	public void init() {
		promocionDao = new PromocionDao();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		try {
			List<Promocion> promociones = promocionDao.all();
			request.setAttribute("promociones", promociones);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/new-promocion.jsp");
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
