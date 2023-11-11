// WebScraper.java
package com.example;

import com.microsoft.playwright.*;

public class WebScraper {
    public ProductInfo scrapeProductInformation(String productName, int nProducts) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://amazon.ae");
        page.getByPlaceholder("Search Amazon.ae").fill(productName);
        page.locator("id=nav-search-submit-button").click();
        page.locator("img[data-image-index='%s']".formatted(nProducts)).click();
        String product1 = page.locator("id=productTitle").textContent();
        String price1 = page.locator("(//span[@class='a-offscreen'])[1]").textContent();
        // Add your web scraping logic here based on the provided productName and nProducts

        playwright.close();

        // Assume you extracted product information and return it
        return new ProductInfo(product1, price1);
    }
}
