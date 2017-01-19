package com.am.supermkt.core.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.am.supermkt.core.Cart;

public class CartTest {
	Cart cart;
	@Rule
	public ExpectedException excep = ExpectedException.none();

	public CartTest() {
		cart = new Cart();
	}

	@Test
	public void addToListInvalidCode() throws Exception {
		String code = "123";
		excep.expect(Exception.class);
		excep.expectMessage("Invalid product code: " + code);

		cart.addToList(code, 1);

	}

	@Test
	public void addToListInvalidQuantity() throws Exception {
		excep.expect(Exception.class);
		excep.expectMessage("Quantity cannot be 0");
		cart.addToList("65P1-UDGM-XH2M-LQW2", 0);
	}
}
