/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.geeks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Magnus
 */
public class Second {
    private int poeng;
    private int bane;

    /**
     * @return the poeng
     */
    public int getPoeng() {
        return poeng;
    }

    /**
     * @param poeng the poeng to set
     */
    public void setPoeng(int poeng) {
        this.poeng = poeng;
    }

    /**
     * @return the bane
     */
    public int getBane() {
        return bane;
    }

    /**
     * @param bane the bane to set
     */
    public void setBane(int bane) {
        this.bane = bane;
    }
    
    public int store() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url="jdbc:derby://localhost:1527/test;create=true;user=test;password=test";
        Connection con = DriverManager.getConnection(url);
        
        PreparedStatement ps = con.prepareStatement("insert into spill(bane,poeng) values(?,?)");
        
        ps.setInt(1, bane);
        ps.setInt(2, poeng);
        
        int a = ps.executeUpdate();
        
        if(a==1){
            return a;
        }else{
            return a;
        }

    }
    
    
}
