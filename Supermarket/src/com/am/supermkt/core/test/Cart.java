package com.am.supermkt.core;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<Product> products;
	List<String> productCodes;
	float cartTotal;
	Store store;

	public Cart() {
		store = new Store();
		productCodes = new ArrayList<String>();
		products = new ArrayList<Product>();
		cartTotal = 0;
	}

	/**
	 * Add item to cart
	 * 
	 * @param newProductCode
	 */
	public void addToList(String newProductCode, int quantity) throws Exception {
		if (isCodeValid(newProductCode) && quantity != 0) {
			// productCodes.add(newProductCode);
			updateCart(newProductCode, quantity);
		}
		else{
			throw new Exception("Quantity cannot be 0");
		}
	}

	/**
	 * update cart if code is valid
	 */
	public void updateCart(String code, int quantity) {
		try {
			Product p = store.retrieveProduct(code);
			products.add(p);
			float totalPrice = p.getProductPrice() * quantity;
			cartTotal += totalPrice;
			System.out.println("Cart total: " + cartTotal);
			System.out.println("Items in cart: " + products.size());
		} catch (Exception ex) {
			System.out.println("Invalid code sent to the cart");
		}
	}

	public void checkout() {
		// TODO
	}

	public boolean isCodeValid(String productCode) throws Exception {
		// TODO alphanumeric 16 digit case insensitive
		boolean isValid = false;
		String code = productCode.toLowerCase();
		String[] strArr = code.split("-");
		if (strArr.length == 4) {
			for (int i = 0; i < 4; i++) {
				if (strArr[i].matches("[A-Za-z0-9]*")) {
					isValid = true;
				} else
					break;
			}
		}
		if (!isValid)
			throw new Exception("Invalid product code: " + productCode);
		else
			return isValid;
	}

	public void clearCart() {
		products.clear();
		productCodes.clear();
		cartTotal = 0;
		System.out.println("Clearing all items***************");
	}

	public static void main(String[] arg) throws Exception {
		Cart c = new Cart();
		c.addToList("65P1UDGMXH2MLQW2", 1);
		c.addToList("65P1-UDGM-XH2M-LQW2", 1);
		c.addToList("65P1-UDGM-XH2M-LQW2", 1);
		c.addToList("TQ4C-VV6T-75ZX-1RMR", 2);
		c.clearCart();
		c.addToList("65P1-UDGM-XH2M-LQW2", 1);
		c.addToList("TQ4C-VV6T-75ZX-1RMR", 2);

	}
}
