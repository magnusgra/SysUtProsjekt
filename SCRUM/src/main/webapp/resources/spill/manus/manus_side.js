$(document).ready(function() {
                           $("#cssView").keydown(function (e) {
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
                    count = count - 1;
                    if (count < 10) {
                        count = 10;
                        clearInterval(counter);
                        return;
                    }
                    if (count < 300) {
                        document.getElementById("timer").innerHTML = count + " poeng";
                    } else {
                        document.getElementById("timer").innerHTML = 300 + " poeng";
                    }
                }      
                
                var solutionHtml = ""; 
                var solutionCss = "";
                
                var oppgavetekst1 = "Steven har kludret til manuset. Han har laget forskjellige farger på alle elementene og høyrestilt teksten. Nic får vondt i hodet av å prøve å lese det. Velg overskrift og paragraf, gi alle fargen sort, venstrestill og sett fargen på bakgrunnen til #f8f5f0, slik at Nic får ro i sjela.";
                var oppgavetekst2 = "Steven har kludret til manuset. Han har laget forskjellige farger på alle elementene og høyrestilt teksten. Nic får vondt i hodet av å prøve å lese det. Velg overskrift og paragraf, gi alle fargen blå, midtstill og sett fargen på bakgrunnen til #f8f5f0, slik at Nic får ro i sjela.";
                var oppgavetekst3 = "Steven har kludret til manuset. Han har laget forskjellige farger på alle elementene og høyrestilt teksten. Nic får vondt i hodet av å prøve å lese det. Velg overskrift og paragraf, gi alle fargen sort, midtstill og sett fargen på bakgrunnen til #f8f5f0, slik at Nic får ro i sjela.";
                
                var startingHtml = "<div id =\"manus\">\n"+
                "<h1>\"Wraith Rider\"</h1>\n"+
                "<p>\n" + 
                "\“I did a bald rump 360 triple back flip in the forefront of twenty two thousand human beings. It’s sort of amusing, it’s on Youtube, check it out. But when my father got ill, I did something way madder than that.\”\n" + 
                "</p>\n" +
                "</div>";
                        
        
                var startingCss =   "#manus {\n"+
                                    "background-color: red;\n"+
                                    "text-align: right;\n"+
                                    "}\n"+
                                    "#manus p {\n"+
                                    "color: green;\n"+
                                    "}\n"+
                                    "#manus h1 {\n"+
                                    "color: blue;\n"+
                                    "}";
                
                //setRenderedResult($("#solutionFrame"), solutionHtml, solutionCss);

                $("#htmlView").val(startingHtml); 
                $("#cssView").val(startingCss); 
                var random = Math.floor((Math.random() * 3) + 1);
                if(random===1){
                    document.getElementById("oppgavetekst").innerHTML = oppgavetekst1;
                }
                else if(random===2){
                    document.getElementById("oppgavetekst").innerHTML = oppgavetekst2;
                }
                else if(random===3){
                    document.getElementById("oppgavetekst").innerHTML = oppgavetekst3;
                }
                
                
                $("#viewResult").click(function() {
                    
                    var innhold = $("#cssView").val();
                    var bakgrunn = finnDel(innhold.substring(innhold.indexOf("background-color:")+17, innhold.indexOf("background-color:")+27));
                    var align = finnDel(innhold.substring(innhold.indexOf("text-align:")+11, innhold.indexOf("text-align:")+18));
                    var color1 = finnDel(innhold.substring(innhold.indexOf("#manus p {\ncolor:")+17, innhold.indexOf("#manus p {\ncolor:")+27));
                    var color2 = finnDel(innhold.substring(innhold.indexOf("#manus h1 {\ncolor:")+18, innhold.indexOf("#manus h1 {\ncolor:")+28));
                    
                    $("#manus").css("background-color", bakgrunn);
                    $("#manus").css("text-align", align);
                    $("#manus p").css("color", color1);
                    $("#manus h1").css("color", color2);
                    
                    if((bakgrunn.toLowerCase()==="#f8f5f0")&& align.toLowerCase()==="left" && (color1.toLowerCase()==="black"||color1==="#000000") && (color2.toLowerCase()==="black"||color2==="#000000")&&(random===1)){
                       $("#box").css("background-color", "green");
                       
                       clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=7;
                        document.getElementById("poeng").value=count;
                        document.cookie="bane=7";
                    }
                    else if((bakgrunn.toLowerCase()==="#f8f5f0")&& align.toLowerCase()==="center" && (color1.toLowerCase()==="blue"||color1==="#0000ff") && (color2.toLowerCase()==="blue"||color2==="#0000ff")&&(random===2)){
                       $("#box").css("background-color", "green");
                       
                       clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=7;
                        document.getElementById("poeng").value=count;
                        document.cookie="bane=7";
                    }
                    
                    else if((bakgrunn.toLowerCase()==="#f8f5f0")&& align.toLowerCase()==="center" && (color1.toLowerCase()==="black"||color1==="#000000") && (color2.toLowerCase()==="black"||color2==="#000000")&&(random===3)){
                       $("#box").css("background-color", "green");
                       
                       clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=7;
                        document.getElementById("poeng").value=count;
                        document.cookie="bane=7";
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
                $head.append("<style>" + css + "</style>"); 
            }