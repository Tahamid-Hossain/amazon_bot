package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
public class WebScraper {

    public ProductInfo scrapeProductInformation(String productName, int nProducts) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://amazon.ae");
        page.waitForLoadState(LoadState.LOAD);
        page.getByPlaceholder("Search Amazon.ae").fill(productName);
        page.locator("id=nav-search-submit-button").click();

        String products="";

        for (int i = 1; i <=nProducts; i++){
            page.locator("(//span[contains(@class,'a-size-base-plus a-color-base')])[%s]".formatted(i)).click();
            String product = page.locator("#productTitle").textContent();

            System.out.println(product);

            String price = page.locator("(//span[@class='a-offscreen'])[1]").textContent();
            System.out.println(price);

            String productn = "Product%s:".formatted(i) + product + "\n" + "Price: " + price + "\n" + "URL:" + page.url() + "\n\n\n";
            products = products+productn;

            page.goBack();
        }

        page.close();
        browser.close();
        playwright.close();

        return new ProductInfo(products);
    }
}
