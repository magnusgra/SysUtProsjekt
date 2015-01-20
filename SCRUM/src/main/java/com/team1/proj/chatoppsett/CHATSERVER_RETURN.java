package com.team1.proj.chatoppsett;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * @author Kai
 */

public class CHATSERVER_RETURN implements Runnable{
    
    Socket SOCK;
    private Scanner INPUT;
    private PrintWriter OUT;
    String MESSAGE = "";
    
    public CHATSERVER_RETURN(Socket X){
        this.SOCK = X;
    }
    
    public void CHECKConnection()throws IOException{
        if(!SOCK.isConnected()){
            for(int i = 1; i <= CHATSERVER.ConnectionArray.size();i++){
                if(CHATSERVER.ConnectionArray.get(i) == SOCK){
                    CHATSERVER.ConnectionArray.remove(i);
                }
            }
            
            for(int i = 1; i <= CHATSERVER.ConnectionArray.size();i++){
                Socket TEMP_SOCK = (Socket)CHATSERVER.ConnectionArray.get(i-1);
                PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName() + " logget av!");
                TEMP_OUT.flush();
                System.out.println(TEMP_SOCK.getLocalAddress().getHostName() + " logget av!");
            }
        }
    }
    
    public void run(){
            try{
                INPUT = new Scanner(SOCK.getInputStream());
                OUT = new PrintWriter(SOCK.getOutputStream());
                
                while(true){
                    CHECKConnection();
                    
                    if(!INPUT.hasNext()){
                        return;
                    }
                    
                    MESSAGE = INPUT.nextLine();
                    System.out.println("Bruker sa: " + MESSAGE);
                    
                    for(int i = 1; i <= CHATSERVER.ConnectionArray.size();i++){
                        Socket TEMP_SOCK = (Socket)CHATSERVER.ConnectionArray.get(i-1);
                        PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                        TEMP_OUT.println(MESSAGE);
                        TEMP_OUT.flush();
                        System.out.println("Sent to: " + TEMP_SOCK.getLocalAddress().getHostName());
                    }
                }
                
            }
        catch (Exception X) {
            System.out.println(X);
        }
    }
    
    
}
