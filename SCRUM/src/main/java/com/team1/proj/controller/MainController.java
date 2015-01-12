/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.controller;

import com.team1.proj.brukerklasser.Brukerdata; 
import com.team1.proj.brukerklasser.RegistreringsForm;
import com.team1.proj.service.BrukerService;
import com.team1.proj.service.BrukerServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        System.out.println("******************     UserController.showLogin   ************************");
        if(brukerdata.isInnlogget()){
            return "index";
        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login"; 
        
    }
    @RequestMapping(value="Home", method=RequestMethod.POST)
    public String showIndexSide(@ModelAttribute("logindata") Brukerdata logindata,Model model) {
        System.out.println("******************     UserController.showStartside/index   ************************");
      
        
        Brukerdata innlogget = brukerService.loggInn(logindata.getEpost(), logindata.getPassord());
        if (innlogget != null){
            
            this.brukerdata.setBrukernavn(innlogget.getBrukernavn());
            this.brukerdata.setEpost(innlogget.getEpost());
            this.brukerdata.setInnlogget(innlogget.isInnlogget());
 
            return "index";
        }
        
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }


    
    @RequestMapping(value = "EndrePassord")
    public String showEndrePassord(Model model) {
        System.out.println("******************     UserController.showEndrePassord   ************************");
        if(brukerdata.isInnlogget()){
            return "EndrePassord";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping(value = "Highscore")
    public String showHighscore(Model model) {
        System.out.println("******************     UserController.Highscore   ************************");

        if(brukerdata.isInnlogget()){
            return "Highscore";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping(value="RegistreringSide")
    public String registreringSide(Model model){
        System.out.println("******************     UserController.showRegistreringSide   ************************");
        model.addAttribute(brukerService.getRegistreringsForm());
        return "Login/RegistreringSide";
    }
    
    
    @RequestMapping(value="RegistrerBruker", method=RequestMethod.POST)
    public String registrerBruker(@ModelAttribute(value="registreringsForm") RegistreringsForm regForm, Model model){
        
        if (!regForm.isGodtarBrukervilkar()){
            //Godtar ikke brukervilkår
            model.addAttribute("melding", "Du må godta brukervilkårene.");
            return "Login/RegistreringSide";
        } 
        String email = regForm.getBrukerdata().getEpost();
        String navn = regForm.getBrukerdata().getBrukernavn();    
        if (navn == null || navn.isEmpty() || email == null || email.isEmpty()){
            return "Login/RegistreringSide";
        }
        
        if (brukerService.leggTilBruker(regForm.getBrukerdata())){
            
            model.addAttribute("logindata", new Brukerdata());
            return "Login/login";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/RegistreringSide";
        
        
    }
    
@RequestMapping(value="/avtale")
    public String avtale(){
        System.out.println("******************     UserController.showLogin   ************************");
        return "Login/avtale";
    }   
    
    

    
    @RequestMapping(value="/Spill")
    public String spill(Model model){
        System.out.println("******************     UserController.showLogin   ************************");
        if(brukerdata.isInnlogget()){
            return "Spill";
        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping(value="/LoggUt")
    public String loggUt(Model model){
        System.out.println("******************     UserController.showLogin   ************************");
        brukerdata.setInnlogget(false);
        brukerdata.setPassord("");
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
 
    
   
}
