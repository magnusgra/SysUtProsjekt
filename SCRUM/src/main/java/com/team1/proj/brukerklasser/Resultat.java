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
    private String fornavn;
    private String etternavn;
    private String epost;
    private int rettigheter;
    private String status; 
    private int oppgavenr;

    

    
    public Resultat(){    
    }

    public Resultat(String fornavn, String etternavn, String epost,int rettigheter, String status) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.epost = epost;
        this.rettigheter = rettigheter;
        this.status = status;
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

    public void setRettigheter(int rettigheter) {
        this.rettigheter = rettigheter;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
   
    
       
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOppgavenr() {
        return oppgavenr;
    }

    public void setOppgavenr(int oppgavenr) {
        this.oppgavenr = oppgavenr;
    }

    
}
