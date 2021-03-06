<%-- 
    Document   : index
    Created on : 07.jan.2015, 09:39:01
    Author     : arnecs
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nic and Steven</title>
        
         <!-- Bootstrap -->
        <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
    
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
    </head>
    <body>
    <div class="navbar navbar-default">
    	<div class="container">
    		<a href="Home" class = "navbar-brand"></a>
    		<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>

    		<div class="collapse navbar-collapse navHeaderCollapse">
    			
    			<ul class="nav navbar-nav navbar-right">
    				
                            <li><a href="<c:url value='/Home'/>">Home</a></li>
    				<li><a href="<c:url value='/Spill'/>">Start Spillet</a></li>
    				<li><a href="<c:url value='/Highscore'/>">Se Highscore</a></li>
    				<li class="active"><a href="<c:url value='/MinSide'/>">Min Side</a></li>
    				<li><a href="<c:url value='/LoggUt'/>">Logg ut</a></li>
    			</ul>
                        <a href="http://hist.no"><img src="<c:url value='/resources/bilder/HIST_logo_farge_liten.png' />" width="50" id="histLogo"/></a>
    		</div>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    
    
        <div id="endre-passord-container">
            <h1>Endre passord</h1>
                <form:form method="POST" modelAttribute="endrePassordFormBackingBean" action="MinSide">
                    <center>
                        <p class="melding ${meldingtype}">${melding}</p>
                        <form:input type= "password" placeholder="Gammelt passord" path="gammeltPassord" /><br>
                        <form:input type= "password" placeholder="Nytt passord" path="nyttPassord" /><br>
                        <form:input type= "password" placeholder="Bekreft nytt passord" path="gjentaNyttPassord" /><br>
                        <input type="submit" value="Endre" title="Endre Passord" />
                        <br>
                        
                    </center>
                </form:form>
        </div>
    </body>
</html>
