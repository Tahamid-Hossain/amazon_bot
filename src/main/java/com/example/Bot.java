// Specify the package name for the Bot class
package com.example;

import java.util.Scanner;

// Define the Bot class
public class Bot {
    // The main method, the entry point of the program
    public static void main(String[] args) {
        // Create an instance of the UserInput class to handle user input
        UserInput userInput = new UserInput();
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the product name and store it in the productName variable
        String productName = userInput.askForProductName();

        // Initialize nProducts to handle scope outside the loop
        int nProducts = 0;

        // Keep prompting the user until a valid input is provided
        while (true) {
            try {
                // Prompt the user to enter the number of products and store it in the nProducts variable
                nProducts = userInput.askForNumberOfProducts();

                // Check if nProducts is within the valid range of 1 to 10
                if (nProducts >= 1 && nProducts <= 10) {
                    break;  // Exit the loop if the input is valid
                } else {
                    // Throw an exception with a descriptive message for an invalid input range
                    throw new IllegalArgumentException("Number of products must be between 1 and 10.");
                }
            } catch (IllegalArgumentException e) {
                // Catch the exception and print an error message
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid value.");
            }
        }

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
