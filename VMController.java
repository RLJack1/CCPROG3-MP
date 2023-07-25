/*MAIN TASKS: call view and model to interact with one another
 *			: prompt and perform menu processes (create, test, maintain)
 *			: write data into files
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

/** 
  * Makes the initial function calls to start the interaction of classes.
  */
public class VMController {
	private int cashIn;
	private int userChoice;
	private boolean isSpecial;
	private Item selectedItem;
	private ArrayList<Item> oldInventory;
	private ArrayList<Transaction> transacHistory;
	private VendingMachine vm;
	
	/** 
      * A constructor that creates an instance of the VMController object.
      */
	public VMController() {
		this.cashIn = 0;
		this.userChoice = 0;
		this.isSpecial = false;
		this.selectedItem = null;
		this.oldInventory = new ArrayList<Item>();
		this.transacHistory = new ArrayList<Transaction>();
		this.vm = new VendingMachine("The Classic Vending Machine", 0, 0);
		
		this.vm.mh.newCashBox();
		this.vm.ir.newItemRack();
	}

	/** 
      * The main method of the program
	  * @param args Stores Java command-line arguments
      */
	public static void main(String[] args) {
		VMController c = new VMController();
		/*buttonSend("Loading Vending Machine...\n");*/
		/*buttonSend("Done!\n");*/
		c.displayMenu();
	}
		
	/** 
	  * Displays the main menu of the Vending Machine and repeatedly gets user input.
	  * Makes the necessary method calls to perform specific sub-tasks.
	  * @param vm	The Vending Machine being operated on
	  * @param s 	The active scanner object
	  * @throws FileNotFoundException if the needed file does not exist in this directory
	  */
	public void displayMenu() {
		do {		
			/*buttonSend("==============================\n" +
						 "Welcome to The Founding Fathers' Vending Pantry!\n" + 
						 "You are currently operating: " + vm.getName() + "\n" +
						
						 "(2) Test a Vending Machine\n" +
						 "(3) Leave and Exit\n" +
						 "Select: ");
			userChoice = Integer.parseInt(buttonCall);*/
			
			//Create VM
			if(userChoice == 1) {
				this.createMenu();
				/*buttonSend("\nReturning to Main Menu...");*/
			}
			
			//Test or Maintain
			else if(userChoice == 2) {
				do {
					/*buttonSend("==============================\n" +
								 "Vending Machine Features:\n" + 
								 "(1) Test Current Vending Machine Features\n" +
								 "(2) Perform Maintenance Features\n" +
								 "(3) Return to Main Menu\n" +
								 "Select: ");
					userChoice = Integer.parseInt(buttonCall);*/
					
					//Test
					if(userChoice == 1) {
						if(!this.isSpecial)
							this.testMenu();
						else
							this.specialTestMenu();
						
						/*buttonSend("\nTransaction complete. Returning to Features Menu...\n");*/
					}
					
					//Maintain
					else if(userChoice == 2) {
						this.maintainMenu();
						/*buttonSend("\nMaintenance complete. Returning to Features Menu...\n");*/
					}
					
					//Return to main menu
					else if(userChoice == 3) {
						/*buttonSend("\nReturning to Main Menu...\n");*/
					}
					
					//Error catch
					else {
						/*buttonSend("\nInvalid input. Please try again.\n");*/
						userChoice = 0;
					}
					
				} while (userChoice != 3);
				
				userChoice = 0;
			}
			
			//Exit
			else if(userChoice == 3) {
				/*buttonSend("\nThank you for coming!\n" + "Exiting program...\n");*/
			}
			
			//Error catch
			else {
				/*buttonSend("\nInvalid input. Please try again.\n");*/
				userChoice = 0;
			}
			
		} while(userChoice != 3);
	}

