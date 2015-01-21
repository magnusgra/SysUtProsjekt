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
                
                var solutionHtml = "<div id=\"tre\" title=\"tre\"></div>\n" +
                "<div id=\"bygning5\" class=\"bygninger\" title=\"bygg5\"></div>\n" +
                "<div id=\"gress\" title=\"gress\"></div>\n" +
                "<div id=\"vei\" title=\"asfalt\"></div>"; 
        
                var solutionCss = "";
                
                var startingHtml = "<div id=\"\" title=\"tre\"></div>\n" +
                "<div id=\"bygning5\" class=\"\" title=\"bygg5\"></div>\n" +
                "id=\"gress\" title=\"gress\"\n" +
                "<div id=\"\" title=\"asfalt\"></div>";
        
                var startingCss = "#tre {\n" +
                "position: absolute;\n" +
                "height: 274px;\n" +
                "width: 208px;\n" +
                "top: 37px;\n" +
                "right: 40px;\n" +
                "z-index: 1;\n" +
                "background-image: url(\"bilder/tre.png\");\n" +
                "}\n\n" +
                ".bygninger, #vei {\n" +
                    "background-color: #404040;\n" +
                    "position: absolute;\n" +
                    "z-index: 0;\n" +
                "}\n\n" +
                "#vei {\n" +
                    "height: 110px;\n" +
                    "width: 800px;\n" +
                    "bottom: 0px;\n" +
                "}\n\n" +
                ".bygninger {\n" +
                    "bottom: 190px;\n" +
                "}\n\n" +
                "#bygning5 {\n" +
                    "height: 125px;\n" +
                    "width: 125px;\n" +
                    "left: 175px;\n" +
                "}\n\n" +
                "#gress {\n" +
                    "height: 80px;\n" +
                    "width: 800px;\n" +
                    "position: absolute;\n" +
                    "top: 260px;\n" +
                    "left: 0px;\n" +
                    "z-index: 0;\n" +
                    "background-color: #bfcd9c;\n" +
                "}";
                
                $("#htmlView").val(startingHtml); 
                $("#cssView").val(startingCss); 
                
                
                $("#viewResult").click(function() {
                    var bygning = "<div id=\"bygning5\" class=\"bygninger\" title=\"bygg5\"></div>\n";
                    var tre = "<div id=\"tre\" title=\"tre\"></div>\n";
                    var vei = "<div id=\"vei\" title=\"asfalt\"></div>";
                    var gress = "<div id=\"gress\" title=\"gress\"></div>\n";
                    var innhold = $("#htmlView").val();
                    
                    if (innhold.indexOf(bygning)!== -1) {
                        $("#bygning5").css("z-index", "0"); 
                    }
                    if (innhold.indexOf(tre)!== -1) {
                        $("#tre").css("z-index", "1"); 
                    }
                    if (innhold.indexOf(vei)!== -1) {
                        $("#vei").css("z-index", "0"); 
                    }
                    if (innhold.indexOf(gress)!== -1) {
                        $("#gress").css("z-index", "0"); 
                    }
                    if ($("#htmlView").val() === solutionHtml) {
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=4;
                        document.getElementById("poeng").value=count;
                        document.cookie="bane=4";
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
                $head.append("<style>" + css + "</style>"); 
            }