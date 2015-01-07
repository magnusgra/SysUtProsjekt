<!DOCTYPE html>
<html>
    <head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
      <link rel="stylesheet" href="<c:url value="/resources/css/menuStyle.css"/>" media="screen" type="text/css" />
    </head>
    <body>
        <div class="brukernavn" >&lt;Brukernavn&gt;</div>
        <center>
            <br><br>
            <a class="button" href="<c:url value="#"/>" >Kul YOLO</a><br>
            <a class="button" href="<c:url value="RegistreringSide"/>" >RegistreringSide</a><br>
            <a class="button" href="<c:url value="#"/>" >Endre Passord</a><br>
            <a class="button" href="<c:url value="login"/>" >Logg ut</a>
        </center>

    </body>
</html>