	/** 
	  * Gets input from the user and creates a new Vending Machine
	  * @param s 	The active scanner object
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
    public void createMenu(name, ispecial) {
		char c = '\0';
		
		if(vm.ir.getItemsOnSale() != null) {
			/*buttonSend("\nDo you want to obliterate this Vending Machine and create a new one? Y/N\n" + "Input: ");*/
			c = s.next().charAt(0);
			c = Character.toLowerCase(c);
			s.nextLine();
		}
		
		else if(vm.ir.getItemsOnSale() == null) {
			c = 'y';
		}
		
		//For clearing
		if(c == 'y') {
			vm.ir.clearItemList();
			this.cashIn = 0;
			this.selectedItem = null;
			
			//Get VM details from user
			/*buttonSend("\nName your Vending Machine!\n" + "Input: ");
			String name = Integer.parseInt(buttonCall);*/
				
			/*buttonSend("\nGreat! Do you want " + name + " to be a Special Vending Machine? Y/N\n" + "Input: ");
			if(s.hasNextLine()) {
				c = s.next().charAt(0);
				c = Character.toLowerCase(c);
				s.nextLine();
			} buttonCall*/
			
			//Sets up new VM
			boolean isSpecial = false;
			
			if(c == 'y') {
				isSpecial = true;
			}

			this.vm.setMachineName(name);
			this.isSpecial = isSpecial;
			this.vm.setLastTotalSales(0);
			this.vm.totalSales = 0;
			this.transacHistory.clear();
			/*buttonSend("\nFilling up cash box...");*/
			this.vm.mh.newCashBox();

			/*buttonSend("\nAlright! Let's get some items in here!\n");*/
			if(!isSpecial) {
				/*buttonSend(this.vm.ir.getPresetItems());
				do {
					//add way to count unique items
					
					if(buttonCall == 99) {
						if(unique < 8) {
							buttonSend("\nOops! The minimum of 8 items has not yet been reached. You are at " + unique + "items.\n");
							buttonCall = 98;
						}
					} 
					
					else if(unique == 16) {
						buttonSend("\nMaximum 16 items reached.\n");
						buttonCall = 99;
					}
					
					if(buttonCall != 99) {
						selectedItem = this.vm.ir.getPresetItemAt(buttonCall());
						
						if(selectedItem.getStandalone == true) {
							this.vm.ir.addItem(selectedItem);
							this.vm.ir.addFullStock(selectedItem, 7);
							buttonSend("\nItem add success!\n");
						}
						
						else {
							buttonSend("\nOops! The selected item could not be sold individually. Please try again.\n");
						}
					}
				} while(buttonCall != 99);*/
			}
			
			else {
				//SPECIAL VM INITIALIZATION AAAAAAAAAAAAAAAAAAAAAA
			}

			/*buttonSend("\nAlright! " + name + " is all set up!");*/
		}
		
		else if(c == 'n') 
			/*buttonSend("\nCanceling vending machine set up...");*/
		
		this.selectedItem = null;
    }

	/** 
	  * Facilitates the product transaction process
	  * @param s 	The active scanner object
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
    public void testMenu() {
		/*buttonSend(this.vm.ir.getItemsOnSale());
		buttonCall(input);
		set this.selectedItem = this.vm.ir.getItemAt(index)*/
		
		if(!(this.selectedItem == null)) {
			//Get money from the user
			int input = 0;
			boolean success = false;
			
			do {
				/*buttonCall(value)
				buttonSend(this.vm.mh.inputDenominations(value));*/
			} while(input != 999);
			
			this.cashIn = this.vm.mh.getCashIn();
			success = this.vm.mh.payment(selectedItem);
			
			if(success) {
				//Dispense item, print receipt, record transaction
				/*buttonSend("\nDispensing " + this.selectedItem.getName() + "...");*/
				this.vm.ir.removeItem(this.selectedItem);
				this.vm.setLastTotalSales(this.vm.totalSales);
				this.vm.addTotalSales(this.selectedItem.getPrice());
				this.transacHistory.add(new Transaction(this.selectedItem.getName(), this.vm.getLastTotalSales, this.vm.getTotalSales(), false));
				
				/*buttonSend("============RECEIPT===========" +
						 "\nPurchased Item: " + this.selectedItem.getName() +
						 "\nTotal Calories: " + this.selectedItem.getCalories() +
						 "\nItem Price: " + this.selectedItem.getPrice() +
						 "\nAmount Paid: " + this.cashIn +
						 "\nIssued Change: " + this.cashIn - this.selectedItem.getPrice()\n\n);*/
			}
			
			else
				this.cashIn = 0;
		}
	}
	
	public void specialTestMenu() {
		//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		/*recipe purchase (custom or preset)
		regular item purchase (only standalone)
		special payment, special transaction + stock saving*/
	}

	/** 
	  * Facilitates and conducts all maintenance features. 
	  * @param s 	The active scanner object
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
    public void maintainMenu() throws FileNotFoundException {
		char c = '\0';
		ArrayList<Item> temp = new ArrayList<Item>();
		boolean success = false;
		
		do {
			/*buttonSend("\n==============================\n" +
							 "Maintenance Menu:\n" + 
							 "(1) Restock Items\n" +
							 "(2) Change Item Price\n" +
							 "(3) Take Out Money\n" +
							 "(4) Replenish Money\n" +
							 "(5) Print Transaction History\n" +
							 "(6) Print Restock History\n" +
							 "(7) Display CashBox Contents\n" +
							 "(8) Display Items on Sale\n" +
							 "(9) Exit Maintenance Menu\n" +
							 "Select: ");*/
			
			if(s.hasNextInt()) {
				userChoice = s.nextInt();
				s.nextLine();
			}			
			
			//Item restock
			if(userChoice == 1) {
				//Temporary old inventory holder
				temp.clear();
				for(Item i : itemList) {
					temp.add(new Item(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getStock(), i.getGrid()));
				}
					
				do {
					c = '\0';
					
					/*buttonSend("Please select the item you would like to restock!");
					buttonSend(this.vm.ir.getItemsOnSale);
					this.selectedItem(buttonCall);*/
					
					/*buttonSend("Input amount of stock to add: ");
					int amountToAdd = s.nextInt();*/
					this.vm.ir.addItem(this.selectedItem);
					
					if(success) {
						//Sets old inventory to temp if restock is successful
						System.out.println("Restocking " + this.selectedItem.getName() + "...");
						System.out.println("Restock success!");
						this.oldInventory.clear();
						this.oldInventory.addAll(temp);
					}
					
					else {
						System.out.println("Oops! Amount to add is too much.");
					}
					
					System.out.print("Restock another item? Y/N\n" + "Input: ");
					c = s.next().charAt(0);
					c = Character.toLowerCase(c);
					s.nextLine();
				} while(c == 'y');
				
				//Save restock details into file
				this.lastTotalSales = 0;
				this.totalSales = 0;
				System.out.println("Saving restock inventories...");
				this.saveRestock();
				System.out.println("Returning to Maintenance Menu...");
			}
			
			//Item re-price
			else if(userChoice == 2) {
				System.out.println("Please select the item you would like to re-price!");
				this.selectedItem = pDisplay.displayOnSale(itemList, s); 
				
				System.out.println("Input new price for " + this.selectedItem.getName() + ":");
				int newPrice = this.selectedItem.getPrice();
				
				if(s.hasNextInt()) {
					newPrice = s.nextInt();
					s.nextLine();
				}
				
				this.selectedItem.setPrice(newPrice);
				System.out.println("New price successfully set!");
			}
			
			//Take out money
			else if(userChoice == 3) {
				mh.displayDenomList();
				
				System.out.print("\nCash out all money? Or only specific bills?\n" +
								   "Type Y for cash out all money and\n" +
								   "Type N for cash out specific bills.\n" +
								   "Select: ");
				c = '\0';
				success = false;
				
				//Get input
				if(s.hasNextLine()) {
					c = s.next().charAt(0);
					c = Character.toLowerCase(c);
					s.nextLine();
				}
				
				//Take out all money
				if(c == 'y') {
					int moneyTotal = mh.getTotal();
					mh.cashOut();
					System.out.println("Successfully cashed out " + moneyTotal + " pesos. " + this.getName() + " is now cash-empty.");
				}
				
				//Take out specific bill/s
				else {
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
					
					mh.cashOne(bill, amount);
				}
			}
			
			//Replenish money
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
				
				success = mh.refillOne(bill, amount);
				
				if(success) {
					System.out.println("Replenishing " + amount + " " + bill + " bills...");
					System.out.println("Replenish success!");
				}
				
				else
					System.out.println("Invalid bill value.\n");
			}
			
			//Print transaction history
			else if(userChoice == 5) {
				
			}
			
			//Print restock history
			else if(userChoice == 6) {
				this.printRestockHistory();
			}
			
			else if(userChoice == 7) {
				/*buttonSend(this.vm.mh.displayCashBox());*/
			}
			
			else if(userChoice == 8) {
				/*buttonSend(this.vm.ir.getItemsOnSale());*/
			}
			
			//Exit
			else if(userChoice == 9) {
				/*buttonSend("\nReturning to Features Menu...");*/
			}
			
			//Error catch
			else {
				/*buttonSend("\nInvalid input. Please try again.");*/
				userChoice = 0;
			}
			
		} while(userChoice != 9);
					
		userChoice = 0;
    }
}