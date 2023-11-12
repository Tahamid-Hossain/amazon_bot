// Specify the package name for the WebScraper class
package com.example;

// Import Playwright classes and options for web automation
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

// Define the WebScraper class
public class WebScraper {

    // Method to scrape product information from a website
    public ProductInfo scrapeProductInformation(String productName, int nProducts) {

        // Create an instance of the Playwright API
        Playwright playwright = Playwright.create();

        // Launch the Chromium browser in non-headless mode
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Create a new page in the browser
        Page page = browser.newPage();

        // Navigate to the Amazon website
        page.navigate("https://amazon.ae");

        // Wait for the page to fully load before proceeding
        page.waitForLoadState(LoadState.LOAD);

        // Fill in the search input field with the provided product name
        page.getByPlaceholder("Search Amazon.ae").fill(productName);

        // Click the search submit button
        page.locator("id=nav-search-submit-button").click();

        // Initialize a string to store the scraped product information
        String products = "";

        // Loop through the specified number of products
        for (int i = 1; i <= nProducts; i++) {

            // Extract the product title from the search page
            String product = page.locator("(//span[contains(@class,'a-size-base-plus a-color-base')])[%s]".formatted(i)).textContent();
            // Print the product title to the console
            System.out.println(product);
            
            // Click on the product to navigate to its details page
            page.locator("(//span[contains(@class,'a-size-base-plus a-color-base')])[%s]".formatted(i)).click();

            

            // Extract the product price from the details page
            String price = page.locator("(//span[@class='a-offscreen'])[1]").textContent();

            // Print the product price to the console
            System.out.println(price);

            // Construct a string containing product details (title, price, and URL)
            String productDetails = "Product %s: ".formatted(i) + product + "\n" + "Price: " + price + "\n" + "URL:"
                    + page.url() + "\n\n\n";

            // Append the product details string to the overall products string
            products = products + productDetails;

            // Navigate back to the search results page
            page.goBack();
        }

        // Close the current page
        page.close();

        // Close the browser
        browser.close();

        // Close the Playwright instance
        playwright.close();

        // Return a new ProductInfo object containing the scraped product information
        return new ProductInfo(products);
    }
}
