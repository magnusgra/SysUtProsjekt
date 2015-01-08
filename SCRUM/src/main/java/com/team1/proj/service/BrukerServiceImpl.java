package com.team1.proj.service;

/**
 * @author Kai
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.repository.BrukerRepository;

//@Service
public class BrukerServiceImpl implements BrukerService{
     
    private BrukerRepository repo;

     @Autowired
     public void setRepository(BrukerRepository repo){
         System.out.println("BrukerServiceImpl.setDatabase2   " + repo);
         this.repo = repo;
     }
   
    public Brukerdata getBruker(String brukernavn){
        System.out.println("**** BrukerServiceImpl.getBruker()  *** ");
        return repo.getBruker(brukernavn);
    }
     
    public List<Brukerdata> getAlleBrukere(){
        System.out.println("**** BrukerServiceImpl.getAlleBruker()  *** ");
        return repo.getAlleBrukere();
    }
    
    public boolean oppdaterBruker(List<Brukerdata> brukerListe){
        System.out.println("**** BrukerServiceImpl.oppdaterBruker()  *** ");
        if (brukerListe == null || brukerListe.size() == 0) return true;
            
        boolean erOppdateringOk = true;
        for (Brukerdata b : brukerListe){
            if (!repo.oppdaterBruker(b)) erOppdateringOk=false;
        }
        return erOppdateringOk;
    }
    
    public boolean registrerBruker(Brukerdata bd){
        System.out.println("**** BrukerServiceImpl.registrerBruker()  *** ");
        return repo.registrerBruker(bd);
    }
    
    public boolean slettBruker(List<Brukerdata> brukerListe){
        System.out.println("**** BrukerServiceImpl.slettBruker()  *** ");
        if (brukerListe == null || brukerListe.size() == 0) return true;
               
        boolean erSlettingOk = true;
        for (Brukerdata bd : brukerListe){
            if (!repo.slettBruker(bd)) erSlettingOk = false;
        }
        return erSlettingOk;
    }
    
    public boolean oppdaterBruker(Brukerdata bd){
        System.out.println("**** BrukerServiceImpl.oppdaterBruker()  *** ");
        return repo.oppdaterBruker(bd);
    }
}

