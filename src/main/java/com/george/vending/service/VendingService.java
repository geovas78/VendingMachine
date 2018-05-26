package com.george.vending.service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.george.vending.io.DataStorage;
import com.george.vending.models.Product;
import com.george.vending.models.ProductInventory;

/**
 * 
 * @author Georgi Vasilski
 * @since 26.05.2018
 * @version 1.0
 *
 */
public class VendingService {
	
	private DecimalFormat df = new DecimalFormat("#0.00");
	private Scanner keyboard;
	private String pound = "\u00a3";
	@SuppressWarnings("unused")
	private String euro = "\u20ac";
	private Scanner sc;
	
	/**
	 * the main thread of the program
	 */
	public void run() {
		ProductInventory inventory = new ProductInventory();
		
		// TODO: read and then after exit write to a file
//		try {
//			inventory = DataStorage.readFromFile("src/test/resources/inventory.dat");
//		}catch(IOException | ClassNotFoundException e) {
//			
//		}
		
		keyboard = new Scanner(System.in);
		
		// create products
		Product gum = new Product("gum", 1.45, 10);
		Product chocolate = new Product("chocolate", 2.25, 10);
		Product juice = new Product("juice", 1.80, 10);
		Product popcorn = new Product("popcorn", 1.2, 10);

		inventory.addProduct(gum);
		inventory.addProduct(chocolate);
		inventory.addProduct(juice);
		inventory.addProduct(popcorn);
		
		char choice;
		
		System.out.println();
		do {
			System.out.println("*** VENDING MACHINE ***");
			System.out.println();
			System.out.println("[1] Get gum");
			System.out.println("[2] Get chocolate");
			System.out.println("[3] Get popcorn");
			System.out.println("[4] Get juice");
			System.out.println("[5] Display total sold so far");
			System.out.println("[6] Refill products");
			System.out.println("[7] Check what has left on shelves");
			System.out.println("[8] Quit");
			System.out.println();
			System.out.print("enter your choice : ");
			choice = keyboard.next().charAt(0);

			switch (choice) {
			case '1':
				productChoice("gum", inventory);
				break;
			case '2':
				productChoice("chocolate", inventory);
				break;
			case '3':
				productChoice("juice", inventory);
				break;
			case '4':
				productChoice("popcorn", inventory);
				break;
			case '5':
				System.out.println();
				total(inventory);
				break;
			case '6':
				refill(inventory);
				break;
			case '7':
				left(inventory);
				break;
			case '8':
				break;
			default:
				System.out.println("Choice 1 - 8 ONLY");
			}
		} while (choice != '8');

		System.out.println("Good Bye !!!");
		
	}
	
	/**
	 * Method that switches choices for the product
	 * 
	 * @param productName - product of interest
	 * @param inventory - Map<productName, product>
	 */
	private void productChoice(String productName, ProductInventory inventory) {
		Product product = inventory.getProduct(productName);
		System.out.println("\nThe price of this item is " + pound + df.format(product.getPrice()));
		System.out.print("Please put your money : ");
		double moneyIn = keyboard.nextDouble();
		if (moneyIn < product.getPrice()) {
			System.out.println("Sorry not enough money");
		} else {
			if (product.getNumberItems() != 0) {
				System.out.println("Here's your " + product.getProductName());
				product.takeItem();
				System.out.println();
				if (moneyIn > product.getPrice())
					System.out.println("Please take your " + pound + df.format((moneyIn - product.getPrice())) + " change");
			} else {
				System.out.println();
				System.out.println("Product sold out");
				System.out.println("You'll recieve your money back\n" + pound + df.format(moneyIn));
				System.out.println();
			}
		}
	}
	
	/**
	 * Method that displays statistics for number of sold items
	 * and the total amount for each and everyone
	 * 
	 * @param inventory
	 */
	private void total(ProductInventory inventory) {		
		inventory.getInventory().forEach((name, product) -> {
			System.out.println(product.getSoldItems() + " items of " + name +" sold");
			System.out.println("Total amount of " + name +" sold : " + pound + df.format(product.getSoldTotal()));
			System.out.println();
		});
		System.out.println();
	}
	
	/**
	 * Method that show a menu for refilling the shelfs
	 * and switches between products to refill it
	 * 
	 * @param inventory
	 */
	private void refill(ProductInventory inventory) {
		sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Please choose which product to refill:");
		System.out.println("[1] gum");
		System.out.println("[2] chocolate");
		System.out.println("[3] juice");
		System.out.println("[4] popcorn");
		System.out.println();
		System.out.print("enter choice : ");
		char entry = sc.next().charAt(0);

		switch (entry) {
		case '1':
			doRefillShelf("gum", inventory);
			break;
		case '2':
			doRefillShelf("chocolate", inventory);
			break;
		case '3':
			doRefillShelf("juice", inventory);
			break;
		case '4':
			doRefillShelf("popcorn", inventory);
			break;
		}
	}
	
	/**
	 * Method that shows how many items were left and
	 * how many were added to the full shelf
	 * 
	 * @param productName
	 * @param inventory
	 */
	private void doRefillShelf(String productName, ProductInventory inventory) {
		Product product = inventory.getProduct(productName);
		System.out.println();
		System.out.println("There were " + product.getNumberItems() + " items left");
		System.out.println((10 - product.getNumberItems()) + " were added");
		product.setNumberItems(10);
	}
	
	/**
	 * Method that shows all left items by kind
	 * 
	 * @param inventory
	 */
	private void left(ProductInventory inventory) {
		System.out.println();
		inventory.getInventory().forEach((k, v) -> {
			System.out.println(v.getNumberItems() + " items of " + k +" left");
		});		
		System.out.println();
	}

}
