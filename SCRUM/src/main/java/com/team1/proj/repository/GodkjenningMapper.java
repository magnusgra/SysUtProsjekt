/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.repository;

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Resultat;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Mari
 */
public class GodkjenningMapper implements RowMapper<Resultat>  {
    @Override
    public Resultat mapRow(ResultSet rs, int i) throws SQLException {
        Resultat res = new Resultat(); 
        Brukerdata bruker = new Brukerdata();
        bruker.setBrukernavn(rs.getString("etternavn"));
        bruker.setBrukernavn(rs.getString("fornavn"));
        bruker.setEpost(rs.getString("epost"));
        res.setStatus(rs.getString("status"));
        return res;
    }
}
