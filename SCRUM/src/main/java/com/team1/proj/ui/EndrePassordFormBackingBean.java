/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.ui;

import com.team1.proj.brukerklasser.Brukerdata;

/**
 *
 * @author arnecs
 */
public class EndrePassordFormBackingBean {
    
    private Brukerdata brukerdata; 
    private String gammeltPassord;
    private String nyttPassord;
    private String gjentaNyttPassord;

    public EndrePassordFormBackingBean() {
    }


    public Brukerdata getBrukerdata() {
        return brukerdata;
    }

    public void setBrukerdata(Brukerdata brukerdata) {
        this.brukerdata = brukerdata;
    }

    public String getGammeltPassord() {
        return gammeltPassord;
    }

    public void setGammeltPassord(String gammeltPassord) {
        this.gammeltPassord = gammeltPassord;
    }

    public String getNyttPassord() {
        return nyttPassord;
    }

    public void setNyttPassord(String nyttPassord) {
        this.nyttPassord = nyttPassord;
    }

    public String getGjentaNyttPassord() {
        return gjentaNyttPassord;
    }

    public void setGjentaNyttPassord(String gjentaNyttPassord) {
        this.gjentaNyttPassord = gjentaNyttPassord;
    }
    
    public boolean passordErLik(){
        return nyttPassord.equals(gjentaNyttPassord);
    }
    
}
