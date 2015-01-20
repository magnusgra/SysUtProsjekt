<%-- 
    Document   : liste
    Created on : 20.jan.2015, 11:07:40
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Liste</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/felles/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/liste/liste.css'/>">
        <script src="<c:url value='/resources/spill/liste/liste_side.js'/>"></script>
    </head> 

    <body>
        <form id="formen" action="Kart" method="POST">
                <input id="bane" type="hidden" name="bane" value="" />
                <input id="poeng" type="hidden" name="poeng" value="" />
            </form>
        <div id="spill">
            
        <section id="content">
            
            <section class="block">
                
                <div id="oppgavetekst">
                    Nic har satt opp en liste med grunner til at filmselskapet skal 
                    velge ham foran Steven, men Steven har ødelagt formateringen, og nå er alt et rot.
                    Sett teksten opp som en uordnet liste, slik at den blir lesbar.
                </div>
                
                <div id ="container">
                    <span id="timer"></span>
                    <div id ="wrapper">
                       <p id="oppgave"></p>
                    </div>
                </div>

                <canvas id="canvas" >
                    <script src="<c:url value='/resources/spill/liste/liste_spill.js'/>"></script>
                    <div id="box"></div>
                </canvas>

            <div id="codeContainer">  
                <section class="block">        
                    <div class="litenoverskrift">CSS (kan ikke redigeres)</div>
                    <textarea readonly class="codeBox" id="cssView"></textarea>
                </section>

                <section class="block">        
                    <div class="litenoverskrift">HTML</div>
                    <textarea  class="codeBox" id="htmlView"></textarea>
                </section>

                <section class="block" id="knapper">    
                    <input type="button" value="Oppdater" id="viewResult">
                    <input type="button" value="Tilbakestill" id="reset">
                </section>
            </div> 
            
        </section>
            
        </section>
            
        </div>
        
    </body>

</html>
