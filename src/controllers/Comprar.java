package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.AtraccionDao;
import dao.CompraDao;
import dao.PromocionDao;
import dao.TipoDeAtraccionDao;
import model.Atraccion;
import model.Compra;
import model.CostoComparatorAtraccion;
import model.CostoComparatorPromocion;
import model.Promocion;
import model.TiempoComparatorAtraccion;
import model.TiempoComparatorPromocion;
import model.Usuario;

/**
 * Servlet implementation class Comprar
 */
@WebServlet("/comprar")
public class Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtraccionDao atraccionDao;
	private TipoDeAtraccionDao tipoDeAtraccionDao;
	private PromocionDao promocionDao;
	private CompraDao compraDao;

	public void init() {
		atraccionDao = new AtraccionDao();
		promocionDao = new PromocionDao();
		tipoDeAtraccionDao = new TipoDeAtraccionDao();
		compraDao = new CompraDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Usuario user = (Usuario) request.getSession().getAttribute("actual");
			
			List<Atraccion> atraccionesCompradas = new LinkedList<Atraccion>();

			List<Compra> oldCompras= compraDao.allByUser(user);


			for(Compra c : oldCompras) {
				atraccionesCompradas.add(c.getAtraccion());
			}

			List<Promocion> promociones = promocionDao.all();
			List<Promocion> promocionesPreferentes = new LinkedList<Promocion>();
			List<Promocion> otrasPromociones = new LinkedList<Promocion>();

			for (Promocion p : promociones) {
				
				int flag = 0;
				for (Atraccion a : p.getAtracciones()) {
					
					for (Atraccion ac : atraccionesCompradas) {
						
						if (ac.getNombre().equals(a.getNombre())){
							
							flag=1;
						}
					}
					
				}
				if (flag == 0) {
					if(p.getCosto()<=user.getPresupuesto() && p.getTiempo()<=user.getTiempo() && p.getDisponible()==0) {
						if (p.getTipoAtraccion().getDescripcion().equals(user.getPreferencia().getDescripcion())) 
							promocionesPreferentes.add(p);
						else
							otrasPromociones.add(p);

					}
				}
			}


			Collections.sort(promocionesPreferentes, new TiempoComparatorPromocion());
			Collections.sort(promocionesPreferentes, new CostoComparatorPromocion());

			Collections.sort(otrasPromociones, new TiempoComparatorPromocion());
			Collections.sort(otrasPromociones, new CostoComparatorPromocion());


			request.setAttribute("promocionesPreferentes", promocionesPreferentes);
			request.setAttribute("otrasPromociones", otrasPromociones);

			List<Atraccion> atracciones = atraccionDao.all();

			

			//atracciones.removeAll(atraccionesCompradas);


			List<Atraccion> atraccionesPreferentes = new LinkedList<Atraccion>();
			List<Atraccion> otrasAtracciones = new LinkedList<Atraccion>();

			for (Atraccion a : atracciones) {
				int flag = 0;
				for (Atraccion ac : atraccionesCompradas) {

					if (ac.getNombre().equals(a.getNombre())){
						flag=1;
					}
				}
				if (flag == 0) {
					if(a.getCosto()<=user.getPresupuesto() && a.getTiempo()<=user.getTiempo()) {
						if (a.getTipoAtraccion().getDescripcion().equals(user.getPreferencia().getDescripcion())) 
							atraccionesPreferentes.add(a);
						else
							otrasAtracciones.add(a);
					}


				}
			}
			Collections.sort(atraccionesPreferentes, new TiempoComparatorAtraccion());
			Collections.sort(atraccionesPreferentes, new CostoComparatorAtraccion());
			Collections.sort(otrasAtracciones, new TiempoComparatorAtraccion());
			Collections.sort(otrasAtracciones, new CostoComparatorAtraccion());

			request.setAttribute("atraccionesPreferentes", atraccionesPreferentes);
			request.setAttribute("otrasAtracciones", otrasAtracciones);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/usuarios/compra.jsp");
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
