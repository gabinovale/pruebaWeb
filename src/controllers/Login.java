package controllers;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.UsuarioDao;
import model.Usuario;
import util.HibernateUtil;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private UsuarioDao usuarioDao;

	public void init() {
		usuarioDao = new UsuarioDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8080/HolaMundo/login

		String username = request.getParameter("username");
		String password = request.getParameter("password");


		if (usuarioDao.validate(username, password)) {
			request.getSession().setAttribute("currentUser", username);
			request.getSession().setAttribute("isAdmin", usuarioDao.isAdmin(username));
			request.getSession().setAttribute("actual", usuarioDao.actual(username));
			if (usuarioDao.isAdmin(username).equals("true")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-saludo");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/saludo");
				dispatcher.forward(request, response);
			}

		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
