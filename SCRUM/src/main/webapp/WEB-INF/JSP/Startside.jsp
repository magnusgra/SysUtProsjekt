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
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
    </head>
    <body>
    <center>
        <c:set var="user" value="${getUserBean}" />
        <h1>Velkommen ${user.userName}</h1>
        <form:form method="GET" modelAttribute="getUserBean"></form:form>
    
                <input class="button" type="button" value="Start nytt spill"/>
                <br>
                <br>
                <input class="button" type="button" value="Se highscore"/>
       </center>  
    </body>
</html>