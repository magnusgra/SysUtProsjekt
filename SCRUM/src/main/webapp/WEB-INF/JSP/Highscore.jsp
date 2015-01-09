<%-- 
    Document   : index
    Created on : 07.jan.2015, 09:39:01
    Author     : arnecs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    		<a href="Home" class = "navbar-brand">Nic and Steven</a>
    		<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>

    		<div class="collapse navbar-collapse navHeaderCollapse">
    			
    			<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="Home">Home</a></li>
    				<li><a href="Spill">Start Spillet</a></li>
    				<li class="active"><a href="Highscore">Se Highscore</a></li>
    				<li><a href="MinSide">Min Side</a></li>
    				<li><a href="LoggUt">Logg ut</a></li>
    			</ul>
    		</div>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
    
    <form:form action="se highscore" method="GET" modelAttribute="resultatFormBackingBean">
    <h5>Husk at dette bare er et spill. Ikke ta det for seriost :)</h5>
    <table border="1" width="100">
        <tr>
            <th>Bruker</th>
            <th>Antall forsok</th>
            <th>Poeng</th>
        </tr>
        
        <c:forEach var="resultat" items="${resultatFormBackingBean.alleResultat}" varStatus="status">
            <tr>
                <td><c:out value="${resultat.brukerdata.getBrukernavn()}"/>
                </td> 
                                    
                <td> <form:input path="alleResultat[${resultat.index}].poeng" /> 
                </td>
                <td> <form:input path="alleResultat[${resultat.index}].forsoknr" />
                </td>
            </tr>
        </c:forEach>
    </table>
  
    <a class="menu-button" href="Highscore" >Oppdater Highscores</a>
</form:form>
    <hr>
    
    </body>
</html>
