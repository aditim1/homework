package com.am.supermkt.core.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.am.supermkt.core.Product;
import com.am.supermkt.core.Store;

public class StoreTest {

	 @Rule
	    public ExpectedException excep = ExpectedException.none();

	@Test
	public void retrieveProductShouldReturnNull() {
		Store store = new Store();
		Product product;
		try {
			product = store.retrieveProduct("123");
			assertNull(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	//(expected = Exception.class)
	public void retrieveProductShouldReturnException() throws Exception {
		Store store = new Store();
			excep.expect(Exception.class);
			excep.expectMessage("Invalid code");
			Product product = store.retrieveProduct(null);
		
	}
}
