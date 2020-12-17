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
import dao.AtraccionDao;
import model.Atraccion;
import model.TipoDeAtraccion;
import model.Usuario;

@WebServlet("/admin-nuevaAtraccion")
public class CrearAtraccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtraccionDao atraccionDao;

	public void init() {
		atraccionDao = new AtraccionDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			Integer costo = Integer.parseInt(request.getParameter("costo"));
			Double tiempo = Double.parseDouble(request.getParameter("tiempo"));
			Integer cupo = Integer.parseInt(request.getParameter("cupo"));
			
			Integer disponible = 0;
//			
			String tipo_de_atraccion_id = request.getParameter("tipo_de_atraccion_id");
					
			TipoDeAtraccionDao tipoDeAtraccionDao = new TipoDeAtraccionDao();
			TipoDeAtraccion tipo = tipoDeAtraccionDao.findIdByName(tipo_de_atraccion_id);

			Atraccion atraccion = new Atraccion();
			
			atraccion.setNombre(nombre);
			atraccion.setCosto(costo);
			atraccion.setTiempo(tiempo);
			atraccion.setCupo(cupo);
			atraccion.setTipoAtraccion(tipo);
			atraccion.setDisponible(disponible);
			

			atraccionDao.create(atraccion);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-atracciones");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
