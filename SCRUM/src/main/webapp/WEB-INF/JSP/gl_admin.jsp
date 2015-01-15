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
        <style type="text/css">

            .gl-container {
                width:750px;
                margin:0 auto;
                margin-top:75px;
                margin-bottom:2%;
                transition:opacity 1s;
                -webkit-transition:opacity 1s;

                border: 1px solid rgb(231, 231, 231);

                box-shadow: 0px 0px 10px rgba(70,70,70,0.4);

            }
            .gl-container div {
                width:100%;
            }
            .gl-container .gl-header {
                background-color:#d3d3d3;
                padding: 2px;
                cursor: pointer;
                font-weight: bold;
            }
            .gl-container .gl-content {
                display: none;
                padding : 5px;
            }

        </style>
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
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    <center>

        <div class="gl-container">
         


                <c:forEach var="bruker" items="${godkjenningsListe}" varStatus="status">


                    <div class="gl-header">
                        ${bruker.brukerdata.etternavn}, ${bruker.brukerdata.fornavn}                                                  
                    </div>
                    <div class="gl-content">

                        ${bruker.brukerdata.rettigheter}

                        <c:forEach var="oppgave" items="${bruker.oppgaver}" varStatus="status">
                            ${oppgave.oppgavenr}:
                            ${oppgave.poeng}

                        </c:forEach>
                    </div>


                </c:forEach>


        </div>
        <hr>
    </center>




</body>
</html>
