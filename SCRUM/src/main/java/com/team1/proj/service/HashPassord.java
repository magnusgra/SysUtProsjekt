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
        System.out.println(securePassword + ":" + salt); //Prints 83ee5baeea20b6c21635e4ea67847f66
        String[] si = sikker.split(":");
        System.out.println("Splitt : "+ si[0]+":"+si[1]);
         
        String regeneratedPassowrdToVerify = getSecurePassword(passwordToHash, salt);
        System.out.println(regeneratedPassowrdToVerify + ":" + salt); //Prints 83ee5baeea20b6c21635e4ea67847f66
    }
   // public static String hashPassord(String passord) throws NoSuchAlgorithmException, NoSuchProviderException, java.security.NoSuchProviderException{
   //     String salt = HashPassord.getSalt(); 
    //    return HashPassord.getSecurePassword(passord, salt);
        
    //}
     
    public static String getSecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     
    //Add salt
    public static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException, java.security.NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt.toString();
    }

}

    
            
    

