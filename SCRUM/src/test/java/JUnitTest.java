/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.repository.BrukerTemplateRepositoryImpl;
import com.team1.proj.repository.Repository;
import com.team1.proj.service.BrukerServiceImpl;
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
public class JUnitTest {
    
    public JUnitTest() {
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
    @Test
    public void test(){
        Repository repo = new Repository();
        BrukerServiceImpl bs = new BrukerServiceImpl(); 
        Brukerdata bruker = new Brukerdata("Mari", "Thorsteinsen", "123",1, "mari.andrine.t@gmail.com");
        bs.setRepository(repo);
        Brukerdata brukerdatabase = bs.getBrukerdata("mari.andrine.t@gmail.com");
        //assertEquals(bruker, brukerdatabase);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
