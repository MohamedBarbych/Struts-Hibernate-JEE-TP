package com.med.tpstrutshibernate.beans;

import com.med.tpstrutshibernate.hibernate.Professeur;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class AfficherListeProfesseursForm extends ActionForm {
    private String adresse;
    private String nom;
    private String prenom;
    private String idProfesseur;
    public String getIdProfesseur() {
        return idProfesseur;}
    public void setIdProfesseur(String idProfesseur) {
        this.idProfesseur = idProfesseur;
    }
    public String getAdresse() {
        return this.adresse;
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    private Professeur[] professeurs = new Professeur[0];
    public Professeur[] getListProfesseurs() {
        return professeurs;
    }
    public void setProfesseurs(Professeur[] professeurs) {
        this.professeurs = professeurs;
    }
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {
// TODO Auto-generated method stub
        return null;
    }
    public void reset(ActionMapping mapping, HttpServletRequest request) {
// TODO Auto-generated method stub
        professeurs = new Professeur[0];
    }
}