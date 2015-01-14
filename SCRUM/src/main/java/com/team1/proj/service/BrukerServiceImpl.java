package com.team1.proj.service;

/**
 * @author Kai
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Highscore;
import com.team1.proj.ui.HighscoreListe;
import com.team1.proj.brukerklasser.RegistreringsForm;
import com.team1.proj.brukerklasser.Resultat;
import com.team1.proj.mailoppsett.Mail;
import com.team1.proj.mailoppsett.Passord;
import com.team1.proj.repository.Repository;
import com.team1.proj.mailoppsett.EmailValidator;

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
    public String leggTilBruker(Brukerdata bd){
        System.out.println("**** BrukerServiceImpl.registrerBruker()  *** ");
        Passord p = new Passord();
        String passord = p.autogenererPassord();
        bd.setPassord(passord);
            
        if (repo == null) {
            return "Noe gikk galt. Prøv igjen senere.";
        }
        EmailValidator eval = new EmailValidator();
        if (eval.validate(bd.getEpost())){
            if (repo.leggTilBruker(bd)){

                Mail mail = new Mail();

                mail.sendMailMedPassord(bd);
                return null;
            } else {
                return "Din epost er allerede registrert.";
            }
        } else {
            return "Epost er ugyldig.";
        }
    }
    
    @Override
    public RegistreringsForm getRegistreringsForm(){
        return new RegistreringsForm();
    }


    @Override
    public void leggTilResultat(Resultat res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean endrePassord(Brukerdata bd, String nyttPassord) {
        return repo.endrePassord(bd, nyttPassord);
    }
    @Override
    public List<Highscore> getHighscore(){
        System.out.println("****** BrukerServiceImpl.getHighscore()******");
        return repo.getHighscore();
        
    }
    @Override
    public List<Resultat> getAlleBrukere(){
        System.out.println("****** BrukerServiceImpl.getAlleBrukere()******");
        return repo.getAlleBrukere(); 
    }
    

    @Override
    public Brukerdata loggInn(String epost, String passord) {
        Brukerdata bd = null;
        if (repo != null) {
            bd = repo.loggInn(epost, passord);
            if (bd != null){
                bd.setInnlogget(true);
            }
        } else {
            System.out.println("LoggInn - REPO == NULL");
        }
        
        return bd;
        
    }

    
    
}

