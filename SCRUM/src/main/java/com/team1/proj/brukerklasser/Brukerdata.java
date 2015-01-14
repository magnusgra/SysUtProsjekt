package com.team1.proj.brukerklasser;

import java.util.Locale;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.WordUtils;

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
       
        this.fornavn = WordUtils.capitalize(fornavn);
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = WordUtils.capitalize(etternavn);
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
        this.epost = epost.toLowerCase();
        
    }
    
    public void formaterNavn(){
        this.fornavn = WordUtils.capitalize(fornavn.toLowerCase());
        this.etternavn = WordUtils.capitalize(etternavn.toLowerCase());
    }
    
}
