// Specify the package name for the EmailSender class
package com.example;

// Import JavaMail classes and other required packages
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

// Define the EmailSender class
public class EmailSender {
    // Method to send an email with product information
    public void sendEmail(ProductInfo productInfo) {
        // Specify the recipient's email address
        String to = "mitahamid13@gmail.com";

        // Specify the sender's email address
        String from = "amazonbotcud@gmail.com";

        // Create a Properties object to configure email properties
        Properties properties = new Properties();

        // Enable authentication for the mail server
        properties.put("mail.smtp.auth", "true");

        // Enable TLS for secure communication with the mail server
        properties.put("mail.smtp.starttls.enable", "true");

        // Specify the mail server host (SMTP server for Gmail)
        properties.put("mail.smtp.host", "smtp.gmail.com");

        // Specify the port number for the mail server (587 for Gmail)
        properties.put("mail.smtp.port", 587);

        // Create a session with the specified properties and authentication
        Session session = Session.getDefaultInstance(properties, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("amazonbotcud@gmail.com", "gwrs bolh lvdf riiv");
            }
        });

        try {
            // Create a MimeMessage for composing the email
            MimeMessage message = new MimeMessage(session);

            // Set the sender's email address
            message.setFrom(new InternetAddress(from));

            // Set the recipient's email address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set the subject of the email
            message.setSubject("Your product results");

            // Set the text content of the email (product title)
            message.setText(productInfo.getTitle());

            // Send the email using the Transport class
            Transport.send(message);

            // Print a success message to the console
            System.out.println("Message sent successfully");
        } catch (MessagingException mex) {
            // Print the exception details in case of an error
            mex.printStackTrace();
        }
    }
}
