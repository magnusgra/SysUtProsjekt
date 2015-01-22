
package com.team1.proj.repository;

/**
 *
 * @author Kai
 * Klasser for å hente/lagre/slette  fra DB.
 */

import com.team1.proj.repository.mapper.GodkjenningMapper;
import com.team1.proj.repository.mapper.HighscoreMapper;
import com.team1.proj.repository.mapper.OppgaveMapper;
import com.team1.proj.repository.mapper.BrukerMapper;
import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Highscore;
import com.team1.proj.brukerklasser.Oppgave;
import com.team1.proj.ui.HighscoreListe;
import com.team1.proj.brukerklasser.Resultat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class BrukerTemplateRepositoryImpl implements Repository{
    

    private final String sqlDeleteBruker = "Delete from bruker where epost = ?";
    private final String sqlDeleteResultat = "Delete from resultat where epost = ? and oppgavenr = ?";
    private final String sqlSelectBrukerEpost = "select bruker.*, resultat.oppgavenr from bruker LEFT OUTER join resultat on (resultat.epost = bruker.epost)  where bruker.epost = ? order by oppgavenr DESC limit 1";
    private final String sqlSelectBrukerViaEpost = "select bruker.*, resultat.oppgavenr from bruker LEFT OUTER join resultat on (resultat.epost = bruker.epost) where bruker.epost = ? and passord = ? order by oppgavenr DESC limit 1";

    private final String sqlSelect10Beste = "select bruker.fornavn, TOTALSUM from bruker natural join (select resultat.epost, SUM(resultat.poeng) AS TOTALSUM from resultat group by epost) poengsum order by TOTALSUM DESC LIMIT 10";
    
    private final String sqlInsertBruker = "insert into bruker values(?,?,?,?,?)";
    private final String sqlInsertResultat = "insert into resultat values(?, ?, ?)";
    private final String sqlUpdateResultat = "update resultat set poeng = case when poeng < ? then ? else poeng end where (epost = ? and oppgavenr = ?)";
    
    
    private final String sqlUpdateRettigheter = "update bruker set bruker.RETTIGHETER = ? where bruker.epost = ?";
    private final String sqlEndrePassord = "UPDATE bruker SET passord=? WHERE (epost=? AND passord=?)";
    private final String sqlHentGodkjenning = "select bruker.etternavn, bruker.fornavn, bruker.epost, bruker.rettigheter, (select resultat.POENG from resultat where oppgavenr=8 AND resultat.epost = bruker.epost) status from bruker";


    private final String sqlHentBrukerdataFraTil = "SELECT * FROM bruker ORDER BY etternavn ASC LIMIT ? OFFSET ?;";
    private final String sqlHentOppgaverForBruker = "SELECT * FROM resultat WHERE epost=? ORDER BY oppgavenr ASC";
    private final String sqlHentAntBrukere = "SELECT COUNT(*) AS antall FROM bruker";
    
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
        try{
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
    public boolean slettBruker(Brukerdata bd){
        if(getBrukerdata(bd.getEpost())!=null){
            jdbcTemplateObject.update(sqlDeleteBruker, bd.getEpost());
            return true;
        }
        return false;
    }
    @Override
    public void leggTilResultat(Resultat res){
        try {
            jdbcTemplateObject.update(sqlInsertResultat,
                    new Object[]{
                    res.getEpost(),
                    res.getOppgavenr(),
                    res.getPoeng()
            });
        } catch (Exception e){
            jdbcTemplateObject.update(sqlUpdateResultat,
                    new Object[]{
                    res.getPoeng(),
                    res.getPoeng(),
                    res.getEpost(),
                    res.getOppgavenr()
                    
            });
        }
        
    }
    public boolean slettResultat(Resultat res){
        return jdbcTemplateObject.update(sqlDeleteResultat, res.getEpost(), res.getOppgavenr()) == 1;       
       
    }
        
    @Override
    public boolean endrePassord(Brukerdata bd, String nyttPassord){
        return jdbcTemplateObject.update(sqlEndrePassord, nyttPassord, bd.getEpost(), bd.getPassord()) == 1;
        
    }
    @Override
    public boolean endreRettigheter(Brukerdata bd, int rettigheter){
        return jdbcTemplateObject.update(sqlUpdateRettigheter, rettigheter, bd.getEpost())== 1; 
    }
    @Override
    public List<Highscore> getHighscore(){
        try{
            System.out.println("******************** BrukerTemplateRepositoryImpl.getHighscore()*******************");
             return jdbcTemplateObject.query(sqlSelect10Beste, new HighscoreMapper());
        }catch(EmptyResultDataAccessException e){
           return null;
        }
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
            return jdbcTemplateObject.query(sqlHentBrukerdataFraTil, new Object[]{new Integer(til - fra), new Integer(fra)}, new BrukerMapper());
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
    
    @Override
    public int getAntBrukere(){
        try {
            return jdbcTemplateObject.queryForObject(sqlHentAntBrukere, Integer.class).intValue();
            
        } catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
}

