/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.controller;

import com.team1.proj.; 
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author arnecs
 */


@Controller
public class MainController {
    
    @RequestMapping(value="/*")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "Startside")
    public String showSpam(@Valid @ModelAttribute(value = "getPersonBean") Brukerdata userForm, BindingResult result) {
        System.out.println("******************     UserController.showSpam   ************************");
        if (result.hasErrors()) {
            return "index";
        }
        return "Startside";
    }
    
}
