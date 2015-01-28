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
import com.team1.proj.ui.RegistreringsForm;
import com.team1.proj.brukerklasser.Resultat;
import com.team1.proj.mailoppsett.Mail;
import com.team1.proj.mailoppsett.Passord;
import com.team1.proj.repository.Repository;
import com.team1.proj.mailoppsett.EmailValidator;
import com.team1.proj.ui.AdminGodkjenning;
import java.util.ArrayList;
import com.team1.proj.service.HashPassord; 
import java.security.NoSuchAlgorithmException;
import javax.mail.NoSuchProviderException;

//@Service 
public class BrukerServiceImpl implements BrukerService {
     
    @Autowired
    private Repository repo;
    
    @Autowired
     public void setRepository(Repository repo){
         System.out.println("BrukerServiceImpl.setDatabase2   " + repo);
         this.repo = repo;
     }
    
    public Brukerdata getBrukerdata(String epost){
        System.out.println("**** BrukerServiceImpl.getBruker()  *** ");
        return repo.getBrukerdata(epost);
    }
    
     
    @Override
    public String leggTilBruker(Brukerdata bd){
        System.out.println("**** BrukerServiceImpl.registrerBruker()  *** ");
        
        //Fjern HTML-tagger
        bd.setFornavn(HTMLfilter(bd.getFornavn()));
        bd.setEtternavn(HTMLfilter(bd.getEtternavn()));
        bd.setEpost(HTMLfilter(bd.getEpost()));
        
        //Autogenerer og hash passord
        Passord p = new Passord();
        String passord = p.autogenererPassord();
        String salt = null;
        try{
            salt = HashPassord.getSalt();
        }catch(NoSuchAlgorithmException | NoSuchProviderException | java.security.NoSuchProviderException e){
            e.printStackTrace();
        }
        String sikkertpassord = HashPassord.getSecurePassword(passord, salt)+ ":"+salt;
        bd.setPassord(sikkertpassord);
            
        if (repo == null) {
            return "Noe gikk galt. Prøv igjen senere.";
        }
        
        //Valider epost
        EmailValidator eval = new EmailValidator();
        if (eval.validate(bd.getEpost())){
            //formater navn
            bd.formaterNavn();
            //Legg til pruker
            if (repo.leggTilBruker(bd)){
                //Hvis bruker blir lagt til
                //Opprett og send mail
                Mail mail = new Mail();
                mail.sendMailMedPassord(bd, passord);
                return null;
            } else {
                return "Din epost er allerede registrert.";
            }
        } else {
            return "Epost er ugyldig.";
        }
    }
    @Override
    public boolean endreRettigheter(Brukerdata bd, int rettigheter){
        System.out.println("**** BrukerServiceImpl.registrerBruker()  *** ");
        //Sender videre til repository
        return repo.endreRettigheter(bd, rettigheter);
    }
    
    @Override
    public RegistreringsForm getRegistreringsForm(){
        return new RegistreringsForm();
    }


    @Override
    public void leggTilResultat(Resultat res) {
        //Sender videre til repository
        repo.leggTilResultat(res);
    }

    @Override
    public boolean endrePassord(Brukerdata bd, String nyttPassord) {
        //Sender videre til repository
        return repo.endrePassord(bd, nyttPassord);
    }
    @Override
    public List<Highscore> getHighscore(){
        System.out.println("****** BrukerServiceImpl.getHighscore()******");
        //Sender videre til repository
        return repo.getHighscore();
        
    }
    @Override
    public List<Resultat> getAlleBrukere(){
        System.out.println("****** BrukerServiceImpl.getAlleBrukere()******");
        //Sender videre til repository
        return repo.getAlleBrukere(); 
    }
    

    @Override
    public Brukerdata loggInn(String epost, String passord) {
        Brukerdata bd = null;
        if (repo != null) {
            //henter brukerdata
            bd = repo.getBrukerdata(epost);
            if (bd != null) {
                //Hasher passord
                String saltiDB = bd.getPassord().split(":")[1];
                String passordHash = HashPassord.getSecurePassword(passord, saltiDB);
                //Prøv login
                bd = repo.loggInn(epost, passordHash+":"+saltiDB);
                if (bd != null){
                    bd.setInnlogget(true);
                }
            }
        }
        
        return bd;
        
    }
    
    public AdminGodkjenning getResultat(Brukerdata bd){
        AdminGodkjenning ag = new AdminGodkjenning();
        ag.setBrukerdata(bd);
        ag.setOppgaver(repo.getOppgaverFor(bd));
        return ag;
    }
    
    
    @Override
    public List<AdminGodkjenning> getAdminListe(int fra, int til){
        List<Brukerdata> brukerdataListe = repo.getBrukerdata(fra, til);
        ArrayList<AdminGodkjenning> agListe = new ArrayList();
        
        for (Brukerdata bd : brukerdataListe){
            AdminGodkjenning ag = new AdminGodkjenning();
            ag.setBrukerdata(bd);
            //System.out.println(bd.getEpost());
            ag.setOppgaver(repo.getOppgaverFor(bd));
            agListe.add(ag);
        }
        return agListe;
        
    }

    @Override
    public List<Integer> getSider(int aktivSide, int linjerPerSide) {
        
        //Hentet antall brukere
        int antBrukere = repo.getAntBrukere();
        int antSider = (antBrukere / linjerPerSide);
        if (antBrukere % linjerPerSide != 0) {
            antSider++;
        }
        
        //Henter riktige sidetall
        ArrayList<Integer> sider = new ArrayList(); 
        int start = aktivSide <= 5 ? 1 : aktivSide - 5;
        int current = start;
        while (current <= antSider && current < start + 10){
           sider.add(new Integer(current));
           current++;
        }
        
        return sider;        
    }
    
    public static String HTMLfilter(String message) {

        if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());

    }
    
}

