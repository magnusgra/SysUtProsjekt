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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


 // PBKDF2 saltet passord hashing.
 
public class HashPassord {
    public static final String PBKDF2_ALGORITME = "PBKDF2WithHmacSHA1";

    public static final int SALT_BYTE_STR = 24;
    public static final int HASH_BYTE_STR = 24;
    public static final int PBKDF2_KJORING = 1000;

    public static final int KJORE_INDEKS = 0;
    public static final int SALT_INDEKS = 1;
    public static final int PBKDF2_INDEKS = 2;

    /*
     * Returnerer et saltet PBKDF2-hash av passordet.
     */
    public static String lagHash(String passord) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return lagHash(passord.toCharArray());
    }

    public static String lagHash(char[] passord) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Genererer et random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTE_STR];
        random.nextBytes(salt);

        // Hasher passorder
        byte[] hash = pbkdf2(passord, salt, PBKDF2_KJORING, HASH_BYTE_STR);
        // formaterer kjøring:salt:hash
        return PBKDF2_KJORING + ":" + toHex(salt) + ":" +  toHex(hash);
    }

    /*
     * Validerer et passord som bruker hash.
     */
    public static boolean validerPassord(String passord, String riktigHash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return validerPassord(passord.toCharArray(), riktigHash);
    }

    public static boolean validerPassord(char[] passord, String riktigHash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Dekoder hashen til dens parametre
        String[] params = riktigHash.split(":");
        int iterations = Integer.parseInt(params[KJORE_INDEKS]);
        byte[] salt = fromHex(params[SALT_INDEKS]);
        byte[] hash = fromHex(params[PBKDF2_INDEKS]);
        byte[] testHash = pbkdf2(passord, salt, iterations, hash.length);
        return slowEquals(hash, testHash);
    }

    /**
     * SAmmenlikner to byte tabeller i lengde-tid. Metoden brukes
     * slik at passordhasher ikke kan tas ut fra et online system
     * ved å bruke et "timing attack" å følgende attacke offline
     */
    private static boolean slowEquals(byte[] a, byte[] b)
    {
        int diff = a.length ^ b.length;
        for(int i = 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }

    /**
     *  Beregner PBKDF2 hashen til et passord.
     */
    private static byte[] pbkdf2(char[] passord, byte[] salt, int iterations, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(passord, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITME);
        return skf.generateSecret(spec).getEncoded();
    }

    /**
     * Konverterer en string av hexadesimal characters til en byte tabell
     */
    private static byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }

    /**
     * Konverterer en byte tabell til en  hexadesimal string.
     */
    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0) 
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }

    /**
     * Tester
     */
    public static void main(String[] args)
    {
        try
        {
            // Printer ut 10 hasher
            for(int i = 0; i < 10; i++)
                System.out.println(HashPassord.lagHash("p\r\nassw0Rd!"));

            // Tester passord validering
            boolean failure = false;
            System.out.println("Kjører tester...");
            for(int i = 0; i < 100; i++)
            {
                String passord = ""+i;
                String hash = lagHash(passord);
                String andreHash = lagHash(passord);
                if(hash.equals(andreHash)) {
                    System.out.println("FEIL: TO HASHER ER LIKE!");
                    failure = true;
                }
                String feilPassword = ""+(i+1);
                if(validerPassord(feilPassword, hash)) {
                    System.out.println("FEIL: FEIL PASSORD AKSEPTERT!");
                    failure = true;
                }
                if(!validerPassord(passord, hash)) {
                    System.out.println("FEIL: GYLDIG PASSORD IKKE AKSEPTERT!");
                    failure = true;
                }
            }
            if(failure)
                System.out.println("TEST FEILET!");
            else
                System.out.println("TEST OK!");
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex);
        }
    }

}

    
            
    

