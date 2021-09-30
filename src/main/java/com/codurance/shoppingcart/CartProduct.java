package com.codurance.shoppingcart;

public class CartProduct {
    public String name;
    public int quantity;
    public int productId;
    public double unitPrice;

    public CartProduct(Product product, int quantity) {

        this.productId = product.productId;
        this.name = product.name;
        this.unitPrice = product.price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }
}
