<%-- 
    Document   : index
    Created on : 07.jan.2015, 09:39:01
    Author     : arnecs
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nick and Steven</title>
        
         <!-- Bootstrap -->
         <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
         
         
         
         <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
         
    
    </head>
    <body>
    <div class="navbar navbar-default">
    	<div class="container">
            <a href="Home" class = "navbar-brand"><img id="nas-logo" src="<c:url value="/resources/bilder/nicandsteven.png"/>" />Nic and Steven</a>
    		<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>

    		<div class="collapse navbar-collapse navHeaderCollapse">
    			
    			<ul class="nav navbar-nav navbar-right">
    				
    				<li class="active"><a href="<c:url value='/Hjem'/>">Hjem</a></li>
                                <li ><a href="<c:url value='/Spill'/>">Spill</a></li>
                                <li ><a href="<c:url value='/Chat'/>">Chat</a></li>
    				<li><a href="<c:url value='/Highscore'/>">Se Highscore</a></li>
    				<li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Min Side<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li>
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
    <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js' />"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    
    
    <div id="velkomst-container">
        
        <h1>Velkommen!</h1>
        <p>
            <br />
            Til Nic & Steven, en �ving i spillform. Du f�r spille et spill, samtidig som du f�r testet dine ferdigheter i HTML5 og CSS. <br /><br />
            For � f� godkjent �vingen m� du fullf�re alle 8 brettene i spillet Nic & Steven. For hvert fullf�rte brett f�r du en poengscore. Den beste poengscoren f�r du ved � fullf�re hurtigst mulig, og maks poengsum for hvert enkelt brett er 300 poeng. Uansett poengscore f�r du godkjent �vingen dersom du klarer � fullf�re hele spillet.<br /><br />
            Lykke til!<br /><br />
            Hilsen Team1<br /><br />
            <p id="litentekst">
                Siden ble laget av Team1 v�r 2015, som ledd i et prosjekt. Team1 bestod av: Andreas Lersveen Fauske, Mary-Louise Fauske, Magnus Grande, Ingrid Horten, Ken Are Meisler, Arne Christian Skarpnes, Kai Skytt� og Mari Andrine Thorsteinsen
            </p>
        </p>
        
        
    </div>
    
    
    </body>
    
    
    
    
</html>
