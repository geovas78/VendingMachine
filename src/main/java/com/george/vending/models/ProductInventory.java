package com.george.vending.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Georgi Vasilski
 * @since 26.05.2018
 * @version 1.0
 *
 */
public class ProductInventory implements Serializable{

	private static final long serialVersionUID = 7028840641148377040L;
	private Map<String, Product> inventory = new LinkedHashMap<>();

	/**
	 * @return the inventory
	 */
	public Map<String, Product> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Map<String, Product> inventory) {
		if(this.inventory == null || this.inventory.isEmpty()) {
			this.inventory = inventory;
		}else {
			this.inventory.putAll(inventory);
		}
	}
	
	/**
	 * get the product by name
	 * @param productName - product name
	 * @return - product object
	 */
	public Product getProduct(String productName) {
		return this.inventory.get(productName);
	}
	
	/**
	 * add product to the inventory
	 * @param product - product object
	 */
	public void addProduct(Product product) {
		this.inventory.put(product.getProductName(), product);
	}

	@Override
	public String toString() {
		return "ProductInventory [inventory=" + inventory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProductInventory))
			return false;
		ProductInventory other = (ProductInventory) obj;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		return true;
	}
	
	
}
