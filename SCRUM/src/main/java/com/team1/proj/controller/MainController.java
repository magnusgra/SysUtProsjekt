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
    public void setBrukerdata(Brukerdata brukerdata){
        System.out.println("setBrukerdata");
        this.brukerdata = brukerdata; 
    }
    
    @ModelAttribute("brukerService")
    public BrukerService getBrukerService() {
        return new BrukerServiceImpl();
    }
    @ModelAttribute("brukerdata")
    public Brukerdata getBrukerdata() {
        System.out.println("getBrukerdata");
        return new Brukerdata();
    }
    @RequestMapping(value="/*")
    public String index(@Valid @ModelAttribute(value = "brukerService") BrukerService brukerService, BindingResult result){
        System.out.println("******************     UserController.showLogin   ************************");
        if(brukerdata.isInnlogget()){
            return "index";
        }
        return "Login/login";
        
    }
    @RequestMapping(value="Home", method=RequestMethod.POST)
    public String showIndexSide(@Valid @ModelAttribute(value = "brukerService") BrukerService brukerService, BindingResult result) {
        System.out.println("******************     UserController.showStartside/index   ************************");
        if (result.hasErrors()) {
            return "Login/login";
        }
        brukerdata.setInnlogget(true);
        return "index";
    }

    @RequestMapping(value = "Startside")
    public String showStartside(@Valid @ModelAttribute(value = "brukerService") BrukerService brukerService, BindingResult result) {
        System.out.println("******************     UserController.showStartside/index   ************************");
        if (result.hasErrors()) {
            return "Login/login";
        }
        brukerdata.setInnlogget(true);
        return "Startside";
    }
    
    @RequestMapping(value = "EndrePassord")
    public String showEndrePassord(@Valid @ModelAttribute(value = "brukerService") BrukerService brukerService, BindingResult result) {
        System.out.println("******************     UserController.showEndrePassord   ************************");
        if (result.hasErrors()) {
            return "startside";
        }
        if(brukerdata.isInnlogget()){
            return "EndrePassord";
        }
        
        return "Login/login";
    }
    
    @RequestMapping(value = "Highscore")
    public String showHighscore(@Valid @ModelAttribute(value = "brukerService") BrukerService brukerService, BindingResult result) {
        System.out.println("******************     UserController.Highscore   ************************");
        if (result.hasErrors()) {
            return "startside";
        }
        if(brukerdata.isInnlogget()){
            return "Highscore";
        }
        return "Login/login";
    }
    
    @RequestMapping(value="RegistreringSide")
    public String registreringSide(@ModelAttribute(value = "brukerService") BrukerService brukerService, Model model){
        System.out.println("******************     UserController.showRegistreringSide   ************************");
        model.addAttribute(brukerService.getRegistreringsForm());
        return "Login/RegistreringSide";
    }
    
    
    @RequestMapping(value="RegistrerBruker", method=RequestMethod.POST)
    public String registrerBruker(@ModelAttribute(value="registreringsForm") RegistreringsForm regForm, @ModelAttribute(value = "brukerService") BrukerService brukerService){
        
        if (!regForm.isGodtarBrukervilkar()){
            //Godtar ikke brukervilkår
            return "Login/RegistreringSide";
        } 
        String email = regForm.getBrukerdata().getEpost();
        String navn = regForm.getBrukerdata().getBrukernavn();    
        if (navn == null || navn.isEmpty() || email == null || email.isEmpty()){
            return "Login/RegistreringSide";
        }
        
        if (brukerService.leggTilBruker(regForm.getBrukerdata())){
            
            return "Login/login";
        }
        
        return "Login/RegistreringSide";
        
        
    }
    
@RequestMapping(value="/avtale")
    public String avtale(){
        System.out.println("******************     UserController.showLogin   ************************");
        return "Login/avtale";
    }   
    
    
    @RequestMapping(value="/MinSide")
    public String minSide(){
        System.out.println("******************     UserController.showLogin   ************************");
        if(brukerdata.isInnlogget()){
            return "MinSide";
        }
        return "Login/login";
    }
    
    @RequestMapping(value="/Spill")
    public String spill(){
        System.out.println("******************     UserController.showLogin   ************************");
        if(brukerdata.isInnlogget()){
            return "Spill";
        }
        return "Login/login";
    }
    
    @RequestMapping(value="/LoggUt")
    public String loggUt(){
        System.out.println("******************     UserController.showLogin   ************************");
        brukerdata.setInnlogget(false);
        return "Login/login";
    }
    
 
    
   
}
