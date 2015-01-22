
package com.team1.proj.repository.mapper;

/**
 *
 * @author Kai
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.team1.proj.brukerklasser.Brukerdata;

public class BrukerMapper implements RowMapper<Brukerdata> {

    @Override
    public Brukerdata mapRow(ResultSet rs, int i) throws SQLException {
        Brukerdata bruker = new Brukerdata();
        bruker.setFornavn(rs.getString("fornavn"));
        bruker.setEtternavn(rs.getString("etternavn"));
        bruker.setRettigheter(rs.getInt("rettigheter"));
        bruker.setPassord(rs.getString("passord"));
        bruker.setEpost(rs.getString("epost"));
        try {
            bruker.setSisteOppgaveKlart(rs.getInt("oppgavenr"));
        } catch (SQLException sqle){
            bruker.setSisteOppgaveKlart(0);
        }   
        System.out.println("Siste Oppgave Klart: " + bruker.getSisteOppgaveKlart());
        
        return bruker;
    }
}

