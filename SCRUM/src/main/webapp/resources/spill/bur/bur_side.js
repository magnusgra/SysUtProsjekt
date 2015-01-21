$(document).ready(function () {

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

    var startingHtml = "<div id=\"Bur\"></div>";

    var oppgavetext1 = "The Cage has been caged! Steven har fanget stakkars Nic i et bur. Fiks på CSS koden slik at buret løftes opp og Nic kommer seg fri.";
    var oppgavetext2 = "The Cage has been caged! Steven har fanget stakkars Nic i et bur. Fiks på CSS koden slik at buret blir usynlig og Nic kommer seg fri.";
    var oppgavetext3 = "The Cage has been caged! Steven har fanget stakkars Nic i et bur. Fiks på CSS koden slik at buret forsvinner i bakgrunnen og Nic kommer seg fri.";



    var startingCss1 = "#Bur {\n" +
            "position: absolute;\n" +
            "height: 502px;\n" +
            "width: 156px;\n" +
            "bottom: 10px;\n" +
            "left: 115px;\n" +
            "background-image: url('bilder/bur.png')\n" +
            "}";

    var startingCss2 = "#Bur {\n" +
            "position: absolute;\n" +
            "height: 502px;\n" +
            "width: 156px;\n" +
            "left: 115px;\n" +
            "opacity: 1;\n" +
            "background-image: url('bilder/bur.png')\n" +
            "}";
    var startingCss3 = "#Bur {\n" +
            "position: absolute;\n" +
            "height: 502px;\n" +
            "width: 156px;\n" +
            "left: 115px;\n" +
            "background-image: url('bilder/bur.png')\n" +
            "z-index: 1;\n" +
            "}";

    var random = Math.floor((Math.random() * 3) + 1);
    var oppgave;
    var losning;

    if (random === 1) {
        oppgave = startingCss1;
        document.getElementById("oppgavetekst").innerHTML = oppgavetext1;

    }
    else if (random === 2) {
        oppgave = startingCss2;
        document.getElementById("oppgavetekst").innerHTML = oppgavetext2;
    }
    else if (random === 3) {
        oppgave = startingCss3;
        document.getElementById("oppgavetekst").innerHTML = oppgavetext3;

    }

    $("#htmlView").val(startingHtml);
    $("#cssView").val(oppgave);


    $("#viewResult").click(function () {
        var innhold = $("#cssView").val();
        if (random === 1) {
            var streng = innhold.substring(innhold.indexOf("bottom:") + 7, innhold.indexOf("bottom:") + 14);

            var p = streng.indexOf("p");
            var ferdigStreng = "";
            var intStrengen = 0;
            if (p !== -1) {
                var ferdigStreng = streng.substring(0, p);
            }
        }
        else if (random === 2) {

            var streng = innhold.substring(innhold.indexOf("opacity:") + 8, innhold.indexOf("opacity:") + 14);

            var p = streng.indexOf(";");
            var ferdigStreng = "";
            var intStrengen = 0;
            if (p !== -1) {
                var ferdigStreng = streng.substring(0, p);
            }
        }
        else if (random === 3) {

            var streng = innhold.substring(innhold.indexOf("z-index:") + 8, innhold.indexOf("z-index:") + 14);

            var p = streng.indexOf(";");
            var ferdigStreng = "";
            var intStrengen = 0;
            if (p !== -1) {
                var ferdigStreng = streng.substring(0, p);
            }
        }



        intStrengen = parseInt(ferdigStreng);




        if (random === 1 && ferdigStreng > 239) {
            $("#box").css("background-color", "green");

            clearInterval(counter);
            if (count > 300) {
                count = 300;
            }
            window.alert("Gratulerer! Du fikk: " + count + " poeng.");

            $("#cage").css("bottom", intStrengen + "px");
            document.getElementById("bane").value=6;
            document.getElementById("poeng").value=count;
                        

        }
        else if (random === 1 && ferdigStreng > 10 && ferdigStreng < 240) {
            $("#cage").css("bottom", intStrengen + "px");
        }
        else if (random === 2 && ferdigStreng <= 0) {
            $("#box").css("background-color", "green");

            clearInterval(counter);
            if (count > 300) {
                count = 300;
            }
            window.alert("Gratulerer! Du fikk: " + count + " poeng.");
            $("#cage").css("opacity", intStrengen);
            document.getElementById("bane").value=6;
            document.getElementById("poeng").value=count;
        }
        else if (random === 3 && ferdigStreng < 0) {
            $("#box").css("background-color", "green");

            clearInterval(counter);
            if (count > 300) {
                count = 300;
            }
            window.alert("Gratulerer! Du fikk: " + count + " poeng.");
            $("#cage").css("z-index", intStrengen);
            document.getElementById("bane").value=6;
            document.getElementById("poeng").value=count;
        }

        else if (random === 1 && ferdigStreng < 10) {

        }
        else {
            $("#cage").css("bottom", intStrengen + "px");
        }
    });

    $("#reset").click(function () {
        $("#htmlView").val(startingHtml);
        $("#cssView").val(oppgave);

    });
});


function setRenderedResult(frame, html, css) {
    frame.contents().find("html").html(html);
    var $head = frame.contents().find("head");
    $head.append("<style>" + css + "</style>")
}

function finnDel(input) {
    var a = input.indexOf(";");
    if (a !== -1) {
        var input = input.substring(0, a);
    }
    var lengde = input.length;
    var start = input.lastIndexOf(" ");
    var input = input.substring(start + 1, lengde);
    var px = "";
    if (input.indexOf("p") !== -1) {
        input = input.substring(0, input.indexOf("p"));
    }
    return input;
}
    