package com.med.tpstrutshibernate.base;

import com.med.tpstrutshibernate.hibernate.Professeur;
import java.io.Serializable;
public abstract class BaseProfesseur implements Serializable {
    public BaseProfesseur () {
        initialize();
    }
    public BaseProfesseur (Integer id) {
        this.setId(id);
        initialize();
    }
    protected void initialize () {}
    private int hashCode = Integer.MIN_VALUE;
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    public java.lang.Integer getId () {
        return id;
    }
    public void setId (java.lang.Integer id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }
    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof Professeur)) return false;
        else {
            Professeur prof = (Professeur) obj;
            if (null == this.getId() || null == prof.getId()) return false;
            else return (this.getId().equals(prof.getId()));
        }
    }
    public java.lang.String getAdresse() {
        return adresse;
    }
    public void setAdresse(java.lang.String adresse) {
        this.adresse = adresse;
    }
    public java.lang.String getNom() {
        return nom;
    }
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }
    public java.lang.String getPrenom() {
        return prenom;
    }
    public void setPrenom(java.lang.String prenom) {
        this.prenom = prenom;
    }
    public int hashCode () {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" +
                        this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }
    public String toString () {
        return super.toString();
    }
}