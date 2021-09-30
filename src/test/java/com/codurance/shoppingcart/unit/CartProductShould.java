package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.CartProduct;
import com.codurance.shoppingcart.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CartProductShould {
    @Test
    void return_total_price() {
        Product theHobbit = new Product(10002, "The Hobbit", 5.00);
        CartProduct cartHobbit = new CartProduct(theHobbit, 2);

        double totalPrice = cartHobbit.getTotalPrice();

        assertEquals(10.00, totalPrice);
    }
}