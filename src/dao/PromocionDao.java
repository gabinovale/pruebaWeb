package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Promocion;
import util.HibernateUtil;

public class PromocionDao {
	
	public List<Promocion> all() {
		List<Promocion> retorna = Collections.EMPTY_LIST;
		
        try {
        	Session session =  HibernateUtil.getSessionFactory().openSession();
        	
            retorna = (List<Promocion>) session.createQuery("from Promocion P").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	
			
        }
        return retorna;
    }

}
