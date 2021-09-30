package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.Cart;
import com.codurance.shoppingcart.CartRepository;
import com.codurance.shoppingcart.ShoppingCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class ShoppingCartServiceShould {
    ShoppingCartService shoppingCartService;

    @Mock CartRepository cartRepository;
    @Mock Cart cart;

    @BeforeEach
    void setUp() {
        shoppingCartService = new ShoppingCartService(cartRepository);
    }

    @Test
    void add_item_to_user_cart() {
        // given
        int userId = 1;
        int productId = 10002;
        int quantity = 2;

        when(cartRepository.getCartByUserId(userId)).thenReturn(cart);

        // when
        shoppingCartService.addItem(userId, productId, quantity);

        // then
        verify(cartRepository).getCartByUserId(userId);
        verify(cart).addItem(productId, quantity);
        verify(cartRepository).save(cart);
    }

    @Test
    void return_a_users_cart() {
        int userId = 1;

        shoppingCartService.cartFor(userId);

        verify(cartRepository).getCartByUserId(userId);
    }
}