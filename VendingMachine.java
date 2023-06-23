/* TODO
 * make class initialization more cohesive
 * address comments
 * fill out ProductDispenser
 * fill out Transaction
 * create and fill out Restock
 * recheck scanner printwriter file closing
 * double check getters and setters
 * double check functionality w renzos code
 * rigorously test and debug
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class VendingMachine {
    private String machineName;
    private boolean isSpecial;
	private int cashIn;
	private int totalSales;
	private int lastTotalSales;
	private Item selectedItem;
	private ArrayList<Item> itemList;
	private ArrayList<Item> restockList;
	private ArrayList<Transaction> transacList;
	
	public VendingMachine() {
		this.machineName = null;
		this.isSpecial = false;
		this.cashIn = 0;
		this.totalSales = 0;
		this.lastTotalSales = 0;
		this.selectedItem = null;
		itemList = new ArrayList<Item>();
		restockList = new ArrayList<Item>();
		transacList = new ArrayList<Transaction>();
	}
	
	//@megan added the following as part of the machine because the constructor below doesn't recognize the assigning of classes without it.
	MoneyHandler mh;
	ProductDisplay pDisplay;
	ProductDispenser pDispenser;
	
	public VendingMachine(String machineName, boolean isSpecial) {
		this.machineName = machineName;
		this.isSpecial = isSpecial;
		this.cashIn = 0;
		this.totalSales = 0;
		this.lastTotalSales = 0;
		this.selectedItem = null;
		itemList = new ArrayList<Item>();
		restockList = new ArrayList<Item>();
		transacList = new ArrayList<Transaction>();
	}
	
	public void populateVMHistory() {
		File f = new File("VM-History.txt");
		Scanner s = new Scanner(f);
		
		this.machineName = s.nextLine();
		this.isSpecial = (boolean) s.nextLine();
		this.lastTotalSales = (int) s.nextLine();
		this.totalSales = (int) s.nextLine();
		s.nextLine();
		
		while(s.hasNextLine()) {
			String name = s.nextLine();
			double calories = (double) s.nextLine();
			boolean standalone = (boolean) s.nextLine();
			int price = (int) s.nextLine();
			int stock = (int) s.nextLine();
			s.nextLine();
			
			itemList.add(new Item(name, calories, isSpecial, standalone, price, stock));
		}
		
		s.close();
		/*close file*/
	}
	
	public void populateTransacHistory() {
		File f = new File("Transac-History.txt");
		Scanner s = new Scanner(f);
		
		while(s.hasNextLine()) {
			String name = s.nextLine();
			double calories = (double) s.nextLine();
			int price = (int) s.nextLine();
			int cashIn = (int) s.nextLine();
			int change = cashIn - price;
			s.nextLine();
			
			transacList.add(new Transaction(name, calories, price, cashIn, change));
		}
		
		s.close();
		/*close file*/
	}
	
	public void populateRestockHistory() {
		File f = new File("Restock-History.txt");
		Scanner s = new Scanner(f);
		
		/*
		this.machineName = s.nextLine();
		this.isSpecial = (boolean) s.nextLine();
		this.lastTotalSales = (int) s.nextLine();
		this.totalSales = (int) s.nextLine();
		s.nextLine();
		
		while(s.hasNextLine()) {
			String name = s.nextLine();
			double calories = (double) s.nextLine();
			boolean standalone = (boolean) s.nextLine();
			int price = (int) s.nextLine();
			int stock = (int) s.nextLine();
			s.nextLine();
			
			itemList.add(new Item(name, calories, isSpecial, standalone, price, stock));
		} */
		
		s.close();
		/*close file*/
	}
	
	public void writeVMHistory() {
		PrintWriter p = new PrintWriter("VM-History.txt");
		
		p.println(this.machineName);
		p.println(this.isSpecial);
		p.println(this.lastTotalSales);
		p.println(this.totalSales);
		p.println();
		
		for(Item item : itemList) {
			p.println(item.getName());
			p.println(item.getCalories());
			p.println(item.getStandalone());
			p.println(item.getPrice());
			p.println(item.getStock());
			p.println();
		}
		
		p.flush();
		p.close();
	}
	
	public void writeTransacHistory(Item item, int cashIn, int change) {
		PrintWriter p = new PrintWriter("Transac-History.txt");

		p.println(item.getName());
		p.println(item.getCalories());
		p.println(item.getPrice());
		p.println(cashIn);
		p.println(change);
		p.println();
		
		p.flush();
		p.close();
	}
	
	public void writeRestockHistory(ArrayList<Item> restockList, ArrayList<Item> itemList) {
		/*implement way to know restock# */
		int restockNum = 0;
		
		PrintWriter p = new PrintWriter("Restock-History.txt");
		
		p.println(restockNum + "\n");
		
		for(Item item : itemList) {
			for(Item refilled : restockList) {
				if(refilled.getName().equals(item.getName())) 
					p.println(item.getName());
					p.println(item.getStock());
					p.println(refilled.getStock());
					//p.println(item.getSold());
					p.println(refilled.getStock() - item.getStock());
					p.println();
			}
		}
		
		p.println(this.totalSales);
		p.println(this.totalSales - this.lastTotalSales);
		p.println("\n---\n");
		
		p.flush();
		p.close();
	}
    
	public void displayMenu(VendingMachine vm) {
		int userChoice = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Welcome to The Founding Fathers' Vending Pantry!\n" + 
							 "(1) Build a Vending Machine\n" +
							 "(2) Test a Vending Machine\n" +
							 "(3) Leave and Exit" +
							 "Select: ");
			userChoice = Integer.parseInt(input.nextLine());

			
			//@megan VSC prompted me to add the following code after implementing the file solution, still not sure if valid.
			//Create VM

			//@megan, if else could be switch case instead.
			if(userChoice == 1) {
				try {
					createMenu();
				} catch (FileNotFoundException e) {
					System.out.println("Oops! An error occurred.");
					e.printStackTrace();
				}
			}
			
			//Test or Maintain
			else if(userChoice == 2) {
				do {
					System.out.print("==============================" +
								 "Vending Machine Features:\n" + 
								 "(1) Test Current Vending Machine Features\n" +
								 "(2) Perform Maintenance Features\n" +
								 "(3) Return to Main Menu" +
								 "Select: ");
					userChoice = input.nextInt();
					
					//Test
					if(userChoice == 1) {
						testMenu();
						System.out.println("Transaction complete. Returning to Features Menu...");
					}
					
					//Maintain
					else if(userChoice == 2) {
						maintainMenu();
						System.out.println("Maintenance complete. Returning to Features Menu...");
					}
					
					//Return to main menu
					else if(userChoice == 3) {
						System.out.println("Returning to Main Menu...");
						System.out.println("==============================");
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
				System.out.println("Thank you for coming!\n" +
								   "Exiting program...");
			}
			
			//Error catch
			else {
				System.out.println("Invalid input. Please try again.");
				System.out.println("==============================");
				userChoice = 0;
			}
			
		} while(userChoice != 3);
		
		input.close();
	}

    public void createMenu() throws FileNotFoundException {
        System.out.println("Do you want to obliterate this Vending Machine and create a new one?\n" + "Y/N");
		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		c = Character.toLowerCase(c);
		s.nextLine();
		
		//For clearing
		if(c == 'y') {
			clearFile("vmHistory.txt");

			this.clearItemList();
			this.setCashIn(0);
			this.setSelectedItem(null);
			
			System.out.println("Name your Vending Machine: ");
			String name = s.nextLine();
			System.out.println("Great! Do you want " + name + " to be a Special Vending Machine?" +
							   "Y/N: ");
			c = s.next().charAt(0);
			c = Character.toLowerCase(c);
			s.nextLine();
			
			boolean isSpecial = false;
			
			if(c == 'y')
				isSpecial = true;
				
			this.setMachineName(name);
			this.setIsSpecial(isSpecial);

			/*Initialization of items, call pDisplay.methods()*/
			this.itemList.add(new Item("Brioche Buns", 346.0, true, 24, 8, 0));
			this.itemList.add(new Item("Sesame Buns", 140.0, true, 9, 8, 0));
			this.itemList.add(new Item("Angus Beef", 164.0, true, 144, 8, 0));
			this.itemList.add(new Item("Wagyu Beef", 250.0, true, 795, 8, 0));

			this.itemList.add(new Item("White Onions", 40.0, false, 86, 8, 0));
			this.itemList.add(new Item("Melted Butter", 717.0, false, 86, 8, 0));
			this.itemList.add(new Item("Beefsteak Tomato", 18.0, false, 50, 8, 0));
			this.itemList.add(new Item("Iceberg Lettuce", 3.0, false, 44, 8, 0));
		}
		
		s.close();
    }

    public void testMenu() {
		/*@renzo call pDisplay.displayOnSale()
		  @renzo this.selectedItem = pDisplay.userChoice(); */
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please put money into the Vending Machine: ");
		this.cashIn = s.nextInt();
		
		System.out.println("Proceed with transaction? Type Y to proceed and N to cancel.\n" + "Y/N: ");
		char c = s.next().charAt(0);
		c = Character.toLowerCase(c);
		s.nextLine();
		
		if(c == 'y') {
			pDispenser.releaseItem(this.isSpecial, this.selectedItem);
			System.out.println("Calculating change...");
		 	int price = selectedItem.getPrice();
		// 	boolean enough = mh.checkEnoughChange(this.cashIn, price);
			
		// 	if(enough) {
		// 		mh.change(this.cashIn, price);
		// 		pDispenser.printReceipt(this.selectedItem, this.cashIn, this.cashIn - price);
		// 	}
			
		// 	else {
		// 		System.out.println("Sorry! This Vending Machine doesn't have enough change to dispense :((");
		// 	}
		// }
		
		// else {
		// 	System.out.println("Canceling order...");
		// 	System.out.println("Returning money...");
		// 	mh.change(this.cashIn, 0);

		//@megan i believe i've created a method that does all of the above processes, but I'm still not sure how the printReciept would add up.
			mh.checkChange(this.cashIn, price);
		}
		
		s.close();
		
		/* display all items and ask for an item number including input validation to see if there's stock, 
		input money amount or cancel, 
		dispense product with 1 line narration and update stock and add to transac history, 
		dispense product with 1 line narration, 
		give change and update money, 
		display receipt and calories
		*/
    }

    public void maintainMenu() {
		Scanner s = new Scanner(System.in);
		int userChoice = 0;
		
		do {
			System.out.print("==============================" +
							 "Maintenance Menu:\n" + 
							 "(1) Restock Items\n" +
							 "(2) Change Item Price\n" +
							 "(3) Take Out Money\n" +
							 "(4) Replenish Money\n" +
							 "(5) Print Transaction History\n" +
							 "(6) Exit Maintenance Menu\n" +
							 "Select: ");
			userChoice = s.nextInt();
			
			if(userChoice == 1) {
				System.out.println("Please select the item you would like to restock!");
				/*@renzo this.selectedItem = pDisplay.userChoice();
				  contemplating having a minimalist productdisplay for this part idk*/
				
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
			}
			
			else if(userChoice == 2) {
				System.out.println("Please select the item you would like to restock!");
				/*@renzo this.selectedItem = pDisplay.userChoice();
				  contemplating having a minimalist productdisplay for this part idk*/
				
				System.out.println("Input new price for " + this.selectedItem.getName() + ":");
				int newPrice = s.nextInt(); // @megan set newPrice and the scanner into int.
				this.selectedItem.setPrice(newPrice);
				System.out.println("New price successfully set!");
			}
			
			else if(userChoice == 3) {
				System.out.println("Cash out all money? Or only specific bills?\n" +
								   "Type Y for cash out all money and\n" +
								   "Type N for cash out specific bills.\n" +
								   "Select: ");
				char c = s.next().charAt(0);
				c = Character.toLowerCase(c);
				s.nextLine();
				
				if(c == 'y') {
					int moneyTotal = mh.getTotal();
					mh.cashOut();
					System.out.println("Successfully cashed out " + moneyTotal + "pesos." + this.getMachineName() + " is now cash-empty.");
				}
				
				else {
					mh.displayDenomList(); //@megan I assume this function will print the denominations and how much are stored
					
					System.out.println("Which bill would you like to cash out?\n" +
									   "Bill value: ");
					int bill = s.nextInt();
					int index = mh.getIndex(bill);
					System.out.println("How many " + bill + "bills would you like to take?\n" +
									   "Amount: ");
					int amount = s.nextInt();
					
					boolean success = mh.cashOne(index, amount) == 0; // added the boolean check (== 0)
					
					if(success) {
						System.out.println("Cashing out " + amount + " " + bill + "bills...");
						System.out.println("Cash out success!");
					}
					
					else {
						System.out.println("Oops! Amount to cash out is too much.");
					}
				}
			}
			
			else if(userChoice == 4) {
				mh.displayDenomList(); //@megan I assume this function will print the denominations and how much are stored
					
				System.out.println("Which bill would you like to replenish?\n" +
								   "Bill value: ");
				int bill = s.nextInt();
				int index = mh.getIndex(bill);
				System.out.println("How many " + bill + "bills would you like to add?\n" +
								   "Amount: ");
				int amount = s.nextInt();
				
				mh.refillOne(index, amount);
				System.out.println("Replenishing " + amount + " " + bill + "bills...");
				System.out.println("Replenish success!");
			}
			
			else if(userChoice == 5) {
				/*call pDispenser.printTransacHistory()*/
			}
			
			else if(userChoice == 6) {
				System.out.println("Returning to Features Menu...");
				System.out.println("==============================");
			}
			
			else {
				System.out.println("Invalid input. Please try again.");
				System.out.println("==============================");
				userChoice = 0;
			}
			
		} while(userChoice != 6);
					
		userChoice = 0;
		s.close();
		
		/* restock (pick item number, pick qty to add, display feedback message), 
		take money out (ask how much, update money, add to money out history), 
		change item details (pick item number, pick what to change, input changed, validate, display feedback msg)
		*/
		
    }

	/*  Method to save current vending machine's attributes in a text file. Attributes include:
	 *  VM name, Regular or Not, items in itemList along with their attributes*/
	public void saveToFile(String filename){ 
		try {
			File file = new File(filename);
			PrintWriter writer = new PrintWriter(file);

			writer.println(machineName);
			writer.println(isSpecial);

			/*think through*/
			for (Item item : itemList) {
				writer.println(item.getName());
				writer.println(item.getCalories());
				writer.println(item.getStandalone());
				writer.println(item.getPrice());
				writer.println(item.getStock());
				writer.println("\n");
			}

			writer.flush();
			writer.close();
			System.out.println("Vending Machine saved to file: " + filename);

		} catch (FileNotFoundException e) {
			System.out.println("Error saving Vending Machine to file: " + filename);
			e.printStackTrace();
		}
	}

	// Method essentially takes the file (vmHistory.txt), creates another a new file with no content, and replaces that with the original.
	public void clearFile(String filename) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
		writer.flush();
        writer.close();
        System.out.println("File cleared: " + filename);
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
	
	public void setSelectedItem(Item newSelectedItem) {
		this.selectedItem = newSelectedItem;
	}
	
	public static void main(String[] args) {
		VendingMachine vm = null;
		boolean exists = false;
		File vmHistory = new File("VM-History.txt");
		
		try {
			if(vmHistory.createNewFile())
				System.out.println("No previous Vending Machine exists yet.");
				
			else {
				exists = true;
				System.out.println("A previous Vending Machine already exists.");
			}
				
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
			e.printStackTrace();
		}
		
		if(exists == true) {
			System.out.println("Loading Vending Machine history...");
			
			try {
				Scanner s = new Scanner(vmHistory);
				ArrayList<String> history = new ArrayList<>();
			
				while(s.hasNextLine()) {
				String line = s.nextLine();
				history.add(line);
				}
				
				s.close();
			
				VendingMachine vm = new VendingMachine();
				MoneyHandler mh = new MoneyHandler();
				ProductDisplay pDisplay = new ProductDisplay();
				ProductDispenser pDispenser = new ProductDispenser();
			
				System.out.println("Done!");
			} catch (FileNotFoundException e) {
				System.out.println("Oops! An error occurred.");
				e.printStackTrace();
			}
			
		}
		
		else {
			Scanner s = new Scanner(System.in);
			System.out.println("Let's initialize a Vending Machine first.\n" +
							   "Name your Vending Machine: ");
			String name = s.nextLine();
			System.out.println("Great! Do you want " + name + " to be a Special Vending Machine?" +
							   "Y/N: ");
			char c = s.next().charAt(0);
			c = Character.toLowerCase(c);
			s.nextLine();
			
			boolean isSpecial = false;
			
			if(c == 'y')
				isSpecial = true;
				
			vm = new VendingMachine(name, isSpecial);
			MoneyHandler mh = new MoneyHandler();
			ProductDisplay pDisplay = new ProductDisplay();
			ProductDispenser pDispenser = new ProductDispenser();
			
			s.close();
		}
		
		vm.displayMenu(vm); 
		/*to investigate*/
		vm.clearFile("VM-History.txt"); // "Unhandled exception type FileNotFoundException" message according to VSC.
		vm.saveToFile("VM-History.txt");
	}
}