package com.george.vending.models;

import java.io.Serializable;

/**
 * 
 * @author Georgi Vasilski
 * @version 1.0
 * @since 26.05.2018
 *
 */
public class Product implements Serializable{
	
	// the product name
	private String productName;
	// single price of an item
	private double price;
	// number of items available
	private int numberItems;
	// total sold items
	private int soldItems;
	//total amount of money accumulated 
	private double soldTotal;
	
	/**
	 * default constructor
	 */
	public Product() {
	}
	
	/**
	 * constructor setting all private fileds 
	 */
	public Product(String productName, double price, int numberItems, int soldItems, double soldTotal) {
		this.productName = productName;
		if(price <= 0) {
			throw new IllegalArgumentException("Price cannot be negative or zero value");
		}
		this.price = price;
		if(numberItems < 0 ) {
			throw new IllegalArgumentException("The number of items cannot be negative");
		}
		this.numberItems = numberItems;
		if(soldItems < 0) {
			throw new IllegalArgumentException("sold items value cannot be negative");
		}
		this.soldItems = soldItems;
		this.soldTotal = soldTotal;
	}
	
	public Product(String productName, double price, int numberItems) {
		this.productName = productName;
		if(price <= 0) {
			throw new IllegalArgumentException("Price cannot be negative or zero value");
		}
		this.price = price;
		if(numberItems < 0 ) {
			throw new IllegalArgumentException("The number of items cannot be negative");
		}
		this.numberItems = numberItems;
		if(soldItems < 0) {
			throw new IllegalArgumentException("sold items value cannot be negative");
		}
		this.soldItems = 0;
		this.soldTotal = 0.0;
	}
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		if(this.productName != null) {
			throw new IllegalArgumentException("The product has already name '" + 
						this.productName + "' and cannot be changed");
		}
		this.productName = productName;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		if(price <= 0) {
			throw new IllegalArgumentException("Price cannot be negative or zero value");
		}
		this.price = price;
	}
	/**
	 * @return the numberItems
	 */
	public int getNumberItems() {
		return numberItems;
	}
	/**
	 * @param numberItems the numberItems to set
	 */
	public void setNumberItems(int numberItems) {
		if(numberItems < 0) {
			throw new IllegalArgumentException("Number of Items cannot be negative value");
		}
		this.numberItems = numberItems;
	}
	
	/**
	 * deduct 1 item
	 */
	public void takeItem() {
		numberItems--;
		addSoldItem();
	}
	/**
	 * add 1 item to the sold items
	 */
	private void addSoldItem() {
		soldItems++;
		addAmountToTotal();
	}
	/**
	 *  add single price to total amount sold items
	 */
	private void addAmountToTotal() {
		soldTotal+=price;
	}
	/**
	 * @return the soldItems
	 */
	public int getSoldItems() {
		return soldItems;
	}
	/**
	 * @return the soldTotal
	 */
	public double getSoldTotal() {
		return soldTotal;
	}
	
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", numberItems=" + numberItems
				+ ", soldItems=" + soldItems + ", soldTotal=" + soldTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberItems;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + soldItems;
		temp = Double.doubleToLongBits(soldTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (numberItems != other.numberItems)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (soldItems != other.soldItems)
			return false;
		if (Double.doubleToLongBits(soldTotal) != Double.doubleToLongBits(other.soldTotal))
			return false;
		return true;
	}
	
}
