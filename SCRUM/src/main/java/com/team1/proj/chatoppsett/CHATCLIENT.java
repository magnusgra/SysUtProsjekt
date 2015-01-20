package com.team1.proj.chatoppsett;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * @author Kai
 */
public class CHATCLIENT implements Runnable{
    
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND = new Scanner(System.in);
    PrintWriter OUT;
    
    public CHATCLIENT(Socket X){
        this.SOCK = X;
    }
    
    public void run(){
            try{
                INPUT = new Scanner(SOCK.getInputStream());
                OUT = new PrintWriter(SOCK.getOutputStream());
                OUT.flush();
                CheckStream();
            }
            
        
        catch(Exception X){
            System.out.print(X);
        }
    }
    
    public void DISCONNECT() throws IOException{
        OUT.println(CHATGUI.UserName + " har logget av!");
        OUT.flush();
        JOptionPane.showMessageDialog(null, "Du har logget av.");
        System.exit(0);
    }
    
    public void CheckStream(){
        while(true){
            RECEIVE();
        }
    }
    
    public void RECEIVE(){
        if(INPUT.hasNext()){
            String MESSAGE = INPUT.nextLine();
            if(MESSAGE.contains("#?!")){
                String TEMP1 = MESSAGE.substring(3);
                TEMP1 = TEMP1.replace("[","");
                TEMP1 = TEMP1.replace("]","");
                
            String[] CurrentUsers = TEMP1.split(", ");
            CHATGUI.JL_ONLINE.setListData(CurrentUsers);
            }else{
                CHATGUI.TA_CONVERSATION.append(MESSAGE + "\n");
            }
        }
    }
    
    public void SEND(String X){
        OUT.println(CHATGUI.UserName + ": " + X);
        OUT.flush();
        CHATGUI.TF_Message.setText("");
    }
    
    
}
