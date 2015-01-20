package com.team1.proj.chatoppsett;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Kai
 */
public class CHATSERVER {
    
    public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();
    public static ArrayList<String> CurrectUsers = new ArrayList<String>();
    
    public static void main(String[] args)throws IOException {
        try{
            final int PORT = 444;
            ServerSocket SERVER = new ServerSocket(PORT);
            System.out.println("Venter på clienter...");
            
            while(true){
                Socket SOCK = SERVER.accept();
                ConnectionArray.add(SOCK);
                
                System.out.println("Client connected from: " + SOCK.getLocalAddress().getHostName());
                AddUserName(SOCK);
                
                CHATSERVER_RETURN CHAT = new CHATSERVER_RETURN(SOCK);
                Thread X = new Thread(CHAT);
                X.start();
            }
            
        }catch(Exception X){
            System.out.print(X);
            
        }
    }
    
    public static void AddUserName(Socket X)throws IOException{
        Scanner INPUT = new Scanner(X.getInputStream());
        String UserName = INPUT.nextLine();
        CurrectUsers.add(UserName);
        
        for(int i = 1; i<CHATSERVER.ConnectionArray.size();i++){
            Socket TEMP_SOCK = (Socket) CHATSERVER.ConnectionArray.get(i-1);
            PrintWriter OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
            OUT.println("#?!" + CurrectUsers);
            OUT.flush();
        }
    }
}
