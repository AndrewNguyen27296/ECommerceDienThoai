/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author XinKaChu
 */
public class MailerService {

    @Autowired 
    JavaMailSender mailSender;
    
    public void send(String to, String subject, String body) {
        try {
            /*
            Create mail
            */
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
            helper.setFrom("pandarencute96@gmail.com", "DigiWorld Web Master");
            helper.setTo(to);
            helper.setReplyTo("pandarencute96@gmail.com");
            helper.setSubject(subject);
            helper.setText(body, true);

            //Gửi mail
            mailSender.send(mail);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }

    }
}
