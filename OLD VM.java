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

/** 
  * Contains all menu-calling and file management methods.
  * Is central to the operations and functionality of the whole vending machine program.
  */
public class VendingMachine {
 
	
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
	  * Loads item presets into the list of items passed in
	  * @param predefinedList	The destination of loaded items 
	  * @return The fully loaded list of items
	  */
	public ArrayList<Item> populateOptionsList(ArrayList<Item> predefinedList){
        predefinedList.add(new Item("BriocheBread", 346.0, true, 34, 8));
        predefinedList.add(new Item("SesameBread", 140.0, true, 20, 8));
        predefinedList.add(new Item("RyeBread", 259.0, true, 48, 8));
        predefinedList.add(new Item("WholewheatBread", 265.0, true, 40, 8));
        predefinedList.add(new Item("PotatoBread", 266.0, true, 33, 8));
        predefinedList.add(new Item("JackBread", 100.0, true, 100, 8));
        predefinedList.add(new Item("AngusBeef", 164.0, true, 144, 8));
        predefinedList.add(new Item("WagyuBeef", 250.0, true, 795, 8));
        predefinedList.add(new Item("TapaBeef", 187.75, true, 56, 8));
        predefinedList.add(new Item("CheesedBeef", 373.0, true, 214, 8));
        predefinedList.add(new Item("CanadianBacon", 185.0, true, 140, 8));
        predefinedList.add(new Item("WienerSchnitzel", 297.0, true, 175, 8));
        predefinedList.add(new Item("GrilledSalmon", 208.0, true, 300, 8));
        predefinedList.add(new Item("BronzeTurkey", 189.0, true, 185, 8));
        predefinedList.add(new Item("BeyondBeef", 210.0, true, 330, 8));
        predefinedList.add(new Item("JackBeef", 100.0, true, 100, 8));
		
        predefinedList.add(new Item("WhiteOnions", 40.0, false, 30, 8));
        predefinedList.add(new Item("OnionRings", 205.5, false, 85, 8));
        predefinedList.add(new Item("TrappistCheese", 355.0, false, 140, 8));
        predefinedList.add(new Item("MozzarelaCheese", 140.0, false, 75, 8));
        predefinedList.add(new Item("BlueCheese", 177.0, false, 105, 8));
        predefinedList.add(new Item("AmericanCheese", 177.0, false, 40, 8));
        predefinedList.add(new Item("MeltedButter", 307.5, false, 60, 8));
        predefinedList.add(new Item("BeefsteakTomato", 18.0, false, 50, 8));
        predefinedList.add(new Item("IcebergLettuce", 3.0, false, 45, 8));
        predefinedList.add(new Item("DillPickles", 11.0, false, 45, 8));
        predefinedList.add(new Item("HotSauce", 11.0, false, 50, 8));
        predefinedList.add(new Item("BarbequeSauce", 172.0, false, 70, 8));
        predefinedList.add(new Item("CaviarSauce", 252.0, false, 330, 8));
        predefinedList.add(new Item("JackSauce", 10.0, false, 10, 8));
		
		return predefinedList;
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
	
	/** 
	  * Displays all predefined items and returns the user's selected input. 
	  * Called at Vending Machine creation.
	  * @param predefinedItems	The list of all predefined items
	  * @param s 				The active scanner object
	  * @return The ArrayList of item objects added by the user 
	  */
    public ArrayList<Item> populateItemList(ArrayList<Item> predefinedItems, Scanner s) {
        ArrayList<Item> userItemList = new ArrayList<Item>();
        int input = 0;
        int index = 0;

		//displays the predefined items
        for (Item item : predefinedItems) {
			if((item.getName().length() >= 12 && index > 9) || item.getName().length() >= 13) {
				System.out.println("\t\t\t" + (index + 1) + ": " + item.getName() + "\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
			}
			
			else {
				System.out.println("\t\t\t" + (index + 1) + ": " + item.getName() + "\t\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
			}
            
            index++;
        }

		//repeatedly takes in user input, error checks, and adds items
        do {
            System.out.print("Input the index of the item or type \"99\" to exit: ");
            input = s.nextInt();

            if (input == 99 || userItemList.size() == 12) {
                if(userItemList.size() < 8)
					System.out.println("Oops! You need a minimum of 8 items to initialize a Vending Machine.\n" + "You currently have " + userItemList.size() + ".");
				
				else {
					if(userItemList.size() == 12)
						System.out.println("Item capacity of 12 reached.");
					
					break;
				}
					
            }

            else if (input > 0 && input <= predefinedItems.size()) {
                Item selected = predefinedItems.get(input - 1);
                if (userItemList.contains(selected)) {
                    System.out.println(selected.getName() + " is already in the list.");
                } 
				
				else {
                    userItemList.add(selected);
                    System.out.println(selected.getName() + " successfully added!");
                }
            } 
			
			else {
                System.out.println("Invalid input. Please try again.");
            }
			
        } while (true);

        return userItemList;
    }		

	/** 
	  * Displays all items on sale and returns the user's selected input
	  * @param itemList	The list of all items on sale
	  * @param s 		The active scanner object
	  * @return The object instance of the user's selected item 
	  */
    public Item displayOnSale(ArrayList<Item> itemList, Scanner s){
        System.out.println("Items on Sale:\tName\t\t Calories\tPrice\tstock");
        Item toBuy = new Item(null, 0, false, 0, 0);
        boolean done = false;
		int index = 0;
		int input = 99;
		int avail = 1;
        
		//display items 
        for(Item item : itemList) 
        {	
			if(item.getStock() != 0 && ((item.getName().length() >= 12 && index > 9) || item.getName().length() >= 13)) {
				System.out.println("\t\t" + (index + 1) + ": " + item.getName() + "\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
			}
			
			else if (item.getStock() != 0) {
				System.out.println("\t\t" + (index + 1) + ": " + item.getName() + "\t\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
			}
            
			else
                System.out.println("\t\t" + (index + 1) + ": " + item.getName() + " is SOLD OUT.");
			
            index++;
        }
		
		//take input 
		do {
            System.out.print("Input the index of the item: ");
            input = s.nextInt();
			input -= 1;
			toBuy = itemList.get(input);
			avail = toBuy.getStock();
			
            if(input >= 0 && input <= itemList.size() && avail > 0) {
				toBuy = itemList.get(input);
				System.out.println("Successfully selected " + toBuy.getName() + "!\n");
				done = true;
			}
			
			else {
				System.out.println("Invalid input. Please try again.\n");
			}
			
        } while (done == false);

		return toBuy;
    }
	
	/** 
      * Increases the item's current stock by an amount and returns its success
	  * @param item			The item object to add stock to
	  * @param amountToAdd	The amount of stock to be added
	  * @return Whether the program successfully added the stock
      */
    public boolean addStock(Item item, int amountToAdd){
        if (this.stock + amountToAdd > 10)
            return false;
        else
        {
            this.stock += amountToAdd;
            return true;
        }
    }

	/** 
      * Reduces the item's current stock by an amount and returns its success
	  * @param item				The item object to remove stock from
	  * @param amountToMinus	The amount of stock to be subtracted
	  * @return Whether the program successfully reduced the stock
      */
    public boolean minusStock(Item item, int amountToMinus) {
        if (this.stock - amountToMinus < 0)
            return false;
        else
        {
            this.stock -= amountToMinus;
            return true;
        }
    }

	/** 
      * Gets and returns the name of this Vending Machine
	  * @return The machine's name
      */
	public String getName() {
		return this.machineName;
	}
	
	/** 
      * Gets and returns the special status of this Vending Machine
	  * @return The special status
      */
	public boolean getIsSpecial() {
		return this.isSpecial;
	}
	
	/** 
      * Gets and returns the list of items on sale for this Vending Machine
	  * @return The ArrayList of item objects for sale
      */
	public ArrayList<Item> getItemList() {
		return this.itemList;
	}
	
	/** 
      * Gets and returns the amount of inputted user cash bring held by this Vending Machine
	  * @return The amount of cash
      */
	public int getCashIn() {
		return this.cashIn;
	}
	
	/** 
      * Gets and returns the current total sales from the last restocking
	  * @return The current total sales
      */
	public int getTotalSales() {
		return this.totalSales;
	}
	
	/** 
      * Gets and returns the last saved total sales from the last restocking
	  * @return The last saved total sales
      */
	public int getLastTotalSales() {
		return this.lastTotalSales;
	}
	
	/** 
      * Gets and returns the currently selected item by the user
	  * @return The selected item object
      */
	public Item getSelectedItem() {
		return this.selectedItem;
	}
	
	/** 
      * Changes the Vending Machine's name to a new one
	  * @param newName The new name of this VendingMachine object
      */
	public void setMachineName(String newName) {
		this.machineName = newName;
	}
	
	/** 
      * Changes the Vending Machine's special status
	  * @param newIsSpecial The new special status of this VendingMachine object
      */
	public void setIsSpecial(boolean newIsSpecial) {
		this.isSpecial = newIsSpecial;
	}
	
	/** 
      * Clears all item objects for sale
      */
	public void clearItemList() {
		this.itemList.clear();
	}
	
	/** 
      * Adds an item to the list of items on sale
	  * @param item The item object to be added
	  * @return Whether the item was successfully added
      */
	public boolean addItem(Item item) {
		boolean result = false;
		
		if(this.itemList.add(item))
			result = true;
		
		return result;
	}
	
	/** 
      * Changes the amount of user money held to a new value
	  * @param newCashIn The new amount of user money being held
      */
	public void setCashIn(int newCashIn) {
		this.cashIn = newCashIn;
	}
	
	/** 
      * Increases the total sales since last restock by the specified amount
	  * @param amountToAdd The amount by which the total sales will increase
      */
	public void addTotalSales(int amountToAdd) {
		this.totalSales += amountToAdd;
	}
	
	/** 
      * Changes the value of the last saved total sales to a new value
	  * @param newAmount The new amount of last saved total sales
      */
	public void setLastTotalSales(int newAmount) {
		this.lastTotalSales = newAmount;
	}
	
	/** 
      * Sets the currently selected item to a different item object
	  * @param newSelectedItem The new item the user selected
      */
	public void setSelectedItem(Item newSelectedItem) {
		this.selectedItem = newSelectedItem;
	}
}