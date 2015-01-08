<%-- 
    Document   : Startside
    Created on : 07.jan.2015, 10:04:27
    Author     : Mari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Startside</title>
        <link rel="stylesheet" href="../../stylesheet.css" type="text/css"/>
    </head>
    <body>
    <center>
        <h1>Velkommen (brukernavn)</h1>
<<<<<<< HEAD
        <form:form method="GET" modelAttribute="getUserBean"></form:form>
    
                <input class="button" type="button" value="Start nytt spill"/>
                <br>
                <br>
                <input class="button" type="button" value="Se highscore"/>
       </center>     
=======
        <c:set var="user" value="${getPersonBean}" />
        </center>     
>>>>>>> 3ba9d06ad3cd559799b258ad76afa13fcd145911
    </body>
</html>