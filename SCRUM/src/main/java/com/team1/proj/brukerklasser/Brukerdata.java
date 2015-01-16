package com.team1.proj.brukerklasser;

import java.util.Locale;
import java.util.Objects;
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

public class Brukerdata{
   
    private String fornavn;
    private String etternavn;
    
    private int rettigheter;

    private String passord; 
    private String epost;
    private boolean innlogget;
    
    public Brukerdata(){ 
    }
    
    public Brukerdata(String fornavn, String etternavn, String passord, int rettigheter, String epost){
        this.fornavn = fornavn; 
        this.etternavn = etternavn; 
        this.passord = passord; 
        this.rettigheter = rettigheter;
        this.epost = epost; 
    }
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
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        
        Brukerdata other = (Brukerdata) obj;
        
        if (other == this) return true; 
        
        if (this.epost.equals(other.epost) && this.fornavn.equals(other.fornavn)&& other.etternavn.equals(other.etternavn)) {
            return true;
        }
        return false;
    }

    
}
