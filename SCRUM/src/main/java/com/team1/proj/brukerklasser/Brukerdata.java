package com.team1.proj.brukerklasser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mari
 */
public class Brukerdata {
    
    private String email; 
    private String userName; 
    private String password; 
    
    public Brukerdata(){ 
    }
    public Brukerdata(String email, String password){
        this.email = email; 
        this.password = password; 
    }
    /*public Brukerdata(String userName, String password){
        this.userName = userName; 
        this.password = password; 
    }*/
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
