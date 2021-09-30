package com.codurance.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<Integer, Product> products = new HashMap<>();

    public ProductRepository(Map<Integer, Product> products) {
        this.products = products;
    }

    public ProductRepository(){};

    public Product getById(int productId) {
        return products.get(productId);
    }
}
