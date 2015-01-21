
package com.team1.proj.mailoppsett;

/**
 *
 * @author Ingrid
 */
import com.team1.proj.brukerklasser.Brukerdata;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import org.springframework.mail.SimpleMailMessage;
 
public class Mail {
    
    private String host;
    private String port;
    private String userName;
    private String password;
    private String toAddress;
    private String subject;
    private String message;
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
   
    public void sendHtmlEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
       
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // 
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setContent(message, "text/html");
 
        // sends the e-mail
        Transport.send(msg);
 
    }
    
     //public boolean sendMailMedPassord(Brukerdata brukerdata){
          
    public boolean sendMailMedPassord(Brukerdata brukerdata, String ps){
        //Sendt fra bruker og passord
        String fra = "scrumteamhist@yahoo.com";
        String passord = "passordet";
        String fornavn = brukerdata.getFornavn();
        String etternavn = brukerdata.getEtternavn();
        String til = brukerdata.getEpost();
        String host = "smtp.mail.yahoo.com";

        Properties properties = System.getProperties();
        
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", fra);
        properties.put("mail.smtp.password", passord);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fra));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(til));
            
            message.setSubject("Velkommen som ny bruker.");
            message.setContent("    <style type=\"text/css\">\n" +
"body {\n" +
"  margin: 0;\n" +
"  mso-line-height-rule: exactly;\n" +
"  padding: 0;\n" +
"  min-width: 100%;\n" +
"}\n" +
"table {\n" +
"  border-collapse: collapse;\n" +
"  border-spacing: 0;\n" +
"}\n" +
"td {\n" +
"  padding: 0;\n" +
"  vertical-align: top;\n" +
"}\n" +
".spacer,\n" +
".border {\n" +
"  font-size: 1px;\n" +
"  line-height: 1px;\n" +
"}\n" +
".spacer {\n" +
"  width: 100%;\n" +
"}\n" +
"img {\n" +
"  border: 0;\n" +
"  -ms-interpolation-mode: bicubic;\n" +
"}\n" +
".image {\n" +
"  font-size: 12px;\n" +
"  Margin-bottom: 25px;\n" +
"}\n" +
".image img {\n" +
"  display: block;\n" +
"}\n" +
".logo {\n" +
"  mso-line-height-rule: at-least;\n" +
"}\n" +
".logo img {\n" +
"  display: block;\n" +
"}\n" +
"strong {\n" +
"  font-weight: bold;\n" +
"}\n" +
"h1,\n" +
"h2,\n" +
"h3,\n" +
"p,\n" +
"ol,\n" +
"ul,\n" +
"li {\n" +
"  Margin-top: 0;\n" +
"}\n" +
"ol,\n" +
"ul,\n" +
"li {\n" +
"  padding-left: 0;\n" +
"}\n" +
"blockquote {\n" +
"  Margin-top: 0;\n" +
"  Margin-right: 0;\n" +
"  Margin-bottom: 0;\n" +
"  padding-right: 0;\n" +
"}\n" +
".column-top {\n" +
"  font-size: 60px;\n" +
"  line-height: 60px;\n" +
"}\n" +
".column-bottom {\n" +
"  font-size: 34px;\n" +
"  line-height: 34px;\n" +
"}\n" +
".column {\n" +
"  text-align: left;\n" +
"}\n" +
".contents {\n" +
"  width: 100%;\n" +
"}\n" +
".padded {\n" +
"  padding-left: 60px;\n" +
"  padding-right: 60px;\n" +
"}\n" +
".wrapper {\n" +
"  display: table;\n" +
"  table-layout: fixed;\n" +
"  width: 100%;\n" +
"  min-width: 620px;\n" +
"  -webkit-text-size-adjust: 100%;\n" +
"  -ms-text-size-adjust: 100%;\n" +
"}\n" +
"table.wrapper {\n" +
"  table-layout: fixed;\n" +
"}\n" +
".one-col,\n" +
".two-col,\n" +
".three-col {\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"  width: 600px;\n" +
"}\n" +
".centered {\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".two-col .image {\n" +
"  Margin-bottom: 23px;\n" +
"}\n" +
".two-col .column-bottom {\n" +
"  font-size: 37px;\n" +
"  line-height: 37px;\n" +
"}\n" +
".two-col .column {\n" +
"  width: 300px;\n" +
"}\n" +
".two-col .first .padded {\n" +
"  padding-left: 60px;\n" +
"  padding-right: 30px;\n" +
"}\n" +
".two-col .second .padded {\n" +
"  padding-left: 30px;\n" +
"  padding-right: 60px;\n" +
"}\n" +
".three-col .image {\n" +
"  Margin-bottom: 21px;\n" +
"}\n" +
".three-col .column-bottom {\n" +
"  font-size: 39px;\n" +
"  line-height: 39px;\n" +
"}\n" +
".three-col .column {\n" +
"  width: 200px;\n" +
"}\n" +
".three-col .first .padded {\n" +
"  padding-left: 60px;\n" +
"  padding-right: 0;\n" +
"}\n" +
".three-col .second .padded {\n" +
"  padding-left: 30px;\n" +
"  padding-right: 30px;\n" +
"}\n" +
".three-col .third .padded {\n" +
"  padding-left: 0;\n" +
"  padding-right: 60px;\n" +
"}\n" +
"@media only screen and (min-width: 0) {\n" +
"  .wrapper {\n" +
"    text-rendering: optimizeLegibility;\n" +
"  }\n" +
"}\n" +
"@media only screen and (max-width: 620px) {\n" +
"  [class=wrapper] {\n" +
"    min-width: 320px !important;\n" +
"    width: 100% !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col,\n" +
"  [class=wrapper] .two-col,\n" +
"  [class=wrapper] .three-col {\n" +
"    width: 320px !important;\n" +
"  }\n" +
"  [class=wrapper] .column,\n" +
"  [class=wrapper] .gutter {\n" +
"    display: block;\n" +
"    float: left;\n" +
"    width: 320px !important;\n" +
"  }\n" +
"  [class=wrapper] .padded {\n" +
"    padding-left: 30px !important;\n" +
"    padding-right: 30px !important;\n" +
"  }\n" +
"  [class=wrapper] .block {\n" +
"    display: block !important;\n" +
"  }\n" +
"  [class=wrapper] .hide {\n" +
"    display: none !important;\n" +
"  }\n" +
"  [class=wrapper] .image {\n" +
"    margin-bottom: 25px !important;\n" +
"  }\n" +
"  [class=wrapper] .image img {\n" +
"    height: auto !important;\n" +
"    width: 100% !important;\n" +
"  }\n" +
"}\n" +
".wrapper h1 {\n" +
"  font-weight: 400;\n" +
"}\n" +
".wrapper h2 {\n" +
"  font-weight: 400;\n" +
"}\n" +
".wrapper h3 {\n" +
"  font-weight: bold;\n" +
"}\n" +
".wrapper p,\n" +
".wrapper ol,\n" +
".wrapper ul {\n" +
"  font-weight: 400;\n" +
"}\n" +
".wrapper blockquote p,\n" +
".wrapper blockquote ol,\n" +
".wrapper blockquote ul {\n" +
"  font-style: italic;\n" +
"  font-weight: 500;\n" +
"}\n" +
".wrapper .column table:nth-last-child(2) td h1:last-child,\n" +
".wrapper .column table:nth-last-child(2) td h2:last-child,\n" +
".wrapper .column table:nth-last-child(2) td h3:last-child,\n" +
".wrapper .column table:nth-last-child(2) td p:last-child,\n" +
".wrapper .column table:nth-last-child(2) td ol:last-child,\n" +
".wrapper .column table:nth-last-child(2) td ul:last-child {\n" +
"  Margin-bottom: 25px;\n" +
"}\n" +
".wrapper a {\n" +
"  transition: all .2s;\n" +
"}\n" +
".wrapper .preheader,\n" +
".wrapper .header,\n" +
".wrapper .footer,\n" +
".wrapper .feature {\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".wrapper .one-col,\n" +
".wrapper .two-col,\n" +
".wrapper .three-col {\n" +
"  background-color: #ffffff;\n" +
"  border-radius: 4px;\n" +
"  box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1);\n" +
"}\n" +
".wrapper center.divider {\n" +
"  Margin-bottom: 25px;\n" +
"}\n" +
".wrapper center.divider img {\n" +
"  display: block;\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".wrapper .preheader {\n" +
"  width: 600px;\n" +
"}\n" +
".wrapper .preheader table {\n" +
"  width: 540px;\n" +
"}\n" +
".wrapper .preheader .inner {\n" +
"  padding-top: 11px;\n" +
"  padding-bottom: 12px;\n" +
"}\n" +
".wrapper .preheader .title {\n" +
"  text-align: left;\n" +
"}\n" +
".wrapper .preheader .webversion {\n" +
"  text-align: right;\n" +
"  width: 240px;\n" +
"}\n" +
".wrapper .preheader .webversion a {\n" +
"  letter-spacing: 0.03em;\n" +
"}\n" +
".wrapper .preheader .title a,\n" +
".wrapper .preheader .webversion a {\n" +
"  font-weight: bold;\n" +
"  text-decoration: none;\n" +
"}\n" +
".wrapper h1 a,\n" +
".wrapper h2 a,\n" +
".wrapper h3 a {\n" +
"  text-decoration: none;\n" +
"}\n" +
".wrapper h1 {\n" +
"  font-size: 36px;\n" +
"  Margin-bottom: 21px;\n" +
"  text-align: center;\n" +
"}\n" +
".wrapper h2 {\n" +
"  font-size: 24px;\n" +
"  Margin-bottom: 20px;\n" +
"}\n" +
".wrapper h3 {\n" +
"  font-size: 15px;\n" +
"  Margin-bottom: 16px;\n" +
"}\n" +
".wrapper p,\n" +
".wrapper ol,\n" +
".wrapper ul {\n" +
"  font-size: 15px;\n" +
"}\n" +
".wrapper p a,\n" +
".wrapper ol a,\n" +
".wrapper ul a {\n" +
"  text-decoration: none;\n" +
"}\n" +
".wrapper p a:hover,\n" +
".wrapper ol a:hover,\n" +
".wrapper ul a:hover {\n" +
"  border-bottom: none !important;\n" +
"}\n" +
".wrapper ol,\n" +
".wrapper ul {\n" +
"  Margin-left: 39px;\n" +
"}\n" +
".wrapper blockquote {\n" +
"  Margin-left: 1em;\n" +
"  padding-left: 1em;\n" +
"}\n" +
".wrapper .btn {\n" +
"  Margin-bottom: 25px;\n" +
"}\n" +
".wrapper .btn a {\n" +
"  background-image: url(https://i1.createsend1.com/static/eb/master/02-blush/images/btn-one-col.png);\n" +
"  background-position: center center;\n" +
"  background-size: cover;\n" +
"  display: inline-block;\n" +
"  font-size: 15px;\n" +
"  font-weight: 400;\n" +
"  line-height: 25px;\n" +
"  padding: 8px 24px 9px 24px;\n" +
"  text-align: center;\n" +
"  text-decoration: none;\n" +
"  transition: all .2s;\n" +
"  width: 432px;\n" +
"}\n" +
".wrapper .btn a:hover {\n" +
"  opacity: .9;\n" +
"}\n" +
".preheader .title,\n" +
".preheader .webversion,\n" +
".footer .padded {\n" +
"  font-size: 11px;\n" +
"  font-weight: normal;\n" +
"  letter-spacing: 0.01em;\n" +
"  line-height: 17px;\n" +
"}\n" +
".two-col .column table:nth-last-child(2) td h1:last-child,\n" +
".two-col .column table:nth-last-child(2) td h2:last-child,\n" +
".two-col .column table:nth-last-child(2) td h3:last-child,\n" +
".two-col .column table:nth-last-child(2) td p:last-child,\n" +
".two-col .column table:nth-last-child(2) td ol:last-child,\n" +
".two-col .column table:nth-last-child(2) td ul:last-child {\n" +
"  Margin-bottom: 23px;\n" +
"}\n" +
".two-col h1 {\n" +
"  font-size: 32px;\n" +
"  Margin-bottom: 18px;\n" +
"}\n" +
".two-col h2 {\n" +
"  font-size: 20px;\n" +
"  Margin-bottom: 16px;\n" +
"}\n" +
".two-col h3 {\n" +
"  font-size: 14px;\n" +
"  Margin-bottom: 14px;\n" +
"}\n" +
".two-col p,\n" +
".two-col ol,\n" +
".two-col ul {\n" +
"  font-size: 14px;\n" +
"}\n" +
".two-col ol,\n" +
".two-col ul {\n" +
"  Margin-left: 32px;\n" +
"}\n" +
".two-col center.divider {\n" +
"  Margin-bottom: 23px;\n" +
"}\n" +
".two-col .btn {\n" +
"  Margin-bottom: 23px;\n" +
"}\n" +
".two-col .btn a {\n" +
"  background-image: url(https://i2.createsend1.com/static/eb/master/02-blush/images/btn-two-col.png);\n" +
"  font-size: 14px;\n" +
"  line-height: 23px;\n" +
"  padding: 7px 24px 8px 24px;\n" +
"  width: 162px;\n" +
"}\n" +
".three-col .column table:nth-last-child(2) td h1:last-child,\n" +
".three-col .column table:nth-last-child(2) td h2:last-child,\n" +
".three-col .column table:nth-last-child(2) td h3:last-child,\n" +
".three-col .column table:nth-last-child(2) td p:last-child,\n" +
".three-col .column table:nth-last-child(2) td ol:last-child,\n" +
".three-col .column table:nth-last-child(2) td ul:last-child {\n" +
"  Margin-bottom: 21px;\n" +
"}\n" +
".three-col h1 {\n" +
"  background-image: none;\n" +
"  font-size: 26px;\n" +
"  Margin-bottom: 16px;\n" +
"}\n" +
".three-col h2 {\n" +
"  font-size: 18px;\n" +
"  Margin-bottom: 12px;\n" +
"}\n" +
".three-col h3 {\n" +
"  font-size: 13px;\n" +
"  Margin-bottom: 10px;\n" +
"}\n" +
".three-col p,\n" +
".three-col ol,\n" +
".three-col ul {\n" +
"  font-size: 13px;\n" +
"}\n" +
".three-col ol,\n" +
".three-col ul {\n" +
"  Margin-left: 24px;\n" +
"}\n" +
".three-col center.divider {\n" +
"  Margin-bottom: 21px;\n" +
"}\n" +
".three-col .btn {\n" +
"  Margin-bottom: 21px;\n" +
"}\n" +
".three-col .btn a {\n" +
"  background-image: url(https://i3.createsend1.com/static/eb/master/02-blush/images/btn-three-col.png);\n" +
"  font-size: 13px;\n" +
"  line-height: 21px;\n" +
"  padding: 5px 24px 6px 24px;\n" +
"  width: 92px;\n" +
"}\n" +
".feature-top,\n" +
".feature-bottom {\n" +
"  background-color: #ffffff;\n" +
"  font-size: 0;\n" +
"  line-height: 0;\n" +
"  width: 600px;\n" +
"}\n" +
".feature-top img,\n" +
".feature-bottom img {\n" +
"  display: inline-block;\n" +
"}\n" +
".feature-top {\n" +
"  padding-bottom: 44px;\n" +
"}\n" +
".feature-bottom {\n" +
"  padding-top: 31px;\n" +
"}\n" +
".feature {\n" +
"  background-color: #ffffff;\n" +
"  width: 600px;\n" +
"}\n" +
".feature .column-top {\n" +
"  font-size: 44px;\n" +
"  line-height: 44px;\n" +
"}\n" +
".feature .column-bottom {\n" +
"  font-size: 10px;\n" +
"  line-height: 10px;\n" +
"}\n" +
".feature .one-col {\n" +
"  text-align: center;\n" +
"  width: 510px;\n" +
"}\n" +
".wrapper .feature .one-col {\n" +
"  box-shadow: none;\n" +
"}\n" +
".feature .padded {\n" +
"  padding-left: 44px;\n" +
"  padding-right: 44px;\n" +
"}\n" +
".feature h2 {\n" +
"  text-align: center;\n" +
"}\n" +
".feature h3 {\n" +
"  text-align: center;\n" +
"}\n" +
".feature p {\n" +
"  text-align: center;\n" +
"}\n" +
".feature ol,\n" +
".feature ul {\n" +
"  text-align: left;\n" +
"}\n" +
".feature blockquote {\n" +
"  border-left: 0;\n" +
"  Margin-left: 0;\n" +
"  padding-left: 0;\n" +
"}\n" +
".wrapper .feature .btn a {\n" +
"  background-image: url(https://i5.createsend1.com/static/eb/master/02-blush/images/btn-feature.png);\n" +
"  width: 372px;\n" +
"}\n" +
".frame-bottom td {\n" +
"  line-height: 9px;\n" +
"}\n" +
".frame-bottom .left,\n" +
".frame-bottom .right {\n" +
"  width: 245px;\n" +
"}\n" +
".heart {\n" +
"  mso-line-height-rule: at-least;\n" +
"  vertical-align: middle;\n" +
"  width: 18px;\n" +
"}\n" +
".heart img {\n" +
"  display: block;\n" +
"}\n" +
".header {\n" +
"  width: 600px;\n" +
"}\n" +
".logo {\n" +
"  padding-top: 40px;\n" +
"  padding-bottom: 37px;\n" +
"}\n" +
".logo div {\n" +
"  font-size: 42px;\n" +
"  line-height: 50px;\n" +
"}\n" +
".logo div a {\n" +
"  text-decoration: none;\n" +
"}\n" +
".logo div.logo-center {\n" +
"  text-align: center;\n" +
"}\n" +
".logo div.logo-center img {\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".footer {\n" +
"  width: 600px;\n" +
"}\n" +
".footer .divider {\n" +
"  line-height: 11px;\n" +
"  width: 100%;\n" +
"}\n" +
".footer #address a,\n" +
".footer #permission a {\n" +
"  text-decoration: none;\n" +
"  font-weight: normal;\n" +
"}\n" +
".social td {\n" +
"  padding: 0 13px 40px 13px;\n" +
"  vertical-align: middle;\n" +
"}\n" +
".social img {\n" +
"  vertical-align: middle;\n" +
"}\n" +
".social span {\n" +
"  mso-text-raise: 6px;\n" +
"}\n" +
".forward,\n" +
".facebook,\n" +
".twitter {\n" +
"  display: inline-block;\n" +
"  font-size: 12px;\n" +
"  font-weight: 400;\n" +
"  line-height: 12px;\n" +
"  text-decoration: none;\n" +
"  text-transform: uppercase;\n" +
"}\n" +
".footer .contents {\n" +
"  width: 600px;\n" +
"}\n" +
".footer .contents a {\n" +
"  font-weight: 700;\n" +
"  text-decoration: none;\n" +
"}\n" +
".address,\n" +
".campaign {\n" +
"  font-size: 11px;\n" +
"  font-weight: 400;\n" +
"  line-height: 19px;\n" +
"  padding-bottom: 40px;\n" +
"  -webkit-font-smoothing: antialiased;\n" +
"}\n" +
".address {\n" +
"  text-align: left;\n" +
"  padding-left: 30px;\n" +
"  padding-right: 10px;\n" +
"  width: 45%;\n" +
"}\n" +
".campaign {\n" +
"  text-align: right;\n" +
"  padding-right: 30px;\n" +
"  padding-left: 10px;\n" +
"  width: 55%;\n" +
"}\n" +
".campaign .links a {\n" +
"  font-weight: bold;\n" +
"}\n" +
".column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-center {\n" +
"  border-top-left-radius: 4px;\n" +
"  -moz-border-top-left-radius: 4px;\n" +
"  border-top-right-radius: 4px;\n" +
"  -moz-border-top-right-radius: 4px;\n" +
"}\n" +
".column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-left {\n" +
"  border-top-left-radius: 4px;\n" +
"  -moz-border-top-left-radius: 4px;\n" +
"  border-top-right-radius: 0;\n" +
"  -moz-border-top-right-radius: 0;\n" +
"}\n" +
".column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-right {\n" +
"  border-top-left-radius: 0;\n" +
"  -moz-border-top-left-radius: 0;\n" +
"  border-top-right-radius: 4px;\n" +
"  -moz-border-top-right-radius: 4px;\n" +
"}\n" +
".first.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-center,\n" +
".first.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-left {\n" +
"  border-top-left-radius: 4px;\n" +
"  -moz-border-top-left-radius: 4px;\n" +
"  border-top-right-radius: 0;\n" +
"  -moz-border-top-right-radius: 0;\n" +
"}\n" +
".two-col .second.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-center,\n" +
".two-col .second.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-right {\n" +
"  border-top-left-radius: 0;\n" +
"  -moz-border-top-left-radius: 0;\n" +
"  border-top-right-radius: 4px;\n" +
"  -moz-border-top-right-radius: 4px;\n" +
"}\n" +
".three-col .second.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-center,\n" +
".three-col .second.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-right,\n" +
".three-col .second.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-left {\n" +
"  border-top-left-radius: 0;\n" +
"  -moz-border-top-left-radius: 0;\n" +
"  border-top-right-radius: 0;\n" +
"  -moz-border-top-right-radius: 0;\n" +
"}\n" +
".third.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-center,\n" +
".third.column .rounded-image-bleed:first-child .gnd-corner-image-top.gnd-corner-image-right {\n" +
"  border-top-left-radius: 0;\n" +
"  -moz-border-top-left-radius: 0;\n" +
"  border-top-right-radius: 4px;\n" +
"  -moz-border-top-right-radius: 4px;\n" +
"}\n" +
"@media only screen and (max-width: 620px) {\n" +
"  [class=wrapper] .preheader,\n" +
"  [class=wrapper] .preheader table,\n" +
"  [class=wrapper] .header,\n" +
"  [class=wrapper] .footer,\n" +
"  [class=wrapper] .footer .contents,\n" +
"  [class=wrapper] .feature {\n" +
"    width: 320px !important;\n" +
"  }\n" +
"  [class=wrapper] .preheader .title {\n" +
"    display: none;\n" +
"  }\n" +
"  [class=wrapper] .preheader .webversion {\n" +
"    text-align: center !important;\n" +
"  }\n" +
"  [class=wrapper] .logo {\n" +
"    padding-left: 10px !important;\n" +
"    padding-right: 10px !important;\n" +
"  }\n" +
"  [class=wrapper] .logo img {\n" +
"    max-width: 280px !important;\n" +
"    height: auto !important;\n" +
"  }\n" +
"  [class=wrapper] .footer .address,\n" +
"  [class=wrapper] .footer .campaign {\n" +
"    display: block;\n" +
"    padding-left: 30px !important;\n" +
"    padding-right: 30px !important;\n" +
"    text-align: center !important;\n" +
"    width: 260px !important;\n" +
"  }\n" +
"  [class=wrapper] .footer .address {\n" +
"    padding-bottom: 20px !important;\n" +
"  }\n" +
"  [class=wrapper] .footer .social td {\n" +
"    display: block !important;\n" +
"    text-align: center !important;\n" +
"    padding-left: 0 !important;\n" +
"    padding-right: 0 !important;\n" +
"    padding-bottom: 10px !important;\n" +
"  }\n" +
"  [class=wrapper] .footer .social td:last-child {\n" +
"    padding-bottom: 40px !important;\n" +
"  }\n" +
"  [class=wrapper] .first .column-bottom,\n" +
"  [class=wrapper] .three-col .second .column-bottom {\n" +
"    display: none;\n" +
"  }\n" +
"  [class=wrapper] .second .column-top,\n" +
"  [class=wrapper] .third .column-top {\n" +
"    display: none;\n" +
"  }\n" +
"  [class=wrapper] .one-col .column:last-child table:nth-last-child(2) td h1:last-child,\n" +
"  [class=wrapper] .two-col .column:last-child table:nth-last-child(2) td h1:last-child,\n" +
"  [class=wrapper] .three-col .column:last-child table:nth-last-child(2) td h1:last-child,\n" +
"  [class=wrapper] .one-col .column:last-child table:nth-last-child(2) td h2:last-child,\n" +
"  [class=wrapper] .two-col .column:last-child table:nth-last-child(2) td h2:last-child,\n" +
"  [class=wrapper] .three-col .column:last-child table:nth-last-child(2) td h2:last-child,\n" +
"  [class=wrapper] .one-col .column:last-child table:nth-last-child(2) td h3:last-child,\n" +
"  [class=wrapper] .two-col .column:last-child table:nth-last-child(2) td h3:last-child,\n" +
"  [class=wrapper] .three-col .column:last-child table:nth-last-child(2) td h3:last-child,\n" +
"  [class=wrapper] .one-col .column:last-child table:nth-last-child(2) td p:last-child,\n" +
"  [class=wrapper] .two-col .column:last-child table:nth-last-child(2) td p:last-child,\n" +
"  [class=wrapper] .three-col .column:last-child table:nth-last-child(2) td p:last-child,\n" +
"  [class=wrapper] .one-col .column:last-child table:nth-last-child(2) td ol:last-child,\n" +
"  [class=wrapper] .two-col .column:last-child table:nth-last-child(2) td ol:last-child,\n" +
"  [class=wrapper] .three-col .column:last-child table:nth-last-child(2) td ol:last-child,\n" +
"  [class=wrapper] .one-col .column:last-child table:nth-last-child(2) td ul:last-child,\n" +
"  [class=wrapper] .two-col .column:last-child table:nth-last-child(2) td ul:last-child,\n" +
"  [class=wrapper] .three-col .column:last-child table:nth-last-child(2) td ul:last-child {\n" +
"    Margin-bottom: 25px !important;\n" +
"  }\n" +
"  [class=wrapper] .column-top {\n" +
"    font-size: 25px !important;\n" +
"    line-height: 25px !important;\n" +
"  }\n" +
"  [class=wrapper] .column-bottom {\n" +
"    font-size: 5px !important;\n" +
"    line-height: 5px !important;\n" +
"  }\n" +
"  [class=wrapper] center.divider {\n" +
"    margin-bottom: 25px !important;\n" +
"  }\n" +
"  [class=wrapper] .btn {\n" +
"    margin-bottom: 25px !important;\n" +
"  }\n" +
"  [class=wrapper] .btn a {\n" +
"    background-image: url(https://i4.createsend1.com/static/eb/master/02-blush/images/btn-mobile.png) !important;\n" +
"    display: block !important;\n" +
"    font-size: 15px !important;\n" +
"    line-height: 25px !important;\n" +
"    padding: 8px 24px 9px 24px !important;\n" +
"    width: auto !important;\n" +
"  }\n" +
"  [class=wrapper] h1 {\n" +
"    font-size: 36px !important;\n" +
"    margin-bottom: 21px !important;\n" +
"  }\n" +
"  [class=wrapper] h2 {\n" +
"    font-size: 24px !important;\n" +
"    margin-bottom: 20px !important;\n" +
"  }\n" +
"  [class=wrapper] h3 {\n" +
"    font-size: 15px !important;\n" +
"    margin-bottom: 16px !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col p,\n" +
"  [class=wrapper] .two-col p,\n" +
"  [class=wrapper] .three-col p,\n" +
"  [class=wrapper] .one-col ol,\n" +
"  [class=wrapper] .two-col ol,\n" +
"  [class=wrapper] .three-col ol,\n" +
"  [class=wrapper] .one-col ul,\n" +
"  [class=wrapper] .two-col ul,\n" +
"  [class=wrapper] .three-col ul {\n" +
"    font-size: 15px !important;\n" +
"    line-height: 25px !important;\n" +
"  }\n" +
"  [class=wrapper] ol,\n" +
"  [class=wrapper] ul {\n" +
"    margin-left: 26px !important;\n" +
"  }\n" +
"  [class=wrapper] .feature-top {\n" +
"    padding-bottom: 25px !important;\n" +
"  }\n" +
"  [class=wrapper] .feature-bottom {\n" +
"    padding-top: 9px !important;\n" +
"  }\n" +
"  [class=wrapper] .feature-top img,\n" +
"  [class=wrapper] .feature-bottom img {\n" +
"    display: block !important;\n" +
"  }\n" +
"  [class=wrapper] .feature-top .right,\n" +
"  [class=wrapper] .feature-bottom .right {\n" +
"    display: none !important;\n" +
"  }\n" +
"  [class=wrapper] .feature .one-col,\n" +
"  [class=wrapper] .feature .column {\n" +
"    width: 280px !important;\n" +
"  }\n" +
"  [class=wrapper] .feature .padded {\n" +
"    padding-left: 20px !important;\n" +
"    padding-right: 20px !important;\n" +
"  }\n" +
"  [class=wrapper] .feature .column-top {\n" +
"    font-size: 20px !important;\n" +
"    line-height: 20px !important;\n" +
"  }\n" +
"  [class=wrapper] .feature .column-bottom {\n" +
"    font-size: 2px !important;\n" +
"    line-height: 2px !important;\n" +
"  }\n" +
"  [class=wrapper] .feature .frame-bottom .left,\n" +
"  [class=wrapper] .feature .frame-bottom .right {\n" +
"    width: 131px !important;\n" +
"  }\n" +
"  [class=wrapper] .feature .btn a {\n" +
"    background-image: url(https://i7.createsend1.com/static/eb/master/02-blush/images/btn-feature-mobile.png) !important;\n" +
"  }\n" +
"}\n" +
"@media only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (min--moz-device-pixel-ratio: 2), only screen and (-o-min-device-pixel-ratio: 2/1), only screen and (min-device-pixel-ratio: 2), only screen and (min-resolution: 192dpi), only screen and (min-resolution: 2dppx) {\n" +
"  [class=wrapper] .one-col .btn a {\n" +
"    background-image: url(https://i9.createsend1.com/static/eb/master/02-blush/images/btn-one-col-2x.png) !important;\n" +
"  }\n" +
"  [class=wrapper] .two-col .btn a {\n" +
"    background-image: url(https://i6.createsend1.com/static/eb/master/02-blush/images/btn-two-col-2x.png) !important;\n" +
"  }\n" +
"  [class=wrapper] .three-col .btn a {\n" +
"    background-image: url(https://i8.createsend1.com/static/eb/master/02-blush/images/btn-three-col-2x.png) !important;\n" +
"  }\n" +
"  [class=wrapper] .feature .btn a {\n" +
"    background-image: url(https://i10.createsend1.com/static/eb/master/02-blush/images/btn-feature-2x.png) !important;\n" +
"  }\n" +
"}\n" +
"@media only screen and (max-width: 620px) and (-webkit-min-device-pixel-ratio: 2), only screen and (max-width: 620px) and (min--moz-device-pixel-ratio: 2), only screen and (max-width: 620px) and (-o-min-device-pixel-ratio: 2/1), only screen and (max-width: 620px) and (min-device-pixel-ratio: 2), only screen and (max-width: 620px) and (min-resolution: 192dpi), only screen and (max-width: 620px) and (min-resolution: 2dppx) {\n" +
"  [class=wrapper] .btn a {\n" +
"    background-image: url(https://i1.createsend1.com/static/eb/master/02-blush/images/btn-mobile-2x.png) !important;\n" +
"  }\n" +
"  [class=wrapper] .feature .btn a {\n" +
"    background-image: url(https://i2.createsend1.com/static/eb/master/02-blush/images/btn-feature-mobile-2x.png) !important;\n" +
"  }\n" +
"}\n" +
"@media only screen and (-webkit-min-device-pixel-ratio: 1) {\n" +
"  .divider img,\n" +
"  .heart img {\n" +
"    outline: 1px solid #ffffff;\n" +
"  }\n" +
"  .feature-top img,\n" +
"  .feature-bottom img {\n" +
"    float: left;\n" +
"  }\n" +
"}\n" +
"</style>\n" +
"    <!--[if mso]>\n" +
"    <style>\n" +
"      .frame-bottom .left, .frame-bottom .right {\n" +
"        width: 246px !important;\n" +
"      }\n" +
"      .column-top {\n" +
"        mso-line-height-rule: exactly !important;\n" +
"      }\n" +
"    </style>\n" +
"    <![endif]-->\n" +
"  <meta name=\"robots\" content=\"noindex,nofollow\" />\n" +
"<meta property=\"og:title\" content=\"My First Campaign\" />\n" +
"</head>\n" +
"  <body style=\"margin: 0;mso-line-height-rule: exactly;padding: 0;min-width: 100%;background-color: #dddfe0\"><style type=\"text/css\">\n" +
"@import url(https://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic);@import url(https://fonts.googleapis.com/css?family=Bitter:400,700,400italic);@import url(https://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic);@import url(https://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic);@import url(https://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic);@import url(https://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic);body,.wrapper,.separator,.emb-editor-canvas{background-color:#dddfe0}h1{color:#3888bd}.wrapper h1{}.wrapper h1{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.wrapper h1{font-family:Roboto,Tahoma,sans-serif !important}}h1{}.one-col h1{line-height:44px}.two-col h1{line-height:40px}.three-col h1{line-height:32px}@media only screen and (max-width: \n" +
"620px){h1{line-height:44px !important}}h2{color:#555}.wrapper h2{}.wrapper h2{font-family:Georgia,serif}@media only screen and (min-width: 0){.wrapper h2{font-family:Bitter,Georgia,serif !important}}h2{}.one-col h2{line-height:32px}.two-col h2{line-height:26px}.three-col h2{line-height:24px}@media only screen and (max-width: 620px){h2{line-height:32px !important}}h3{color:#377fcc}.wrapper h3{}.wrapper h3{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.wrapper h3{font-family:Roboto,Tahoma,sans-serif !important}}h3{}.one-col h3{line-height:21px}.two-col h3{line-height:22px}.three-col h3{line-height:19px}@media only screen and (max-width: 620px){h3{line-height:21px !important}}p,ol,ul{color:#61606c}.wrapper p,.wrapper ol,.wrapper ul{}.wrapper p,.wrapper ol,.wrapper ul{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.wrapper p,.wrapper ol,.wrapper \n" +
"ul{font-family:Roboto,Tahoma,sans-serif !important}}p,ol,ul{}.one-col p,.one-col ol,.one-col ul{line-height:24px;Margin-bottom:24px}.two-col p,.two-col ol,.two-col ul{line-height:22px;Margin-bottom:22px}.three-col p,.three-col ol,.three-col ul{line-height:20px;Margin-bottom:20px}@media only screen and (max-width: 620px){p,ol,ul{line-height:24px !important;Margin-bottom:24px !important}}.image{color:#61606c}.image{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.image{font-family:Roboto,Tahoma,sans-serif !important}}.wrapper a{color:#7193b0}.wrapper a:hover{color:#557a99 !important}.wrapper p a,.wrapper ol a,.wrapper ul a{border-bottom:1px dotted #7193b0}.wrapper p a:hover,.wrapper ol a:hover,.wrapper ul a:hover{border-bottom-color:#557a99 !important}.wrapper .logo div{color:#555}.wrapper .logo div{font-family:Tahoma,sans-serif}@media only screen and (min-width: \n" +
"0){.wrapper .logo div{font-family:Roboto,Tahoma,sans-serif !important}}.wrapper .logo div a{color:#555}.wrapper .logo div a:hover{color:#555 !important}.btn a{}.wrapper .btn a{}.wrapper .btn a{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.wrapper .btn a{font-family:Roboto,Tahoma,sans-serif !important}}.wrapper .btn a{background-color:#9ec9df;border-top:1px solid #fefeff;border-bottom:1px solid #64a9cc;color:#fff !important;text-shadow:0 1px 0 0 1px 0 #8eb5c9}.wrapper .btn a:hover{background-color:#64a9cc !important;color:#fff !important}blockquote{border-left:4px solid #dddfe0}center.divider span,center.divider img{background-color:#3888bd}.feature .one-col{border-top:1px dashed #9ec9df;border-left:1px dashed #9ec9df;border-right:1px dashed #9ec9df}.frame-bottom .left,.frame-bottom .right{border-bottom:1px dashed #9ec9df;mso-border-bottom-alt:1pt dashed \n" +
"#9ec9df}.frame-bottom .left{border-left:1px dashed #9ec9df;mso-border-left-alt:1pt dashed #9ec9df}.frame-bottom .right{border-right:1px dashed #9ec9df;mso-border-right-alt:1pt dashed #9ec9df}.heart span,.heart img{background-color:#9ec9df}.feature-top span,.feature-bottom span,.feature-top img,.feature-bottom img{background-color:#dddfe0}.header{border-top:1px dashed #968e96}.footer .forward,.footer .facebook,.footer .twitter{color:#968e96}.wrapper .footer .forward,.wrapper .footer .facebook,.wrapper .footer .twitter{}.wrapper .footer .forward,.wrapper .footer .facebook,.wrapper .footer .twitter{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.wrapper .footer .forward,.wrapper .footer .facebook,.wrapper .footer .twitter{font-family:Roboto,Tahoma,sans-serif !important}}.footer .forward,.footer .facebook,.footer .twitter{}.footer .forward:hover,.footer \n" +
".facebook:hover,.footer .twitter:hover{color:#706870 !important}.address,.campaign,.preheader .title,.preheader .webversion{color:#968e96}.address,.campaign,.preheader .title,.preheader .webversion{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.address,.campaign,.preheader .title,.preheader .webversion{font-family:Roboto,Tahoma,sans-serif !important}}.wrapper .address a,.wrapper .campaign a,.wrapper .preheader .title a,.wrapper .preheader .webversion a{color:#968e96}.wrapper .address a:hover,.wrapper .campaign a:hover,.wrapper .preheader .title a:hover,.wrapper .preheader .webversion a:hover{color:#706870 !important}.footer .campaign a{}.wrapper .footer .campaign a{}.wrapper .footer .campaign a{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.wrapper .footer .campaign a{font-family:Roboto,Tahoma,sans-serif !important}}.footer .campaign \n" +
"a{}.footer .campaign a{letter-spacing:0.03em}.footer .divider{border-top:1px dashed #968e96}.forward,.facebook,.twitter{}.wrapper .forward,.wrapper .facebook,.wrapper .twitter{}.wrapper .forward,.wrapper .facebook,.wrapper .twitter{font-family:Tahoma,sans-serif}@media only screen and (min-width: 0){.wrapper .forward,.wrapper .facebook,.wrapper .twitter{font-family:Roboto,Tahoma,sans-serif !important}}.forward,.facebook,.twitter{}\n" +
"</style>\n" +
"    <center class=\"wrapper\" style=\"display: table;table-layout: fixed;width: 100%;min-width: 620px;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;background-color: #dddfe0\">\n" +
"      <table class=\"preheader centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px\">\n" +
"        <tbody><tr>\n" +
"          <td class=\"inner\" style=\"padding: 0;vertical-align: top;padding-top: 11px;padding-bottom: 12px\">\n" +
"            <table style=\"border-collapse: collapse;border-spacing: 0;width: 540px;Margin-left: auto;Margin-right: auto\" align=\"center\">\n" +
"              <tbody><tr>\n" +
"                <td class=\"title\" style=\"padding: 0;vertical-align: top;font-size: 11px;font-weight: normal;letter-spacing: 0.01em;line-height: 17px;color: #968e96;font-family: Tahoma,sans-serif;text-align: left\">Velkommen som ny bruker</td>\n" +
"                <td class=\"webversion\" style=\"padding: 0;vertical-align: top;font-size: 11px;font-weight: normal;letter-spacing: 0.01em;line-height: 17px;color: #968e96;font-family: Tahoma,sans-serif;text-align: right;width: 240px\">\n" +
"                  Utviklet av SCRUMTEAM1<webversion>Januar 2015</webversion>\n" +
"                </td>\n" +
"              </tr>\n" +
"            </tbody></table>\n" +
"          </td>\n" +
"        </tr>\n" +
"      </tbody></table>\n" +
"      <table class=\"header centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px;border-top: 1px dashed #968e96\">\n" +
"        <tbody><tr>\n" +
"          <td class=\"logo\" style=\"padding: 0;vertical-align: top;mso-line-height-rule: at-least;padding-top: 40px;padding-bottom: 37px\"><div class=\"logo-center\" style=\"font-size: 42px;line-height: 50px;color: #555;font-family: Tahoma,sans-serif;text-align: center\" align=\"center\" id=\"emb-email-header\"><img style=\"border: 0;-ms-interpolation-mode: bicubic;display: block;Margin-left: auto;Margin-right: auto;max-width: 240px\" src=\"http://s10.postimg.org/8fthqf4yh/nicandsteven.png\" alt=\"\" width=\"160\" height=\"124\" /></div></td>\n" +
"        </tr>\n" +
"      </tbody></table>\n" +
"      \n" +
"          <table class=\"one-col centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px;background-color: #ffffff;border-radius: 4px;box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1)\">\n" +
"            <tbody><tr>\n" +
"              <td class=\"column\" style=\"padding: 0;vertical-align: top;text-align: left\">\n" +
"                <div><div class=\"column-top\" style=\"font-size: 60px;line-height: 60px\">&nbsp;</div></div>\n" +
"                  <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;width: 100%\">\n" +
"                    <tbody><tr>\n" +
"                      <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px\">\n" +
"                        \n" +
"            \n" +
"<h1 style=\"Margin-top: 0;color: #3888bd;font-weight: 400;font-size: 36px;Margin-bottom: 21px;text-align: center;font-family: Tahoma,sans-serif;line-height: 44px\">Velkommen som ny bruker.</h1><p style=\\\"Margin-top: 0;color: #61606c;font-weight: 400;font-size: 15px;font-family: Tahoma,sans-serif;line-height: 24px;Margin-bottom: 24px\\\">Er du klar for &#229; spille Nic & Steven og samtidig l&#230;re CSS og HTML5?</p><p style=\\\"Margin-top: 0;color: #61606c;font-weight: 400;font-size: 15px;font-family: Tahoma,sans-serif;line-height: 24px;Margin-bottom: 24px\\\">Her er alt du trenger for &#229; komme i gang:</p><h3 style=\\\"Margin-top: 0;color: #377fcc;font-weight: bold;font-size: 15px;Margin-bottom: 16px;font-family: Tahoma,sans-serif;line-height: 21px\\\">&nbsp;</h3><h3 style=\\\"Margin-top: 0;color: #377fcc;font-weight: bold;font-size: 15px;Margin-bottom: 16px;font-family: \\n\" +\n" +
"\"Tahoma,sans-serif;line-height: 21px\\\">BRUKERNAVN:<p style=\\\"Margin-top: 0;color: #61606c;font-weight: 400;font-size: 15px;font-family: Tahoma,sans-serif;line-height: 24px;Margin-bottom: 24px\\\">"+ brukerdata.getEpost()+"</h3><h3 style=\\\"Margin-top: 0;color: #377fcc;font-weight: bold;font-size: 15px;Margin-bottom: 16px;font-family: Tahoma,sans-serif;line-height: 21px\\\">PASSORD:<p style=\\\"Margin-top: 0;color: #61606c;font-weight: 400;font-size: 15px;font-family: Tahoma,sans-serif;line-height: 24px;Margin-bottom: 24px\\\">"+ps+"</h3><p style=\"Margin-top: 0;color: #61606c;font-weight: 400;font-size: 15px;font-family: Tahoma,sans-serif;line-height: 24px;Margin-bottom: 24px\">&nbsp;</p><p style=\"Margin-top: 0;color: #61606c;font-weight: 400;font-size: 15px;font-family: Tahoma,sans-serif;line-height: 24px;Margin-bottom: 24px\">&nbsp;</p><p style=\"Margin-top: 0;color: #61606c;font-weight: 400;font-size: 15px;font-family: Tahoma,sans-serif;line-height: 24px;Margin-bottom: 24px\">&#8203;<em>Du kan endre passord p&#229; nettsiden etter &#229; ha logget inn</em></p><p style=\"Margin-top: 0;color: #61606c;font-weight: 400;font-size: 15px;font-family: Tahoma,sans-serif;line-height: 24px;Margin-bottom: 25px\">&nbsp;</p>\n" +
"          \n" +
"                      </td>\n" +
"                    </tr>\n" +
"                  </tbody></table>\n" +
"                \n" +
"                <div class=\"column-bottom\" style=\"font-size: 34px;line-height: 34px\">&nbsp;</div>\n" +
"              </td>\n" +
"            </tr>\n" +
"          </tbody></table>\n" +
"        \n" +
"          <div class=\"separator\" style=\"background-color: #dddfe0;line-height: 40px\">&nbsp;</div>\n" +
"        \n" +
"      <table class=\"footer centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px\">\n" +
"        <tbody><tr>\n" +
"          <td style=\"padding: 0;vertical-align: top\">\n" +
"            <table class=\"social\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto\" align=\"center\">\n" +
"              <tbody><tr>\n" +
"                <td style=\"padding: 0 13px 40px 13px;vertical-align: middle\">\n" +
"                  <fblike class=\"facebook\" style=\"display: inline-block;font-size: 12px;font-weight: 400;line-height: 12px;text-decoration: none;text-transform: uppercase;color: #968e96;font-family: Tahoma,sans-serif\"><img style=\"border: 0;-ms-interpolation-mode: bicubic;vertical-align: middle\" src=\"https://i6.createsend1.com/static/eb/master/02-blush/images/facebook-dark.png\" alt=\"\" width=\"20\" height=\"20\" />&nbsp; <span style=\"mso-text-raise: 6px\">Liker</span></fblike>\n" +
"                </td>\n" +
"                <td style=\"padding: 0 13px 40px 13px;vertical-align: middle\">\n" +
"                  <tweet class=\"twitter\" style=\"display: inline-block;font-size: 12px;font-weight: 400;line-height: 12px;text-decoration: none;text-transform: uppercase;color: #968e96;font-family: Tahoma,sans-serif\"><img style=\"border: 0;-ms-interpolation-mode: bicubic;vertical-align: middle\" src=\"https://i7.createsend1.com/static/eb/master/02-blush/images/twitter-dark.png\" alt=\"\" width=\"20\" height=\"20\" />&nbsp; <span style=\"mso-text-raise: 6px\">Tweet</span></tweet>\n" +
"                </td>\n" +
"                \n" +
"              </tr>\n" +
"            </tbody></table>\n" +
"            <table class=\"divider\" style=\"border-collapse: collapse;border-spacing: 0;line-height: 11px;width: 100%;border-top: 1px dashed #968e96\"><tbody><tr><td style=\"padding: 0;vertical-align: top\">&nbsp;</td></tr></tbody></table>\n" +
"            <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;width: 600px\">\n" +
"              <tbody><tr>\n" +
"                <td class=\"address\" style=\"padding: 0;vertical-align: top;font-size: 11px;font-weight: 400;line-height: 19px;padding-bottom: 40px;-webkit-font-smoothing: antialiased;text-align: left;padding-left: 30px;padding-right: 10px;width: 45%;color: #968e96;font-family: Tahoma,sans-serif\">\n" +
"                  <div>SCRUMTEAM1<br />\n" +
"AiTeL<br />\n" +
"HiST&nbsp;</div>\n" +
"                </td>\n" +
"                <td class=\"campaign\" style=\"padding: 0;vertical-align: top;font-size: 11px;font-weight: 400;line-height: 19px;padding-bottom: 40px;-webkit-font-smoothing: antialiased;text-align: right;padding-right: 30px;padding-left: 10px;width: 55%;color: #968e96;font-family: Tahoma,sans-serif\">\n" +
"                  <div class=\"links\">\n" +
"                    <span class=\"block\">\n" +
"                      \n" +
"                    </span>\n" +
"                    <span class=\"block\">\n" +
"                      <unsubscribe href=\"#\">\n" +
"                        Januar\n" +
"                      </unsubscribe>\n" +
"                    </span>\n" +
"                  </div>\n" +
"                  <div>2015<br />\n" +
"<br />\n" +
"&nbsp;</div>\n" +
"                </td>\n" +
"              </tr>\n" +
"            </tbody></table>\n" +
"          </td>\n" +
"        </tr>\n" +
"      </tbody></table>\n" +
"    </center>\n" +
"  \n" +
"</body>","text/html");
        
            //Send meldingen
            Transport transport = session.getTransport("smtp");
            transport.connect(host, fra, passord);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        
        }
    }

}

            
            
     
    
