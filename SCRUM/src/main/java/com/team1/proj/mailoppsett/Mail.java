/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ingrid
 */
package com.team1.proj.mailoppsett;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.team1.proj.mailoppsett.Passord;
import java.awt.Font;

public class Mail {

    public static void main(String[] args) {
        //Sendt fra bruker og passord
        String fra = "nicandsteven@yahoo.com";
        String passord = "scrumteam1";
        //Mottaker:
        String brukernavnet = "ingrid";
        String til = "ingrid.horten@gmail.com";
        String host = "smtp.mail.yahoo.com";

        Properties properties = System.getProperties();
        //Setup mailserver
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", fra);
        properties.put("mail.smtp.password", passord);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            //Lager et default MimeMessage-objekt.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fra));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(til));

            //Overskrift
            message.setSubject("Velkommen som ny bruker.");

            //Melding
            Passord p = new Passord();
            String sendt = p.autogenererPassord();
            message.setText("Er du klar for å spille Nic And Steven og samtidig lære CSS og HTML5?"
                    + "\n\n Her er det du trenger for å komme igang.\n Brukernavn: "+brukernavnet+" \n Passord: "+sendt+"  \n\n Du kan endre passord på nettsiden etter å ha logget inn");

            //Send meldingen
            Transport transport = session.getTransport("smtp");
            transport.connect(host, fra, passord);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
