<%@ page language="java" import="beans.UserinputForm" contentType="text/html;
charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Confirmation de l'ajout de l'utilisateur </title>
</head>
<body>
<%
  UserinputForm utilisateur= (UserinputForm) session.getAttribute("user");
%>
Nom : <%=utilisateur.getNom() %><br/>
Prenom :<%=utilisateur.getPrenom() %><br/>
Email : <%=utilisateur.getEmail() %>
<html:button property="add"
             onclick="location.href='afficherProfesseurs.do'">Afficher la liste des
  professeurs
</html:button>
</body>
</html>

