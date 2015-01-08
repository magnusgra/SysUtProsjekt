package com.team1.proj.brukerklasser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mari/Kai :P - øy! don't take my fame Kai!
 */
public class Brukerdata {
    private String brukernavn;
    private int rettigheter;
    private String passord; 
    private String epost;
    
    public Brukerdata(){ 
    }
    public Brukerdata(String brukernavn, String passord){
        this.brukernavn = brukernavn; 
        this.passord = passord; 
    }
    /*public Brukerdata(String userName, String password){
        this.userName = userName; 
        this.password = password; 
    }*/
    
    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }
    
    public int getRettigheter() {
        return rettigheter;
    }

    public void setRettigheter(int ret) {
        this.rettigheter = ret;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
    
    public String getEpost(){
        return epost;
    }
    
    public void setEpost(String epost){
        this.epost = epost;
    }
    
    
}
