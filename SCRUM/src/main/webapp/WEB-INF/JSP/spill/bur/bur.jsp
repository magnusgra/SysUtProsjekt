<%-- 
    Document   : bur
    Created on : 20.jan.2015, 10:52:57
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bur</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/felles/style.css' />">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/bur/bur.css'/>">
        <script src="<c:url value='/resources/spill/bur/bur_side.js' />"></script>
    </head>
    <body>
        <form id="formen" action="Kart" method="POST">
                <input id="bane" type="hidden" name="bane" value="" />
                <input id="poeng" type="hidden" name="poeng" value="" />
            </form>
        <div id="spill">
        <section class="block">

            <div id="oppgavetekst">
            </div>

            <div id="container">
                <span id="timer"></span>
                <div id="cage"></div></div>
                
            <canvas id="canvas">
                <script src="<c:url value='/resources/spill/bur/bur_spill.js'/>"></script>
                <div id="box"></div>
            </canvas>

        <div id="codeContainer">  
            <section class="block">        
                <div class="litenoverskrift">CSS</div>
                <textarea class="codeBox" id="cssView"></textarea>
            </section>

            <section class="block">        
                <div class="litenoverskrift">HTML (kan ikke redigeres)</div>
                <textarea readonly class="codeBox" id="htmlView"></textarea>
            </section>

            <section class="block" id="knapper">    
                <input type="button" value="Oppdater" id="viewResult">
                <input type="button" value="Tilbakestill" id="reset">
            </section>
        </div>
            
        </section>
        </div>

    </body>
</html>
