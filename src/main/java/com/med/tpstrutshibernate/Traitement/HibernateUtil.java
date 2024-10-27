package com.med.tpstrutshibernate.Traitement;  // Ensure the package name follows Java naming conventions (lowercase)

import com.med.tpstrutshibernate.hibernate.Professeur;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;  // SessionFactory for managing sessions
    public static final ThreadLocal<Session> session = new ThreadLocal<>();  // Thread-local session management

    static {
        try {
            // Load hibernate.cfg.xml from the classpath
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception and throw a RuntimeException for better error handling
            throw new RuntimeException("Problem with Hibernate configuration: " + ex.getMessage(), ex);
        }
    }

    // Returns the current session, creates a new one if it does not exist
    public static Session currentSession() throws HibernateException {
        Session s = session.get();

        // Open a new session if this thread has none
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }

        return s;  // Return the current session
    }

    // Closes the session and removes it from the ThreadLocal
    public static void closeSession() throws HibernateException {
        Session s = session.get();
        session.set(null);  // Clear the ThreadLocal

        if (s != null) {
            s.close();  // Close the session if it exists
        }
    }
}
