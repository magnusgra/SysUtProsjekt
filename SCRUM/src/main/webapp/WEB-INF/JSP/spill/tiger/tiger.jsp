<%-- 
    Document   : tiger
    Created on : 20.jan.2015, 11:12:24
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tiger</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/felles/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/tiger/tiger.css'/>">
        <script src="<c:url value='/resources/spill/tiger_side.js'/>"></script>
    </head> 

    <body>
        <form id="formen" action="Kart" method="POST">
                <input id="bane" type="hidden" name="bane" value="" />
                <input id="poeng" type="hidden" name="poeng" value="" />
            </form>
        <div id="spill">

            <section id="content">

                <section class="block">
                    
                    <div id="oppgavetekst">TIGER!
                        Steven har sluppet løs en tiger, og Nic tør ikke gå forbi den.
                        Krymp tigeren ned til en liten pusekatt, så blir den mindre skummel.
                    </div>

                    <div id ="container">
                        <span id="timer"></span>
                        <div id ="wrapper">
                            <img src="<c:url value='/resources/spill/bilder/tiger.png'/>" alt="tiger"/>
                        </div>
                    </div>

                    <canvas id="canvas" >
                        <script src="<c:url value='/resources/spill/tiger/tiger_spill.js'/>"></script>
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
                
            </section>
            
        </div>

    </body>
    
</html>