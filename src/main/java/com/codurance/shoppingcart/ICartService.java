package com.codurance.shoppingcart;

public interface ICartService {
    default void addItemToUserCart(int userId, int productId, int quantity) {
        throw new UnsupportedOperationException();
    }
}
