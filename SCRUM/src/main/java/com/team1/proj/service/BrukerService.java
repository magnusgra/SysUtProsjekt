
package com.team1.proj.service;

/*
 * @author Kai
 */
import java.util.List;
import com.team1.proj.brukerklasser.Brukerdata;

/*
 * @author Kai
 */

public interface BrukerService {
        
    public List<Brukerdata> getAlleBrukere();
    public Brukerdata getBruker(String brukernavn);
    
    public boolean oppdaterBruker(Brukerdata b);
    public boolean oppdaterBruker(List<Brukerdata> brukerListe);
    
    public boolean registrerBruker(Brukerdata b);
    
    public boolean slettBruker(List<Brukerdata> brukerListe);
    
}

