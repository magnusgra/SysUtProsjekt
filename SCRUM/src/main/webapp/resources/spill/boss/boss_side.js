$(document).ready(function() {
                
              
                sekund = 15;
                
                var timeout;
                
                function timer() {
                    
                    if (sekund === 0) {

                    }
                    else{
                        sekund=sekund-1;
                        document.getElementById("sekunder").innerHTML=sekund;
                    }
                    
                }     
                
                var solutionHtml = ""; 
                var solutionCss = "";
                
                var startingHtml = "<div id=\"container\">\n" + 
                                   "<div id=\"kvadrat\"></div>\n" + 
                                   "<div id=\"kommando\"></div>\n" +
                                   "</div>";
                        
        
                var startingCss =   "#boks {\n"+
                                    "background-color: black;\n"+
                                    "width: 100px;\n"+
                                    "font-size: 12px;\n"+
                                    "border-radius: 0px;\n"+
                                    "}";

                $("#htmlView").val(startingHtml); 
                $("#cssView").val(startingCss); 
                
                var sekundTeller = setInterval(timer, 1000);
                

                $("#viewResult").click(function() {
                    
                    clearTimeout(timeout);
                    timeout = window.setTimeout(function() {
                        $("#htmlView").val(startingHtml); 
                        $("#cssView").val(startingCss);
                        
                        $("#boks").css("background-color", "black");
                        $("#statusboks").css("width", "122");
                        sekund = 15;
                        
                        $("#boks").css("width", 100);
                        $("#statusboks").css("width", "122");
                        sekund = 15;
                        
                        $("#boks").css("font-size", 12+"px");
                        $("#statusboks").css("width", "122");
                        sekund = 15;
                        
                        document.getElementById("kommando").innerHTML = "Gjør boksen rød!";
                    },15000);
                    oppgave();

                });
 
                $("#reset").click(function() {
                    $("#htmlView").val(startingHtml); 
                    $("#cssView").val(startingCss);
                    
                });
            });
            
            function oppgave(){
                document.getElementById("kommando").innerHTML = "Gjør boksen rød!";
                var innhold = $("#cssView").val();
                    var bakgrunn = finnDel(innhold.substring(innhold.indexOf("background-color:")+17, innhold.indexOf("background-color:")+27));
                    $("#boks").css("background-color", bakgrunn);
                    if ((bakgrunn==="red")||(bakgrunn==="#ff0000")) {
                        sekund=15;
                        document.getElementById("kommando").innerHTML = "Gjør boksen<br>200px bred!";
                        var bredde = finnDel(innhold.substring(innhold.indexOf("width:")+6, innhold.indexOf("width:")+12));
                        $("#boks").css("width", bredde);
                        $("#statusboks").css("width", "91.5px");
                        if (bredde==="200") {
                            sekund=15;
                            document.getElementById("kommando").innerHTML = "Endre tekststørrelsen<br> til 20px";
                            var font = finnDel(innhold.substring(innhold.indexOf("font-size:")+10, innhold.indexOf("font-size:")+15));
                            $("#boks").css("font-size", font+"px");
                            $("#statusboks").css("width", "61px");
                            if (font==="20") {
                                sekund=15;
                                document.getElementById("kommando").innerHTML = "Rund av kantene på<br> boksen med 25px";
                                var border = finnDel(innhold.substring(innhold.indexOf("border-radius:")+14, innhold.indexOf("border-radius:")+19));
                                $("#boks").css("border-radius", border+"px");
                                $("#statusboks").css("width", "30.5px");
                                if (border==="25") {
                                    sekund=0;
                                    document.getElementById("kommando").innerHTML = "You win...this time!";
                                    $("#box").css("background-color", "green");
                                    $("#statusboks").css("width", "0px");
                                    setTimeout(function() {document.getElementById('formen').submit();}, 4000);
                                }   
                            }
                        }   
                    }
            }
            
            function finnDel(input){
                var a = input.indexOf(";"); 
                if(a!==-1){
                   var input = input.substring(0,a);
                }
                var lengde = input.length;
                var start = input.lastIndexOf(" ");
                var input = input.substring(start+1,lengde);
                var px = "";
                if(input.indexOf("p")!== -1){
                    input = input.substring(0, input.indexOf("p"));
                }
                return input;
            }
            
            function setRenderedResult(frame, html, css) {
                frame.contents().find("html").html(html);
                var $head = frame.contents().find("head");                
                $head.append("<style>" + css + "</style>"); 
            }  