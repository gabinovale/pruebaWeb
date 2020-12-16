package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.TipoDeAtraccion;
import model.Usuario;
import util.HibernateUtil;

public class TipoDeAtraccionDao {
	
	public List<TipoDeAtraccion> all() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (List<TipoDeAtraccion>) session.createQuery("from TipoDeAtraccion ta").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
	
	public TipoDeAtraccion findIdByName(String name) {
		TipoDeAtraccion tipo = new TipoDeAtraccion();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tipo = (TipoDeAtraccion) session
            		.createQuery("FROM TipoDeAtraccion T WHERE T.descripcion = :name")
            		.setParameter("name", name)
            		.uniqueResult();

            return tipo;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipo;
	}

}
