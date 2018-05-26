package com.george.vending.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.george.vending.models.Product;
import com.george.vending.models.ProductInventory;

public class DataStorageTest {
	
	private Product bread = new Product("bread", 0.85, 10);
	private Product butter = new Product("butter", 2.55, 15);

	@Test
	public void testWrite() throws FileNotFoundException, ClassNotFoundException {
		ProductInventory inventory = new ProductInventory();
		inventory.addProduct(bread);
		inventory.addProduct(butter);
		
		DataStorage.writeToFile(inventory, "src/test/resources/inventory.dat");
		
		Path file= Paths.get("src/test/resources/inventory.dat");
		
		assertTrue(Files.exists(file));
	}
	
	@Test
	public void testRead() throws FileNotFoundException, ClassNotFoundException {
		ProductInventory inventory = DataStorage.readFromFile("src/test/resources/inventory.dat");
		
		assertNotNull(inventory);
		assertTrue( 2 == inventory.getInventory().size());
		assertEquals("bread", inventory.getProduct("bread").getProductName());
	}

}
