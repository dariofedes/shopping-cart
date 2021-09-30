package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.Cart;
import com.codurance.shoppingcart.CartBuilder;
import com.codurance.shoppingcart.CartProductBuilder;
import com.codurance.shoppingcart.Clock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CartBuilderShould {

    @Mock Clock clock;
    @Mock CartProductBuilder cartProductBuilder;

    CartBuilder cartBuilder;

    @BeforeEach
    void setUp() {
        cartBuilder = new CartBuilder(clock, cartProductBuilder);
    }

    @Test
    void return_a_cart_for_the_given_user() {
        int userId = 1;

        Cart cart = cartBuilder.build(userId);

        assertEquals(userId, cart.userId);
    }
}