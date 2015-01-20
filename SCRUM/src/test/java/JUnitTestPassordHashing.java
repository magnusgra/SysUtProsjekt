/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team1.proj.service.HashPassord;
import static com.team1.proj.service.HashPassord.getSecurePassword;
import java.security.NoSuchAlgorithmException;
import javax.mail.NoSuchProviderException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mari
 */
public class JUnitTestPassordHashing {
    
    public JUnitTestPassordHashing() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testHashingAvPassord() {
        String passordTilHash = "passord";
        String salt = null;
        String salt2 = null;
        try{
            salt = HashPassord.getSalt();
            salt2 = HashPassord.getSalt();
        }catch(NoSuchAlgorithmException | NoSuchProviderException | java.security.NoSuchProviderException e){
            e.printStackTrace();
        }
        String sikkertPassord = getSecurePassword(passordTilHash, salt);
        String sikkertPassord2 = getSecurePassword(passordTilHash, salt2);
        String regenerertPassordVerifisering = getSecurePassword(passordTilHash, salt);
        
        System.out.println( sikkertPassord+ ":" + salt); //skriver 83ee5baeea20b6c21635e4ea67847f66
        System.out.println( sikkertPassord2+ ":" + salt2);
        System.out.println(regenerertPassordVerifisering + ":" + salt); //skriver 83ee5baeea20b6c21635e4ea67847f66
        
        assertEquals(sikkertPassord, regenerertPassordVerifisering);
        assertNotSame(salt, salt2);
        assertNotSame(sikkertPassord, sikkertPassord2);
        System.out.println("//TEST//: testHashingAvPassord() = funker!");
    
    }
}
