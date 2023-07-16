/*MAIN TASKS: clear files (done)
 *			: load files
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;

public class FileHandler {
	public FileHandler() {
	}
	
	/** 
	  * Clears all data of a file, given its filename
	  * @param filename The name of the file to be cleared
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
	public void clearFile(String filename) throws FileNotFoundException {
        try {
			PrintWriter p = new PrintWriter(filename);
            p.close();
			System.out.println("File cleared: " + filename);
        } catch (IOException e) {
			System.out.println("Error clearing: " + filename);
            e.printStackTrace();
        }
	}
	
		/** 
	  * Loads the previously saved vending machine data into the current program 
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
	public void populateVMHistory() throws FileNotFoundException {
		try {
			File f = new File("VM-History.txt");
			Scanner s = new Scanner(f);
			double calories = 0;
			boolean standalone = false;
			int price = 0;
			int stock = 0;
			String name;
			int billIndex = 0;
			int amount = 0;
			
			while(s.hasNextLine()) {
				this.machineName = s.nextLine();
				this.isSpecial = Boolean.parseBoolean(s.nextLine());
				this.lastTotalSales = Integer.parseInt(s.nextLine());
				this.totalSales = Integer.parseInt(s.nextLine());

				while(billIndex < 8) {
					amount = Integer.parseInt(s.nextLine());
					mh.setCashBox(billIndex, amount);
					billIndex++;
				}
				
				while(s.hasNextLine()) {
					name = s.nextLine();
					calories = Double.parseDouble(s.nextLine());
					standalone = Boolean.parseBoolean(s.nextLine());				
					price = Integer.parseInt(s.nextLine());
					stock = Integer.parseInt(s.nextLine());
					
					itemList.add(new Item(name, calories, standalone, price, stock));
				}		
			}
			
			s.close();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	  * Saves all vending machine data into a file
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
	public void writeVMHistory() throws FileNotFoundException {
		BufferedWriter b = null;
		
		try {
			b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("VM-History.txt"), StandardCharsets.UTF_8));
		
			b.write(this.machineName + "\n");
			b.write(this.isSpecial + "\n");
			b.write(this.lastTotalSales + "\n");
			b.write(this.totalSales + "");

			int billIndex= 0;
			while(billIndex < 8) {
				b.write("\n" + mh.getCashBoxAmount(billIndex));
				billIndex++;
			}
			
			for(Item item : this.itemList) {
				b.write("\n" + item.getName() + "\n");
				b.write(item.getCalories() + "\n");
				b.write(item.getStandalone() + "\n");
				b.write(item.getPrice() + "\n");
				b.write(item.getStock() + "");
			}
			
			b.close();
		} catch(IOException e) {
			System.out.println("Oops! An error occurred.");
			e.printStackTrace();
		}
	}
	
	/** 
	  * Saves the details of one transaction into a file
	  * @param name		The name of the item dispensed
	  * @param qty		The number of times the item was dispensed
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
	public void writeTransacHistory(String name, int qty) throws FileNotFoundException {
		BufferedWriter b = null;
		
		try {
			b = new BufferedWriter(new FileWriter(new File("Transac-History.txt"), true));
			b.write(name + "\n");
			b.write(qty + "\n");
			b.write(this.lastTotalSales + "\n");
			b.write(this.totalSales + "\n");
			b.close();
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }	
	}

	/** 
	  * Saves the details of one restock into a file
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
	public void saveRestock() throws FileNotFoundException {
		BufferedWriter b = null;
		
		try {
			b = new BufferedWriter(new FileWriter(new File("Restock-History.txt")));
			
			for(Item start : this.oldInventory) {
				b.write(start.getName() + "\n");
				b.write(start.getStock()  + "\n");
			}
			
			b.write("---\n");
			
			for(Item end : this.itemList) {
				b.write(end.getName() + "\n");
				b.write(end.getStock()  + "\n");
			}
			
			b.close();
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }
	}
	
	/** 
	  * Displays all restock history details from the savefile
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
	public void printRestockHistory() throws FileNotFoundException {
		try {
			File f = new File("Restock-History.txt");
			Scanner s = new Scanner(f);
				
			String name = null;
			int qty = 0;
			int size = this.itemList.size();
			
			while(s.hasNextLine()) {
				System.out.println("==============STARTING INVENTORY===============" +
								   "\nItem Name\t\tQuantity");
				
				while(size > 0) {
					name = s.nextLine();
					qty = Integer.parseInt(s.nextLine());
					System.out.println(name + "\t\t" + qty + "\n");
					size--;
				}
				
				s.nextLine();
				
				System.out.println("===============ENDING INVENTORY================" +
								   "\nItem Name\t\tQuantity");
				
				while(s.hasNextLine()) {
					name = s.nextLine();
					qty = Integer.parseInt(s.nextLine());
					System.out.println(name + "\t\t" + qty + "\n");
				}	
			}
			
			s.close();
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }
	}
	
	/** 
	  * Narrates dispensing of the item and subtracts its stock by 1
	  * @param isSpecial 	Whether the vending machine is a special vending machine
	  * @param selectedItem	The item to be dispensed
	  */
	public void releaseItem(boolean isSpecial, Item selectedItem) {
		if(!isSpecial) {
			boolean result = selectedItem.minusStock(selectedItem, 1);
			
			if(result) 
				System.out.println("Dispensing " + selectedItem.getName() + "...");
			
			else
				System.out.println("Oops! An error occurred.");
		}
	}
	
	/** 
	  * Displays all details of the transaction that just occurred
	  * @param selectedItem	The item that was sold
	  * @param cashIn		The total amount of money inputted by the user
	  * @param change		The amount of change given in the transaction
	  */
	public void printReceipt(Item selectedItem, int cashIn, int change) {
		System.out.println("============RECEIPT===========" +
						 "\nPurchased Item: " + selectedItem.getName() +
						 "\nTotal Calories: " + selectedItem.getCalories() +
						 "\nItem Price: " + selectedItem.getPrice() +
						 "\nAmount Paid: " + cashIn +
						 "\nIssued Change: " + change);
	}
	
	/** 
	  * Displays all details of all previous transactions on this vending machine
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
	public void printTransacHistory() throws FileNotFoundException {
		try {
			File f = new File("Transac-History.txt");
			Scanner s = new Scanner(f);
			
			String name = null;
			int qty = 1;
			int lastTotalSales = 0;
			int totalSales = 0;
			int count = 1;
			
			while(s.hasNextLine()) {
				name = s.nextLine();
				qty = Integer.parseInt(s.nextLine());
				lastTotalSales = Integer.parseInt(s.nextLine());
				totalSales = Integer.parseInt(s.nextLine());
				
				System.out.println("================TRANSACTION#" + count + "=================" +
								   "\nPurchased Item:\t\t\t" + name + 
								   "\nQty:\t\t\t\t" + qty +
								   "\nTotal Sales At Last Restock:\t" + lastTotalSales +
								   "\nCurrent Total Sales:\t\t" + totalSales + "\n");
				
				count++;
			}
			
			s.close();
		} catch (IOException e) {
		System.out.println("Oops! An error occurred.");
		e.printStackTrace();
		}
	}
}