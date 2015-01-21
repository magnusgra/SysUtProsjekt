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
               
               var oppgavetekst1 = "Nic har rotet seg litt bort på denne kompliserte veien og vet ikke helt hvor han har vært (han har besøkt tre av de fire linkene). Gi besøkte linker fargen lilla (purple). Den ubesøkte linken vil da angi veien videre.";
               var oppgavetekst2 = "Nic har rotet seg litt bort på denne kompliserte veien og vet ikke helt hvor han har vært (han har besøkt tre av de fire linkene). Gi besøkte linker fargen grønn (green). Den ubesøkte linken vil da angi veien videre.";
               var oppgavetekst3 = "Nic har rotet seg litt bort på denne kompliserte veien og vet ikke helt hvor han har vært (han har besøkt tre av de fire linkene). Gi besøkte linker fargen gul (yellow). Den ubesøkte linken vil da angi veien videre.";
               
                var solutionHtml = "<div id=\"link1\" class=\"linker\">" + 
                    "<a href=\"http://www.w3schools.com\" target=\"_blank\">Vært her?</a>" + 
                    "</div>\n" +
                    "<div id=\"link2\" class=\"linker\">" + 
                    "<a href=\"http://www.github.com\" target=\"_blank\">Enn her?</a>" + 
                    "</div>\n" +
                    "<div id=\"link3\" class=\"linker\">" + 
                    "<a href=\"http://www.http://www.reddit.com/r/learnprogramming\" target=\"_blank\">Her da?</a>" + 
                    "</div>\n" +
                    "<div id=\"link4\" class=\"linker\">" + 
                    "<a href=\"http://www.w3.org/TR/html5/\" target=\"_blank\">Her?</a>" + 
                    "</div>";
                var solutionCss = ".linker {\n" + 
                    "color: white;\n" +
                    "}\n" + 
                    "a {\n" + 
                    "color: white;\n" +
                    "text-decoration: none;\n" +
                    "}\n" +
                    "a:active {\n" + 
                    "}\n" +
                    "a:visited {\n" + 
                    "color: purple;\n" +
                    "}\n" + 
                    "a:hover {\n" + 
                    "}";
                var solutionCss2 = ".linker {\n" + 
                    "color: white;\n" +
                    "}\n" + 
                    "a {\n" + 
                    "color: white;\n" +
                    "text-decoration: none;\n" +
                    "}\n" +
                    "a:active {\n" + 
                    "}\n" +
                    "a:visited {\n" + 
                    "color:purple;\n" +
                    "}\n" + 
                    "a:hover {\n" + 
                    "}";
                
                var startingHtml = "<div id=\"link1\" class=\"linker\">" + 
                    "<a href=\"http://www.w3schools.com\" target=\"_blank\">Vært her?</a>" + 
                    "</div>\n" +
                    "<div id=\"link2\" class=\"linker\">" + 
                    "<a href=\"http://www.github.com\" target=\"_blank\">Enn her?</a>" + 
                    "</div>\n" +
                    "<div id=\"link3\" class=\"linker\">" + 
                    "<a href=\"http://www.reddit.com/r/learnprogramming\" target=\"_blank\">Her da?</a>" + 
                    "</div>\n" +
                    "<div id=\"link4\" class=\"linker\">" + 
                    "<a href=\"http://www.w3.org/TR/html5/\" target=\"_blank\">Her?</a>" + 
                    "</div>";
        
                var startingCss = ".linker {\n" + 
                    "color: white;\n" +
                    "}\n" + 
                    "a {\n" + 
                    "color: white;\n" +
                    "text-decoration: none;\n" +
                    "}\n" +
                    "a:active {\n" + 
                    "}\n" +
                    "a:hover {\n" + 
                    "}\n"+
                    "a:visited {\n" + 
                    "}";
                
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
                    var farge = finnDel(innhold.substring(innhold.lastIndexOf("color:")+6, innhold.lastIndexOf("color:")+20));
                    $(".lilla").css("color", farge);
                    if((farge.toLowerCase() === "purple")&&(random===1)){
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=5;
                        document.getElementById("poeng").value=count;
                    }
                    else if(((farge.toLowerCase() === "green")||(farge.toLowerCase() === "#00ff00"))&&(random===2)){
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=5;
                        document.getElementById("poeng").value=count;
                    }
                    else if(((farge.toLowerCase() === "yellow")||(farge.toLowerCase() === "#ffff00"))&&(random===3)){
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=5;
                        document.getElementById("poeng").value=count;
                    }
                    
                    
                });
                
                $("#reset").click(function() {
                    $("#htmlView").val(startingHtml); 
                    $("#cssView").val(startingCss);
                    
                });
            });
            
            function setRenderedResult(frame, html, css) {
                frame.contents().find("html").html(html);
                var $head = frame.contents().find("head");                
                $head.append("<style>" + css + "</style>") 
            }
            
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