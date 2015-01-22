<%-- 
    Document   : gl
    Created on : Jan 13, 2015, 1:23:17 PM
    Author     : Kai
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
    				
    				<li><a href="../Hjem">Hjem</a></li>
    				<li><a href="../Spill">Spill</a></li>
                                <li ><a href="../Chat">Chat</a></li>
    				<li><a href="../Highscore">Se Highscore</a></li>
    				<li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Min Side<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li class="active"><a href="<c:url value='/MinSide/EndrePassord'/>" >Endre Passord</a></li>
                                        <li><a href="<c:url value='/MinSide/Godkjenningsliste'/>" >Godkjenningsliste</a></li>
                                    </ul>
                                </li>
    				<li><a href="../LoggUt">Logg ut</a></li>
    			</ul>
                                    <a href="http://hist.no"><img src="<c:url value='/resources/bilder/HIST_logo_farge_liten.jpg' />" width="50" id="histLogo"/></a>
    		</div>
        </div>
    </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    <center>
        
        <div class="oversikt-container" style="margin-top: -250px;" >
                <h1>${bruker.brukerdata.fornavn} ${bruker.brukerdata.etternavn}</h1>
                <h2 class="${bruker.statusClass}">${bruker.status}</h2>
                <h3>${bruker.brukerdata.epost}</h3>
               
                    <center>
                        <table>
                            <tr>
                                <th>#</th>
                                <th>Nivå</th>
                                <th>Poeng</th>
                            </tr>
                            <c:forEach var="oppgave" items="${oppgavenavn}" varStatus="statusOppgave">
                                <tr>
                                    <td>${statusOppgave.index+1}</td>
                                    <td>${oppgave}</td>
                                    <td>${bruker.oppgaver[statusOppgave.index].poeng}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </center>
                    <h2>Poeng: ${bruker.totalPoeng}</h2>
                </div>
    </center>    
    </body>
</html>
