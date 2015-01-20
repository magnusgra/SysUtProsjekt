<%-- 
    Document   : mismatch
    Created on : 20.jan.2015, 11:10:54
    Author     : Magnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mismatch</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/felles/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/spill/mismatch/mismatch.css'/>">
        <script src="<c:url value='/resources/spill/mismatch/mismatch_side.js'/>"></script>

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
                        Her er det noe som er fryktelig galt. 
                        Steven har kludret med html-koden slik at den ikke henger sammen med css-en. 
                        Det skal være en vei her som Nic kan følge. Fiks html-koden slik at den passer med css-en.
                    </div>

                    <div id ="container">
                        <span id="timer"></span>
                        <div id="tre" title="tre"></div>
                        <div id="bygning1" class="bygninger" title="bygg1"></div>
                        <div id="bygning2" class="bygninger" title="bygg2"></div>
                        <div id="bygning3" class="bygninger" title="bygg3"></div>
                        <div id="bygning4" class="bygninger" title="bygg4"></div>
                        <div id="bygning5" class="bygninger" title="bygg5"></div>
                        <div id="bygning6" class="bygninger" title="bygg6"></div>
                        <div id="bygning7" class="bygninger" title="bygg7"></div>
                        <div id="bygning8" class="bygninger" title="bygg8"></div>
                        <div id="bygning9" class="bygninger" title="bygg9"></div>
                        <div id="bygning10" class="bygninger" title="bygg10"></div>
                        <div id="gress" title="gress"></div>
                        <div id="vei" title="asfalt"></div>
                        <div id="fartsstrek1" class="fartsstreker" title="fstrek1"></div>
                        <div id="fartsstrek2" class="fartsstreker" title="fstrek2"></div>
                        <div id="fartsstrek3" class="fartsstreker" title="fstrek3"></div>
                        <div id="fartsstrek4" class="fartsstreker" title="fstrek4"></div>
                        <div id="fartsstrek5" class="fartsstreker" title="fstrek5"></div>
                    </div>

                    <canvas id="canvas" >

                        <script src="<c:url value='/resources/spill/mismatch/mismatch_spill.js'/>"></script>
                        <div id="box"></div>

                    </canvas>

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

            </section>

        </div>

    </body>

</html>
