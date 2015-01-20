<%-- 
    Document   : formLevel.jsp
    Created on : 20.jan.2015, 11:02:18
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formlevel</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="<c:url value='/resources/spill/form/formLevel_side.js' />"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/felles/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/form/formLevel.css'/>">
    </head>
    <body>
        
        <form id="formen" action="Kart" method="POST">
            <input id="bane" type="hidden" name="bane" value="" />
            <input id="poeng" type="hidden" name="poeng" value="" />
        </form>
        
        <div id="spill">
            <section class="block">

                <div id="oppgavetekst">
                    Nic har endelig nådd fram til audition, men Steven har slettet alle opplysningene som <br>
                    filmselskapet hadde om Nic! Opprett en form for Nic med inputfelt for fornavn, etternavn og <br>
                    alder, samt en submitknapp for å sende inn skjemaet.
                </div>
                
                <div id="container">
                    <span id="timer"></span>
                </div>
                
                <canvas id="canvas" >
                    <script src="<c:url value='/resources/spill/form/formLevel_spill.js'/>"></script>
                    <div id="box"></div>
                </canvas>
                
                <form id="form">
                    Fornavn:<input type="text" id="fornavn"  placeholder="Steven?"><br><br>
                    Etternavn:<input type="text" id="etternavn" placeholder="Seagal?"><br><br>
                    Alder: <input type="number" min="0" max="99"><br><br>
                    <input type="button" value="submit" onclick="doSomething()">
                </form>

                <div id="codeContainer">  
                    <section class="block">        
                        <div class="litenoverskrift">CSS (kan ikke redigeres)</div>
                        <textarea readonly class="codeBox" id="cssView"></textarea>
                    </section>

                    <section class="block">        
                        <div class="litenoverskrift">HTML</div>
                        <textarea class="codeBox" id="htmlView"></textarea>
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
