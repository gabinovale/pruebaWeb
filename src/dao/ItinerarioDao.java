package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Itinerario;
import model.Usuario;
import util.HibernateUtil;

public class ItinerarioDao {
	
	public boolean create(Itinerario itinerario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			int lastId = (int) session.createQuery("select max(I.id) from Itinerario I").uniqueResult();
			itinerario.setId(++lastId);
			session.save(itinerario);
		    session.getTransaction().commit();
			return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public Itinerario findById(int id) {
		Itinerario itinerario = new Itinerario();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	itinerario = (Itinerario) session
            		.createQuery("FROM Itinerario I WHERE I.id = :id")
            		.setParameter("id", id)
            		.uniqueResult();

            return itinerario;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itinerario;
	}
	
	public List<Itinerario> all() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (List<Itinerario>) session.createQuery("from Itinerario I").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
	
	public List<Itinerario> allByUser(Usuario user) {
		List<Itinerario> retorna = Collections.EMPTY_LIST;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	//WHERE I.usuario_id = :id" ).setParameter("id", user.getId()
        	retorna = (List<Itinerario>) session.createQuery("from Itinerario I WHERE I.usuario = :usuario")
            		.setParameter("usuario", user).getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorna;
    }
}
