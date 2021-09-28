package com.codurance.shoppingcart.features;

import com.codurance.shoppingcart.CartService;
import com.codurance.shoppingcart.Console;
import com.codurance.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.inOrder;

@SpringBootTest
class ShoppingCartFeature {

	@Mock
	Console console;

	@Test
	void show_the_cart_content() {
		//given
		CartService cartService = new CartService();
		ShoppingCart shoppingCart = new ShoppingCart(cartService);
		int userId = 1;
		int theHobbitId = 10002;
		int breakingBadId = 20110;

		shoppingCart.addItem(userId, theHobbitId, 2);
		shoppingCart.addItem(userId, breakingBadId, 5);

		// when
		shoppingCart.basketFor(userId);

		// then
		InOrder inOrder = inOrder(console);
		inOrder.verify(console).printLine("- 28/09/2021");
		inOrder.verify(console).printLine("- 2 x The Hobbit   // 2 x 5.00 = £10.00");
		inOrder.verify(console).printLine("- 5 x Breaking Bad // 5 x 7.00 = £35.00");
		inOrder.verify(console).printLine("- Total: £45.00");
	}

}
