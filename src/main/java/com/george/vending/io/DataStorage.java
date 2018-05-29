package com.george.vending.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.george.vending.models.ProductInventory;

/**
 * 
 * @author Georgi Vasilski
 * @since 26.05.2018
 * @version 1.0
 *
 */
public class DataStorage {
	
	private static String pathToFile = "src/main/resources";
	private static String fileName = "inventory.dat";
	
	/**
	 * 
	 * @param inventory
	 * @param pathIn
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static void writeToFile(ProductInventory inventory, String pathIn) throws FileNotFoundException, ClassNotFoundException {
		String filePath = null;
		if(pathIn == null) {
			Path path = Paths.get(pathToFile).toAbsolutePath();
			filePath = path.resolve(fileName).toString();
		}else {
			filePath = pathIn;
		}
		try {
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(inventory);
			oos.close();
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param pathIn - path
	 * @return - productInventory
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public static ProductInventory readFromFile(String pathIn) throws ClassNotFoundException, FileNotFoundException {
		String filePath = null;
		if(pathIn == null) {
			Path path = Paths.get(pathToFile).toAbsolutePath();
			filePath = path.resolve(fileName).toString();
		}else {
			filePath = pathIn;
		}
		ProductInventory inventory = null;
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			ObjectInputStream ois = new ObjectInputStream(fis);
			inventory = (ProductInventory) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return inventory;
	}
	
	/**
	 * 
	 * @return - path to the storage file
	 */
	public static String checkStorageExists() {
		String storagePath;
		Path path = Paths.get(pathToFile).toAbsolutePath();
		if(Files.exists(path.resolve(fileName))) {
			storagePath = path.resolve(fileName).toString();
		}else {
			storagePath = null;
		}
		return storagePath;
	}

}
