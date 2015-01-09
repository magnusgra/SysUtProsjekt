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
    private int forsoknr;
    private int oppgavenr;
    private int poeng;
    private String status;


    
    public Resultat(){    
    }

    public Resultat(Brukerdata brukerdata, int forsoknr, int oppgavenr, int poeng, String status) {
        this.brukerdata = brukerdata;
        this.forsoknr = forsoknr;
        this.oppgavenr = oppgavenr;
        this.poeng = poeng;
        this.status = status;
    }
   
    public Brukerdata getBrukerdata() {
        return brukerdata;
    }

    public void setBrukerdata(Brukerdata brukerdata) {
        this.brukerdata = brukerdata;
    }

    public int getOppgavenr() {
        return oppgavenr;
    }

    public void setOppgavenr(int oppgavenr) {
        this.oppgavenr = oppgavenr;
    }

    public int getPoeng() {
        return poeng;
    }

    public void setPoeng(int poeng) {
        this.poeng = poeng;
    } 
    
    public int getForsoknr() {
        return forsoknr;
    }

    public void setForsoknr(int forsoknr) {
        this.forsoknr = forsoknr;
    }
       
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
