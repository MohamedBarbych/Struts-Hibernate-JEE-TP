package com.med.tpstrutshibernate.Traitement;

import com.med.tpstrutshibernate.hibernate.Professeur;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestMain {
    private Session session = null;
    private List professeurs = new ArrayList();
    private Transaction tx = null;
    public TestMain(){}
    //Creation des enregistrements
    public void AjouterProfesseur(Professeur prof) {
        session = HibernateUtil.currentSession();
        tx = session.beginTransaction();
        session.save(prof);
        tx.commit();
        HibernateUtil.closeSession();
    }
    //Suppression d'un enregistrement
    public void SupprimerProfesseur(Integer id) {
        session = HibernateUtil.currentSession();
        if(existe(id)){
            tx = session.beginTransaction();
            Professeur u = (Professeur) session.get(Professeur.class, id);
            session.delete(u);
            tx.commit();
        }
        else{
            System.out.println("Professeur Absent !");
        }
        HibernateUtil.closeSession();
    }
    public boolean existe(Integer id){
        boolean exist = false;
        session = HibernateUtil.currentSession();
        List tmp = session.createQuery("from com.med.tpstrutshibernate.hibernate.Professeur").list();
        for (Iterator iter = tmp.iterator(); iter.hasNext();) {
            professeurs.add((Professeur) iter.next());
        }
        for (int i = 0; i < professeurs.size(); i++) {
            Professeur prof = (Professeur) professeurs.get(i);
            if(prof.getId().equals(id)){
                exist=true;}
        }
        return exist;
    }
    // Lecture des enregistrements
    public void AfficherProfesseurs() {
        session = HibernateUtil.currentSession();
        List tmp = session.createQuery("from com.med.tpstrutshibernate.hibernate.Professeur").list();
        for (Iterator iter = tmp.iterator(); iter.hasNext();) {
            professeurs.add((Professeur) iter.next());
        }
        for (int i = 0; i < professeurs.size(); i++) {
            Professeur usr = (Professeur) professeurs.get(i);
            System.out.println("Monsieur " + usr.getNom() + " "
                    + usr.getPrenom() + " reside actuellement a "
                    + usr.getAdresse());
        }
        HibernateUtil.closeSession();
    }
    // Modification d'un enregistrement
    public void ModifierProfesseur(Integer id, Professeur p) {
        session = HibernateUtil.currentSession();
        tx = session.beginTransaction();
        List tmp = session.createQuery("from com.med.tpstrutshibernate.hibernate.Professeur").list();
        Professeur prof = (Professeur) session.get(Professeur.class, id);
        prof.setNom(p.getNom());
        prof.setPrenom(p.getPrenom());
        prof.setAdresse(p.getAdresse());
        session.save(prof);
        tx.commit();
        HibernateUtil.closeSession();
    }
    public static void main(String[] args) {
        TestMain test = new TestMain();
        MetierProfesseurs m = new MetierProfesseurs();
        m.getAllProfesseurs();
    }
}