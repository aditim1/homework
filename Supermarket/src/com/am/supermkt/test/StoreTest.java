package com.am.supermkt.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.am.supermkt.core.StoreManager;
import com.am.supermkt.vo.Product;

public class StoreTest {

	 @Rule
	    public ExpectedException excep = ExpectedException.none();

	@Test
	public void retrieveProductShouldReturnNull() {
		StoreManager store = new StoreManager();
		Product product;
		try {
			product = store.retrieveProduct("123");
			Assert.assertNotNull("The product was not retrieevd successfully", product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	//(expected = Exception.class)
	public void retrieveProductShouldReturnException() throws Exception {
		StoreManager store = new StoreManager();
			excep.expect(Exception.class);
			excep.expectMessage("Invalid code");
			Product product = store.retrieveProduct(null);
		
	}
}
