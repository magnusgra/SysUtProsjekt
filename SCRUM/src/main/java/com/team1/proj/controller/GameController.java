/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.controller;

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Resultat;
import com.team1.proj.service.BrukerService;
import com.team1.proj.service.BrukerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author arnecs
 */

@Controller
@SessionAttributes({"brukerService","brukerdata"})
@RequestMapping("/Spill")
public class GameController {
    
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
    
    
    
    
    
    @RequestMapping("/*")
    public String index(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/index";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
 
    @RequestMapping(value = "Kart",  method = RequestMethod.GET)
    public String kartGet(Model model){
        if (brukerdata.isInnlogget()){
            model.addAttribute("brukerdata", brukerdata);
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
        @RequestMapping(value = "/Kart",  method = RequestMethod.POST)
    public String kartPost(Model model, @RequestParam("bane") Integer bane, @RequestParam("poeng") Integer poeng){
        if (brukerdata.isInnlogget()){
            
            //Lagre data
            Resultat res = new Resultat();
            res.setEpost(brukerdata.getEpost());
            res.setOppgavenr(bane);
            res.setPoeng(poeng);
            brukerService.leggTilResultat(res);
            
            if (brukerdata.getSisteOppgaveKlart() < bane){
                brukerdata.setSisteOppgaveKlart(bane);
            }
            
            model.addAttribute("brukerdata", brukerdata);
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "/Login/login";
    }
    
    @RequestMapping("/Hinder")
    public String hinder(Model model){
        if (brukerdata.isInnlogget()){
            if (brukerdata.getSisteOppgaveKlart() >= 0){
                return "spill/hinder/hinder";
            }
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Liste")
    public String liste(Model model){
        if (brukerdata.isInnlogget()){
            if (brukerdata.getSisteOppgaveKlart() >= 1){
                return "spill/liste/liste";
            }
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Tiger")
    public String tiger(Model model){
        if (brukerdata.isInnlogget()){
            if (brukerdata.getSisteOppgaveKlart() >= 2){
                return "spill/tiger/tiger";
            }
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Mismatch")
    public String mismatch(Model model){
        if (brukerdata.isInnlogget()){
            if (brukerdata.getSisteOppgaveKlart() >= 3){
                return "spill/mismatch/mismatch";
            }
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Linker")
    public String linker(Model model){
        if (brukerdata.isInnlogget()){
            if (brukerdata.getSisteOppgaveKlart() >= 4){
                return "spill/linker/linker";
            }
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Bur")
    public String bur(Model model){
        if (brukerdata.isInnlogget()){
            if (brukerdata.getSisteOppgaveKlart() >= 5){
                return "spill/bur/bur";
            }
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    
    @RequestMapping("/Manus")
    public String manus(Model model){
        if (brukerdata.isInnlogget()){
            if (brukerdata.getSisteOppgaveKlart() >= 6){
                return "spill/manus/manus";
            }
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    
    @RequestMapping("/Form")
    public String form(Model model){
        if (brukerdata.isInnlogget()){
            if (brukerdata.getSisteOppgaveKlart() >= 7){
                return "spill/form/formLevel";
            }
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping(value="/BossBattle", method=RequestMethod.POST)
    public String bossBattlePost(Model model, @RequestParam("bane") Integer bane, @RequestParam("poeng") Integer poeng){
        if (brukerdata.isInnlogget()){
            
             //Lagre data
            Resultat res = new Resultat();
            res.setEpost(brukerdata.getEpost());
            res.setOppgavenr(bane);
            res.setPoeng(poeng);
            brukerService.leggTilResultat(res);
            
            
            return "spill/boss/boss";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
}