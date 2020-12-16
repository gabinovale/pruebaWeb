package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Atraccion;
import util.HibernateUtil;

public class AtraccionDao {
	
	public List<Atraccion> all() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (List<Atraccion>) session.createQuery("from Atraccion A").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }


}
