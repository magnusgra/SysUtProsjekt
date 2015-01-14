<%-- 
    Document   : index
    Created on : 07.jan.2015, 09:39:01
    Author     : arnecs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nick and Steven</title>
        
         <!-- Bootstrap -->
        <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
    
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
        <script>
            function sjekkNyttPassord(){
                var nyttPass = document.getElementById("nytt-passord").value;
                var bekrPass = document.getElementById("bekreft-passord").value;
                var submitKnapp = document.getElementById("submit-endre-passord");
             
             
                //alert(nyttPass + " = " + bekrPass + " = " + (nyttPass === bekrPass));
                
                
                
                submitKnapp.disabled = !sjekkPassord(nyttPass, bekrPass);
                
                
            }
            
            function sjekkPassord(passord, bekreft){
                var melding = document.getElementById("melding");
                
                if (passord.length < 8) {
                    melding.innerHTML = "Passordet er for kort";
                    melding.className = "melding melding-error";
                    return false;
                }
                
                if (!containsANumber(passord)) {
                    melding.innerHTML = "Passordet må inneholde minst et tall.";
                    melding.className = "melding melding-error";
                    return false;
                }
                
                if (passord !== bekreft) {
                    melding.innerHTML = "Passordene er ikke like";
                    melding.className = "melding melding-error";
                    return false;
                }
                
                
                melding.className = "melding";
                melding.innerHTML = "";
                return true;
                
            }
            
            function containsANumber(str){
               
                strLen = str.length;
                while (--strLen) {
                    switch (str[strLen]) {
                        case "0":
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                        return true;
                    }
                }
                return false;            
            }
            
        </script>
    </head>
    <body>
    <div class="navbar navbar-default">
    	<div class="container">
    		<a href="Home" class = "navbar-brand">Nic and Steven</a>
    		<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>

    		<div class="collapse navbar-collapse navHeaderCollapse">
    			
    			<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="<c:url value='/Home'/>">Home</a></li>
                                <li><a href="<c:url value='/Spill'/>">Start Spillet</a></li>
    				<li><a href="<c:url value='/Highscore'/>">Se Highscore</a></li>
    				<li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Min Side<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li class="active">
                                            <a href="<c:url value='/MinSide/EndrePassord'/>" >Endre Passord</a>
                                        </li>
                                        <li>
                                            <a href="<c:url value='MinSide/Godkjenningsliste' />" >Godkjenningsliste</a>
                                        </li>
                                    </ul>
                                </li>
    				<li><a href="<c:url value='/LoggUt' />">Logg ut</a></li>
    			</ul>
    		</div>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    
    
        <div id="endre-passord-container">
            <h1>Endre passord</h1>
                <form:form method="POST" modelAttribute="endrePassordFormBackingBean" action="EndrePassord">
                    <center>
                        <p id="melding" class="melding ${meldingtype}">${melding}</p>
                        <form:input type= "password" placeholder="Gammelt passord" path="gammeltPassord" /><br>
                        <form:input id="nytt-passord" onkeyup="sjekkNyttPassord()" type= "password" placeholder="Nytt passord" path="nyttPassord" /><br>
                        <form:input  id="bekreft-passord" onkeyup="sjekkNyttPassord()" type= "password" placeholder="Bekreft nytt passord" path="gjentaNyttPassord" /><br>
                        <input id="submit-endre-passord" disabled  type="submit" value="Endre" title="Endre Passord" />
                        <br>
                        
                    </center>
                </form:form>
        </div>
    </body>
</html>
