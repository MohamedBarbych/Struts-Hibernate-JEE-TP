<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<center>
    <div>
        <h:form action="/userinput">
            <table border="1">
                <tr>
                    <td><strong>Nom :</strong></td>
                    <td><h:text property="nom" /><h:errors
                            property="nomVide"/></td>
                </tr>
                <tr>
                    <td><strong>Prenom :</strong></td>
                    <td><h:text property="prenom" /><h:errors
                            property="prenomVide"/></td>
                </tr>
                <tr>
                    <td><strong>Email :</strong></td>
                    <td><h:text property="email" /><h:errors
                            property="emailVide"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><h:reset value="Effacer"/><h:submit
                            value="Ok"/></td>
                </tr>
            </table>
        </h:form>
    </div>
</center>
</body>
</html>