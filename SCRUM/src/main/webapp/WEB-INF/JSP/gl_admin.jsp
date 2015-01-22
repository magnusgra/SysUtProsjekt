<%-- 
    Document   : gl_admin
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
        <title>Nic and Steven</title>
        
         <!-- Bootstrap -->
         <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
         
         
         
         <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
         
         
        <script>
            function openBox(box) {
                
                document.getElementById('cover').hidden = false;
                document.getElementById(box).hidden = false;
            }
            function closeBoxes() {
                
                var boxes = document.getElementsByClassName('oversikt-container');
                
                document.getElementById('cover').hidden = true;
                for (var i = 0; i < boxes.length; i++){
                   boxes[i].hidden = true;
                }
            }
        </script>
    
    </head>
    <body>
    <div class="navbar navbar-default">
    	<div class="container">
            <a href="Home" class = "navbar-brand"><img id="nas-logo" src="<c:url value="/resources/bilder/nicandsteven.png"/>" /></a>
    		<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>

    		<div class="collapse navbar-collapse navHeaderCollapse">
    			
    			<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="<c:url value='/Hjem'/>">Hjem</a></li>
                                <li><a href="<c:url value='/Spill'/>">Spill</a></li>
                                <li><a href="<c:url value='/Chat'/>">Chat</a></li>
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
    <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js' />"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    
    <div class="gl-cover" id="cover" onclick="closeBoxes()" hidden ></div>
    <div id="gl-container">
        <h1>Godkjenningsliste</h1>
        <center>
            <br>
            <p>
                Dette er en godkjenningsliste. Her kan du se hvem som har godkjent oppgavene.
            </p>
        </center>

        <c:forEach var="bruker" items="${godkjenningsListe}" varStatus="status">
            <div class="gl-header ${bruker.statusClass}" onclick="openBox('oversikt-container${status.index}')">
                    ${bruker.brukerdata.etternavn}, ${bruker.brukerdata.fornavn} <span>${bruker.rettigheter}</span>  
            </div>
            <div class="oversikt-container" id="oversikt-container${status.index}" hidden>
                <h1>${bruker.brukerdata.fornavn} ${bruker.brukerdata.etternavn}</h1>
                <h2 class="${bruker.statusClass}">${bruker.status}</h2>
                <h3>${bruker.brukerdata.epost}</h3>
                <c:if test="${brukerdata.rettigheter == 2}">
                    <form:form method="POST" modelAttribute="bruker.brukerdata" action="Godkjenningsliste"  >
                        <input type="hidden" name="aktivBruker" value="${status.index}" >
                        <input type="hidden" name="aktivBrukerEpost" value="${bruker.brukerdata.epost}" >
                        <input type="hidden" name="side" value="${aktivSide}" >
                            
                                <c:if test="${bruker.brukerdata.rettigheter != 0}">
                                     <input type="submit" name="aktivBrukerType" value="Gjør til Student">
                                </c:if>
                                <c:if test="${bruker.brukerdata.rettigheter != 1}">
                                    <input type="submit"name="aktivBrukerType" value="Gjør til Studentassistent" >
                                </c:if>
                                <c:if test="${bruker.brukerdata.rettigheter != 2}">
                                    <input type="submit" name="aktivBrukerType" title="Faglærer" value="Gjør til Faglærer" >
                                </c:if>
                                
                            
                    </form:form>
                </c:if>
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
                <div></div>
                <c:if test="${aktivBruker == status.index}">
                    <script>    
                        openBox('oversikt-container${status.index}');
                    </script>
                </c:if>
            </c:forEach>
                    
            <center>
                <nav>
                    <ul class="pagination">
                        <c:if test="${aktivSide > 1}">
                          <li>
                            <a href="?side=${aktivSide-1}" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                        </c:if>
                        <c:forEach var="i" items="${sider}" >
                            <li <c:if test="${aktivSide==i}">class="active"</c:if>>
                                <a href="?side=${i}">
                                    ${i}
                                </a>
                            </li>
                        </c:forEach>
                        <c:if test="${!sisteSide}" >
                        <li>
                          <a href="?side=${aktivSide+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                          </a>
                        </li>
                      </c:if>
                    </ul>
                </nav>
            </center>
        
    </div>
    
    

 
    

        
    
    
    
    </body>
    
    
    
    
</html>
