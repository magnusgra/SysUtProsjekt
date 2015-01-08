<%-- 
    Document   : EndrePassord
    Created on : Jan 8, 2015, 10:50:33 AM
    Author     : Kai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" media="screen" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
   
        <div id="login">
            <div id="triangle"></div>
            <h1>Endre passord</h1>
            <form:form method="POST" modelAttribute="brukerService" action="EndrePassord">
                <form:input type= "password" placeholder="Gammelt passord" path="brukerdata.passord" /><br>
                <form:input type= "password" placeholder="Nytt passord" path="brukerdata.passord" /><br>
                <form:input type= "password" placeholder="Bekreft nytt passord" path="brukerdata.passord" /><br>
                <input type="submit" value="Endre" />
                <br>
                <br>
            </form:form>
            </div>
        
        <script src='<c:url value="http://codepen.io/assets/libs/fullpage/jquery.js" />'></script>

    </body>
</html>
