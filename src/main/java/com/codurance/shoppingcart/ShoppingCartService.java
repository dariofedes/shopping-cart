package com.codurance.shoppingcart;

public class ShoppingCartService {

    CartRepository cartRepository;

    public ShoppingCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addItem(int userId, int productId, int quantity) {
        Cart cart = cartRepository.getCartByUserId(userId);
        cart.addItem(productId, quantity);
        cartRepository.save(cart);
    }

    public Cart cartFor(int userId) {
        return cartRepository.getCartByUserId(userId);
    }
}
