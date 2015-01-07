/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.mailoppsett;

/**
 *
 * @author Ingrid
 */
import java.security.SecureRandom;
import java.util.Random;

public class Passord {
    private static final Random RANDOM = new SecureRandom();
    public static final int PASSORD_LENGDE = 8;
    
    public static String autogenererPassord(){
        String bokstaver = "abcdefghijklnmopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String password = "";
        for(int i=0; i<PASSORD_LENGDE; i++){
            int index = (int)(RANDOM.nextDouble()*bokstaver.length());
            password+=bokstaver.substring(index, index+1);
        }
        return password;
    }
}
        
  
    

