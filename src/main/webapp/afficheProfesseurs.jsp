<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"
%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"
%>
<%
  String path = request.getContextPath();
  String basePath =
          request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort
                  ()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <style>.TabCommon {FONT: 12px Verdana; COLOR: #6D6D6D; PADDING: 1px; FONT-
  WEIGHT: bold; TEXT-ALIGN: center; HEIGHT: 15px; WIDTH: 120px;}
  .TabContent {PADDING: 5px;}
  .TabContentBottom {PADDING: 1px; BORDER-BOTTOM: 1px outset #99ccff;}
  .TabOff {CURSOR: hand; BACKGROUND-COLOR: #E2E2E3; BORDER-LEFT: 1px
  solid #BBBBBB;}
  .TabOn {CURSOR: default; BORDER-TOP: 1px outset #D1D1D1; COLOR:
          #000000;}
  .TabBorderBottom{BORDER-BOTTOM: 1px inset #D1D1D1;}
  .TabActiveBorderLeftRight{BORDER-RIGHT: 1px outset #D1D1D1; BORDER-
  LEFT: 1px outset #D1D1D1;}
  .TabActiveBackground {BACKGROUND-COLOR: #F7F8F3;}
  </style>
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1"" />
  <title>Gestion de l'Ecole</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <link href="<html:rewrite page='/form/default.css'/>" rel="stylesheet"
        type="text/css"/>
  <style type="text/css">
    <!--
    .Style11 {font-weight: bold}
    .Style20 {font-size: 14px; font-family: "Times New Roman", Times, serif;
      font-weight: bold; }
    -->
  </style>
</head>
<body>
<center>
  <div id="header">
    <h1>Liste des Professeurs</h1>
  </div>
</center>
<!-- end #header -->
<center>
</center>
<center>
  <table border="1">
    <tbody>
    <%-- set the header --%>
    <tr>
      <td><span class="Style20">Identifiant Professeur <br>
</span></td>
      <td><span class="Style20">Nom<br>
</span></td>
      <td><span class="Style20">Prénom<br>
</span></td>
      <td><span class="Style20">Adresse<br>
</span></td>
      <td><span class="Style20">Supprimer<br>
</span></td>
    </tr><logic:iterate name="listeProfesseursForm" property="listProfesseurs"
                        id="listeProfesseur">
      <tr>
        <td><span class="Style20"><bean:write name="listeProfesseur" property="id"
        /></span></td>
        <td><span class="Style20"><bean:write name="listeProfesseur" property="nom"
        /></span></td>
        <td><span class="Style20"><bean:write name="listeProfesseur"
                                              property="prenom" /></span></td>
        <td><span class="Style20"><bean:write name="listeProfesseur"
                                              property="adresse" /></span></td>
        <td><html:link action="professeurEdit.do?do=deleteProfesseur"
                       paramName="listeProfesseur" paramProperty="id" paramId="id"><span
                class="Style20">Supprimer</span></html:link></td>
      </tr>
    </logic:iterate>
    <logic:notPresent name="listeProfesseursForm">
      <tr>
        <td colspan="5">La Liste des Professeurs est Vide .</td>
      </tr>
    </logic:notPresent>
    </tbody>
  </table>
</center>
<center><div>
  <br>
  <%-- add and back to menu button --%>
  <html:button property="add"
               onclick="location.href='userinput.do'">Ajouter Professeur dans la liste
  </html:button>
  &nbsp;
</div>
</center>
<div style="clear: both;">&nbsp;</div>
<!-- end #content -->
<div id="footer">
  <p id="legal"></p>
</div>
</body>
</html>