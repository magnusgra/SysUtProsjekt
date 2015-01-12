<%-- 
    Document   : RegistreringSide
    Created on : Jan 7, 2015, 1:55:48 PM
    Author     : Kai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">

        <title>Registrer deg!</title>

        <link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>" media="screen" type="text/css" />
        
    </head>

    <body>

        

        <div id="login">
            
            <h1>Registrer deg</h1>
            <form:form method="POST" modelAttribute="registreringsForm" action = "RegistreringBruker">
                <center><p class="melding">Du er ikke gammel nok.</p></p></center>
                <form:input type= "email" placeholder="Epost" path="brukerdata.epost" /><br>
                <%--<input type="email" placeholder="Epost" /><br>--%>
                <form:input type= "text" placeholder="Navn" path="brukerdata.brukernavn" /><br>
                <center><form:checkbox path="godtarBrukervilkar"/> <form:label path="godtarBrukervilkar" >  Ja, jeg godtar <a href="avtale" target="popup" onclick="window.open('avtale','avtale','width=600,height=400')">brukervilkårene</a>.</form:label></center><br>
           
                <%--<input type="password" placeholder="Passord" /><br>--%>
                <input type="submit" value="Registrer bruker" />
                <br>
                
            </form:form>
        </div>


        <script src='<c:url value="http://codepen.io/assets/libs/fullpage/jquery.js" />'></script>

        <script src='<c:url value="/resources/js/index.js" />'></script>

    </body>

</html>
