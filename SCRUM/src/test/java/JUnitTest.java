/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Highscore;
import com.team1.proj.brukerklasser.Oppgave;
import com.team1.proj.brukerklasser.Resultat;
import com.team1.proj.konfig.Konfig;
import com.team1.proj.repository.BrukerTemplateRepositoryImpl;
import com.team1.proj.repository.Repository;
import com.team1.proj.service.BrukerServiceImpl;
import java.util.List;
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
    private static BrukerTemplateRepositoryImpl temp= new BrukerTemplateRepositoryImpl();
    private static Repository repo; 
    
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
    public void testDbTilkobling(){
        
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        System.out.println("//TEST// testDbTilkobling() = funker!");
        
    }

    @Test
    public void testGetBrukerdata(){
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        Brukerdata bruker1 = new Brukerdata("Mari", "Thorsteinsen", "123",1, "mari.andrine.t@gmail.com");
        Brukerdata bruker2 = temp.getBrukerdata("mari.andrine.t@gmail.com");
        Brukerdata bruker3 = temp.getBrukerdata("123@123.no");
        assertEquals(bruker1, bruker2);
        if(bruker2 != null){
            System.out.println("//TEST// bruker1 er lik bruker2");
        }
       assertNotSame(bruker1, bruker3);
       if(bruker3 != null){
           System.out.println("//TEST//bruker1 er ikke lik bruker3");
       }
        System.out.println("//TEST// testGetBrukerdata() = funker!");
    }
    @Test
    public void testGetHighscore(){
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        List<Highscore> h = temp.getHighscore();
        if(h.size()>3){
            System.out.println("//TEST// getHighscoreTest() = funker!");
            
        }
        
    }
    @Test 
    public void testGetAlleBrukere(){
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        List<Resultat> godkjenning = temp.getAlleBrukere();
        if(godkjenning.size() > 3 ){
            System.out.println("//TEST// testGetAlleBrukere() = funker!");
        }
    }
    @Test
    public void testLoggInnHvisEksisterer(){
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        if(temp.loggInn("horten@horten.no", "123")!= null){
            System.out.println("//TEST// horten@horten.no eksiterer i databasen og kan logge inn");
        }
        if(temp.loggInn("123@hort.no", "123lj")== null){
            System.out.println("//TEST// 123@hort.no eksiterer IKKE i databasen og kan IKKE logge inn");
        }
        System.out.println("//TEST// testLoggInnHvisEksisterer() = funker!");
    }
    @Test
    public void testGetBrukerdataFraTil(){
       Konfig konfig = new Konfig();
       temp.setDataSource(konfig.dataSource()); 
       List<Brukerdata> fraTil = temp.getBrukerdata(0, 2);
       if(fraTil.size() == 3){
           System.out.println("//TEST// hentet ut bruker 0 til og med 2");
       }
       List<Brukerdata> fraTil2 = temp.getBrukerdata(3, 4);
       if(fraTil2.size() == 2){
           System.out.println("//TEST// hentet ut bruker 3 til og med 4");
       }
        System.out.println("//TEST// testGetBrukerdataFraTil() = funker!");
    }
    @Test
    public void testGetOppgaverFor(){
       Konfig konfig = new Konfig();
       temp.setDataSource(konfig.dataSource()); 
       Brukerdata bruker1 = new Brukerdata("Mari", "Thorsteinsen", "123",1, "mari.andrine.t@gmail.com");
       Brukerdata brukerSomIkkeEksisterer = new Brukerdata("Lars", "Hansen", "321",0, "hansen@lars.com");
       List<Oppgave> oppgavertilBruker = temp.getOppgaverFor(bruker1);
       if( oppgavertilBruker.size() > 1){
           System.out.println("//TEST// hentet ut oppgaver til bruker1");
       }
       if( temp.getOppgaverFor(brukerSomIkkeEksisterer) == null){
           System.out.println("//TEST// får ikke hentet ut oppgaver hos bruker som ikke eksisterer");
       }
       System.out.println("//TEST// testGetOppgaverFor() = funker!");
       
    }
    @Test
    public void testLeggTilBruker(){
       Konfig konfig = new Konfig();
       temp.setDataSource(konfig.dataSource());
       Brukerdata nyBruker = new Brukerdata("nybrukerTest", "nyBrukerTest", "123",0, "nybruker@nybruker.no");
       assertTrue(temp.leggTilBruker(nyBruker)); 
        System.out.println("//TEST//: lagt til ny bruker nybruker@nybruker.no");
       assertFalse(temp.leggTilBruker(nyBruker));
       System.out.println("//TEST//: prøver å legge til samme bruker pånytt (nybruker@nybruker.no)");
       assertTrue(temp.slettBruker(nyBruker));
        System.out.println("//TEST//: slettet den nye brukeren nybruker@nybruker.no");
       
    }
    @Test
    public void testLeggTilResultat(){
        
    }
}
