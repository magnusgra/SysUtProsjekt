package com.team1.proj.service;

/**
 * @author Kai
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.RegistreringsForm;
import com.team1.proj.brukerklasser.Resultat;
import com.team1.proj.mailoppsett.Mail;
import com.team1.proj.repository.Repository;

//@Service
public class BrukerServiceImpl implements BrukerService {
     
    @Autowired
    private Repository repo;
    
    @Autowired
     public void setRepository(Repository repo){
         System.out.println("BrukerServiceImpl.setDatabase2   " + repo);
         this.repo = repo;
     }
    
    public Brukerdata getBrukerdata(String brukernavn){
        System.out.println("**** BrukerServiceImpl.getBruker()  *** ");
        return repo.getBrukerdata(brukernavn);
    }
    
     
    @Override
    public boolean leggTilBruker(Brukerdata bd){
        System.out.println("**** BrukerServiceImpl.registrerBruker()  *** ");
        Mail mail = new Mail();
        String passord = mail.sendMailMedPassord(bd);
        if (passord != null){
            bd.setPassord(passord);
            
            if (repo != null){
                repo.leggTilBruker(bd);
            } else {
                System.out.println("REPO == NULL");;
            }
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public RegistreringsForm getRegistreringsForm(){
        return new RegistreringsForm();
    }

    
    public void setBrukerdata(Brukerdata bd) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean loggInn(Brukerdata bd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leggTilResultat(Resultat res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean endrePassord(Brukerdata bd, String nyttPassord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loggInn(String brukernavn, String passord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

