/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.team1.proj.chatoppsett;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;


import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/chat")
public class ChatAnnotation {

    //private static final Log log = LogFactory.getLog(ChatAnnotation.class);

    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private static final Set<ChatAnnotation> connections =
            new CopyOnWriteArraySet<>();

    private String nickname;
    private Session session;
    
    
    public ChatAnnotation() {
        System.out.println("ChatAnnotation");
       
    }


    @OnOpen
    public void start(Session session) {
        this.session = session;
        
        
        connections.add(this);
        String message = String.format("-addUser:"+nickname);
       // broadcast(message);
    }


    @OnClose
    public void end() {
        connections.remove(this);
        String msg = "-setUL:";
            for (ChatAnnotation ca : connections) {
                msg += "<p>" + filter(ca.nickname) + "</p>";
                
            }
        broadcast(msg);
    }


    @OnMessage
    public void incoming(String message) {
        
        if (message.startsWith("-addUser:")){
            nickname = message.substring(9);
            String msg = "-setUL:";
            for (ChatAnnotation ca : connections) {
                msg += "<p>" + ca.nickname + "</p>";
                
            }
            broadcast(msg);
        } else {
            // Never trust the client
            String filteredMessage = String.format("<b>%s:</b>%s", nickname,filter(message.toString()));
            broadcast(filteredMessage);
        }
        
    }




    @OnError
    public void onError(Throwable t) throws Throwable {
       // log.error("Chat Error: " + t.toString(), t);
    }


    private static void broadcast(String msg) {
        for (ChatAnnotation client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
              //  log.debug("Chat Error: Failed to send message to client", e);
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String message = "-removeUser:" + client.nickname;
                broadcast(message);
            }
        }
    }
    
    
    
        public static String filter(String message) {

        if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());

    }
    
    
    
}
