/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.controller;

import com.team1.proj.brukerklasser.Brukerdata; 
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author arnecs
 */


@Controller
@SessionAttributes("getUserBean")
public class MainController {
    
    @ModelAttribute("getUserBean")
    public Brukerdata getUserForm() {
        return new Brukerdata();
    }
    @RequestMapping(value="/*")
    public String index(){
        return "login";
    }
    @RequestMapping(value = "Startside")
    public String showStartside(@Valid @ModelAttribute(value = "getUserBean") Brukerdata userForm, BindingResult result) {
        System.out.println("******************     UserController.showStartside   ************************");
        if (result.hasErrors()) {
            return "login";
        }
        return "Startside";
    }
    
    @RequestMapping(value="RegistreringSide")
    public String registreringSide(){
        return "RSegistreringSide";
    }
    
    
}
