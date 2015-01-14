/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.brukerklasser;

/**
 *
 * @author arnecs
 */
public class Resultat {
    private Brukerdata brukerdata;
    private String status; 
    private int oppgavenr; 
    private int poeng;

    

    
    public Resultat(){    
    }

    public Resultat(Brukerdata brukerdata, String status) {
        this.brukerdata = brukerdata;
        this.status = status;
    }
   
    public Brukerdata getBrukerdata() {
        return brukerdata;
    }

    public void setBrukerdata(Brukerdata brukerdata) {
        this.brukerdata = brukerdata;
    }
       
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getPoeng() {
        return poeng;
    }

    public void setPoeng(int poeng) {
        this.poeng = poeng;
    }

    public int getOppgavenr() {
        return oppgavenr;
    }

    public void setOppgavenr(int oppgavenr) {
        this.oppgavenr = oppgavenr;
    }

    
}
