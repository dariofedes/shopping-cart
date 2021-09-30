package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.Cart;
import com.codurance.shoppingcart.CartProduct;
import com.codurance.shoppingcart.CartProductBuilder;
import com.codurance.shoppingcart.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CartShould {

    @Mock
    CartProductBuilder cartProductBuilder;

    Cart cart;

    @BeforeEach
    void setUp() {
        int userId = 1;
        String date = "29/09/2021";
        cart = new Cart(userId, date, cartProductBuilder);
    }

    @Test
    void add_items() {
        int productId = 10002;
        String name = "The Hobbit";
        double price = 5.00;
        int quantity = 2;
        when(cartProductBuilder.build(productId, quantity)).thenReturn(new CartProduct(new Product(productId, name, price), quantity));

        cart.addItem(productId, quantity);

        verify(cartProductBuilder).build(productId, quantity);
        assertEquals(productId, cart.items.get(0).productId);
        assertEquals(quantity, cart.items.get(0).quantity);
    }

    @Test
    void return_the_total_price() {
    }
}