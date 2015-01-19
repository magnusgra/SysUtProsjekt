/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1.proj.controller;


import com.team1.proj.brukerklasser.Brukerdata;
import com.team1.proj.service.BrukerService;
import com.team1.proj.service.BrukerServiceImpl;
import com.team1.proj.service.HashPassord;
import com.team1.proj.ui.EndrePassordFormBackingBean;
import com.team1.proj.ui.ResultatFormBackingBean;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.mail.NoSuchProviderException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author arnecs
 */
 
@Controller
@SessionAttributes
public class MinSideController {
    
    @Autowired
    private Brukerdata brukerdata;
    
    @Autowired
    public void setBrukerdata(Brukerdata brukerdata){
        System.out.println("setBrukerdata");
        this.brukerdata = brukerdata; 
    }

    @ModelAttribute("brukerdata")
    public Brukerdata getBrukerdata() {
        System.out.println("getBrukerdata");
        return new Brukerdata();
    }
    
    @Autowired
    private BrukerService brukerService;
    
    @Autowired
    public void setBrukerService(BrukerService brukerService){
        this.brukerService = brukerService;
    }
    
    @ModelAttribute("brukerService")
    public BrukerService getBrukerService() {
        return new BrukerServiceImpl();
    }

    
    @RequestMapping(value="MinSide/EndrePassord")
    public String minSide(Model model){
        System.out.println("******************     UserController.MinSide   ************************");
        if(brukerdata.isInnlogget()){
            model.addAttribute(new EndrePassordFormBackingBean());
            return "EndrePassord";
        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    
    
    @RequestMapping(value="MinSide/EndrePassord", method=RequestMethod.POST)
    public String endrePassord(Model model, @ModelAttribute EndrePassordFormBackingBean epfbb){
        System.out.println("******************     UserController.endrePassord   ************************");
        if(brukerdata.isInnlogget()){
            model.addAttribute(new EndrePassordFormBackingBean());
            if (!epfbb.passordErLik()){
                model.addAttribute("meldingtype", "melding-error");
                model.addAttribute("melding", "Passordene er ikke like.");
                return "EndrePassord";
            }
            String salt = null;
            try{
                salt = HashPassord.getSalt();
            }catch(NoSuchAlgorithmException | NoSuchProviderException | java.security.NoSuchProviderException e){
                e.printStackTrace();
            }
            //Hasher nytt passord:
            String hashNyttPassord = HashPassord.getSecurePassword(epfbb.getNyttPassord(), salt)+ ":"+salt;
            //Henter Brukerens passord og salt som ligger i databasen: 
            Brukerdata brukeriDB = brukerService.getBrukerdata(brukerdata.getEpost());
            String saltiDB = brukeriDB.getPassord() .split(":")[1];
            //Hasher og salter gammelt passord som han har skrevet inn: 
            String hashGammeltPassord = HashPassord.getSecurePassword(epfbb.getGammeltPassord(), saltiDB)+ ":"+saltiDB; 
            brukerdata.setPassord(hashGammeltPassord);
            if (brukerService.endrePassord(brukerdata, hashNyttPassord)){ 
                model.addAttribute("meldingtype", "melding-suksess");
                model.addAttribute("melding", "Passordet er endret");
                return "EndrePassord";
            } else {
                model.addAttribute("meldingtype", "melding-error");
                model.addAttribute("melding", "Gammelt passord er feil.");
                return "EndrePassord";
            }

        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
    
    @RequestMapping(value="MinSide/Godkjenningsliste")
    public String godkjenningsliste(Model model, HttpServletRequest request){
        System.out.println("******************     UserController.GL   ************************");
        if(brukerdata.isInnlogget()){
            switch (brukerdata.getRettigheter()){
                case 0: //Student
                //    Resultat oppgaver = brukerService.getResultat(brukerdata.getEpost());
                //    model.addAttribute("oppgaver", oppgaver);
                    return "gl";
                    
                case 1: //Admin
                    String sideString = request.getParameter("side");
                    int side = 1;
                    try {
                        side = Integer.parseInt(sideString);
                    } catch (NumberFormatException e){
                        System.out.println("NFE: " + sideString);
                    }
                    
                    if (side < 1) {
                        side = 1;
                    }
                    
                    
                    int antPerSide = 5;
                    int fra = (side - 1) * antPerSide;
                    int til = side * antPerSide;
                    
                    List<Integer> sider = brukerService.getSider(side,antPerSide);

                    if (sider.size() == 0 || side > sider.get(sider.size() - 1).intValue()) {
                        side = 1;
                        fra = (side - 1) * antPerSide;
                        til = side * antPerSide;

                        sider = brukerService.getSider(side,antPerSide);
                    } 
                    
                                      boolean sisteSide = false;
                    if (sider.size() > 0){
                        sisteSide = side >= sider.get(sider.size() - 1).intValue(); 
                    }
                    
                    model.addAttribute("sider", sider);
                    model.addAttribute("aktivSide", side);
                    model.addAttribute("sisteSide", sisteSide);
                    model.addAttribute("godkjenningsListe", brukerService.getAdminListe(fra,til));
                    return "gl_admin";
                    
                default:
                    break;
            }
        }
        model.addAttribute("logindata", new Brukerdata());
        return "Login/login";
    }
        
        

}
