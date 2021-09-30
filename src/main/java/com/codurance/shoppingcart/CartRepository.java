package com.codurance.shoppingcart;


import java.util.HashMap;
import java.util.Map;

public class CartRepository {

    private Map<Integer, Cart> carts = new HashMap<>();

    private CartBuilder cartBuilder;

    public CartRepository(CartBuilder cartBuilder) {
        this.cartBuilder = cartBuilder;
    }

    public Cart getCartByUserId(int userId) {
        Cart cart = carts.get(userId);

        if(cart == null) {
            cart = cartBuilder.build(userId);

            carts.put(userId, cart);
        }

        return cart;
    }

    public void save(Cart cart) {
        carts.put(cart.userId, cart);
    }

    // TODO setter only for testing purpose, I don't like it
    public void setCarts(Map<Integer, Cart> carts) {
        this.carts = carts;
    }
}
