
package com.team1.proj.service;

/*
 * @author Kai
 */

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.RegistreringsForm;
import com.team1.proj.brukerklasser.Resultat;

/*
 * @author Kai
 */

public interface BrukerService {
   
    
    public boolean leggTilBruker(Brukerdata bd);
    public void leggTilResultat(Resultat res);
    public boolean endrePassord(Brukerdata bd, String nyttPassord);
   
    public Brukerdata loggInn(String brukernavn, String passord);
   
    public RegistreringsForm getRegistreringsForm();
    
}

