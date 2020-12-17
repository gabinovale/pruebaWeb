package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.AtraccionDao;
import dao.CompraDao;
import dao.ItinerarioDao;
import dao.UsuarioDao;
import model.Atraccion;
import model.Compra;
import model.Usuario;

/**
 * Servlet implementation class NuevaCompra
 */
@WebServlet("/nuevaCompra")
public class NuevaCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ItinerarioDao itinerarioDao;
	private CompraDao compraDao;
	private UsuarioDao usuarioDao;
	private AtraccionDao atraccionDao;

	public void init() {
		itinerarioDao = new ItinerarioDao();
		compraDao = new CompraDao();
		usuarioDao = new UsuarioDao();
		atraccionDao = new AtraccionDao();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			
			int atraccionId = Integer.parseInt(request.getParameter("prodId"));
			
			
			Atraccion atraccion = atraccionDao.findById(atraccionId);
			
			atraccion.setCupo(atraccion.getCupo()-1);
			
			atraccionDao.update(atraccion);
						
			Usuario user = (Usuario) request.getSession().getAttribute("actual");
			
			user.setPresupuesto(user.getPresupuesto()-atraccion.getCosto());
			user.setTiempo(user.getTiempo()-atraccion.getTiempo());
			
			usuarioDao.update(user);
			
			Compra compra = new Compra();
			
			compra.setUsuario(user);
			compra.setAtraccion(atraccion);
			
			compraDao.create(compra);
			
//			List<Atraccion> atracciones = new LinkedList<>();
//			atracciones.add(atraccion);
			
//			Itinerario itinerario = new Itinerario();
//			itinerario.setUsuario(user);
//			itinerario.setCostoTotal(atraccion.getCosto());
//			itinerario.setTiempoTotal(atraccion.getTiempo());
//			itinerario.setAtracciones(atracciones);
//
//			itinerarioDao.create(itinerario);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/comprar");
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
