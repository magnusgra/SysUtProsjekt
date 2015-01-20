(function () {
    var requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
    window.requestAnimationFrame = requestAnimationFrame;
})();

var canvas = document.getElementById("canvas"),
    ctx = canvas.getContext("2d"),
    width = 800,
    height = 450,
        
        spiller = {
        width:40,
        height:90,
        x: 80,
        y: 15,
     
        speed: 2,
        velX: 0,
        velY: 0,
        jumping: false,
        grounded: false
    },
    keys = [];
   // friction = 0.8,
   // gravity = 0.3;

var boxes = [];
var wall = [];

// Grenser
boxes.push({             // Øvre kartgrense
    x: 0,
    y: 0,
    width: width,
    height: 5    
});
boxes.push({             // Nedre kartgrense
    x: 0,
    y: height-30,
    width: width,
    height: 10    
});
boxes.push({            // Høyre kartgrense
    x: width-20,
    y: 0,
    width: 10,
    height: height
});
boxes.push({            // Venstre vei til første nivå
    x: 60,
    y: 0,
    width: 10,
    height: 250
});
boxes.push({             // Høyre vei til første nivå
    x: 110,
    y: 0,
    width: 10,
    height: 165    
});
boxes.push({             // Øvre vei mellom første og andre nivå
    x: 110,
    y: 155,
    width: 270,
    height: 10    
});
boxes.push({            // Nedre vei mellom første og andre nivå
    x: 60,
    y: 255,
    width: 185,
    height: 10
});
boxes.push({            // Nedre vei etter andre nivå
    x: 290,
    y: 255,
    width: 90,
    height: 10
});
boxes.push({             // Høyre vei etter andre nivå
    x: 390,
    y: 80,
    width: 10,
    height: 250    
});
boxes.push({            // Venstre vei mellom andre og tredje nivå
    x: 235,
    y: 260,
    width: 10,
    height: 180
});
boxes.push({            // Høyre vei mellom andre og tredje nivå
    x: 290,
    y: 260,
    width: 10,
    height: 70
});
boxes.push({            // Øvre vei mellom tredje og fjerde nivå
    x: 291,
    y: 320,
    width: 295,
    height: 10
});
boxes.push({            // Høyre vei mellom tredje og fjerde nivå
    x: 627,
    y: 360,
    width: 10,
    height: 50
});
boxes.push({            // Nedre vei mellom fjerde og femte nivå
    x: 650,
    y: 360,
    width: 90,
    height: 10
});
boxes.push({            // Venstre vei mellom femte nivå og nedre grense
    x: 730,
    y: 360,
    width: 10,
    height: 50
});
boxes.push({            // Øvre vei mellom fjerde og femte nivå
    x: 600,
    y: 255,
    width: 140,
    height: 10
});
boxes.push({            // Venstre vei mellom femte og sjette nivå
    x: 730,
    y: 95,
    width: 10,
    height: 120
});
boxes.push({            // Nedre vei mellom sjette og syvende nivå
    x: 440,
    y: 95,
    width: 280,
    height: 10
});
boxes.push({            // Venstre vei etter åttende nivå
    x: 440,
    y: 95,
    width: 10,
    height: 230
});
        
// Laster inn bilde av Nic
var spillerBilde = new Image();
spillerBilde.onload = function () {
    spillerKlar = true;
};spillerBilde.src="../bilder/littlenic.png";
    
canvas.width = width;
canvas.height = height;


