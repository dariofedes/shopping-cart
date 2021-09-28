package com.codurance.shoppingcart;

public class ShoppingCart {

    private ICartService cartService;

    public ShoppingCart(ICartService cartService) {
        this.cartService = cartService;
    }

    public void addItem(int userId, int productId, int quantity) {
        cartService.addItemToUserCart(userId, productId, quantity);
    }

    public void basketFor(int userId) {
        throw new UnsupportedOperationException();
    }
}
