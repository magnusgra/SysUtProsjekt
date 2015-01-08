/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.brukerklasser;

import javax.validation.constraints.NotNull;

/**
 *
 * @author arnecs
 */
public class RegistreringsForm {
    
    @NotNull
    private Brukerdata brukerdata;
    private boolean godtarBrukervilkar;

    public RegistreringsForm(){
        
    }
    
    public Brukerdata getBrukerdata() {
        return brukerdata;
    }

    public void setBrukerdata(Brukerdata brukerdata) {
        this.brukerdata = brukerdata;
    }

    public boolean isGodtarBrukervilkar() {
        return godtarBrukervilkar;
    }

    public void setGodtarBrukervilkar(boolean godtarBrukervilkar) {
        this.godtarBrukervilkar = godtarBrukervilkar;
    }
    
    
    
    
}
