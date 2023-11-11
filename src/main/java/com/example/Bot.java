
package com.example;

public class Bot {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        String productName = userInput.askForProductName();
        int nProducts = userInput.askForNumberOfProducts();

        WebScraper webScraper = new WebScraper();
        ProductInfo productInfo = webScraper.scrapeProductInformation(productName, nProducts);

        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(productInfo);
    }
}
