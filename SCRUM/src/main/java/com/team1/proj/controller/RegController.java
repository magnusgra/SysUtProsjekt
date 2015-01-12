package com.team1.proj.controller;

/*
 * @author Kai
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.brukerklasser.RegistreringsForm;
import com.team1.proj.service.BrukerService;
import com.team1.proj.service.BrukerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.dao.

@Controller
@SessionAttributes
public class RegController {
    
    @Autowired
    private BrukerService brukerService;
    
    @ModelAttribute("brukerService")
    public BrukerService getBrukerService() {
        return new BrukerServiceImpl();
    }
    
    @RequestMapping(value = "RegistreringBruker" , method=RequestMethod.GET)
    public String vare(@ModelAttribute Brukerdata bd) {
        System.out.println(" ******   Reg.controller.nybruker() ");
        return "RegistreringSide";
    }
       
    @RequestMapping(value = "RegistreringBruker" , method=RequestMethod.POST)
    public String registrerBruker(@ModelAttribute(value="registreringsForm") RegistreringsForm regForm){
        
        if (!regForm.isGodtarBrukervilkar()){
            //Godtar ikke brukervilkår
            return "Login/RegistreringSide";
        } 
        String email = regForm.getBrukerdata().getEpost();
        String navn = regForm.getBrukerdata().getBrukernavn();    
        if (navn == null || navn.isEmpty() || email == null || email.isEmpty()){
            return "Login/RegistreringSide";
        }
        
        if (brukerService.leggTilBruker(regForm.getBrukerdata())){
            return "Login/login";
        }
            
        return "Login/RegistreringSide";
        
        
    }

    
}
