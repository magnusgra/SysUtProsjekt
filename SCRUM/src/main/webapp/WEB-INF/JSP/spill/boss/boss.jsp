<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BOSS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/felles/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/boss/boss.css'/>">
        <script src="<c:url value='/resources/spill/boss/boss_side.js'/>"></script>
    </head> 

    <body>

        <div id="spill">
            
            <section id="content">
                
                <section class="block">
                    
                    <div id="oppgavetekst"><h1>BOSS! TIDA GÅR</h1></div>
                    
                    <div id ="container">
                        <label id="sekunder">15</label>
                        <div id="boks"><p>Boks</p></div>
                        <div id="wrapper">
                            <div id="kommando">Gjør boksen rød!</div>
                        </div>
                        <div id="steven"></div>
                        <div id="snakkeboble"></div>
                        <div id="statusboks"></div>
                        <div id="statusbak"></div>
                    </div>

                    <canvas id="canvas" >
                        <script src="<c:url value='/resources/spill/boss/boss_spill.js'/>"></script>
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
            <!--<audio autoplay="autoplay"><source src="fight.mp3" type="audio/mpeg" /></audio> -->
        </div>
        <form hidden id="formen" action="Kart" method="GET">
        </form>                
        
</html>