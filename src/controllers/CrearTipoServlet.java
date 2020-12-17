package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.TipoDeAtraccionDao;
import dao.TipoDeAtraccionDao;
import model.Atraccion;
import model.TipoDeAtraccion;


@WebServlet("/admin-nuevoTipo")
public class CrearTipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TipoDeAtraccionDao tipoDeAtraccionDao;

	public void init() {
		tipoDeAtraccionDao = new TipoDeAtraccionDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String descripcion = request.getParameter("descripcion");
			
			TipoDeAtraccion tipo = new TipoDeAtraccion();
			tipo.setDescripcion(descripcion);
			

			tipoDeAtraccionDao.create(tipo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/tipo-de-atracciones");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
