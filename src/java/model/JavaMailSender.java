/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author PC
 */
public class JavaMailSender {
    public String getRandom() {
        Random r = new Random();
        int num = r.nextInt(999999);
        return String.format("%06d", num);
    }
    
    public boolean sendEmailSignup(String email, String username, String code) {
        boolean test = false;

        String fromEmail = "nmquang.2908@gmail.com";
        String password = "iuqjtsxbsrbhreut";  
        String toEmmail = email;
        Properties pr = new Properties();
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.port", "587"); //TLS
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.starttls.enable", "true");

        //get Session
        Session session = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }

        });

        try {
            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmmail));
           
            mess.setSubject("Security Code");
            mess.setText("Hi " + username + "\n"
                    + "Your security code: " + code + "\n"
                    + "To be able to log in, please enter the security code to activate your account."
                    + "Please do not share the code with anyone.");
            Transport.send(mess);
            test = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return test;
    }
}
