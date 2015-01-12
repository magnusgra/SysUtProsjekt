(function () {
    var requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
    window.requestAnimationFrame = requestAnimationFrame;
})();

var canvas = document.getElementById("canvas"),
    ctx = canvas.getContext("2d"),
    width = 800,
    height = 450,
        
        spiller = {
        width:100,
        height:297,
        x: 10,
        y: height -850,
     
        speed: 5,
        velX: 0,
        velY: 0,
        jumping: false,
        grounded: false
    },
    keys = [],
    friction = 0.8,
    gravity = 0.3;

var boxes = [];
var wall = [];

// Grenser
boxes.push({            // Venstre grense
    x: 0,
    y: 0,
    width: 10,
    height: height
});
boxes.push({            // Nedre grense
    x: 0,
    y: height,
    width: width,
    height: 50
});
boxes.push({            // Høyre grense
    x: width,
    y: 0,
    width: 10,
    height: height
});
wall.push({             // Usynlig sperre
    x: 110,
    y: 0,
    width: 10,
    height: height    
});
        
// Laster inn bilde av Nic
var spillerBilde = new Image();
spillerBilde.onload = function () {
    spillerKlar = true;
};spillerBilde.src="bilder/nic.png";
    
canvas.width = width;
canvas.height = height;

function update() {
    
    // Sjekker tastetrykk 
    if (keys[38] || keys[32]) {
        
        // Pil-opp eller space
        if (!spiller.jumping && spiller.grounded) {
            spiller.jumping = true;
            spiller.grounded = false;
            spiller.velY = -spiller.speed * 1.5;
        }
    }
    if (keys[39]) {
        // Høyre-pil
        if (spiller.velX < spiller.speed) {
            spiller.velX++;
        }
    }
    if (keys[37]) {
        // Venstre-pil
        if (spiller.velX > -spiller.speed) {
            spiller.velX--;
        }
    }

    spiller.velX *= friction;
    spiller.velY += gravity;

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
    
     for (var i = 0; i < wall.length; i++) {
        ctx.rect(wall[i].x, wall[i].y, wall[i].width, wall[i].height);
      
        if(fargesjekk()==="t"){
            var vegg = colCheck(spiller, wall[i]);
        

        if (vegg === "l" || vegg === "r") {
            spiller.velX = 0;
            spiller.jumping = false;
            } else if (vegg === "b") {
                spiller.grounded = true;
                spiller.jumping = false;
            } else if (vegg === "t") {
                spiller.velY *= -1;
            }
        }
    }
    
    if(spiller.grounded){
         spiller.velY = 0;
    }
    
    spiller.x += spiller.velX;
    spiller.y += spiller.velY;

    ctx.fill();
    ctx.drawImage(spillerBilde, spiller.x, spiller.y-35, 100, 297);

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