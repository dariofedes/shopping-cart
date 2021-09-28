package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.CartService;
import com.codurance.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
class ShoppingCartShould {
    @Mock
    CartService cartService;

    ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart(cartService);
    }

    @Test
    void add_new_items() {
        //given
        int userId = 1;
        int productId = 10002;
        int quantity = 2;

        // when
        shoppingCart.addItem(userId, productId, quantity);

        // then
        verify(cartService).addItemToUserCart(userId, productId, quantity);
    }
}