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
        System.out.println("******************     UserController.showLogin   ************************");
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
    
    @RequestMapping(value = "endrepassord")
    public String showEndrePassord(@Valid @ModelAttribute(value = "getUserBean") Brukerdata userForm, BindingResult result) {
        System.out.println("******************     UserController.showStartside   ************************");
        if (result.hasErrors()) {
            return "startside";
        }
        return "endrepassord";
    }
    
    @RequestMapping(value = "highscore")
    public String showHighscore(@Valid @ModelAttribute(value = "getUserBean") Brukerdata userForm, BindingResult result) {
        System.out.println("******************     UserController.showStartside   ************************");
        if (result.hasErrors()) {
            return "startside";
        }
        return "highscore";
    }
    
    @RequestMapping(value="RegistreringSide")
    public String registreringSide(){
        System.out.println("******************     UserController.showRegistreringSide   ************************");
        return "RegistreringSide";
    }
    
    
}
