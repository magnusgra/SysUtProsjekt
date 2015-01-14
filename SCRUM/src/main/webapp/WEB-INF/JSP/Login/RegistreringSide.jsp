<%-- 
    Document   : RegistreringSide
    Created on : Jan 7, 2015, 1:55:48 PM
    Author     : Kai
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">

        <title>Registrer deg!</title>

        <link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>" media="screen" type="text/css" />
        
    </head>
    
    <script>
        function validerInput(){
            var epost = document.getElementById("epost").value;
            var fornavn = document.getElementById("fornavn").value;
            var etternavn = document.getElementById("etternavn").value;
            var brukervilkar = document.getElementById("brukervilkar").checked;
            var submit = document.getElementById("submit-reg");
            
            submit.disabled = !sjekkInput(epost, fornavn, etternavn, brukervilkar);
            
        }
        
        function sjekkInput(epost, fornavn, etternavn, brukervilkar){
            var melding = document.getElementById("melding");
            
            if (!validateEmail(epost)){
                melding.className = "melding melding-error";
                melding.innerHTML = "Ugyldig epost";
                return false;
            }
            if (fornavn === "" || etternavn === ""){
                melding.className = "melding melding-error";
                melding.innerHTML = "Navn må fylles ut";
                return false;
            }
            
    
            if (!brukervilkar) {
                melding.className = "melding melding-error";
                melding.innerHTML = "Du må godta brukervilkårene";
                return false;
            }
            
            melding.className = "melding";
            melding.innerHTML = "Registrer deg";
            return true;
        }
        
        function validateEmail(email) { 
            var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(email);
        }
        
    </script>

    <body>

        

        <div id="login">
            
            <h1>Nic and Steven</h1>
            <form:form method="POST" modelAttribute="registreringsForm" action = "RegistreringBruker">
                <center>
                    <p id="melding" class="melding ${meldingtype}">
                        <c:if test="${melding==null}">
                            Registrer deg
                        </c:if>${melding}
                    </p>
                </center>
                        <form:input id="epost" type= "email" onchange="validerInput()" placeholder="Epost" path="brukerdata.epost" /><br>
                <%--<input type="email" placeholder="Epost" /><br>--%>
                <form:input type= "text" id="fornavn" onkeyup="validerInput()" placeholder="Fornavn" path="brukerdata.fornavn" /><br>
                <form:input type= "text" id="etternavn" onkeyup="validerInput()" placeholder="Etternavn" path="brukerdata.etternavn" /><br>
                <center><form:checkbox id="brukervilkar" onclick="validerInput()" path="godtarBrukervilkar"/> <form:label path="godtarBrukervilkar" >  Ja, jeg godtar <a href="avtale" target="popup" onclick="window.open('avtale','avtale','width=600,height=400')">brukervilkårene</a>.</form:label></center><br>
           
                <%--<input type="password" placeholder="Passord" /><br>--%>
                <input id="submit-reg" disabled="" type="submit"  value="Registrer bruker" />
                <br>
                
            </form:form>
        </div>


        <script src='<c:url value="http://codepen.io/assets/libs/fullpage/jquery.js" />'></script>

        <script src='<c:url value="/resources/js/index.js" />'></script>

    </body>

</html>
