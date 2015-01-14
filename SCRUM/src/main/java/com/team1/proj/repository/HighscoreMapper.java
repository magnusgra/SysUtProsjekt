/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.repository;

/**
 *
 * @author Mari
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.team1.proj.brukerklasser.Highscore;


public class HighscoreMapper implements RowMapper<Highscore>{
    @Override
    public Highscore mapRow(ResultSet rs, int i) throws SQLException {
        System.out.println("******************** HighscoreMapper.mapRow()*******************");
        Highscore bruker = new Highscore();
        bruker.setFornavn(rs.getString("fornavn"));
        bruker.setTotalsum(rs.getInt("totalsum"));
        return bruker;
    }
}
