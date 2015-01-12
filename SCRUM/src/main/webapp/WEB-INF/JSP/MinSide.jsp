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
    				<li><a href="Highscore">Se Highscore</a></li>
    				<li class="active"><a href="MinSide">Min Side</a></li>
    				<li><a href="LoggUt">Logg ut</a></li>
    			</ul>
    		</div>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    
    <center>
        <h1>Endre passord</h1>
            <form:form method="POST" modelAttribute="endrePassordFormBackingBean" action="EndrePassord">
                <form:input type= "password" placeholder="Gammelt passord" path="gammeltPassord" /><br>
                <form:input type= "password" placeholder="Nytt passord" path="nyttPassord" /><br>
                <form:input type= "password" placeholder="Bekreft nytt passord" path="gjentaNyttPassord" /><br>
                <input type="submit" value="Endre" title="Endre Passord" />
                <br>
                <br>
            </form:form>
    </center>
    
    
    </body>
</html>