function update() {
    
    // Sjekker tastetrykk 
    if (keys[38]) {
        // Pil-opp eller space
        spiller.y -= spiller.speed;
    }
    if (keys[39]) {
        // Høyre-pil
        spiller.x += spiller.speed;
        
    }
    if (keys[37]) {
        // Venstre-pil
        spiller.x -= spiller.speed;
        
    }
    
    if (keys[40]) { // Player holding down
	spiller.y += spiller.speed;
    }

    

   // spiller.velX *= friction;
   // spiller.velY += gravity;

    // Tegner inn grensene rundt spillvinduet, og gjør dem usynlig
    ctx.clearRect(0, 0, width, height);
    ctx.fillStyle = "transparent";
    ctx.beginPath();
    
    spiller.grounded = false;

    for (var i = 0; i < boxes.length; i++) {
        ctx.rect(boxes[i].x, boxes[i].y, boxes[i].width, boxes[i].height);
        
        var dir = colCheck(spiller, boxes[i]);
        
        if (dir === "l" || dir === "r") {
            spiller.velX = 0;
            spiller.jumping = false;
        } else if (dir === "b") {
            spiller.grounded = true;
            spiller.jumping = false;
        } else if (dir === "t") {
            spiller.velY *= -1;
        }

    }
    
    // Level 1
    if (spiller.x > 69 && spiller.x < 80 && spiller.y > 150) {
        document.getElementById("start").setAttribute("href", "../hinder/hinder.jsp");
        $("#start").css("opacity", "100");
    }
    // Level 2
    else if (spiller.x > 230 && spiller.x < 270 && spiller.y < 190) {
        document.getElementById("start").setAttribute("href", "../liste/liste.jsp");
        $("#start").css("opacity", "100");
    }
    // Level 3
    else if (spiller.x > 230 && spiller.x < 270 && spiller.y > 310) {
        document.getElementById("start").setAttribute("href", "../tiger/tiger.jsp");
        $("#start").css("opacity", "100");
    }
    // Level 4
    else if (spiller.x > 570 && spiller.x < 610 && spiller.y < 290 && spiller.y > 250) {
        document.getElementById("start").setAttribute("href", "../mismatch/mismatch.jsp");
        $("#start").css("opacity", "100");
    }
    // Level 5
    else if (spiller.x > 720 && spiller.y > 250 && spiller.y < 290) {
        document.getElementById("start").setAttribute("href", "../linker/linker.jsp");
        $("#start").css("opacity", "100");
    }
    // Level 6
    else if (spiller.x > 720 && spiller.y < 30) {
        document.getElementById("start").setAttribute("href", "../bur/bur.jsp");
        $("#start").css("opacity", "100");
    }
    // Level 7
    else if (spiller.x > 540 && spiller.x < 580 && spiller.y < 50) {
        document.getElementById("start").setAttribute("href", "../manus/manus.jsp");
        $("#start").css("opacity", "100");
    }
    // Level 8
    else if (spiller.x > 380 && spiller.x < 430 && spiller.y < 50) {
        document.getElementById("start").setAttribute("href", "../form/formLevel.jsp");
        $("#start").css("opacity", "100");
    }
    else {
        $("#start").css("opacity", "0");
        document.getElementById("start").setAttribute("href", "#");
    }
    
    if(spiller.grounded){
         spiller.velY = 0;
    }
    
    spiller.x += spiller.velX;
    spiller.y += spiller.velY;

    ctx.fill();
    ctx.drawImage(spillerBilde, spiller.x, spiller.y);

    requestAnimationFrame(update);
}

function fargesjekk(){
    var a;
    var b;
    var c;
    c="(#FF0000)";
    a=farge();
    b="rgb(255, 0, 0)";
    if(a===b){
        sjekk="t";
    }
    else{
        sjekk="f";
    }
    
    return sjekk;
}

// Kollisjonssjekk
function colCheck(shapeA, shapeB) {
    // get the vectors to check against
    var vX = (shapeA.x + (shapeA.width / 2)) - (shapeB.x + (shapeB.width / 2)),
        vY = (shapeA.y + (shapeA.height / 2)) - (shapeB.y + (shapeB.height / 2)),
        // add the half widths and half heights of the objects
        hWidths = (shapeA.width / 2) + (shapeB.width / 2),
        hHeights = (shapeA.height / 2) + (shapeB.height / 2),
        colDir = null;

    // if the x and y vector are less than the half width or half height, they we must be inside the object, causing a collision
    if (Math.abs(vX) < hWidths && Math.abs(vY) < hHeights) {
        // figures out on which side we are colliding (top, bottom, left, or right)
        var oX = hWidths - Math.abs(vX),
            oY = hHeights - Math.abs(vY);
        if (oX >= oY) {
            if (vY > 0) {
                colDir = "t";
                shapeA.y += oY;
            } else {
                colDir = "b";
                shapeA.y -= oY;
            }
        } else {
            if (vX > 0) {
                colDir = "l";
                shapeA.x += oX;
            } else {
                colDir = "r";
                shapeA.x -= oX;
            }
        }
    }
    return colDir;
}

function farge(){
    var e=document.getElementById('box');
    var cs=document.defaultView.getComputedStyle(e,null);
    var bg=cs.getPropertyValue('background-color');
    return bg;
    
}
document.body.addEventListener("keydown", function (e) {
    keys[e.keyCode] = true;
});

document.body.addEventListener("keyup", function (e) {
    keys[e.keyCode] = false;
});


window.addEventListener("load", function () {
    update();
  
});
