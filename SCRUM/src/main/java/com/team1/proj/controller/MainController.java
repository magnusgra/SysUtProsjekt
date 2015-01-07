/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.controller;

import org.springframework.stereotype.Controller;
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
    
}
