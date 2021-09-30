package com.codurance.shoppingcart;

public class CartProductBuilder {
    private ProductRepository productRepository;

    public CartProductBuilder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public CartProduct build(int productId, int quantity) {
        Product product = productRepository.getById(productId);

        return new CartProduct(product, quantity);
    }
}
