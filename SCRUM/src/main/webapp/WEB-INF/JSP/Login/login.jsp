<%-- 
    Document   : login
    Created on : 07.jan.2015, 14:18:05
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Login Form</title>

  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" media="screen" type="text/css" />

</head>

<body>

  <span href="#" class="button" id="toggle-login">Log in</span>
  
<center>
<div id="login">
  <div id="triangle"></div>
  <h1>Log in</h1>
  <form action="Startside" >
      <input type="email" placeholder="Email" /><br>
      <input type="password" placeholder="Password" /><br>
    <input type="submit" value="Log in" />
  </form>
</div>
</center>

  <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

  <script src="js/index.js"></script>

</body>

</html>
