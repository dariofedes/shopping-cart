package com.codurance.shoppingcart.features;

import com.codurance.shoppingcart.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ShoppingCartFeature {

	ShoppingCartService shoppingCartService;

	@Mock Clock clock;

	@Test
	void show_the_cart_content() {
		//given
		String date = "29/09/2021";
		when(clock.now()).thenReturn(date);
		int THE_HOBBIT_ID = 10002;
		int BREAKING_BAD_ID = 20110;
		Product theHobbit = new Product(THE_HOBBIT_ID, "The Hobbit", 5.00);
		Product breakingBad = new Product(BREAKING_BAD_ID, "Breaking Bad", 7.00);
		Map<Integer, Product> productsAvailable = new HashMap<>();
		productsAvailable.put(THE_HOBBIT_ID, theHobbit);
		productsAvailable.put(BREAKING_BAD_ID, breakingBad);
		ShoppingCartService shoppingCartService = new ShoppingCartService(new CartRepository(new CartBuilder(clock, new CartProductBuilder(new ProductRepository(productsAvailable)))));
		int userId = 1;
		shoppingCartService.addItem(userId, THE_HOBBIT_ID, 2);
		shoppingCartService.addItem(userId, BREAKING_BAD_ID, 5);

		// when
		Cart cart = shoppingCartService.cartFor(userId);

		// then
		assertEquals(date, cart.creationDate);
		assertEquals(45.00, cart.getTotal());
		assertEquals("The Hobbit", cart.items.get(0).name);
		assertEquals(2, cart.items.get(0).quantity);
		assertEquals(5.00, cart.items.get(0).unitPrice);
		assertEquals(10, cart.items.get(0).getTotalPrice());
		assertEquals("Breaking Bad", cart.items.get(1).name);
		assertEquals(5, cart.items.get(1).quantity);
		assertEquals(7.00, cart.items.get(1).unitPrice);
		assertEquals(35.00, cart.items.get(1).getTotalPrice());
	}

}
