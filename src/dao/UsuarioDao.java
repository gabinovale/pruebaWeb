package dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import model.Usuario;
import util.HibernateUtil;

public class UsuarioDao {

	public boolean validate(String username, String password) {

        Usuario user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = (Usuario) session
            		.createQuery("FROM Usuario U WHERE U.username = :username")
            		.setParameter("username", username)
            		.uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public boolean create(Usuario usuario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			int lastId = (int) session.createQuery("select max(u.id) from Usuario u").uniqueResult();
			usuario.setId(++lastId);
			
			session.save(usuario);
		    session.getTransaction().commit();
			return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public List<Usuario> all() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (List<Usuario>)
            		session.createQuery("from Usuario u")
            		.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
	
	public String isAdmin(String username) {
		Usuario user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = (Usuario) session
            		.createQuery("FROM Usuario U WHERE U.username = :username")
            		.setParameter("username", username)
            		.uniqueResult();

            if (user != null && user.getAdmin()==1) {
                return "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
	}
	
}
