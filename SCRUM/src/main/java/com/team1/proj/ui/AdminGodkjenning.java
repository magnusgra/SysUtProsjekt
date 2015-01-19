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
    
    
    public String getStatusClass(){
        return oppgaver.size() == 8 ? "gl-godkjent" : "gl-ikke-godkjent";
    }
    
    public String getStatus(){
        return oppgaver.size() == 8 ? "Godkjent" : "Ikke Godkjent";
    }
    
    public String getRettigheter(){
        switch (brukerdata.getRettigheter()) {
            case 0: //student
                return "Student";
            case 1: // Stud.ass
                return "Studentassistent";
            case 2: //Faglærer
                return "Faglærer";
            default:
                return "";
        }
    }
    
    public int getTotalPoeng(){
        int tot = 0;
        for (Oppgave o : oppgaver){
            tot += o.getPoeng();
        }
        return tot;
    }

    
}
