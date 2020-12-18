package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Atraccion;
import model.Compra;
import model.Itinerario;
import model.Promocion;
import model.TipoDeAtraccion;
import model.TipoPromo;
import model.Usuario;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.sqlite.JDBC");
                settings.put(Environment.URL, "jdbc:sqlite:/Users/gabino/Documents/workspace/pruebaWeb/WebContent/db/TierraMedia.db");
                settings.put(Environment.DIALECT, "com.enigmabridge.hibernate.dialect.SQLiteDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);
                
                configuration.addAnnotatedClass(Usuario.class);
                configuration.addAnnotatedClass(Atraccion.class);
                configuration.addAnnotatedClass(TipoDeAtraccion.class);
                configuration.addAnnotatedClass(Promocion.class);
                configuration.addAnnotatedClass(TipoPromo.class);
                configuration.addAnnotatedClass(Itinerario.class);
                configuration.addAnnotatedClass(Compra.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}