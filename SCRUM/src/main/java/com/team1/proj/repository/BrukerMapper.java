
package com.team1.proj.repository;

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
        bruker.setBrukernavn(rs.getString("brukernavn"));
        bruker.setRettigheter(rs.getInt("rettigheter"));
        bruker.setPassord(rs.getString("passord"));
        bruker.setEpost(rs.getString("epost"));
        return bruker;
    }
}

