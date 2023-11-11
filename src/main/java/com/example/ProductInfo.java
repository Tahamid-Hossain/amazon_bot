// Specify the package name for the ProductInfo class
package com.example;

// Define the ProductInfo class
public class ProductInfo {
    // Declare a private final instance variable to store the product title
    private final String title;

    // Constructor to initialize the ProductInfo object with a title
    public ProductInfo(String title) {
        // Set the title using the provided value
        this.title = title;
    }

    // Getter method to retrieve the product title
    public String getTitle() {
        // Return the stored product title
        return title;
    }
}
