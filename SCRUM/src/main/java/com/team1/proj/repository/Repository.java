/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.repository;

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Highscore;
import com.team1.proj.brukerklasser.Oppgave;
import com.team1.proj.brukerklasser.Resultat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arnecs
 */
public interface Repository {
    
    public Brukerdata getBrukerdata(String epost);
    public boolean leggTilBruker(Brukerdata bd);
    public void leggTilResultat(Resultat res);
    public boolean endrePassord(Brukerdata bd, String nyttPassord);
    public List<Highscore> getHighscore();
    public List<Resultat> getAlleBrukere(); 
    public boolean endreRettigheter(Brukerdata bd, int rettigheter);
    
    //dfsfdsfdf
    
    public Brukerdata loggInn(String epost, String passord);
    
    
    
    
    public List<Brukerdata> getBrukerdata(int fra, int til);
    public List<Oppgave> getOppgaverFor(Brukerdata brukerdata);
    public int getAntBrukere();
    
}
