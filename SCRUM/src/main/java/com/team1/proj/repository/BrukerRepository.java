/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.repository;

/*
 * @author Kai
 */

import java.util.List;
import com.team1.proj.brukerklasser.Brukerdata;

/*
 * @author Kai
 */
public interface BrukerRepository {
     
    public Brukerdata getBruker(String brukernavn);

    public List<Brukerdata> getAlleBrukere() ;

    public boolean registrerBruker(Brukerdata bd) ;

    public boolean oppdaterBruker(Brukerdata bd) ;

    public boolean slettBruker(Brukerdata bd) ;
}

