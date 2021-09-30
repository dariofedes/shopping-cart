package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.Product;
import com.codurance.shoppingcart.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductRepositoryShould {

    ProductRepository productRepository;
    int productId = 10002;
    String name = "The Hobbit";
    double price = 5.00;
    Product product = new Product(productId, name, price);

    @BeforeEach
    void setUp() {
        Map<Integer, Product> products = new HashMap<>();
        products.put(productId, product);
        productRepository = new ProductRepository(products);
    }

    @Test
    void return_an_existing_product() {
        Product retrievedProduct = productRepository.getById(productId);

        assertEquals(product, retrievedProduct);
    }
}