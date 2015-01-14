package com.team1.proj.ui;

import java.util.List;
import javax.validation.Valid;
import com.team1.proj.brukerklasser.Resultat;

/*
 * @author Kai
 */

public class ResultatFormBackingBean {
    
    @Valid
    private List<Resultat> valgtResultat = null;
    private List<Resultat> alleResultat = null;
    
    public List<Resultat> getValgtResultat(){
        return valgtResultat;
    }
    
    public void setValgtResultat(List<Resultat> valgtResultat){
        this.valgtResultat = valgtResultat;
    }
    
    public List<Resultat> getAlleResultat(){
        return alleResultat;
    }
    
    
}
