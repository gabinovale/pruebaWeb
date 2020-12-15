package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.TipoDeAtraccion;
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

}
