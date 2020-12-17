package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Atraccion;
import model.TipoDeAtraccion;
import model.Usuario;
import util.HibernateUtil;

public class AtraccionDao {
	
	public boolean create(Atraccion atraccion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			int lastId = (int) session.createQuery("select max(a.id) from Atraccion a").uniqueResult();
			atraccion.setId(++lastId);
			
			session.save(atraccion);
		    session.getTransaction().commit();
			return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public boolean update(Atraccion atraccion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			
			
			session.saveOrUpdate(atraccion);
		    session.getTransaction().commit();
			return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public List<Atraccion> all() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (List<Atraccion>) session.createQuery("from Atraccion A").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
	
	public Atraccion findById(int id) {
		Atraccion atraccion = new Atraccion();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	atraccion = (Atraccion) session
            		.createQuery("FROM Atraccion A WHERE A.id = :id")
            		.setParameter("id", id)
            		.uniqueResult();

            return atraccion;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atraccion;
	}


}
