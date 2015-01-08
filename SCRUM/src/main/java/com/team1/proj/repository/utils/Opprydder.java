/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.repository.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author Kai
 */
public class Opprydder {
    public static void lukkResSet(ResultSet res) {
    try {
      if (res != null &&!res.isClosed()) res.close();
    } catch (SQLException e) {
      skrivMelding(e, "lukkResSet()");
    }
  }

  public static void lukkSetning(Statement stm) {
    try {
      if (stm != null && !stm.isClosed()) stm.close();
    } catch (SQLException e) {
      skrivMelding(e, "lukkSetning()");
    }
  }

  public static void lukkForbindelse(Connection forbindelse) {
    try {
      if (forbindelse != null && !forbindelse.isClosed()) forbindelse.close();
    } catch (SQLException e) {
      skrivMelding(e, "lukkForbindelse()");
    }
  }

  public static void rullTilbake(Connection forbindelse) {
    try {
      if (forbindelse != null && !forbindelse.getAutoCommit()) forbindelse.rollback();
    } catch (SQLException e) {
      skrivMelding(e, "rollback()");
    }
  }

  public static void settAutoCommit(Connection forbindelse) {
    try {
      if (forbindelse != null && !forbindelse.getAutoCommit()) forbindelse.setAutoCommit(true);
    } catch (SQLException e) {
      skrivMelding(e, "settAutoCommit()");
    }
  }

  public static void skrivMelding(Exception e, String melding) {
    System.err.println("*** Feil oppstÃ¥tt: " + melding + ". ***");
    e.printStackTrace(System.err);
  }
}

