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
    private String fornavn; 
    private int totalsum; 
    private int plassering;

    public Highscore(String fornavn, int totalsum) {
        this.fornavn = fornavn;
        this.totalsum = totalsum;
    }
    
    public Highscore(){
        
    }
    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public int getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(int totalsum) {
        this.totalsum = totalsum;
    }

    public int getPlassering() {
        return plassering;
    }

    public void setPlassering(int plassering) {
        this.plassering = plassering;
    }
}
