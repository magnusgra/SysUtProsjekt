package com.team1.proj.brukerklasser;

import javax.validation.constraints.NotNull;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * @author Mari/Kai :P - øy! don't take my fame Kai!
 */

public class Brukerdata {
    @NotNull
    private String brukernavn;
    private int rettigheter;
    @NotNull
    private String passord; 
    private String epost;
    private boolean innlogget;
    
    public Brukerdata(){ 
    }
    public Brukerdata(String brukernavn,int rettigheter, String passord, String epost){
        this.brukernavn = brukernavn; 
        this.rettigheter = rettigheter;
        this.passord = passord; 
        this.epost = epost;
    }
    /*public Brukerdata(String userName, String password){
        this.userName = userName; 
        this.password = password; 
    }*/
    public boolean isInnlogget(){
        return innlogget;
    }
    public void setInnlogget(boolean verdi){
        this.innlogget = verdi; 
    }
   
    
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
