import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class VendingMachine {
    private String machineName;
    private boolean isSpecial;
    private ArrayList<Item> itemList;
	private int cashIn;
	private Item selectedItem;
	
	public VendingMachine(String machineName, boolean isSpecial) {
		this.machineName = machineName;
		this.isSpecial = isSpecial;
		this.cashIn = 0;
		this.selectedItem = null;
		itemList = new ArrayList<Item>();
		
		MoneyHandler mh = new MoneyHandler();
		ProductDisplay pDisplay = new ProductDisplay();
		ProductDispenser pDispenser = new ProductDispenser();
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
			userChoice = input.nextInt();
			
			//Create VM
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
		Character.toLowerCase(c);
		
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
			Character.toLowerCase(c);
			
			boolean isSpecial = false;
			
			if(c == 'y')
				isSpecial = true;
				
			this.setMachineName(name);
			this.setIsSpecial(isSpecial);

			/*Initialization of items, call pDisplay.methods()*/
			this.itemList.add(new Item("Brioche Buns", 346.0, true, 24, 8));
			this.itemList.add(new Item("Sesame Buns", 140.0, true, 9, 8));
			this.itemList.add(new Item("Angus Beef", 164.0, true, 144, 8));
			this.itemList.add(new Item("Wagyu Beef", 250.0, true, 795, 8));

			this.itemList.add(new Item("White Onions", 40.0, false, 86, 8));
			this.itemList.add(new Item("Melted Butter", 717.0, false, 86, 8));
			this.itemList.add(new Item("Beefsteak Tomato", 18.0, false, 50, 8));
			this.itemList.add(new Item("Iceberg Lettuce", 3.0, false, 44, 8));
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
		Character.toLowerCase(c);
		
		if(c == 'y') {
			pDispenser.releaseItem(this.isSpecial, this.selectedItem);
			System.out.println("Calculating change...");
			int price = selectedItem.getPrice();
			boolean enough = mh.checkEnoughChange(this.cashIn, price);
			
			if(enough) {
				mh.change(this.cashIn, price);
				pDispenser.printReceipt(this.selectedItem, this.cashIn, this.cashIn - price);
			}
			
			else {
				System.out.println("Sorry! This Vending Machine doesn't have enough change to dispense :((");
			}
		}
		
		else {
			System.out.println("Canceling order...");
			System.out.println("Returning money...");
			mh.change(this.cashIn, 0);
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
			int userChoice = s.nextInt();
			
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
				String newPrice = s.nextLine();
				this.selectedItem.setPrice(newPrice);
				System.out.println("New price successfully set!");
			}
			
			else if(userChoice == 3) {
				System.out.println("Cash out all money? Or only specific bills?\n" +
								   "Type Y for cash out all money and\n" +
								   "Type N for cash out specific bills.\n" +
								   "Select: ");
				char c = s.next().charAt(0);
				Character.toLowerCase(c);
				
				if(c == 'y') {
					int moneyTotal = mh.getTotal();
					mh.cashOut();
					System.out.println("Successfully cashed out " + moneyTotal + "pesos." + this.getMachineName() + " is now cash-empty.");
				}
				
				else {
					mh.displayDenomList();
					
					System.out.println("Which bill would you like to cash out?\n" +
									   "Bill value: ");
					int bill = s.nextInt();
					int index = mh.getIndex(bill);
					System.out.println("How many " + bill + "bills would you like to take?\n" +
									   "Amount: ");
					int amount = s.nextInt();
					
					boolean success = mh.cashOne(index, amount);
					
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
				mh.displayDenomList();
					
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

	//Method to save current vending machine's attributes in a text file. Attributes include: VM name, Regular or Not, items in itemList along with their attributes
	public void saveToFile(String filename) { 
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

			writer.close();
			System.out.println("Vending Machine saved to file: " + filename);
			
		} catch (FileNotFoundException e) {
			System.out.println("Error saving Vending Machine to file: " + filename);
		}
	}

	// Method essentially takes the file (vmHistory.txt), creates another a new file with no content, and replaces that with the original.
	public void clearFile(String filename) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        writer.close();
		/*weird*/
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
			
				/*vm = new VendingMachine(...)
				  read the file*/
			
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
			Character.toLowerCase(c);
			
			boolean isSpecial = false;
			
			if(c == 'y')
				isSpecial = true;
				
			vm = new VendingMachine(name, isSpecial);
			
			s.close();
		}
		
		vm.displayMenu(vm); 
		/*to investigate*/
		vm.clearFile("VM-History.txt");
		vm.saveToFile("VM-History.txt");
	}
}