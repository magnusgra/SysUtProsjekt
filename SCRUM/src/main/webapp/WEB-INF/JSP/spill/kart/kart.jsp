<%-- 
    Document   : kart
    Created on : 20.jan.2015, 09:22:57
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Kart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../felles/style.css">
        <link rel="stylesheet" type="text/css" href="kart.css">
    </head>
        
    <body>
        <jsp:useBean id="myBean" scope="session" class="org.geeks.Second" />
        <jsp:setProperty name="myBean" property="bane" />
        <jsp:setProperty name="myBean" property="poeng" />
        <jsp:getProperty name="myBean" property="bane" />
        <jsp:getProperty name="myBean" property="poeng" />
        
        <%
            int a = myBean.store();
        %>
        
        <div id="spill">
        
            <section id="content">

                <section class="block">
                    
                    <div id="oppgavetekst">Velg brett!</div>

                    <div id ="container"></div>

                    <canvas id="canvas" >

                        <script src="kart.js"></script>
                        <div id="box"></div>

                    </canvas>
                    
                </section>
                
                <div id="level">
                        <p>Nic er på vei til audition.</p>
                        <p>Beveg Nic med piltastene.</p>
                        <br />
                        <a href="#" id="start">Start</a>
                </div>

            </section>
            
        </div>
        
    </body>
    
</html>
