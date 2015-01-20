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
            
            
            return "spill/kart/kart";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "/Login/login";
    }
    
    @RequestMapping("/Hinder")
    public String hinder(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/hinder/hinder";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Liste")
    public String liste(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/liste/liste";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Tiger")
    public String tiger(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/tiger/tiger";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Mismatch")
    public String mismatch(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/mismatch/mismatch";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Linker")
    public String linker(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/linker/linker";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/Bur")
    public String bur(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/bur/bur";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    
    @RequestMapping("/Manus")
    public String manus(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/manus/manus";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    
    @RequestMapping("/Form")
    public String form(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/form/form";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping("/BossBattle")
    public String bossBattle(Model model){
        if (brukerdata.isInnlogget()){
            return "spill/boss/boss";
        }
        
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
}