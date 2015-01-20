/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.service;

/**
 *
 * @author Ingrid
 */
import java.security.SecureRandom;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.mail.NoSuchProviderException;


 // PBKDF2 saltet passord hashing.
 
public class HashPassord {
    public static void main(String[] args) {
        String passwordToHash = "password";
        String salt = null;
        try{
            salt = HashPassord.getSalt();
        }catch(NoSuchAlgorithmException | NoSuchProviderException | java.security.NoSuchProviderException e){
            e.printStackTrace();
        }
        String securePassword = getSecurePassword(passwordToHash, salt);
        String sikker = securePassword+":"+salt; 
        System.out.println(securePassword + ":" + salt); //skriver 83ee5baeea20b6c21635e4ea67847f66
        String[] si = sikker.split(":");
        System.out.println("Splitt : "+ si[0]+":"+si[1]);
         
        String regeneratedPassowrdToVerify = getSecurePassword(passwordToHash, salt);
        System.out.println(regeneratedPassowrdToVerify + ":" + salt); //skriver 83ee5baeea20b6c21635e4ea67847f66
    }
   // public static String hashPassord(String passord) throws NoSuchAlgorithmException, NoSuchProviderException, java.security.NoSuchProviderException{
   //     String salt = HashPassord.getSalt(); 
    //    return HashPassord.getSecurePassword(passord, salt);
        
    //}
     
    public static String getSecurePassword(String passwordToHash, String salt){
        String generertPassord = null;
        try {
            // Lager MessageDigest instanse for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Legger til passord-bytes til digest
            md.update(salt.getBytes());
            //Henter bytes fra hashen
            byte[] bytes = md.digest(passwordToHash.getBytes());
            // bytes[] har bytes på desimalformat;
            //Konverterer det til hexadesimalt format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //lager det hashede passordet i hex-format
            generertPassord = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generertPassord;
    }
    
    public static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException, java.security.NoSuchProviderException
    {
        //Bruker SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //lager en byteliste med saltet
        byte[] salt = new byte[16];
        //henter tilfeldig salt
        sr.nextBytes(salt);
        //returnerer salt
        return salt.toString();
    }

}

    
            
    

