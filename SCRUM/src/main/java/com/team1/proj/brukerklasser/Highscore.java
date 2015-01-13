/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.brukerklasser;

/**
 *
 * @author Mari
 */
public class Highscore {
    private String brukernavn; 
    private int totalsum; 

    public Highscore(String brukernavn, int totalsum) {
        this.brukernavn = brukernavn;
        this.totalsum = totalsum;
    }
    
    public Highscore(){
        
    }
    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public int getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(int totalsum) {
        this.totalsum = totalsum;
    }
    
    
}
