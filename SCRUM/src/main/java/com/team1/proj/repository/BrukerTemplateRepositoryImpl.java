
package com.team1.proj.repository;

/**
 *
 * @author Kai
 * Klasser for å hente/lagre/slette  fra DB.
 */

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Highscore;
import com.team1.proj.brukerklasser.Oppgave;
import com.team1.proj.ui.HighscoreListe;
import com.team1.proj.brukerklasser.Resultat;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;



public class BrukerTemplateRepositoryImpl implements Repository{
    
    private Connection forbindelse;
    private final String sqlDeleteBruker = "Delete from bruker where brukernavn = ?";
    private final String sqlSelectBruker = "Select * from bruker where etternavn = ?";
    private final String sqlSelectBrukerEpost = "Select * from bruker where epost = ?";
    private final String sqlSelectBrukerViaEpost = "Select * from bruker where epost = ? and passord = ?";
    private final String sqlSelectAlleBrukere = "Select brukernavn from bruker";
    private final String sqlSelect10Beste = "select bruker.fornavn, TOTALSUM from bruker natural join (select resultat.epost, SUM(resultat.poeng) AS TOTALSUM from resultat group by epost) poengsum order by TOTALSUM DESC FETCH NEXT 10 ROWS ONLY";
    
    private final String sqlInsertBruker = "insert into bruker values(?,?,?,?,?)";
    private final String sqlInsertResultat = "insert into resultat values(?, ?, ?, ?, ?)";
    private final String sqlUpdateBruker = "update bruker set passord=?, rettigheter = ?, epost = ? where brukernavn = ?";
    private final String sqlUpdateRettigheter = "update bruker set bruker.RETTIGHETER = ? where bruker.epost = ?";
    private final String sqlEndrePassord = "UPDATE bruker SET passord=? WHERE (epost=? AND passord=?)";
    private final String sqlHentGodkjenning = "select bruker.etternavn, bruker.fornavn, bruker.epost, bruker.rettigheter, (select resultat.POENG from resultat where oppgavenr=8 AND resultat.epost = bruker.epost) status from bruker";


    private final String sqlHentBrukerdataFraTil = "SELECT * FROM bruker ORDER BY etternavn ASC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    private final String sqlHentOppgaverForBruker = "SELECT * FROM resultat WHERE epost=?";
    
    private DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;
    
    public BrukerTemplateRepositoryImpl() {}
    
    @Autowired
    public void setDataSource(DataSource dataSource){
        System.out.println(" Database.setDataSource " + dataSource);
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    @Override
    public Brukerdata getBrukerdata(String epost ){
        try {
            return (Brukerdata)jdbcTemplateObject.queryForObject(sqlSelectBrukerEpost, new Object[]{epost}, new BrukerMapper());
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    @Override 
    public List<Resultat> getAlleBrukere(){
        try {
            return jdbcTemplateObject.query(sqlHentGodkjenning, new GodkjenningMapper());
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
   
    @Override
    public boolean leggTilBruker(Brukerdata bd){
        
        if (getBrukerdata(bd.getEpost()) == null){
            jdbcTemplateObject.update(sqlInsertBruker, 
                new Object[]{
                    bd.getFornavn(),
                    bd.getEtternavn(),
                    bd.getRettigheter(), 
                    bd.getPassord(),
                    bd.getEpost()
            });
            return true;
        }
        return false;
        
    }
    
    public void leggTilResultat(Resultat res){
        jdbcTemplateObject.update(sqlInsertResultat,
                new Object[]{
                res.getFornavn(),
                res.getEtternavn(),
                res.getEpost(),
                res.getRettigheter(),
                res.getStatus()
        });
    }
        
    @Override
    public boolean endrePassord(Brukerdata bd, String nyttPassord){
        
        
        return jdbcTemplateObject.update(sqlEndrePassord, nyttPassord, bd.getEpost(), bd.getPassord()) == 1;
        
    }
    @Override
    public List<Highscore> getHighscore(){
        System.out.println("******************** BrukerTemplateRepositoryImpl.getHighscore()*******************");
          return jdbcTemplateObject.query(sqlSelect10Beste, new HighscoreMapper());
	
    }
    
    @Override
    public Brukerdata loggInn(String epost, String passord){
        try{  
            return(Brukerdata)jdbcTemplateObject.queryForObject(sqlSelectBrukerViaEpost, new Object[]{epost,passord}, new BrukerMapper());
       
       }catch(EmptyResultDataAccessException e){
           return null; 
       }
       
    }
    
    @Override 
    public List<Brukerdata> getBrukerdata(int fra, int til) {
        try {
            return jdbcTemplateObject.query(sqlHentBrukerdataFraTil, new Object[]{new Integer(fra), new Integer(til - fra)}, new BrukerMapper());
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    
    public List<Oppgave> getOppgaverFor(Brukerdata brukerdata){
         try {
            return jdbcTemplateObject.query(sqlHentOppgaverForBruker, new Object[]{brukerdata.getEpost()}, new OppgaveMapper());
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    
}

