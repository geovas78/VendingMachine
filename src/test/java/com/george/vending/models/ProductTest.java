package com.george.vending.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	private Product product = new Product("bread", 0.85, 5, 0, 0.0);

	@Test
	public void testCreatingProduct() throws Exception {
		
		assertEquals("bread", product.getProductName());
		assertTrue(0.85 == product.getPrice());
		
		product.takeItem();
		
		assertTrue( 4 == product.getNumberItems() );
		assertTrue( 1 == product.getSoldItems() );
		assertTrue( 0.85 == product.getSoldTotal() );
		
		product.takeItem();
		
		assertTrue( 3 == product.getNumberItems() );
		assertTrue( 2 == product.getSoldItems() );
		assertTrue( 1.7 == product.getSoldTotal());
	}
	
	@Test
	public void testRefillItems() throws Exception {
		
		Product salt = new Product("salt", 2.65, 5, 0, 0.0);
		
		// reset the available items to 10
		salt.setNumberItems(10);
		
		assertEquals("salt", salt.getProductName());
		assertTrue( 10 == salt.getNumberItems() );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeRefill() throws Exception {
		
		Product oil = new Product("oil", 1.99, 5, 0, 0.0);
		
		oil.setNumberItems(-5);
		
		assertTrue( 5 == oil.getNumberItems() );
	}
	
	@Test
	public void testPositiveRefill() throws Exception {
		
		Product rice = new Product("rice", 4.49, 5, 0, 0.0);
		
		rice.setNumberItems(10);
		
		assertTrue( 10 == rice.getNumberItems() );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeOrZeroPrice() throws Exception {
		
		//setting the price to zero from the constructor
		Product beer = new Product("beer", 0.0, 5, 0, 0.0);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPriceFromMethodSetToZero() throws Exception {
		
		Product beer = new Product();
		
		beer.setPrice(0);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativePriceFromMethod() throws Exception {
		
		Product beer = new Product();
		
		beer.setPrice(-15.75);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorNegativeItems() throws Exception {
		Product beer = new Product("beer", 2.5, -5, 0, 0.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorNegativeItemsSold() throws Exception {
		Product beer = new Product("beer", 2.5, 10, -30, 0.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testChangeProductName() throws Exception {
		
		Product beer = new Product("beer", 2.5, 10, 20, 400.56);
		
		beer.setProductName("coca-cola");
	}
	
	@Test
	public void testSecondConstructor() throws Exception {
		
		Product dough = new Product("dough", 1.95, 10);
		
		assertTrue( 0 == dough.getSoldItems() );
		assertTrue( 0 == dough.getSoldTotal() );
	}
	
	@Test
	public void testManualCreationOfProduct() throws Exception {
		
		Product prod = new Product();
		prod.setProductName("product");
		prod.setPrice(25.65);
		prod.setNumberItems(10);
		
		assertEquals("product", prod.getProductName());
		assertTrue(25.65 == prod.getPrice());
		assertTrue(10 == prod.getNumberItems());
		assertTrue(0 == prod.getSoldItems());
		assertTrue(0.0 == prod.getSoldItems());
	}

}
