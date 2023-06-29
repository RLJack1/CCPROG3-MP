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
    private String machineName;
    private boolean isSpecial;
	private int cashIn;
	private int userChoice;
	private int totalSales;
	private int lastTotalSales;
	private Item selectedItem;
	private ArrayList<Item> itemList;
	private ArrayList<Item> predefinedList;
	private ArrayList<Item> oldInventory;
	MoneyHandler mh = new MoneyHandler();
	ProductDisplay pDisplay = new ProductDisplay();
	ProductDispenser pDispenser = new ProductDispenser();
	
	/** 
	  * A constructor that creates a vending machine instance with null parameters
	  */
	public VendingMachine() {
		this.machineName = null;
		this.isSpecial = false;
		this.cashIn = 0;
		this.userChoice = 0;
		this.totalSales = 0;
		this.lastTotalSales = 0;
		this.selectedItem = null;
		itemList = new ArrayList<Item>();
		predefinedList = new ArrayList<Item>();
		oldInventory = new ArrayList<Item>();
	}
	
	/** 
	  * A constructor that creates a vending machine instance given its name and special status
	  */
	public VendingMachine(String machineName, boolean isSpecial) {
		this.machineName = machineName;
		this.isSpecial = isSpecial;
		this.cashIn = 0;
		this.userChoice = 0;
		this.totalSales = 0;
		this.lastTotalSales = 0;
		this.selectedItem = null;
		itemList = new ArrayList<Item>();
		predefinedList = new ArrayList<Item>();
		oldInventory = new ArrayList<Item>();
	}
	
	/** 
	  * Loads the previously saved vending machine data into the current program 
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
			int bills = 7;
			
			this.machineName = s.nextLine();
			this.isSpecial = Boolean.parseBoolean(s.nextLine());
			this.lastTotalSales = Integer.parseInt(s.nextLine());
			this.totalSales = Integer.parseInt(s.nextLine());

			/*while(bills > 0) {
				denomList[bills] = Integer.parseInt(s.nextLine());
				bills--;
			}*/
			
			while(s.hasNextLine()) {
				name = s.nextLine();
				calories = Double.parseDouble(s.nextLine());
				standalone = Boolean.parseBoolean(s.nextLine());				
				price = Integer.parseInt(s.nextLine());
				stock = Integer.parseInt(s.nextLine());
				
				itemList.add(new Item(name, calories, standalone, price, stock));
			}
			
			/*implement money save*/
			
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
		
		/*
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
        predefinedList.add(new Item("JackSauce", 10.0, false, 10, 8));*/
		return predefinedList;
    }
	
	/** 
	  * Saves all vending machine data into a file
	  */
	public void writeVMHistory() throws FileNotFoundException {
		BufferedWriter b = null;
		
		try {
			b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("VM-History.txt"), StandardCharsets.UTF_8));
		
			b.write(this.machineName + "\n");
			b.write(this.isSpecial + "\n");
			b.write(this.lastTotalSales + "\n");
			b.write(this.totalSales + "");

			/*int bills = 7
			while(bills > 0) {
				b.write("\n" + denomList.getBill(bills);
				bills--;
			}*/
			
			for(Item item : this.itemList) {
				b.write("\n" + item.getName() + "\n");
				b.write(item.getCalories() + "\n");
				b.write(item.getStandalone() + "\n");
				b.write(item.getPrice() + "\n");
				b.write(item.getStock() + "");
			}
			
			/*implement money save*/
			
			b.close();
		} catch(IOException e) {
			System.out.println("Oops! An error occurred.");
			e.printStackTrace();
		}
	}
	
	/** 
	  * Saves the details of one transaction into a file
	  * @param item		The item dispensed during the transaction
	  * @param cashIn	The amount of money the user paid during the transaction
	  */
	public void writeTransacHistory(String name, int qty) throws FileNotFoundException {
		BufferedWriter b = null;
		
		try {
			b = new BufferedWriter(new FileWriter(new File("Transac-History.txt"), true));
			b.write("\nname" + "\n");
			b.write(qty + "\n");
			b.write(this.lastTotalSales + "\n");
			b.write(this.totalSales + "");
			b.close();
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }	
	}

	/** 
	  * Saves the details of a restock into a file
	  * @param amountToAdd 	The amount of stock added to the item
	  * @param newStock 	The new total stock of the item for sale
	  */
	public void saveRestock() throws FileNotFoundException {
		BufferedWriter b = null;
		
		try {
			b = new BufferedWriter(new FileWriter(new File("Restock-History.txt")));
			
			for(Item item : this.oldInventory) {
				b.write(item.getName() + "\n");
				b.write(item.getStock()  + "\n");
			}
			
			b.write("---");
			
			for(Item item : this.itemList) {
				b.write(item.getName() + "\n");
				b.write(item.getStock()  + "\n");
			}
			
			b.close();
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }
	}
	
	/** 
	  * Displays all restock history details from the savefile
	  */
	public void printRestockHistory() throws FileNotFoundException {
		try {
			File f = new File("Restock-History.txt");
			Scanner s = new Scanner(f);
				
			String name = null;
			int qty = 0;
			int size = this.itemList.size();
			
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
			
			s.close();
			
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }
	}
	
	/** 
	  * Clears all data of a file, given its filename
	  * @param filename The name of the file to be cleared
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
	
	public void displayMenu(VendingMachine vm, Scanner s) throws FileNotFoundException {
		do {		
			
			if(this.itemList == null) {
				System.out.println("No Vending Machine history was found.");
			}
			
			System.out.print("==============================\n" +
						 "Welcome to The Founding Fathers' Vending Pantry!\n" + 
						 "(1) Build a Vending Machine\n" +
						 "(2) Test a Vending Machine\n" +
						 "(3) Leave and Exit\n" +
						 "Select: ");
			userChoice = s.nextInt();
			
			//Create VM
			if(userChoice == 1) {
				createMenu(s);
				System.out.println("Returning to Main Menu...");
			}
			
			//Test or Maintain
			else if(userChoice == 2) {
				do {
					System.out.print("==============================\n" +
								 "Vending Machine Features:\n" + 
								 "(1) Test Current Vending Machine Features\n" +
								 "(2) Perform Maintenance Features\n" +
								 "(3) Return to Main Menu\n" +
								 "Select: ");
					userChoice = s.nextInt();
					s.nextLine();
					
					//Test
					if(userChoice == 1) {
						testMenu(s);
						System.out.println("Transaction complete. Returning to Features Menu...");
					}
					
					//Maintain
					else if(userChoice == 2) {
						maintainMenu(s);
						System.out.println("Maintenance complete. Returning to Features Menu...");
					}
					
					//Return to main menu
					else if(userChoice == 3) {
						System.out.println("Returning to Main Menu...");
					}
					
					//Error catch
					else {
						System.out.println("Invalid input. Please try again.");
						userChoice = 0;
					}
					
				} while (userChoice != 3);
				
				userChoice = 0;
			}
			
			//Exit
			else if(userChoice == 3) {
				System.out.println("Thank you for coming!\n" + "Exiting program...");
				setLastTotalSales(getTotalSales());
			}
			
			//Error catch
			else {
				System.out.println("Invalid input. Please try again.");
				userChoice = 0;
			}
			
		} while(userChoice != 3);
	}

    public void createMenu(Scanner s) throws FileNotFoundException {
		char c = '\0';
		
		if(this.itemList != null) {
			System.out.print("Do you want to obliterate this Vending Machine and create a new one? Y/N\n" + "Input: ");
			c = s.next().charAt(0);
			c = Character.toLowerCase(c);
			s.nextLine();
		}
		
		else if(this.itemList == null) {
			c = 'y';
		}
		
		//For clearing
		if(c == 'y') {
			this.clearFile("VM-History.txt");
			this.clearFile("Transac-History.txt");
			this.clearFile("Restock-History.txt");
			this.clearItemList();
			this.setCashIn(0);
			this.setSelectedItem(null);
			
			System.out.println("Name your Vending Machine!\n" + "Input: ");
			String name = s.nextLine();
				
			System.out.print("\nGreat! Do you want " + name + " to be a Special Vending Machine? Y/N\n" + "Input: ");
			if(s.hasNextLine()) {
				c = s.next().charAt(0);
				c = Character.toLowerCase(c);
				s.nextLine();
			}
			
			boolean isSpecial = false;
			
			if(c == 'y') {
				isSpecial = true;
			}

			this.setMachineName(name);
			this.setIsSpecial(isSpecial);

			populateOptionsList(predefinedList); 

			itemList = pDisplay.populateItemList(predefinedList, s); 
			
			System.out.println("Alright! " + name + " is all set up!");
		}
		
		else if(c == 'n') 
			System.out.println("Canceling vending machine set up...");
	
    }

    public void testMenu(Scanner s) throws FileNotFoundException {
		boolean success = false;
		this.selectedItem = pDisplay.displayOnSale(itemList, s); 
		
		if(!(this.selectedItem == null)) {
			mh.inputDenominations(s);
			this.cashIn = mh.getCashIn();
			success = mh.payment(selectedItem, s);
			
			if(success) {
				pDispenser.printReceipt(this.selectedItem, this.cashIn, this.cashIn - this.selectedItem.getPrice());
				this.writeTransacHistory(this.selectedItem.getName(), 1);
				this.addTotalSales(this.selectedItem.getPrice());
			}
			
			else
				this.cashIn = 0;
		}
	}

    public void maintainMenu(Scanner s) throws FileNotFoundException {
		char c = '\0';
		
		do {
			System.out.print("==============================\n" +
							 "Maintenance Menu:\n" + 
							 "(1) Restock Items\n" +
							 "(2) Change Item Price\n" +
							 "(3) Take Out Money\n" +
							 "(4) Replenish Money\n" +
							 "(5) Print Transaction History\n" +
							 "(6) Print Restock History\n" +
							 "(7) Exit Maintenance Menu\n" +
							 "Select: ");
			
			if(s.hasNextInt()) {
				userChoice = s.nextInt();
				s.nextLine();
			}			
			
			if(userChoice == 1) {
				c = 'y';
				
				this.oldInventory.clear();
				this.oldInventory.addAll(this.itemList);
				
				System.out.println("Please select the item you would like to restock!");
				this.selectedItem = pDisplay.displayOnSale(itemList, s); 
				
				System.out.println("Input amount of stock to add: ");
				int amountToAdd = s.nextInt();
				boolean success = selectedItem.addStock(this.selectedItem, amountToAdd);
				
				if(success) {
					System.out.println("Restocking " + this.selectedItem.getName() + " ...");
					System.out.println("Restock success!");
				}
				
				else {
					System.out.println("Oops! Amount to add is too much.");
				}
				
				while(c == 'y') {
					c = '\0';
					System.out.print("Restock another item? Y/N\n" + "Input: ");
					
					if(s.hasNextLine()) {
						c = s.next().charAt(0);
						c = Character.toLowerCase(c);
						s.nextLine();
					}
					
					System.out.println("Please select the item you would like to restock!");
					this.selectedItem = pDisplay.displayOnSale(itemList, s); 
					
					System.out.println("Input amount of stock to add: ");
					amountToAdd = s.nextInt();
					success = selectedItem.addStock(this.selectedItem, amountToAdd);
					
					if(success) {
						System.out.println("Restocking " + this.selectedItem.getName() + " ...");
						System.out.println("Restock success!");
					}
					
					else {
						System.out.println("Oops! Amount to add is too much.");
					}
				}
				
				System.out.println("Saving restock inventories...");
				this.saveRestock();
				System.out.println("Returning to Maintenance Menu...");
			}
			
			else if(userChoice == 2) {
				System.out.println("Please select the item you would like to re-price!");
				this.selectedItem = pDisplay.userChoice(itemList, s);
				
				System.out.println("Input new price for " + this.selectedItem.getName() + ":");
				int newPrice = this.selectedItem.getPrice();
				
				if(s.hasNextInt())
					newPrice = s.nextInt();
				
				this.selectedItem.setPrice(newPrice);
				System.out.println("New price successfully set!");
			}
			
			else if(userChoice == 3) {
				System.out.print("Cash out all money? Or only specific bills?\n" +
								   "Type Y for cash out all money and\n" +
								   "Type N for cash out specific bills.\n" +
								   "Select: ");
				c = '\0';
				boolean success = false;
				
				if(s.hasNextLine()) {
					c = s.next().charAt(0);
					c = Character.toLowerCase(c);
					s.nextLine();
				}
				
				if(c == 'y') {
					int moneyTotal = mh.getTotal();
					mh.cashOut();
					System.out.println("Successfully cashed out " + moneyTotal + " pesos." + this.getMachineName() + " is now cash-empty.");
				}
				
				else {
					mh.displayDenomList();
					
					System.out.print("Which bill would you like to cash out?\n" + "Bill value: ");
					
					int bill = 0;
					int amount = 0;
					
					if(s.hasNextInt()) {
						bill = s.nextInt();
						s.nextLine();
					}
					
					System.out.print("How many " + bill + " bills would you like to take?\n" + "Amount: ");
					
					if(s.hasNextInt()) {
						amount = s.nextInt();
						s.nextLine();
					}
					
					success = mh.cashOne(bill, amount);
					
					if(success) {
						System.out.println("Cashing out " + amount + " " + bill + " bills...");
						System.out.println("Cash out success!");
					}
					
					else {
						System.out.println("Oops! Amount to cash out is too much.");
					}
				}
			}
			
			else if(userChoice == 4) {
				mh.displayDenomList();
					
				System.out.print("Which bill would you like to replenish?\n" + "Bill value: ");
				
				int bill = 0;
				int amount = 0;
				
				if(s.hasNextInt()) {
					bill = s.nextInt();
					s.nextLine();
				}
				
				System.out.print("How many " + bill + " bills would you like to add?\n" + "Amount: ");
				
				if(s.hasNextInt()) {
					amount = s.nextInt();
					s.nextLine();
				}
				
				mh.refillOne(bill, amount);
				System.out.println("Replenishing " + amount + " " + bill + " bills...");
				System.out.println("Replenish success!");
			}
			
			else if(userChoice == 5) {
				pDispenser.printTransacHistory();
			}
			
			else if(userChoice == 6) {
				this.printRestockHistory();
			}
			
			else if(userChoice == 7) {
				System.out.println("Returning to Features Menu...");
			}
			
			else {
				System.out.println("Invalid input. Please try again.");
				userChoice = 0;
			}
			
		} while(userChoice != 7);
					
		userChoice = 0;
    }

	public String getMachineName() {
		return this.machineName;
	}
	
	public boolean getIsSpecial() {
		return this.isSpecial;
	}
	
	public ArrayList<Item> getItemList() {
		return this.itemList;
	}
	
	public int getCashIn() {
		return this.cashIn;
	}
	
	public int getTotalSales() {
		return this.totalSales;
	}
	
	public int getLastTotalSales() {
		return this.lastTotalSales;
	}
	
	public Item getSelectedItem() {
		return this.selectedItem;
	}
	
	public void setMachineName(String newName) {
		this.machineName = newName;
	}
	
	public void setIsSpecial(boolean newIsSpecial) {
		this.isSpecial = newIsSpecial;
	}
	
	public void clearItemList() {
		this.itemList.clear();
	}
	
	public boolean addItem(Item item) {
		boolean result = false;
		
		if(this.itemList.add(item))
			result = true;
		
		return result;
	}
	
	public void setCashIn(int newCashIn) {
		this.cashIn = newCashIn;
	}
	
	public void addTotalSales(int amountToAdd) {
		this.totalSales += amountToAdd;
	}
	
	public void setLastTotalSales(int newAmount) {
		this.lastTotalSales = newAmount;
	}
	
	public void setSelectedItem(Item newSelectedItem) {
		this.selectedItem = newSelectedItem;
	}
}