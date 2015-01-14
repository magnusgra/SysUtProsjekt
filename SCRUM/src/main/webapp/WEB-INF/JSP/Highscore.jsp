<%-- 
    Document   : index
    Created on : 07.jan.2015, 09:39:01
    Author     : arnecs
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    				
    				<li><a href="<c:url value='/Home'/>">Home</a></li>
                                <li><a href="<c:url value='/Spill'/>">Start Spillet</a></li>
    				<li class="active"><a href="<c:url value='/Highscore'/>">Se Highscore</a></li>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    
            <center>
   
 
    
    <div id="highscore-container">
        <h1>
            <a id="oppdater-highscores" href="Highscore">
                <img src="<c:url value='/resources/bilder/update_icon.png'/>"/>
            </a>
            <center>
                Highscore
            </center>
        </h1>
        <br>
        <p class="melding">Husk at dette bare er et spill. Ikke ta det for seri&oslash;st :)</p>
        <br>
        <table >
            <tr>
                <th>#</th>
                <th>Bruker</th>
                <th>Poeng</th>
            </tr>

            <c:forEach var="highscore" items="${highscoreListe.higscoreliste}" varStatus="status">
                <tr class="plass${highscore.plassering}">
                    <td> 
                         ${highscore.plassering}
                    </td> 
                    <td> 
                         ${highscore.fornavn}
                    </td>                   
                    <td>
                        ${highscore.totalsum}
                    </td>
                </tr>
            </c:forEach>

        </table>    
       
        <hr>
      

</div>
      </center>
    
    </body>
</html>
