/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.ui;

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Oppgave;
import java.util.List;

/**
 *
 * @author arnecs
 */
public class AdminGodkjenning {
    private Brukerdata brukerdata;
    private List<Oppgave> oppgaver;

    public AdminGodkjenning() {
    }

    public Brukerdata getBrukerdata() {
        return brukerdata;
    }

    public void setBrukerdata(Brukerdata brukerdata) {
        this.brukerdata = brukerdata;
    }

    public List<Oppgave> getOppgaver() {
        return oppgaver;
    }

    public void setOppgaver(List<Oppgave> oppgaver) {
        this.oppgaver = oppgaver;
    }
    

    
}
