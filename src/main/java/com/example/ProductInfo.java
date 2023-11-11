// ProductInfo.java
package com.example;

public class ProductInfo {
    private final String title;
    private final String price;

    public ProductInfo(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}
