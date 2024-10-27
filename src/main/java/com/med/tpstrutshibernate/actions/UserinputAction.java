package com.med.tpstrutshibernate.actions;

import com.med.tpstrutshibernate.hibernate.Professeur;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.med.tpstrutshibernate.Traitement.TestMain;
import com.med.tpstrutshibernate.beans.UserinputForm;
public class UserinputAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse
                                         response) {
        UserinputForm userinputForm = (UserinputForm) form;
        System.out.println(userinputForm.getNom());
        System.out.println(userinputForm.getPrenom());
        System.out.println(userinputForm.getEmail());
        HttpSession session = request.getSession(true);
        com.med.tpstrutshibernate.Traitement.TestMain test = new TestMain();
        Professeur prof = new Professeur();
        prof.setNom(userinputForm.getNom());
        prof.setPrenom(userinputForm.getPrenom());
        prof.setAdresse(userinputForm.getEmail());
        test.AjouterProfesseur(prof);
        session.setAttribute("user", userinputForm);
        return mapping.findForward("succes");
    }
}