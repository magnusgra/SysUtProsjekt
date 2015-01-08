<%-- 
    Document   : login
    Created on : 07.jan.2015, 14:18:05
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">

        <title>Login Form</title>

        

    </head>

    <body>

        <span href="#" class="button" id="toggle-login" style="width: 125px;" >Nic and Steven</span>

        <div id="login">
            <div id="triangle"></div>
            <h1>Brukerkonto</h1>
            <form:form method="POST" modelAttribute="brukerService" action = "Startside">
                <form:input type= "email" placeholder="Epost" path="brukerdata.epost" /><br>
                <%--<input type="email" placeholder="Epost" /><br>--%>
                <form:input type= "password" placeholder="Passord" path="brukerdata.passord" /><br>
                <%--<input type="password" placeholder="Passord" /><br>--%>
                <input type="submit" value="Logg inn" />
                <br>
                <br>
                <center>
                    <span> Ny bruker? <a href="RegistreringSide">Registrer deg her!</a></span>
                </center>
            </form:form>
        </div>


        <script src='<c:url value="http://codepen.io/assets/libs/fullpage/jquery.js" />'></script>

        <script src='<c:url value="/resources/js/index.js" />'></script>

    </body>

</html>
