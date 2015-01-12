/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.repository;

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Resultat;

/**
 *
 * @author arnecs
 */
public interface Repository {
    
    public Brukerdata getBrukerdata(String brukernavn);
    public void leggTilBruker(Brukerdata bd);
    public void leggTilResultat(Resultat res);
    public boolean endrePassord(Brukerdata bd, String nyttPassord);
    
    public Brukerdata loggInn(String brukernavn, String passord);
    
    
    
    
    
    
}
