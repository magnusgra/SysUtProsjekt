/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.ui;

import com.team1.proj.brukerklasser.Highscore;
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
        setPlasseringer();
    }
    
    
    public void setPlasseringer(){
        int plass = 0;
        int score = Integer.MAX_VALUE;
        int sammeScore = 0;
        
        for (Highscore highscore : higscoreliste) {
            if (highscore.getTotalsum() <= score) {
                score = highscore.getTotalsum();
                plass += sammeScore + 1;
                sammeScore = 0;
            } else {
                sammeScore++;
            }
            highscore.setPlassering(plass);
        }
    }
    
}
