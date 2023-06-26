import java.util.ArrayList;
import java.util.NoSuchElementException;
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
	MoneyHandler mh = new MoneyHandler();
	ProductDisplay pDisplay = new ProductDisplay();
	ProductDispenser pDispenser = new ProductDispenser();
	
	public VendingMachine() {
		this.machineName = null;
		this.isSpecial = false;
		this.cashIn = 0;
		this.totalSales = 0;
		this.lastTotalSales = 0;
		this.selectedItem = null;
		itemList = new ArrayList<Item>();
	}
	
	public VendingMachine(String machineName, boolean isSpecial) {
		this.machineName = machineName;
		this.isSpecial = isSpecial;
		this.cashIn = 0;
		this.totalSales = 0;
		this.lastTotalSales = 0;
		this.selectedItem = null;
		itemList = new ArrayList<Item>();
	}
	
	public void populateVMHistory() throws FileNotFoundException {
    try {
        File f = new File("VM-History.txt");
        Scanner s = new Scanner(f);
		double calories = 0;
		boolean standalone = false;
		int price = 0;
		int stock = 0;

        if (s.hasNextLine()) {
            this.machineName = s.nextLine();
        }
        if (s.hasNextBoolean()) {
            this.isSpecial = s.nextBoolean();
        }
        if (s.hasNextInt()) {
            this.lastTotalSales = s.nextInt();
        }
        if (s.hasNextInt()) {
            this.totalSales = s.nextInt();
        }
        s.nextLine();

        while (s.hasNextLine()) {
            String name = s.nextLine();
            if (s.hasNextDouble()) {
                calories = s.nextDouble();
            }
            if (s.hasNextBoolean()) {
                standalone = s.nextBoolean();
            }
            if (s.hasNextInt()) {
            	price = s.nextInt();
            }
            if (s.hasNextInt()) {
                stock = s.nextInt();
            }
            //s.nextLine();

            itemList.add(new Item(name, calories, standalone, price, stock));
        }

        s.close();
    } catch (NoSuchElementException e) {
        e.printStackTrace();
    }
}
	
	public void writeVMHistory() throws FileNotFoundException {
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
	
	public void writeTransacHistory(Item item, int cashIn) throws FileNotFoundException {
		try {
			PrintWriter p = new PrintWriter("Transac-History.txt"); 

			p.println(item.getName());
			p.println(item.getCalories());
			p.println(item.getPrice());
			p.println(cashIn);
			p.println(cashIn - item.getPrice());
			p.println();
			
			p.flush();
			p.close();

		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }	
	}

	public void saveRestock(int amountToAdd, int newStock) throws FileNotFoundException {
		try {
			PrintWriter p = new PrintWriter("Restock-History.txt"); 
			
			for(Item item : itemList) {
				p.println(item.getName());
				p.println(amountToAdd);
				p.println(newStock);
				p.println();
			}
			
			p.println();
			p.println(this.lastTotalSales);
			p.println(this.totalSales);
			p.println(this.totalSales - this.lastTotalSales);
			p.println("\n---\n\n");
			
			p.flush();
			p.close();
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }
	}
	
	public void printRestockHistory() throws FileNotFoundException {
		try {
			File f = new File("Restock-History.txt");
			Scanner s = new Scanner(f);
				
			String name = null;
			int amountAdded = 0;
			int newStock = 0;
			int lastTotalSales = 0;
			int totalSales = 0;
			int count = 1;
			int numItems = 0;
			
			while(s.hasNextLine()) {
					for(Item item : itemList) {
						numItems++;
					}
				
				System.out.println("=======RESTOCK#" + count + "========");
					
				while(numItems > 0) {
					name = s.nextLine();
					amountAdded = s.nextInt();
					newStock = s.nextInt();
					s.nextLine();
					
					System.out.println("Item Name: " + name +
									   "\nAmount Added: " + amountAdded +
									   "\nNew Stock: " + newStock + "\n");
									   
					numItems--;
				}
				
				System.out.println("\nLast Total Sales: " + lastTotalSales +
								   "\nCurrent Total Sales: " + totalSales +
								   "\nAmount Earned from Last Restock: " + (lastTotalSales - totalSales) + "\n---\n\n");
				
				count++;
			}
			
			s.close();
		} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
        }
	}
	
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
	
	public void saveToFile(String filename) throws FileNotFoundException { 
		try {
			this.writeVMHistory();
			System.out.println("History saved to: " + filename);
		} catch (FileNotFoundException e) {
			System.out.println("Error saving to: " + filename);
			e.printStackTrace();
		}
	}
    
	public void displayMenu(VendingMachine vm) throws FileNotFoundException {
		int userChoice = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Welcome to The Founding Fathers' Vending Pantry!\n" + 
							 "(1) Build a Vending Machine\n" +
							 "(2) Test a Vending Machine\n" +
							 "(3) Leave and Exit\n" +
							 "Select: ");
			userChoice = Integer.parseInt(input.nextLine());

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
					System.out.print("==============================\n" +
								 "Vending Machine Features:\n" + 
								 "(1) Test Current Vending Machine Features\n" +
								 "(2) Perform Maintenance Features\n" +
								 "(3) Return to Main Menu\n" +
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
		
		setLastTotalSales(getTotalSales());
		
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
			this.clearFile("VM-History.txt");
			this.clearFile("Transac-History.txt");
			this.clearFile("Restock-History.txt");

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
		}
		
		populateOptionsList(itemList);
		//pDisplay.displayOnSale(itemList); test to see if it goes into the machien

		s.close();
    }

    public void testMenu() throws FileNotFoundException {
		pDisplay.displayOnSale(itemList);
		this.selectedItem = pDisplay.userChoice(itemList); 
		
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
		 	int price = 0;
			price = selectedItem.getPrice();
			mh.checkChange(this.cashIn, price);
			
			pDispenser.printReceipt(this.selectedItem, this.cashIn, this.cashIn - price);
			this.writeTransacHistory(this.selectedItem, this.cashIn);
			this.totalSales = setTotalSales(price);
			this.cashIn = 0;
		}
		
		else {
			System.out.println("Canceling transaction...");
			System.out.println("Releasing full change...");
			this.cashIn = 0;
		}
		
		s.close();
    }

    public void maintainMenu() throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		int userChoice;
		
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
			userChoice = s.nextInt();
			
			if(userChoice == 1) {
				System.out.println("Please select the item you would like to restock!");
				this.selectedItem = pDisplay.userChoice(itemList); 
				
				System.out.println("Input amount of stock to add: ");
				int amountToAdd = s.nextInt();
				boolean success = selectedItem.addStock(this.selectedItem, amountToAdd);
				
				if(success) {
					System.out.println("Restocking " + this.selectedItem.getName() + " ...");
					System.out.println("Restock success!");
					this.saveRestock(amountToAdd, this.selectedItem.getStock());
				}
				
				else {
					System.out.println("Oops! Amount to add is too much.");
				}
			}
			
			else if(userChoice == 2) {
				System.out.println("Please select the item you would like to re-price!");
				this.selectedItem = pDisplay.userChoice(itemList);
				
				System.out.println("Input new price for " + this.selectedItem.getName() + ":");
				int newPrice = s.nextInt();
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
					mh.displayDenomList();
					
					System.out.println("Which bill would you like to cash out?\n" +
									   "Bill value: ");
					int bill = s.nextInt();
					int index = mh.getIndex(bill);
					System.out.println("How many " + bill + "bills would you like to take?\n" +
									   "Amount: ");
					int amount = s.nextInt();
					
					boolean success = mh.cashOne(index, amount) == 0;
					
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
				pDispenser.printTransacHistory();
			}
			
			else if(userChoice == 6) {
				this.printRestockHistory();
			}
			
			else if(userChoice == 7) {
				System.out.println("Returning to Features Menu...");
				System.out.println("==============================");
			}
			
			else {
				System.out.println("Invalid input. Please try again.");
				System.out.println("==============================");
				userChoice = 0;
			}
			
		} while(userChoice != 7);
					
		userChoice = 0;
		s.close();
    }

	public ArrayList<Item> populateOptionsList(ArrayList<Item> itemList){
        itemList.add(new Item("BriocheBread", 346.0, true, 34, 8));
        itemList.add(new Item("SesameBread", 140.0, true, 20, 8));
        itemList.add(new Item("RyeBread", 259.0, true, 48, 8));
        itemList.add(new Item("WholewheatBread", 265.0, true, 40, 8));
        itemList.add(new Item("PotatoBread", 266.0, true, 33, 8));
        itemList.add(new Item("JackBread", 100.0, true, 100, 8));
        itemList.add(new Item("AngusBeef", 164.0, true, 144, 8));
        itemList.add(new Item("WagyuBeef", 250.0, true, 795, 8));
        itemList.add(new Item("TapaBeef", 187.75, true, 56, 8));
        itemList.add(new Item("CheesedBeef", 373.0, true, 214, 8));
        itemList.add(new Item("CanadianBacon", 185.0, true, 140, 8));
        itemList.add(new Item("ChickenSchnitzel", 297.0, true, 175, 8));
        itemList.add(new Item("SalmonPatty", 208.0, true, 300, 8));
        itemList.add(new Item("BronzeTurkey", 189.0, true, 185, 8));
        itemList.add(new Item("BeyondBeef", 210.0, true, 330, 8));
        itemList.add(new Item("JackBeef", 100.0, true, 100, 8));
        itemList.add(new Item("WhiteOnions", 40.0, false, 30, 8));
        itemList.add(new Item("OnionRings", 205.5, false, 85, 8));
        itemList.add(new Item("TrappistCheese", 355.0, false, 140, 8));
        itemList.add(new Item("MozzarelaCheese", 140.0, false, 75, 8));
        itemList.add(new Item("BlueCheese", 177.0, false, 105, 8));
        itemList.add(new Item("AmericanCheese", 177.0, false, 40, 8));
        itemList.add(new Item("MeltedButter", 307.5, false, 60, 8));
        itemList.add(new Item("BeefsteakTomato", 18.0, false, 50, 8));
        itemList.add(new Item("IcebergLettuce", 3.0, false, 45, 8));
        itemList.add(new Item("DillPickles", 11.0, false, 45, 8));
        itemList.add(new Item("HotSauce", 11.0, false, 50, 8));
        itemList.add(new Item("BarbequeSauce", 172.0, false, 70, 8));
        itemList.add(new Item("CaviarSauce", 252.0, false, 330, 8));
        itemList.add(new Item("JackSauce", 10.0, false, 10, 8));
		return itemList;
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
	
	public int getLastTotalSales() {
		return this.lastTotalSales;
	}
	
	public int getTotalSales() {
		return this.totalSales;
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
	
	public int setTotalSales(int amountToAdd) {
		return (this.totalSales + amountToAdd);
	}
	
	public void setLastTotalSales(int newAmount) {
		this.lastTotalSales = newAmount;
	}
	
	public void setSelectedItem(Item newSelectedItem) {
		this.selectedItem = newSelectedItem;
	}
}