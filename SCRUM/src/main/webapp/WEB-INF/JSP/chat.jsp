<%-- 
    Document   : chat
    Created on : 20.jan.2015, 23:18:34
    Author     : arnecs
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>Nic and Steven</title>
     
    <!-- Bootstrap -->
         <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
         
         
         
         <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
    <style type="text/css">
        
        input#chat {
            width: 100%;
            margin: 0 auto;
            background: #white;
            color: #555555;
            border-left: none;
            border-bottom: none;
            border-right: none;
        }
        
        input#chat:focus {
            outline: none;
        }

        #console-container {
            position: relative;
            width: 100%;
            height: 350px;
            margin: 0 auto;
            
            
        }

        #chat-user-list {
            position: absolute;
            top: 0;
            right: 0;
            margin: 0 auto;
            
            height: 100%;
            overflow-y: scroll;
            
            float: right;
            width: 25%;
            background: #ffffff;
            color: #555555;
            text-align: left;
            
            border-left: 1px solid #ccc;
            
        }
        
        
        
        #console {
            
            margin: 0 auto;
            
            height: 100%;
            overflow-y: scroll;
            float: left;
            width: 75%;
            background: #ffffff;
            color: #555555;
            text-align: left;
        }

        p {
            margin: 0 auto;
            padding: 0 12px;
            
            
        }
        
        p:nth-child(2n) {
            background: #fefefe;
        }
        p:nth-child(2n + 1) {
            background: #fcfcfc;
        }
        
        
    </style>
    <script>
        "use strict";

        var Chat = {};

        Chat.socket = null;

        Chat.connect = (function(host) {
            if ('WebSocket' in window) {
                Chat.socket = new WebSocket(host);
            } else if ('MozWebSocket' in window) {
                Chat.socket = new MozWebSocket(host);
            } else {
                Console.log('Error: WebSocket er ikke støttet av nettleseren.');
                return;
            }

            Chat.socket.onopen = function () {
                //Console.log('Info: WebSocket connection opened.');
                
                Chat.socket.send("-addUser:${brukerdata.fornavn}");
                
              
                
                
                document.getElementById('chat').onkeydown = function(event) {
                    if (event.keyCode == 13) {
                        Chat.sendMessage();
                    }
                };
               
            };

            Chat.socket.onclose = function () {
                document.getElementById('chat').onkeydown = null;
                Console.log('Info: Chatten er lukket.');
            };

            Chat.socket.onmessage = function (message) {
                Console.log(message.data);
            };
        });

        Chat.initialize = function() {          
            if (window.location.protocol == 'http:') {
                Chat.connect('ws://' + window.location.host + '/database/chat');
            } else {
                Chat.connect('wss://' + window.location.host + '/database/chat');
            }
            Chat.users = [];
        };

        Chat.sendMessage = (function() {
            var message = ' ' + document.getElementById('chat').value.trim();
            if (message !== ' ') {
                Chat.socket.send(message);
                document.getElementById('chat').value = '';
            }
        });

        var Console = {};

        Console.log = (function(message) {
            
           
            if (message.substring(0,7) === "-setUL:") {
                var usernames = message.substring(7, message.length);
              
                document.getElementById('chat-user-list').innerHTML = usernames;
              
            } else {
                var console = document.getElementById('console');
                var p = document.createElement('p');
                p.style.wordWrap = 'break-word';
                p.innerHTML = message;
                console.appendChild(p);
                
                
                while (console.childNodes.length > 25) {
                    console.removeChild(console.firstChild);
                }
                console.scrollTop = console.scrollHeight;
            }
        });

        Chat.initialize();


        document.addEventListener("DOMContentLoaded", function() {
            // Remove elements with "noscript" class - <noscript> is not allowed in XHTML
            var noscripts = document.getElementsByClassName("noscript");
            for (var i = 0; i < noscripts.length; i++) {
                noscripts[i].parentNode.removeChild(noscripts[i]);
            }
        }, false);
        

         

    </script>
    
   
</head>
<body>
    
    <div class="navbar navbar-default">
    	<div class="container">
            <a href="Home" class = "navbar-brand"><img id="nas-logo" src="<c:url value="/resources/bilder/nicandsteven.png"/>" /></a>
    		<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>

    		<div class="collapse navbar-collapse navHeaderCollapse">
    			
    			<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="<c:url value='/Hjem'/>">Hjem</a></li>
                                <li ><a href="<c:url value='/Spill'/>">Spill</a></li>
                                <li class="active"><a href="<c:url value='/Chat'/>">Chat</a></li>
    				<li><a href="<c:url value='/Highscore'/>">Se Highscore</a></li>
    				<li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Min Side<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="<c:url value='/MinSide/EndrePassord'/>" >Endre Passord</a>
                                        </li>
                                        <li>
                                            <a href="<c:url value='MinSide/Godkjenningsliste' />" >Godkjenningsliste</a>
                                        </li>
                                    </ul>
                                </li>
    				<li><a href="<c:url value='/LoggUt' />">Logg ut</a></li>
    			</ul>
                        <a href="http://hist.no"><img src="<c:url value='/resources/bilder/HIST_logo_farge_liten.png' />" width="50" id="histLogo"/></a>
    		</div>
        </div>
    </div>
    
    
    
<div class="noscript">
    <h2 style="color: #ff0000">
        Seems your browser doesn't support Javascript! Websockets rely on Javascript being enabled. Please enable
        Javascript and reload this page!
    </h2>
</div>
<div class="chat-container">
    <h1>Chat</h1>
    <center>
    <div id="console-container">
        <div id="console"></div>
        <div id="chat-user-list"></div>
    </div>
    
        <input type="text" placeholder="Skriv og trykk enter for å chatte" id="chat" />
    
    </center>
</div>
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js' />"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
    
    
    
</body>
</html>
