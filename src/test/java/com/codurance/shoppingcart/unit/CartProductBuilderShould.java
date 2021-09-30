package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.CartProduct;
import com.codurance.shoppingcart.CartProductBuilder;
import com.codurance.shoppingcart.Product;
import com.codurance.shoppingcart.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CartProductBuilderShould {
    @Mock
    ProductRepository productRepository;

    CartProductBuilder cartProductBuilder;

    @BeforeEach
    void setUp() {
        cartProductBuilder = new CartProductBuilder(productRepository);
    }

    @Test
    void return_a_cart_product_with_the_product_info() {
        int productId = 10002;
        int quantity = 2;
        String name = "The Hobbit";
        double price = 5.00;
        when(productRepository.getById(productId)).thenReturn(new Product(productId, name, price));

        CartProduct cartProduct = cartProductBuilder.build(productId, quantity);

        verify(productRepository).getById(productId);
        assertEquals(productId, cartProduct.productId);
        assertEquals(quantity, cartProduct.quantity);
        assertEquals(name, cartProduct.name);
        assertEquals(price, cartProduct.unitPrice);

    }
}