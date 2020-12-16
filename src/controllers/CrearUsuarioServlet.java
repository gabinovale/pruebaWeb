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
import dao.UsuarioDao;
import model.TipoDeAtraccion;
import model.Usuario;

@WebServlet("/admin-nuevoUsuario")
public class CrearUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao;

	public void init() {
		usuarioDao = new UsuarioDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int presupuesto = Integer.parseInt(request.getParameter("presupuesto"));
			double tiempo = Double.parseDouble(request.getParameter("tiempo"));
			String isAdmin = request.getParameter("is-admin");
			int intAdmin = 0;
//			if(isAdmin.equals("true")) {
//				intAdmin = 1;
//			}

			
			String preferencia = request.getParameter("preferencia");
			
			TipoDeAtraccionDao tipoDeAtraccionDao = new TipoDeAtraccionDao();
			TipoDeAtraccion tipo = tipoDeAtraccionDao.findIdByName(preferencia);

			Usuario usuario = new Usuario();
			
			usuario.setUsername(username);
			usuario.setPassword(password);
			usuario.setAdmin(intAdmin);
			usuario.setPresupuesto(presupuesto);
			usuario.setTiempo(tiempo);
			usuario.setPreferencia(tipo);

			usuarioDao.create(usuario);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-lista-usuarios");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
