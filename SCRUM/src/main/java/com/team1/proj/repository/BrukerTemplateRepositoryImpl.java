
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



public class BrukerTemplateRepositoryImpl implements BrukerRepository{
    
    private Connection forbindelse;
    private final String sqlDeleteBruker = "Delete from bruker where brukernavn = ?";
    private final String sqlSelectBruker = "Select * from bruker where brukernavn = ?";
    private final String sqlSelectAlleBrukere = "Select brukernavn from bruker";
    
    private final String sqlInsertBruker = "insert into bruker values(?,?,?)";
    private final String sqlUpdateBruker = "update bruker set passord=?, rettigheter = ? where brukernavn = ?";

    
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
    public Brukerdata getBruker(String brukernavn ){
        return (Brukerdata)jdbcTemplateObject.queryForObject(sqlSelectBruker, new Object[]{brukernavn}, new BrukerMapper());
    }
    @Override
    public List<Brukerdata> getAlleBrukere(){
        return jdbcTemplateObject.query(sqlSelectAlleBrukere, new BrukerMapper());
    }
    @Override
    public boolean slettBruker(Brukerdata bd) {
        jdbcTemplateObject.update(sqlDeleteBruker, bd.getBrukernavn() );
        return true;
    }
    @Override
    public boolean oppdaterBruker(Brukerdata bd){
        jdbcTemplateObject.update(sqlUpdateBruker, new Object[]{
            bd.getBrukernavn(),
            bd.getRettigheter(),
            bd.getPassord()
        });
        return true;
    }
    @Override
    public boolean registrerBruker(Brukerdata bd){
        jdbcTemplateObject.update(sqlInsertBruker, 
            new Object[]{
                bd.getBrukernavn(), 
                bd.getRettigheter(), 
                bd.getPassord()
        });
        return true;
    }
}

