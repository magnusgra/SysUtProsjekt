/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.controller;

import com.team1.proj.brukerklasser.Brukerdata; 
import com.team1.proj.brukerklasser.Highscore;
import com.team1.proj.ui.HighscoreListe;
import com.team1.proj.ui.RegistreringsForm;
import com.team1.proj.service.BrukerService;
import com.team1.proj.service.BrukerServiceImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author arnecs
 */


@Controller
@SessionAttributes({"brukerService","brukerdata"})

public class MainController {
    @Autowired
    private Brukerdata brukerdata;
    
    @Autowired
    private BrukerService brukerService;
    
    @Autowired
    public void setBrukerService(BrukerService brukerService){
        this.brukerService = brukerService;
    }
    
    @ModelAttribute("brukerService")
    public BrukerService getBrukerService() {
        return new BrukerServiceImpl();
    }

    @Autowired
    public void setBrukerdata(Brukerdata brukerdata){
        System.out.println("setBrukerdata");
        this.brukerdata = brukerdata; 
    }
    
    @ModelAttribute("brukerdata")
    public Brukerdata getBrukerdata() {
        System.out.println("getBrukerdata");
        return new Brukerdata();
    }
    
    @RequestMapping(value="/*")
    public String index(Model model){
        if(brukerdata.isInnlogget()){
            return "index";
        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login"; 
        
    }
    
    //Metode for å logge inn
    @RequestMapping(value="Home", method=RequestMethod.POST)
    public String showIndexSide(@ModelAttribute("logindata") Brukerdata logindata,Model model) {
        
        //Prøv å logge inn
        Brukerdata innlogget = brukerService.loggInn(logindata.getEpost(), logindata.getPassord());
        if (innlogget != null){
            //hvis innlogget
            this.brukerdata.setFornavn(innlogget.getFornavn());
            this.brukerdata.setEtternavn(innlogget.getEtternavn());
            this.brukerdata.setEpost(innlogget.getEpost());
            this.brukerdata.setInnlogget(innlogget.isInnlogget());
            this.brukerdata.setRettigheter(innlogget.getRettigheter());
            this.brukerdata.setSisteOppgaveKlart(innlogget.getSisteOppgaveKlart());
            
            return "index";
        }
        
        logindata.setPassord("");
        model.addAttribute("melding", "Epost eller passord er feil.");
        model.addAttribute("meldingtype","melding-error");
        model.addAttribute("logindata", logindata);
        return "Login/login";
    }

    //Spill
    @RequestMapping(value="/Spill")
    public String spill(Model model){
        if(brukerdata.isInnlogget()){
            return "Spill";
        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login"; 
        
    }

    //Highscore
    @RequestMapping(value = "Highscore")
    public String showHighscore(@ModelAttribute HighscoreListe hs, Model model) {
        System.out.println("******************     UserController.Highscore   ************************");

        if(brukerdata.isInnlogget()){  
            //Henter highscoreliste
            hs.setHigscoreliste(brukerService.getHighscore());
            return "Highscore";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    //Registreringsside
    @RequestMapping(value="RegistreringSide")
    public String registreringSide(Model model){
        System.out.println("******************     UserController.showRegistreringSide   ************************");
        
        //Lag registreringsform
        model.addAttribute(brukerService.getRegistreringsForm());
        return "Login/RegistreringSide";
    }
    
    //Hvis brukervilkår
@RequestMapping(value="/avtale")
    public String avtale(){
        System.out.println("******************     UserController.brukervilkår   ************************");
        return "Login/avtale";
    }   
    
    

    

    
    @RequestMapping(value="/LoggUt")
    public String loggUt(Model model){
        System.out.println("******************     UserController.showLogin   ************************");
        
        //Set innloggen til false
        brukerdata.setInnlogget(false);
        brukerdata.setPassord("");
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
      
    
    //Chat
    @RequestMapping(value="/Chat")
    public String chat(Model model){
        
        if(brukerdata.isInnlogget()){  
            
            model.addAttribute("brukerdata", brukerdata);
            return "chat";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
 
            
    }
}
