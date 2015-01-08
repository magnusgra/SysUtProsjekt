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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Endre passord</title>
        <style type="text/css">
            body{
                font-family: arial, sans-serif;
                color:white;
            }
            #tekst{
                font-size: 1.7em;
                
                margin-top: 15px;
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
            }
            #knapp{
                width: 200px;  
            }
        </style>
    </head>
    <body>
    
        <div class="innhold">
            
            <p id="tekst">Endre passord</p>
            <form>
                <input class="passord" type="password" placeholder="Gammelt passord" />
                <div class="break"></div>
                <input class="passord" type="password" placeholder="Nytt passord" />
                <div class="break"></div>
                <input class="passord" type="password" placeholder="Bekreft nytt passord" />
                <div class="break"></div>
                <input id="knapp" type="submit" value="Endre" />
            </form>
            
        </div>
    </body>
</html>
