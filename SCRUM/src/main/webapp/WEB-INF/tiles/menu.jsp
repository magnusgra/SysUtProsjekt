<!DOCTYPE html>
<html>
    <head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
      <link rel="stylesheet" href="<c:url value="/resources/css/menuStyle.css"/>" media="screen" type="text/css" />
      <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" media="screen" type="text/css" />
    </head>
    <body>
        <div class="brukernavn" >&lt;Brukernavn&gt;</div>
        <center>
            <br><br>
            <a class="menu-button" href="<c:url value="#"/>" >Start spill</a><br>
            <a class="menu-button" href="<c:url value="Highscore"/>" >Se highscore</a><br>
            <a class="menu-button" href="<c:url value="EndrePassord"/>" >Endre Passord</a><br>
            <a class="menu-button" href="<c:url value="login"/>" >Logg ut</a>
        </center>

    </body>
</html>