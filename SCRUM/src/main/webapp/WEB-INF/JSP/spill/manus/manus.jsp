<%-- 
    Document   : manus
    Created on : 20.jan.2015, 11:09:13
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manus</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/felles/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/manus/manus.css'/>">
        <script src="<c:url value='/resources/spill/manus/manus_side.js'/>"></script>
    </head>

    <body>
        <form id="formen" action="Kart" method="POST">
                <input id="bane" type="hidden" name="bane" value="" />
                <input id="poeng" type="hidden" name="poeng" value="" />
            </form>
        <div id="spill">

            <section id="content">

                <div id="alt">

                    <section class="block">

                        <div id="oppgavetekst">
                        </div>

                        <div id ="container">
                            <span id="timer"></span>
                            <div id ="manus">
                                <h1>"Wraith Rider"</h1>
                                <p>“I did a bald rump 360 triple back flip in the forefront of twenty two thousand human beings. It’s sort of amusing, it’s on Youtube, check it out. But when my father got ill, I did something way madder than that.”</p>
                            </div>
                        </div>

                        <canvas id="canvas" >
                            <script src="<c:url value='/resources/spill/manus/manus_spill.js'/>"></script>
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
                
            </section>
    </div>
</html>
