<%-- 
    Document   : EndrePassord
    Created on : Jan 8, 2015, 10:50:33 AM
    Author     : Kai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" media="screen" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Endre passord</title>
        <style type="text/css">
            body{
                font-family: 'Open Sans',sans-serif;
                color:white;
            }
            #tekst{
                font-size: 1.4em;
                
                margin-top: 18px;
                margin-bottom: 0px;
            }
            .innhold{
                float: left;
                padding-left: 15px;
                margin-left: 37%;
                
                
            }
            .passord{
                height:30px;
                width: 200px;
                margin-bottom:5px;
                margin-top: 10px;
                font-size: 1em;
            }
            .button2{
                width:205px;
                background:#3399cc;
                display:block;
                margin:0 auto;
                margin-top:10px;
                padding:10px;
                text-align:center;
                text-decoration:none;
                color:#fff;
                cursor:pointer;
                transition:background .3s;
                -webkit-transition:background .3s;
                font-size: 1em;
            }

            .button2:hover{
                background:#2288bb;
            }
        </style>
    </head>
    <body>
    <center>
        <div id="EndrePassord">
            <div id="triangle"></div>
            <h1>Endre passord</h1>
            <form:form method="POST" modelAttribute="brukerService" action="EndrePassord">
                <form:input type= "passord" placeholder="Gammelt passord" path="brukerdata.passord" /><br>
                <form:input type= "passord" placeholder="Nytt passord" path="brukerdata.passord" /><br>
                <form:input type= "passord" placeholder="Bekreft nytt passord" path="brukerdata.passord" /><br>
                <input type="submit" value="Endre" />
                <br>
                <br>
            </form:form>
            </div>
        </center>
        <script src='<c:url value="http://codepen.io/assets/libs/fullpage/jquery.js" />'></script>

    </body>
</html>
