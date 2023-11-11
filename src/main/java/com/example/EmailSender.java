// EmailSender.java
package com.example;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailSender {
    public void sendEmail(ProductInfo productInfo) {
        String to = "mitahamid13@gmail.com";
        String from = "amazonbotcud@gmail.com";
        String host = "localhost";
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);

        Session session = Session.getDefaultInstance(properties, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("amazonbotcud@gmail.com", "gwrs bolh lvdf riiv");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Your product results");
            message.setText("Product1: " + productInfo.getTitle() + "Price: " + productInfo.getPrice());

            Transport.send(message);

            System.out.println("Message sent successfully");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
