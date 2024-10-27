package com.med.tpstrutshibernate.actions;

import jakarta.servlet.http.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.med.tpstrutshibernate.Traitement.MetierProfesseurs;
import com.med.tpstrutshibernate.beans.AfficherListeProfesseursForm;

public class AfficherListeProfesseurs extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        AfficherListeProfesseursForm listeProfesseursForm = (AfficherListeProfesseursForm) form;// TODO Auto-generated method stub
        MetierProfesseurs m = new MetierProfesseurs();
        listeProfesseursForm.setProfesseurs(m.getAllProfesseurs());
        return mapping.findForward("succes");
    }
}