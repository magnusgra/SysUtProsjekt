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
                
                var solutionHtml = ""; 
                var solutionCss = "";
                
                var startingHtml = "<div id=\"tiger\"></div>";
                        
        
                var startingCss =   "#tiger {\n"+
                                    "position: absolute;\n"+
                                    "width: 300px;        \n"+
                                    "left: 0;\n"+
                                    "bottom: 0;\n"+
                                    "}";
                
                //setRenderedResult($("#solutionFrame"), solutionHtml, solutionCss);

                $("#htmlView").val(startingHtml); 
                $("#cssView").val(startingCss); 
                
                
                
                $("#viewResult").click(function() {
                    
                    var innhold = $("#cssView").val();
                    
                    var bredde = finnDel(innhold.substring(innhold.indexOf("width:")+6, innhold.indexOf("width:")+12));
                    $("#wrapper img").css("width", bredde+"px");
                    
                    if (parseInt(bredde)<50) {
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=3;
                        document.getElementById("poeng").value=count;
                        document.cookie="bane=3";
                        
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