<%-- 
    Document   : login
    Created on : 07.jan.2015, 14:18:05
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">

        <title>Login Form</title>

        <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" media="screen" type="text/css" />

    </head>

    <body>

        <span href="#" class="button" id="toggle-login">Log in</span>

<<<<<<< HEAD
  <span href="#" class="button" id="toggle-login">Logg inn</span>
  

<div id="login">
  <div id="triangle"></div>
  <h1>Logg Inn</h1>
  <form action="Startside" >
<<<<<<< HEAD
      <input type="email" placeholder="E-post" /><br>
      <input type="password" placeholder="Passord" /><br>
    <input type="submit" value="Logg inn" />
=======
      <input type="email" placeholder="Epost" /><br>
      <input type="password" placeholder="Passord" /><br>
    <input type="submit" value="Log in" />
    <br>
    <br>
    <center>
    <a href="RegistreringSide.jsp">Ny bruker? registrer deg her!</a>
    </center>
>>>>>>> 8fbb2f8aabfda2ceb50a4adf87cf8b4b187f481e
  </form>
</div>
=======

        <div id="login">
            <div id="triangle"></div>
            <h1>Log in</h1>
            <form:form method="POST" modelAttribute="getUserBean" action = "Startside">
                <form:input type= "email" placeholder="Epost" path="userName" /><br>
                <%--<input type="email" placeholder="Epost" /><br>--%>
                <form:input type= "password" placeholder="Passord" path="password" /><br>
                <%--<input type="password" placeholder="Passord" /><br>--%>
                <input type="submit" value="Log in" />
                <br>
                <br>
                <center>
                    <a href="RegistreringSide">Ny bruker? registrer deg her!</a>
                </center>
            </form:form>
        </div>
>>>>>>> 3ba9d06ad3cd559799b258ad76afa13fcd145911


        <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

        <script src="js/index.js"></script>

    </body>

</html>
