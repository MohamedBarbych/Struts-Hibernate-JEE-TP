package com.med.tpstrutshibernate.Traitement;

import com.med.tpstrutshibernate.hibernate.Professeur;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException; // Correct import for exceptions
import org.hibernate.Session; // Correct import for Session
import org.hibernate.Transaction; // Correct import for Transaction
import org.hibernate.query.Query; // Import for using Hibernate Query

public class MetierProfesseurs {
    private Session session;
    private Logger log;

    public MetierProfesseurs() {}

    public Professeur[] getAllProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        Transaction tx = null;
        session = HibernateUtil.currentSession();
        try {
            tx = session.beginTransaction();
            Query<Professeur> query = session.createQuery("FROM Professeur", Professeur.class);
            List<Professeur> tmpprofesseurs = query.list();

            for (Professeur per : tmpprofesseurs) {
                professeurs.add(per);
                System.out.println("Nom: " + per.getNom() + " Prenom: " + per.getPrenom() + " Adresse: " + per.getAdresse());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback(); // Rollback transaction in case of error
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }

        return professeurs.toArray(new Professeur[0]);
    }

    // Suppression d'un enregistrement
    public void SupprimerProfesseur(Integer id) {
        Transaction tx = null;
        session = HibernateUtil.currentSession();
        try {
            if (existe(id)) {
                tx = session.beginTransaction();
                Professeur u = session.get(Professeur.class, id);
                if (u != null) {
                    session.delete(u);
                }
                tx.commit();
            } else {
                System.out.println("Professeur Absent !");
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback(); // Rollback transaction in case of error
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public boolean existe(Integer id) {
        boolean exist = false;
        session = HibernateUtil.currentSession();
        List<Professeur> professeurs = session.createQuery("FROM Professeur", Professeur.class).list();

        for (Professeur prof : professeurs) {
            if (prof.getId().equals(id)) {
                exist = true;
                break; // No need to continue the loop
            }
        }
        return exist;
    }

    protected void setUp() throws Exception {
        session = HibernateUtil.currentSession();
        log = Logger.getLogger(this.getClass().getName());
    }

    protected void tearDown() throws Exception {
        HibernateUtil.closeSession();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
