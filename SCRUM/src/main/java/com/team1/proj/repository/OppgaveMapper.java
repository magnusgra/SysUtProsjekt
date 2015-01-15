/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.repository;

import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.Oppgave;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author arnecs
 */
public class OppgaveMapper implements RowMapper<Oppgave> {

    @Override
    public Oppgave mapRow(ResultSet rs, int i) throws SQLException {
        
        Oppgave oppgave = new Oppgave();
        oppgave.setOppgavenr(rs.getInt("oppgavenr"));
        oppgave.setPoeng(rs.getInt("poeng"));
        return oppgave;
    }
}

