
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
import com.team1.proj.brukerklasser.HighscoreListe;
import com.team1.proj.brukerklasser.Resultat;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;



public class BrukerTemplateRepositoryImpl implements Repository{
    
    private Connection forbindelse;
    private final String sqlDeleteBruker = "Delete from bruker where brukernavn = ?";
    private final String sqlSelectBruker = "Select * from bruker where brukernavn = ?";
    private final String sqlSelectBrukerViaEpost = "Select * from bruker where epost = ? and passord = ?";
    private final String sqlSelectAlleBrukere = "Select brukernavn from bruker";
    private final String sqlSelect10Beste = "select bruker.brukernavn, TOTALSUM from bruker natural join (\n" +
"    select resultat.epost, SUM(resultat.poeng) AS TOTALSUM from resultat group by epost\n" +
") poengsum order by TOTALSUM DESC FETCH NEXT 10 ROWS ONLY;";
    
    private final String sqlInsertBruker = "insert into bruker values(?,?,?,?)";
    private final String sqlInsertResultat = "insert into resultat values(?, ?, ?, ?, ?)";
    private final String sqlUpdateBruker = "update bruker set passord=?, rettigheter = ?, epost = ? where brukernavn = ?";
    private final String sqlUpdateRettigheter = "update bruker set bruker.RETTIGHETER = ? where bruker.epost = ?";
    
    

    
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
    public Brukerdata getBrukerdata(String brukernavn ){
        return (Brukerdata)jdbcTemplateObject.queryForObject(sqlSelectBruker, new Object[]{brukernavn}, new BrukerMapper());
    }
   
    @Override
    public void leggTilBruker(Brukerdata bd){
        jdbcTemplateObject.update(sqlInsertBruker, 
            new Object[]{
                bd.getBrukernavn(), 
                bd.getRettigheter(), 
                bd.getPassord(),
                bd.getEpost()
        });
    }
    
    public void leggTilResultat(Resultat res){
        jdbcTemplateObject.update(sqlInsertResultat,
                new Object[]{
                res.getBrukerdata(), 
                res.getForsoknr(), 
                res.getOppgavenr(),
                res.getPoeng(),
                res.getStatus()
        });
    }
        
    @Override
    public boolean endrePassord(Brukerdata bd, String nyttPassord){
        return true;
    }
    @Override
    public HighscoreListe getHighscore(){
          
	List<Highscore> brukere = new ArrayList<Highscore>();
          HighscoreListe liste = new HighscoreListe(brukere);
          
	List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(sqlSelect10Beste);
	for (Map row : rows) {
		Highscore bruker = new Highscore();
		bruker.setBrukernavn((String)(row.get("BRUKERNAVN")));
		bruker.setTotalsum((int)(Integer)row.get("TOTALSUM"));
		brukere.add(bruker);
	}
 
	return liste;
    }
    
    @Override
    public Brukerdata loggInn(String epost, String passord){
        try{  
            return(Brukerdata)jdbcTemplateObject.queryForObject(sqlSelectBrukerViaEpost, new Object[]{epost,passord}, new BrukerMapper());
       
       }catch(EmptyResultDataAccessException e){
           return null; 
       }
       
    }
}

