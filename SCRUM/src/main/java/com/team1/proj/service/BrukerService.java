
package com.team1.proj.service;

/*
 * @author Kai
 */

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Highscore;
import com.team1.proj.brukerklasser.RegistreringsForm;
import com.team1.proj.brukerklasser.Resultat;
import com.team1.proj.ui.AdminGodkjenning;
import java.util.List;

/*
 * @author Kai
 */

public interface BrukerService {
   
    
    public String leggTilBruker(Brukerdata bd);
    public void leggTilResultat(Resultat res);
    public boolean endrePassord(Brukerdata bd, String nyttPassord);
   public Brukerdata getBrukerdata(String epost);
    public Brukerdata loggInn(String epost, String passord);
    public boolean endreRettigheter(Brukerdata bd, int rettigheter);
   
    public RegistreringsForm getRegistreringsForm();
    public List<Highscore> getHighscore();
    public List<Resultat> getAlleBrukere(); 
    
    public List<AdminGodkjenning> getAdminListe(int fra, int til);
    
}

