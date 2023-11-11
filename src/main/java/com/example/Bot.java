
// Specify the package name for the Bot class
package com.example;

// Define the Bot class
public class Bot {
    // The main method, the entry point of the program
    public static void main(String[] args) {
        // Create an instance of the UserInput class to handle user input
        UserInput userInput = new UserInput();

        // Prompt the user to enter the product name and store it in the productName variable
        String productName = userInput.askForProductName();

        // Prompt the user to enter the number of products and store it in the nProducts variable
        int nProducts = userInput.askForNumberOfProducts();

        // Create an instance of the WebScraper class to handle web scraping
        WebScraper webScraper = new WebScraper();

        // Use the WebScraper to scrape product information based on the user input
        ProductInfo productInfo = webScraper.scrapeProductInformation(productName, nProducts);

        // Create an instance of the EmailSender class to handle sending emails
        EmailSender emailSender = new EmailSender();

        // Send an email containing the scraped product information
        emailSender.sendEmail(productInfo);
    }
}
