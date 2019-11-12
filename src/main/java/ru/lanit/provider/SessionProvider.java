package ru.lanit.provider;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Logger;

public class SessionProvider {
    private static SessionProvider instance;
    private SessionFactory sessionFactory;
    private static Logger log = Logger.getLogger(SessionProvider.class.getName());

    private SessionProvider() {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (HibernateException e) {
            log.warning(e.getMessage());
        }
    }

    public static SessionProvider getInstance() {
        if (instance == null) {
            instance = new SessionProvider();
        }
        return instance;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
