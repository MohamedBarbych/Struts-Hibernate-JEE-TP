package com.med.tpstrutshibernate.beans;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
public class UserinputForm extends ActionForm{
    private String nom;
    private String prenom;
    private String email;
    public UserinputForm()
    {}
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (this.getNom() == null || this.getNom().length() < 1) {
            errors.add("nomVide", new ActionMessage("erreur.nom.vide"));
        }
        if (this.getPrenom() == null || this.getPrenom().length() < 1) {
            errors.add("prenomVide", new ActionMessage("erreur.prenom.vide"));
        }
        if (this.getEmail() == null || this.getEmail().length() < 1) {
            errors.add("emailVide", new
                    ActionMessage("erreur.email.vide"));
        }
        return errors;
    }
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.nom="";
        this.prenom="";
        this.email="";
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}