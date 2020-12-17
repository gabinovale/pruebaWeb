package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Atraccion;
import model.Compra;
import model.Itinerario;
import model.Usuario;
import util.HibernateUtil;

public class CompraDao {
	
	public boolean create(Compra compra) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			int lastId = (int) session.createQuery("select max(C.id) from Compra C").uniqueResult();
			compra.setId(++lastId);
			
			session.save(compra);
		    session.getTransaction().commit();
			return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public List<Compra> all() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (List<Compra>) session.createQuery("from Compra C").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
	
	public Compra findById(int id) {
		Compra compra = new Compra();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	compra = (Compra) session
            		.createQuery("FROM Compra C WHERE C.id = :id")
            		.setParameter("id", id)
            		.uniqueResult();

            return compra;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return compra;
	}
	
	public List<Compra> allByUser(Usuario user) {
		List<Compra> retorna = Collections.EMPTY_LIST;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	//WHERE I.usuario_id = :id" ).setParameter("id", user.getId()
        	retorna = (List<Compra>) session.createQuery("from Compra C WHERE C.usuario = :usuario")
            		.setParameter("usuario", user).getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorna;
    }


}
