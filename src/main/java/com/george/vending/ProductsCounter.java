package com.george.vending;

/**
 *
 * @author Georgi Vasilski
 */
public class ProductsCounter {
	int product;

	public ProductsCounter() {
		product = 10;
	}

	public int getCount() {
		return product;
	}

	public void setCounter(int x) {
		product = x;
	}

	public void decreaseCount() {
		product--;
	}
}
