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
@SessionAttributes("brukerService")
public class MainController {
    
    @ModelAttribute("brukerService")
    public BrukerService getBrukerService() {
        return new BrukerServiceImpl();
    }
    @RequestMapping(value="/*")
    public String index(){
        System.out.println("******************     UserController.showLogin   ************************");
        return "login";
    }
    @RequestMapping(value = "Startside")
    public String showStartside(@Valid @ModelAttribute(value = "brukerService") BrukerService brukerService, BindingResult result) {
        System.out.println("******************     UserController.showStartside   ************************");
        if (result.hasErrors()) {
            return "login";
        }
        return "Startside";
    }
    
    @RequestMapping(value = "EndrePassord")
    public String showEndrePassord(@Valid @ModelAttribute(value = "brukerService") BrukerService brukerService, BindingResult result) {
        System.out.println("******************     UserController.showStartside   ************************");
        if (result.hasErrors()) {
            return "startside";
        }
        return "EndrePassord";
    }
    
    @RequestMapping(value = "Highscore")
    public String showHighscore(@Valid @ModelAttribute(value = "brukerService") BrukerService brukerService, BindingResult result) {
        System.out.println("******************     UserController.showStartside   ************************");
        if (result.hasErrors()) {
            return "startside";
        }
        return "Highscore";
    }
    
    @RequestMapping(value="RegistreringSide")
    public String registreringSide(@ModelAttribute(value = "brukerService") BrukerService brukerService, Model model){
        System.out.println("******************     UserController.showRegistreringSide   ************************");
        model.addAttribute(brukerService.getRegistreringsForm());
        return "RegistreringSide";
    }
    
    
    @RequestMapping(value="RegistrerBruker", method=RequestMethod.POST)
    public String registrerBruker(@ModelAttribute(value="registreringsForm") RegistreringsForm regForm, @ModelAttribute(value = "brukerService") BrukerService brukerService){
        
        if (!regForm.isGodtarBrukervilkar()){
            //Godtar ikke brukervilkår
            return "RegistreringSide";
        } 
        String email = regForm.getBrukerdata().getEpost();
        String navn = regForm.getBrukerdata().getBrukernavn();    
        if (navn == null || navn.isEmpty() || email == null || email.isEmpty()){
            return "RegistreringSide";
        }
        
        brukerService.leggTilBruker(regForm.getBrukerdata());
        
        return "login";
    }
    
@RequestMapping(value="/avtale")
    public String avtale(){
        System.out.println("******************     UserController.showLogin   ************************");
        return "avtale";
    }    
}
