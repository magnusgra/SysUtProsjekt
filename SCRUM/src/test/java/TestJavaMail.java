
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.jvnet.mock_javamail.Mailbox;
import com.team1.proj.mailoppsett.Mail;
import java.io.IOException;
import org.junit.*;
import javax.mail.MessagingException;

/**
 *
 * @author Ingrid
 */
public class TestJavaMail {

 private Mail mail;

 @Before
 public void setUp(){
 mail = new Mail();
 Mailbox.clearAll();
 }
 
 @Test
 public void testSendHtmlEmail() throws MessagingException, IOException {
     String subject = "TestSubject";
     String message = "TestMessage";
     mail.sendHtmlEmail(message, subject, message, message, message, subject, message);
 }
}
 
 
   //  @After
   // public void cleanup() {
   //     testSmtp.stop();
    /*ServerSetup setup = new ServerSetup(65438, "localhost", "smtp");
     GreenMail testSmtp = new GreenMail(setup);
    Mail emailSender = new Mail();*/
    
  /*  @Before
    public void testSmtpInit() {
        
    
        testSmtp.start();
        

        emailSender.setPort("65438");
        emailSender.setHost("localhost");
    }

    @Test
    public void testEmail() throws InterruptedException, MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("test@sender.com");
        message.setTo("test@receiver.com");
        message.setSubject("test subject");
        message.setText("test message");
        //First we need to call the actual method of EmailSErvice      
        emailSender.send(message);
        //Then after that using GreenMail need to verify mail sent or not      
        assertTrue(testSmtp.waitForIncomingEmail(5000, 1));
        Message[] messages = testSmtp.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals("test subject", messages[0].getSubject());
        String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
        assertEquals("test message", body);
    }

    
    }*/



  
  
    

 
