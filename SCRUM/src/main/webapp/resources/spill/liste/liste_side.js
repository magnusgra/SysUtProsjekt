$(document).ready(function() {
               $("#htmlView").keydown(function (e) {
                if (e.ctrlKey && (e.keyCode === 88 || e.keyCode === 67 || e.keyCode === 86)) {
                    return false;
                }
            });
            $(document).bind("contextmenu",function(e){
                e.preventDefault();
            });       
                var count = 310;
                var counter = setInterval(timer, 1000);
                
                function timer() {
                    count=count-1;
                    if (count < 10) {
                        count = 10;
                       clearInterval(counter);
                       return;
                    }
                    if (count < 300) {
                    document.getElementById("timer").innerHTML=count + " poeng";
                    } else {
                        document.getElementById("timer").innerHTML = 300 + " poeng";
                    }
                }    
                
                var solutionHtml = ""; 
                var solutionCss = "";
                
                var startingHtml1 =  "Better physique"+
                                    "More famous"+
                                    "Cooler name"+
                                    "Handsomer"+
                                    "More badass"+
                                    "Better actor";
                var startingHtml2 =  "Better physique"+
                                    "More famous"+
                                    "Cooler name"+
                                    "Handsomer"+
                                    "More badass"+
                                    "New haircut";
                var startingHtml3 =  "Better physique"+
                                    "More famous"+
                                    "Cooler name"+
                                    "Handsomer"+
                                    "More badass"+
                                    "Tougher";
        
                var startingCss =   
                                "#wrapper {\n"+
                                "position: relative;\n"+
                                "height: 300px;\n"+
                                "width: 300px;\n"+
                                "margin-left: 460px;\n"+
                                "margin-top: 20px;\n"+
                                "font-size: 2em;\n"+
                                "}\n";
                        
                var oppgave1 = "Better physique <br> More famous <br> Cooler name <br> Handsomer<br> More badass<br> Better actor";
                var oppgave2 = "Better physique <br> More famous <br> Cooler name <br> Handsomer<br> More badass<br> New haircut";
                var oppgave3 = "Better physique <br> More famous <br> Cooler name <br> Handsomer<br> More badass<br> Tougher";
                
                //setRenderedResult($("#solutionFrame"), solutionHtml, solutionCss);

                 
                $("#cssView").val(startingCss); 
                var random = Math.floor((Math.random() * 3) + 1);
                if(random===1){
                    $("#htmlView").val(startingHtml1);
                     document.getElementById("oppgave").innerHTML = oppgave1;
                     
                }
                else if(random===2){
                    $("#htmlView").val(startingHtml2);
                    document.getElementById("oppgave").innerHTML = oppgave2;
                    
                }
                else if(random===3){
                    $("#htmlView").val(startingHtml3);
                    document.getElementById("oppgave").innerHTML = oppgave3;
                    
                }
                
                
                var cookie=document.cookie;
                
                
                $("#viewResult").click(function() {
                    
                    var innhold = $("#htmlView").val();
                    document.getElementById("wrapper").innerHTML = innhold;
                    var resultat = rens(innhold);
                    var svar1 = "<ul><li>betterphysique</li><li>morefamous</li><li>coolername</li><li>handsomer</li><li>morebadass</li><li>betteractor</li></ul>";
                    var svar2 = "<ul><li>betterphysique</li><li>morefamous</li><li>coolername</li><li>handsomer</li><li>morebadass</li><li>newhaircut</li></ul>";
                    var svar3 = "<ul><li>betterphysique</li><li>morefamous</li><li>coolername</li><li>handsomer</li><li>morebadass</li><li>tougher</li></ul>";
                    
                    if(resultat === svar1){
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=2;
                        document.getElementById("poeng").value=count;
                    }
                    else if(resultat === svar2){
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=2;
                        document.getElementById("poeng").value=count;
                    }
                    else if(resultat === svar3){
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=2;
                        document.getElementById("poeng").value=count;
                    }
                   

                });
                
                $("#reset").click(function() {
                    $("#htmlView").val(startingHtml); 
                    $("#cssView").val(startingCss);
                    
                });
            });
            
            function finnDel(input){
                var a = input.indexOf(";"); 
                if(a!==-1){
                   var input = input.substring(0,a);
                }
                var lengde = input.length;
                var start = input.lastIndexOf(" ");
                var input = input.substring(start+1,lengde);
                return input;
            }
            
            function setRenderedResult(frame, html, css) {
                frame.contents().find("html").html(html);
                var $head = frame.contents().find("head");                
                $head.append("<style>" + css + "</style>") 
            }
            
            function rens(tekst){
                var lengde = tekst.length;
                var streng = "";
                for (i=0; i<lengde; i++){
                    if((i!==" ")||(i!=="\n")){
                        streng = streng + tekst.charAt(i);
                    }  
                }
                streng = streng.toLowerCase();
                streng = streng.replace(/\s+/g, '');
                return streng.replace(/(\r\n|\n|\r)/gm,"");
            }