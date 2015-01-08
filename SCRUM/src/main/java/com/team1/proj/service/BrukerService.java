
package com.team1.proj.service;

/*
 * @author Kai
 */
import java.util.List;
import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.RegistreringsForm;

/*
 * @author Kai
 */

public interface BrukerService {
   
    
    public List<Brukerdata> getAlleBrukere();
    public Brukerdata getBrukerdata();
    public void setBrukerdata(Brukerdata bd);
    
    public boolean loggInn(Brukerdata bd);
    
    public boolean oppdaterBruker(Brukerdata b);
    public boolean oppdaterBruker(List<Brukerdata> brukerListe);
    
    public boolean registrerBruker(Brukerdata b);
    public boolean slettBruker(List<Brukerdata> brukerListe);
    
    public RegistreringsForm getRegistreringsForm();
    
}

