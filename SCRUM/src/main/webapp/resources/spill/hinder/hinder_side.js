$(document).ready(function() {
                
                var count = 310;
                var counter = setInterval(timer, 1000);
                
                function timer() {
                    count=count-1;
                    if (count < 10) {
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
                
                var startingCss = 
                            "#soppel {\n"+
                            "z-index: 0;\n"+
                            "margin-top:225px;\n"+
                            "}\n";
        
                var startingHtml = "<div id=\"soppel\"></div>";
                
                //setRenderedResult($("#solutionFrame"), solutionHtml, solutionCss);

                $("#htmlView").val(startingHtml); 
                $("#cssView").val(startingCss); 
                
                
                
                $("#viewResult").click(function() {
                    
                    var innhold = $("#cssView").val();
                    var z = finnDel(innhold.substring(innhold.indexOf("z-index:")+8, innhold.indexOf("z-index:")+12));
                    var margin = finnDel(innhold.substring(innhold.indexOf("margin-top:")+11, innhold.indexOf("margin-top:")+19));
                    
                    $("#soppel").css("z-index", z);
                    $("#soppel").css("margin-top", margin+"px");

                    if((margin.lastIndexOf("-")!==-1)||(margin>650)||(z.lastIndexOf("-")!==-1)){
                        $("#box").css("background-color", "green");
                        
                        clearInterval(counter);
                        if (count > 300) {
                            count = 300;
                        }
                        window.alert("Gratulerer! Du fikk: " +count+ " poeng.");
                        document.getElementById("bane").value=1;
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
                var px = "";
                if(input.indexOf("p")!== -1){
                    input = input.substring(0, input.indexOf("p"));
                }
                return input;
            }
            
            function setRenderedResult(frame, html, css) {
                frame.contents().find("html").html(html);
                var $head = frame.contents().find("head");                
                $head.append("<style>" + css + "</style>") 
            }