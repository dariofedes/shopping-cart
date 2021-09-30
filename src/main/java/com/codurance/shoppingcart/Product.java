package com.codurance.shoppingcart;

public class Product {
    public final int productId;
    public final String name;
    public final double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}
