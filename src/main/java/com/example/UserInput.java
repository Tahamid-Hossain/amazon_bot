// UserInput.java
package com.example;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String askForProductName() {
        System.out.println("Enter a keyword: ");
        return scanner.nextLine();
    }

    public int askForNumberOfProducts() {
        System.out.println("Number of results to be shown: ");
        return scanner.nextInt();
    }
}
