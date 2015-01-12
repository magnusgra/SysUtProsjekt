/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.controller;

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.service.BrukerService;
import com.team1.proj.service.BrukerServiceImpl;
import com.team1.proj.ui.EndrePassordFormBackingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author arnecs
 */

@Controller
@SessionAttributes
public class MinSideController {
    
    @Autowired
    private Brukerdata brukerdata;
    
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

    
    @RequestMapping(value="/MinSide")
    public String minSide(Model model){
        System.out.println("******************     UserController.MinSide   ************************");
        if(brukerdata.isInnlogget()){
            model.addAttribute(new EndrePassordFormBackingBean());
            return "MinSide";
        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping(value="/MinSide", method=RequestMethod.POST)
    public String endrePassord(Model model, @ModelAttribute EndrePassordFormBackingBean epfbb){
        System.out.println("******************     UserController.endrePassord   ************************");
        if(brukerdata.isInnlogget()){
            model.addAttribute(new EndrePassordFormBackingBean());
            
            
            
            if (!epfbb.passordErLik()){
                model.addAttribute("meldingError", "Passordene er ikke like.");
                model.addAttribute("melding", "");
                return "MinSide";
            }
            
            if (brukerService.endrePassord(brukerdata, epfbb.getNyttPassord())){
                model.addAttribute("melding", "Passordet er endret");
                model.addAttribute("meldingError", "");
                return "MinSide";
            } else {
                model.addAttribute("meldingError", "Gammelt passord er feil.");
                model.addAttribute("melding", "");
                return "MinSide";
            }

        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
        
        

}
