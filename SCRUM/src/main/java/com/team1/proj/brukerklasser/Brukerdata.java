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
   
    private String fornavn;
    private String etternavn;
    
    private int rettigheter;

    private String passord; 
    private String epost;
    private boolean innlogget;
    
    public Brukerdata(){ 
    }
    public Brukerdata(String fornavn, String etternavn,int rettigheter, String passord, String epost){
        this.fornavn = fornavn; 
        this.etternavn = etternavn;
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

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
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
