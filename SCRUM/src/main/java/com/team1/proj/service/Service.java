/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.service;

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.mailoppsett.Mail;
import com.team1.proj.repository.Repository;

/**
 *
 * @author arnecs
 */
public class Service {
    
    private Repository repo;
    
    
    public void registrerBruker(Brukerdata brukerdata){
        Mail mail = new Mail();
        brukerdata.setPassword(mail.sendMailMedPassord(brukerdata));
        
    }
    
}
