<%-- 
    Document   : Highscore
    Created on : Jan 8, 2015, 10:59:34 AM
    Author     : Kai
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

<h2>Highscore</h2>
<html>
    <head>
            <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" media="screen" type="text/css" />
    </head>

<p>

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
</html>
    