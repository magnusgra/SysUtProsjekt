/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.brukerklasser;

import java.util.List;

/**
 *
 * @author Mari
 */
public class HighscoreListe {
    private List<Highscore> higscoreliste; 

    public HighscoreListe(List<Highscore> higscoreliste) {
        this.higscoreliste = higscoreliste;
    }
    public HighscoreListe(){
        
    }

    public List<Highscore> getHigscoreliste() {
        return higscoreliste;
    }

    public void setHigscoreliste(List<Highscore> higscoreliste) {
        this.higscoreliste = higscoreliste;
    }
    
}
