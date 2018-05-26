package com.george.vending.models;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class ProductInventoryTest {
	
	private Product bread = new Product("bread", 0.85, 10);
	private Product butter = new Product("butter", 2.55, 15);
	private Product flour = new Product("flour", 1.60, 20);

	@Test
	public void testCreateInventory() {
		
		ProductInventory inventory = new ProductInventory();
		inventory.addProduct(bread);
		
		assertTrue( 1 == inventory.getInventory().size());
		assertEquals("bread", inventory.getProduct("bread").getProductName());
		
		Map<String, Product> items = new LinkedHashMap<>();
		items.put(butter.getProductName(), butter);
		items.put(flour.getProductName(), flour);
		
		// adding a map<productname, product> to the inventory
		inventory.setInventory(items);
		
		assertTrue( 3 == inventory.getInventory().size());
		
	}
	
	@Test
	public void testInitialMapAddedToInventory() throws Exception {
		Map<String, Product> items = new LinkedHashMap<>();
		items.put(bread.getProductName(), bread);
		
		ProductInventory inventory = new ProductInventory();
		inventory.setInventory(items);
		
		assertTrue( 1 == inventory.getInventory().size());
		
	}
	
	@Test
	public void testGetProduct() throws Exception {
		
		ProductInventory inventory = new ProductInventory();
		inventory.addProduct(bread);
		inventory.addProduct(butter);
		
		assertEquals("bread", inventory.getProduct("bread").getProductName());
		assertTrue( 0.85 == inventory.getProduct("bread").getPrice());
		assertTrue( 10 == inventory.getProduct("bread").getNumberItems());
	}
	
	@Test(expected=NullPointerException.class)
	public void testNonExistingProduct() throws Exception {
		ProductInventory inventory = new ProductInventory();
		inventory.addProduct(bread);
		inventory.addProduct(butter);
		
		assertEquals("productNotExisting", inventory.getProduct("productNotExisting").getProductName());
	}

}
