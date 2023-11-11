// Specify the package name for the UserInput class
package com.example;

// Import the Scanner class from the java.util package
import java.util.Scanner;

// Define the UserInput class
public class UserInput {
    // Declare a private instance variable for the Scanner
    private Scanner scanner;

    // Constructor to initialize the Scanner instance
    public UserInput() {
        // Create a new Scanner object to read input from the console
        this.scanner = new Scanner(System.in);
    }

    // Method to prompt the user for a product name and return the entered keyword
    public String askForProductName() {
        // Print a message to the console instructing the user to enter a keyword
        System.out.println("Enter a keyword: ");

        // Read the entered line of text from the console and return it
        return scanner.nextLine();
    }

    // Method to prompt the user for the number of products to be shown and return the entered value
    public int askForNumberOfProducts() {
        // Print a message to the console instructing the user to enter the number of results
        System.out.println("Number of results to be shown: ");

        // Read the entered integer value from the console and return it
        return scanner.nextInt();
    }
}
