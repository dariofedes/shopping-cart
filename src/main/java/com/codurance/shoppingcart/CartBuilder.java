package com.codurance.shoppingcart;

public class CartBuilder {
    private Clock clock;
    private CartProductBuilder cartProductBuilder;

    public CartBuilder(Clock clock, CartProductBuilder cartProductBuilder) {
        this.clock = clock;
        this.cartProductBuilder = cartProductBuilder;
    }

    public Cart build(int userId) {
        String date = clock.now();

        return new Cart(userId, date, cartProductBuilder);
    }
}
