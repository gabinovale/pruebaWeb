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
import dao.UsuarioDao;
import model.TipoDeAtraccion;
import model.Usuario;

@WebServlet("/admin-lista-usuarios")
public class UsuariosListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao;
	private TipoDeAtraccionDao tipoDeAtraccionDao;

	public void init() {
		usuarioDao = new UsuarioDao();
		tipoDeAtraccionDao = new TipoDeAtraccionDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Usuario> usuarios = usuarioDao.all();
			request.setAttribute("usuarios", usuarios);
			
			List<TipoDeAtraccion> tiposDeAtracciones = tipoDeAtraccionDao.all();
			request.setAttribute("tiposDeAtraccion", tiposDeAtracciones);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/new-user.jsp");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
