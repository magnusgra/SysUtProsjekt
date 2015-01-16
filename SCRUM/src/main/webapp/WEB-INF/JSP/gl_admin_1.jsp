<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script type="text/javascript" src="//code.jquery.com/jquery-1.9.1.js"></script>
        <title>Godkjenning admin</title>
        <!-- Bootstrap -->
        <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
        

        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
        <script type="text/javascript">
            //<![CDATA[ 
            $(window).load(function () {
                $(".gl-header").click(function () {

                    $header = $(this);
                    //getting the next element
                    $content = $header.next();
                    //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
                    $content.slideToggle(500, function () {
                    });
                });
            });//]]>  


        </script>
        
      
    </head>
    <body>
                        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>

        <div class="navbar navbar-default">
    	<div class="container">
            <a href="Home" class = "navbar-brand"><img id="nas-logo" src="<c:url value="/resources/bilder/nicandsteven.png"/>" />Nic and Steven</a>
    		<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>

    		<div class="collapse navbar-collapse navHeaderCollapse">
    			
    			<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="<c:url value='/Home'/>">Home</a></li>
                                <li><a href="<c:url value='/Spill'/>">Start Spillet</a></li>
    				<li><a href="<c:url value='/Highscore'/>">Se Highscore</a></li>
    				<li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Min Side<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="<c:url value='/MinSide/EndrePassord'/>" >Endre Passord</a>
                                        </li>
                                        <li class="active">
                                            <a href="<c:url value='/MinSide/Godkjenningsliste' />" >Godkjenningsliste</a>
                                        </li>
                                    </ul>
                                </li>
    				<li><a href="<c:url value='/LoggUt' />">Logg ut</a></li>
    			</ul>
    		</div>
        </div>
    </div>
                

        <div id="gl-container">
            <h1>
                Godkjenningsliste
            </h1>
            <br>
            <center>
            <p>
                Dette er en godkjenningsliste. Her kan du se hvem som har godkjent oppgavene.

            </p>
            </center>
            
            
                <c:forEach var="bruker" items="${godkjenningsListe}" varStatus="status">
                    <div class="gl-header ${bruker.statusClass}">
                        ${bruker.brukerdata.etternavn}, ${bruker.brukerdata.fornavn} <span>${bruker.rettigheter}</span>  
                            
                        
                        <!-- Single button -->
                            <div class="btn-group">
                              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                Action <span class="caret"></span>
                              </button>
                              <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                              </ul>
                            </div> 
                        
                    </div>
                    <div class="gl-content">
                       epost: ${bruker.brukerdata.epost}
                           
     
                       
                        
                       
                        <table>
                            <tr>
                                <c:forTokens var="index" items="1 2 3 4 5 6 7 8" delims=" ">
                                    <th>
                                        ${index}
                                    </th>
                                </c:forTokens>
                            </tr>
                            <tr>
                            <c:forEach var="oppgave" items="${bruker.oppgaver}" varStatus="status">
                                <td>
                                ${oppgave.poeng}
                                </td>
                            </c:forEach>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
            <br>
            <br>
            
            </div>
            <hr>

    </body>
</html>
