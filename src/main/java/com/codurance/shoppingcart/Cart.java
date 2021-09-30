package com.codurance.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public String creationDate;
    public double total = 0;
    public List<CartProduct> items = new ArrayList<>();
    public int userId;
    private CartProductBuilder cartProductBuilder;

    public Cart(int userId, String date, CartProductBuilder cartProductBuilder){
        this.userId = userId;
        this.creationDate = date;
        this.cartProductBuilder = cartProductBuilder;
    }


    public void addItem(int productId, int quantity) {
        CartProduct cartProduct = cartProductBuilder.build(productId, quantity);

        items.add(cartProduct);
    }

    public double getTotal() {
        double total = 0;

        for(CartProduct item : items) {
            total += item.getTotalPrice();
        }

        return total;
    }
}
