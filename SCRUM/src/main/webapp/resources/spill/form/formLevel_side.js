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
                       clearInterval(counter);
                       count = 10;
                       return;
                    }
                    if (count < 300) {
                    document.getElementById("timer").innerHTML=count + " poeng";
                    } else {
                        document.getElementById("timer").innerHTML = 300 + " poeng";
                    }
                }
                
                var solutionHtml1 ="<form id=\"form\">\n"+
                "Fornavn:<input type=\"text\"><br />\n"+
                "Etternavn:<input type=\"text\"><br />\n"+
                "Alder:<input type=\"number\" min=\"0\" max=\"99\"><br />\n"+
                "<input type=\"submit\" value=\"submit\">\n"+
                "</form>";
        
                 var solutionHtml2 ="<form id=\"form\">\n"+
                "Fornavn:<input type=\"text\" required><br />\n"+
                "Etternavn:<input type=\"text\"><br />\n"+
                "Alder:<input type=\"number\" min=\"0\" max=\"99\"><br />\n"+
                "<input type=\"submit\" value=\"Send inn\">\n"+
                "</form>";
        
                var solutionHtml3 ="<form id=\"form\">\n"+
                "Fornavn:<input type=\"text\" required><br />\n"+
                "Etternavn:<input type=\"text\"><br />\n"+
                "Alder:<input type=\"number\" min=\"0\" max=\"99\"><br />\n"+
                "<input type=\"submit\" value=\"submit\">\n"+
                "</form>";
                var solutionCss = "";
                
                var startingHtml1 = "<form id=\"\">\n"+
                "Fornavn:<input type=\"\"><br />\n"+
                "Etternavn:<br />\n"+
                "Alder:<input type=\"\" min=\"0\" max=\"99\"><br />\n"+
                "<input type=\"\" value=\"submit\">\n"+
                "<>";
                var startingHtml2 = "<form id=\"\">\n"+
                "Fornavn:<required><br />\n"+
                "Etternavn:<input type=\"\"><br />\n"+
                "Alder:<input type=\"\" min=\"0\" max=\"99\"><br />\n"+
                "<input type=\"\" value=\"Send inn\">\n"+
                "<>";
                var startingHtml3 = "<form id=\"\">\n"+
                "Fornavn:<input type=\"\" required><br />\n"+
                "Etternavn:<br />\n"+
                "Alder:input type=\"\" min=\"0\" max=\"99\"><br\n"+
                "<input type=\"\" value=\"submit\">\n"+
                "<>";
        
                var startingCss = "#form {\n"+
                "position: absolute;\n"+
                "left: 250px;\n"+
                "top: 200px;\n"+
                "}\n"+
                "#form.input {\n"+
                "background-color: white;\n"+
                "}";
                
                var random= Math.floor((Math.random()*3)+1);
                var oppgave;
                var losning;
                
               if(random===1){
                   oppgave=startingHtml1;
                   losning=solutionHtml1;
               }
               else if(random===2){
                   oppgave=startingHtml2;
                   losning=solutionHtml2;
               }
               else if(random===3){
                   oppgave=startingHtml3;
                   losning=solutionHtml3;
               }
                $("#htmlView").val(oppgave); 
                $("#cssView").val(startingCss); 
                
                
                $("#viewResult").click(function() {
                    
                    if ($("#htmlView").val() === losning) {
                        $("#form").css("z-index", "1");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=8;
                        document.getElementById("poeng").value=count;
                        document.cookie="bane=8";
                    }
                });
                
                $("#reset").click(function() {
                    $("#htmlView").val(oppgave); 
                    $("#cssView").val(startingCss);
                    
                });
            });
         
            
            function setRenderedResult(frame, html, css) {
                frame.contents().find("html").html(html);
                var $head = frame.contents().find("head");                
                $head.append("<style>" + css + "</style>"); 
            }
            
           function doSomething(){
               alert("Prepare for battle!");
               window.location.assign("../boss/boss.html");
           } 
            