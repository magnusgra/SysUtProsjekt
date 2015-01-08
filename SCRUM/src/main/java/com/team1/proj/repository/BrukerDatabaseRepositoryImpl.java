/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.repository.utils.Opprydder;

/*
 * @Kai
 */

public class BrukerDatabaseRepositoryImpl implements BrukerRepository{
    private Connection forbindelse;
    private final String sqlDeleteBruker = "Delete from bruker where brukernavn = ?";
    private final String sqlSelectBruker = "Select brukernavn from bruker where brukernavn = ?";
    private final String sqlSelectAlleBrukere = "Select brukernavn from bruker";
    
    private final String sqlInsertBruker = "insert into bruker values(?,?,?)";
    private final String sqlUpdateBruker = "update bruker set brukernavn=?, rettigheter = ? where passord = ?";

    
    private DataSource dataSource;
    
    public BrukerDatabaseRepositoryImpl() {}
    
    @Autowired
    public void setDataSource(DataSource dataSource){
        System.out.println(" Database.setDataSource " + dataSource);
        this.dataSource = dataSource;
    }
    
    private void åpneForbindelse() throws Exception {
        try {
            System.out.println("Skal åpne forbindelse");
            forbindelse = dataSource.getConnection();
            System.out.println("**** Databaseforbindelse opprettet***");
        } catch (SQLException e) {
            System.out.println(" SqlFeil: " + e);
            Opprydder.skrivMelding(e, "Konstruktøren");
            Opprydder.lukkForbindelse(forbindelse);
        } catch( Exception ee){
            System.out.println(" Feil " + ee);
        }
    }

    private void lukkForbindelse() {
        System.out.println("Lukker databaseforbindelsen");
        Opprydder.lukkForbindelse(forbindelse);
    }
    
    public Brukerdata getBruker(String brukernavn){
        System.out.println("Database.getBruker()");
        PreparedStatement stmt = null;
        ResultSet res;
        Brukerdata bd = null;
        try {
            åpneForbindelse();
            stmt = forbindelse.prepareStatement(sqlSelectBruker);
            stmt.setString(1, brukernavn);
            res = stmt.executeQuery();
            if (res.next()) {
                bd = new Brukerdata(res.getString("brukernavn"),res.getInt("rettigheter"), res.getString("passord"));
            }
        } catch (SQLException e) {
            Opprydder.rullTilbake(forbindelse);
            Opprydder.skrivMelding(e, "getAlleBrukere()");
        } catch (Exception e) {
            Opprydder.skrivMelding(e, "getAlleBrukere - ikke sqlfeil");
        } finally {
            Opprydder.settAutoCommit(forbindelse);
            Opprydder.lukkSetning(stmt);
        }
        lukkForbindelse();
        System.out.println(" Database.getBruker(). Har funnet bruker=" + bd );
        return bd;
    }

    public ArrayList<Brukerdata> getAlleBrukere() {
        System.out.println("Database.getAlleBrukere()");
        PreparedStatement psSelectAlle = null;
        ResultSet res;
        ArrayList<Brukerdata> brukerListe = null;
        try {
            åpneForbindelse();
            psSelectAlle = forbindelse.prepareStatement(sqlSelectAlleBrukere);
            res = psSelectAlle.executeQuery();
            while (res.next()) {
                Brukerdata bd = new Brukerdata(res.getString("brukernavn"), res.getInt("rettigheter"), res.getString("passord"));
                if (brukerListe == null) {
                    brukerListe = new ArrayList<Brukerdata>();
                }
                brukerListe.add(bd);
            }
        } catch (SQLException e) {
            Opprydder.rullTilbake(forbindelse);
            Opprydder.skrivMelding(e, "getAlleBrukere()");
        } catch (Exception e) {
            Opprydder.skrivMelding(e, "getAlleBrukere - ikke sqlfeil");
        } finally {
            Opprydder.settAutoCommit(forbindelse);
            Opprydder.lukkSetning(psSelectAlle);
        }
        lukkForbindelse();
        System.out.println(" Database.getAlleBrukere(). Har funnet #bruker=" + brukerListe.size());
        return brukerListe;
    }

    public synchronized boolean registrerBruker(Brukerdata bd) {
        boolean ok = false;
        System.out.println("Database.registrerBruker()");
        PreparedStatement psInsertBruker = null;

        try {
            åpneForbindelse();
            psInsertBruker = forbindelse.prepareStatement(sqlInsertBruker);
            psInsertBruker.setString(1, bd.getBrukernavn());
            psInsertBruker.setInt(2, bd.getRettigheter());
            psInsertBruker.setString(3, bd.getPassord());

            int i = psInsertBruker.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (SQLException e) {
            Opprydder.rullTilbake(forbindelse);
            Opprydder.skrivMelding(e, "*** registrerBruker()");
        } catch (Exception e) {
            Opprydder.skrivMelding(e, "**** registrerBruker - ikke sqlfeil");
        } finally {
            Opprydder.settAutoCommit(forbindelse);
            Opprydder.lukkSetning(psInsertBruker);
        }
        lukkForbindelse();
        return ok;
    }

    public synchronized boolean oppdaterBruker(Brukerdata bd) {
        boolean ok = false;
        System.out.println("oppdaterBruker()");
        PreparedStatement psUpdateBruker = null;

        try {
            åpneForbindelse();
            psUpdateBruker = forbindelse.prepareStatement(sqlUpdateBruker);
            psUpdateBruker.setString(1, bd.getBrukernavn());
            psUpdateBruker.setInt(2, bd.getRettigheter());
            psUpdateBruker.setString(3, bd.getPassord());

            int i = psUpdateBruker.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (SQLException e) {
            Opprydder.rullTilbake(forbindelse);
            Opprydder.skrivMelding(e, "oppdaterBruker()");
        } catch (Exception e) {
            Opprydder.skrivMelding(e, "oppdaterBruker - ikke sqlfeil");
        } finally {
            Opprydder.settAutoCommit(forbindelse);
            Opprydder.lukkSetning(psUpdateBruker);
        }
        lukkForbindelse();
        return ok;
    }

    public synchronized boolean slettBruker(Brukerdata bd) {
        boolean ok = false;
        System.out.println("slettBruker()");
        PreparedStatement psDeleteBruker = null;

        try {
            åpneForbindelse();
            psDeleteBruker = forbindelse.prepareStatement(sqlDeleteBruker);
            psDeleteBruker.setString(1, bd.getBrukernavn());

            int i = psDeleteBruker.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (SQLException e) {
            Opprydder.rullTilbake(forbindelse);
            Opprydder.skrivMelding(e, "slettBruker()");
        } catch (Exception e) {
            Opprydder.skrivMelding(e, "slettBruker - ikke sqlfeil");
        } finally {
            Opprydder.settAutoCommit(forbindelse);
            Opprydder.lukkSetning(psDeleteBruker);
        }
        lukkForbindelse();
        return ok;

    }
}
