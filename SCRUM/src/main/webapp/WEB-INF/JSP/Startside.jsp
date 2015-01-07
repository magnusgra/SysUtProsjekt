<%-- 
    Document   : Startside
    Created on : 07.jan.2015, 10:04:27
    Author     : Mari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Velkommen</h1>
        <form:form method="GET" modelAttribute="getUserBean">
        </form:form>
        
                <input class= button type="button" value="Start nytt spill"></td>
                <input class = button type="button" value="Se highscore"></td>
            
    </body>
</html>