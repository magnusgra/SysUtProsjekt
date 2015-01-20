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
        System.out.println("//TEST//: testDbTilkobling() = funker!");
        
    }

    @Test
    public void testGetBrukerdata(){
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        Brukerdata bruker1 = new Brukerdata("123", "123", "123",0,"123@123.no");
        Brukerdata bruker2 = new Brukerdata("test", "test", "123",0,"test@test.no");
        temp.leggTilBruker(bruker1);
        temp.leggTilBruker(bruker2);
        Brukerdata bruker4 = temp.getBrukerdata("123@123.no");
        Brukerdata bruker3 = temp.getBrukerdata("test@test.no");
        
        assertEquals(bruker1, bruker4);
        if(bruker4 != null){
            System.out.println("//TEST//: bruker1 er lik bruker2");
        }
        assertEquals(bruker2, bruker3);
        if(bruker3 != null){
           System.out.println("//TEST//: bruker1 er ikke lik bruker3");
       }
        System.out.println("//TEST//: testGetBrukerdata() = funker!");
        assertTrue(temp.slettBruker(bruker1));
        assertTrue(temp.slettBruker(bruker2));
    }
    @Test
    public void testGetHighscore(){
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        Brukerdata bruker1 = new Brukerdata("123", "123", "123",0,"123@123.no");
        Brukerdata bruker2 = new Brukerdata("test", "test", "123",0,"test@test.no");
        assertTrue(temp.leggTilBruker(bruker1));
        assertTrue(temp.leggTilBruker(bruker2));
        
        Resultat res1 = new Resultat(); res1.setFornavn("123"); res1.setEpost("123@123.no"); res1.setOppgavenr(1); res1.setPoeng(100);
        Resultat res2 = new Resultat(); res2.setFornavn("123"); res2.setEpost("123@123.no"); res2.setOppgavenr(2); res2.setPoeng(150);
        Resultat res3 = new Resultat(); res3.setFornavn("test"); res3.setEpost("test@test.no"); res3.setOppgavenr(1); res3.setPoeng(300);
        Resultat res4 = new Resultat(); res4.setFornavn("test"); res4.setEpost("test@test.no"); res4.setOppgavenr(2); res4.setPoeng(30);
        temp.leggTilResultat(res1);
        temp.leggTilResultat(res2);
        temp.leggTilResultat(res3);
        temp.leggTilResultat(res4);
        
        List<Highscore> h = temp.getHighscore();
        if(h.size()>1){
            System.out.println("//TEST//: getHighscoreTest() = funker!");
            
        }
        assertTrue(temp.slettResultat(res1));
        assertTrue(temp.slettResultat(res2));
        assertTrue(temp.slettResultat(res3));
        assertTrue(temp.slettResultat(res4));
        assertTrue(temp.slettBruker(bruker1));
        assertTrue(temp.slettBruker(bruker2));
        
    }
    
    @Test
    public void testLoggInnHvisEksisterer(){
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        Brukerdata bruker1 = new Brukerdata("test", "test", "123",0,"test@test.no");
        assertTrue(temp.leggTilBruker(bruker1));
        if(temp.loggInn("test@test.no", "123")!= null){
            System.out.println("//TEST//: test@test.no eksiterer i databasen og kan logge inn");
        }
        if(temp.loggInn("123@hort.no", "123lj")== null){
            System.out.println("//TEST//: 123@hort.no eksiterer IKKE i databasen og kan IKKE logge inn");
        }
        System.out.println("//TEST//: testLoggInnHvisEksisterer() = funker!");
        assertTrue(temp.slettBruker(bruker1));
    }
    
    @Test
    public void testGetBrukerdataFraTil(){
       Konfig konfig = new Konfig();
       temp.setDataSource(konfig.dataSource()); 
       Brukerdata bruker1 = new Brukerdata("123", "123", "123",0,"123@123.no");
       Brukerdata bruker2 = new Brukerdata("test", "test", "123",0,"test@test.no");
       Brukerdata bruker3 = new Brukerdata("ting", "ting", "123",0, "ting@ting.no");
       assertTrue(temp.leggTilBruker(bruker1));
       assertTrue(temp.leggTilBruker(bruker2));
       assertTrue(temp.leggTilBruker(bruker3));
       
       List<Brukerdata> fraTil = temp.getBrukerdata(0, 1);
       if(fraTil.size() == 2){
           System.out.println("//TEST//: hentet ut bruker 0 til og med 1");
       }
       List<Brukerdata> fraTil2 = temp.getBrukerdata(1, 2);
       if(fraTil2.size() == 2){
           System.out.println("//TEST//: hentet ut bruker 1 til og med 2");
       }
        System.out.println("//TEST//: testGetBrukerdataFraTil() = funker!");
        
        assertTrue(temp.slettBruker(bruker1));
        assertTrue(temp.slettBruker(bruker2));
        assertTrue(temp.slettBruker(bruker3));
    }
    @Test
    public void testGetOppgaverFor(){
       Konfig konfig = new Konfig();
       temp.setDataSource(konfig.dataSource()); 
       
       Brukerdata bruker1 = new Brukerdata("123", "123", "123",0,"123@123.no");
        assertTrue(temp.leggTilBruker(bruker1));
        
        Resultat res1 = new Resultat(); res1.setFornavn("123"); res1.setEpost("123@123.no"); res1.setOppgavenr(1); res1.setPoeng(100);
        Resultat res2 = new Resultat(); res2.setFornavn("123"); res2.setEpost("123@123.no"); res2.setOppgavenr(2); res2.setPoeng(150);
        temp.leggTilResultat(res1);
        temp.leggTilResultat(res2);
        
       Brukerdata brukerSomIkkeEksisterer = new Brukerdata("Lars", "Hansen", "321",0, "hansen@lars.com");
       
       List<Oppgave> oppgavertilBruker = temp.getOppgaverFor(bruker1);
       if( oppgavertilBruker.size() > 1){
           System.out.println("//TEST//: hentet ut oppgaver til bruker1");
       }
       if( temp.getOppgaverFor(brukerSomIkkeEksisterer) == null){
           System.out.println("//TEST//: får ikke hentet ut oppgaver hos bruker som ikke eksisterer");
       }
       System.out.println("//TEST//: testGetOppgaverFor() = funker!");
       
        assertTrue(temp.slettResultat(res1));
        assertTrue(temp.slettResultat(res2));
        assertTrue(temp.slettBruker(bruker1));
       
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
       Konfig konfig = new Konfig();
       temp.setDataSource(konfig.dataSource()); 
       Brukerdata bruker1 = new Brukerdata("123", "test", "123",0,"123@123.no");
       assertTrue(temp.leggTilBruker(bruker1));
       Resultat resTest = new Resultat(); resTest.setFornavn("123"); resTest.setEpost("123@123.no"); resTest.setOppgavenr(3);  resTest.setPoeng(123);
       temp.leggTilResultat(resTest);
       System.out.println("//TEST//: legger til nytt resultat for oppgave 11 for test@test.no");
        
       assertTrue(temp.slettResultat(resTest));
       assertTrue(temp.slettBruker(bruker1));
       System.out.println("//TEST//: sletter resultat for oppgave 11 for test@test.no");
       System.out.println("//TEST//: testLeggTilResultat()");
        
    }
    @Test
    public void testEndrePassord(){
       Konfig konfig = new Konfig();
       temp.setDataSource(konfig.dataSource());
       Brukerdata bruker1 = new Brukerdata("123", "123", "123",0,"123@123.no");
       assertTrue(temp.leggTilBruker(bruker1));
       assertTrue(temp.endrePassord(bruker1, "321"));
       System.out.println("//TEST//: endrer passord til test@test.no");
        System.out.println("//TEST//: testEndrePassord() = funker!");
        assertTrue(temp.slettBruker(bruker1));
       
    }
    @Test
    public void testEndreRettigheter(){
        Konfig konfig = new Konfig();
       temp.setDataSource(konfig.dataSource());
       Brukerdata bruker1 = new Brukerdata("test", "testesen", "123",0, "test@test.no");
        assertTrue(temp.leggTilBruker(bruker1));
        assertTrue(temp.endreRettigheter(bruker1, 1));
        assertTrue(temp.endreRettigheter(bruker1, 0));
        System.out.println("//TEST//: endrer tilbake rettigheter til test@test.no");
        System.out.println("//TEST//: testEndreRettigheter() = funker!");
        assertTrue(temp.slettBruker(bruker1));
        
    }
    @Test
    public void  testGetAntBrukere(){
        Konfig konfig = new Konfig();
        temp.setDataSource(konfig.dataSource());
        Brukerdata bruker1 = new Brukerdata("test", "testesen", "123",0, "test@test.no");
        assertTrue(temp.leggTilBruker(bruker1));
        int antBrukere = temp.getAntBrukere();
        if(antBrukere > 0){
            System.out.println("//TEST//: testGetAntBrukere() = funker!");
        }
        assertTrue(temp.slettBruker(bruker1));
    }
}
