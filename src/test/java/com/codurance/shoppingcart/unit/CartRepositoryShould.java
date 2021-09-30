package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CartRepositoryShould {
    @Mock CartBuilder cartBuilder;
    @Mock Clock clock;
    @Mock CartProductBuilder cartProductBuilder;

    CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        cartRepository = new CartRepository(cartBuilder);
    }

    @Test
    void return_new_cart_if_no_cart_for_user() {
        int userId = 1;
        String date = "29/09/2021";
        when(cartBuilder.build(userId)).thenReturn(new Cart(userId, date, cartProductBuilder));

        Cart cart = cartRepository.getCartByUserId(userId);

        verify(cartBuilder).build(userId);
        assertEquals(userId, cart.userId);
    }

    @Test
    void return_an_existing_cart_without_crating_a_new_one() {
        int userId = 1;
        String date = "29/09/2021";
        Cart userCart = new Cart(userId, date, cartProductBuilder);
        Map<Integer, Cart> carts = new HashMap<>();
        carts.put(userId, userCart);
        cartRepository.setCarts(carts);

        Cart cart = cartRepository.getCartByUserId(userId);

        verify(cartBuilder, never()).build(anyInt());
        assertEquals(userId, cart.userId);
    }

}