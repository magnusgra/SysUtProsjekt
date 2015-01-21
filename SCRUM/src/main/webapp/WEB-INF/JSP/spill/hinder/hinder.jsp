<%-- 
    Document   : hinder
    Created on : 19.jan.2015, 15:34:16
    Author     : Magnus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hinder</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="<c:url value='/resources/spill/hinder/hinder_side.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/felles/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/hinder/hinder.css'/>">
        
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
                    Steven har laget en hindring for Nic. Fjern hindringen slik at Nic kommer seg forbi.
                </div>

                <div id ="container">
                    <span id="timer"></span>
                    <div id="soppel">
                        <img src="<c:url value='/resources/spill//bilder/hinder.png'/>"/>
                    </div>
                </div>

                <canvas id="canvas" >
                    <script src="<c:url value='/resources/spill/hinder/hinder_spill.js'/>"></script>
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
                        <input type="button" value="Oppdater" id="viewResult" />
                        <input type="button" value="Tilbakestill" id="reset" />
                    </section>
                </div>
                
            </section>
            
        </section>
            
        </div>
        
    </body>
    
</html>
