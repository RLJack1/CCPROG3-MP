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
	private SpecialVM svm;
	
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
						 "Vending Machine Features:\n" + 
						 "(1) Test Current Vending Machine Features\n" +
						 "(2) Perform Maintenance Features\n" +
						 "(3) Return to Main Menu\n");
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
    public void createMenu(String name, boolean isSpecial) {
		if(!this.isSpecial) {
			this.vm.ir.clearItemList();
			this.vm.setMachineName(name);
			this.vm.setLastTotalSales(0);
			this.vm.setTotalSales(0);
			this.vm.mh.newCashBox();
			this.vm.ir.newItemRack();
		}
		
		else {
			this.svm.spir.clearItemList();
			this.svm.setMachineName(name);
			this.svm.setLastTotalSales(0);
			this.vm.setTotalSales(0);
			this.svm.mh.newCashBox();
			this.svm.spir.newItemRack();
		}
		
		this.userChoice = 0;
		this.cashIn = 0;
		this.selectedItem = null;
		this.isSpecial = isSpecial;
		this.transacHistory.clear();
		this.oldInventory.clear();
    }

	/** 
	  * Facilitates the product transaction process
	  * @param s 	The active scanner object
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
    public void testMenu() {
		/*if(!isSpecial) {
			buttonSend(this.vm.ir.getItemsOnSale());
			buttonCall(index);
			set this.selectedItem = this.vm.ir.getItemAt(index);
		}
		
		else {
			buttonSend(this.svm.spir.getItemsOnSale());
			buttonCall(index);
			set this.selectedItem = this.svm.spir.getItemAt(index);
		}*/
		
		if(this.selectedItem.getStandalone() == false) {
			/*buttonSend("Oops! The selected item cannot be bought alone. Please try again.");*/
			this.selectedItem = null;
		}
		
		if(!(this.selectedItem == null)) {
			//Get money from the user
			int input = 0;
			boolean success = false;
			
			if(!isSpecial) {
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
					this.vm.setLastTotalSales(this.vm.getTotalSales());
					this.vm.addTotalSales(this.selectedItem.getPrice());
					this.transacHistory.add(new Transaction(this.selectedItem.getName(), this.vm.getLastTotalSales(), this.vm.getTotalSales()));
					
					/*buttonSend("============RECEIPT===========" +
							 "\nPurchased Item: " + this.selectedItem.getName() +
							 "\nTotal Calories: " + this.selectedItem.getCalories() +
							 "\nItem Price: " + this.selectedItem.getPrice() +
							 "\nAmount Paid: " + this.cashIn +
							 "\nIssued Change: " + this.cashIn - this.selectedItem.getPrice()\n\n);*/
							 
					if(this.vm.ir.getNumUnique() != 30) {
						this.restockMenu();
					}
				}
				
				else
					this.cashIn = 0;
			}
			
			else {
				do {
					/*buttonCall(value)
					buttonSend(this.svm.mh.inputDenominations(value));*/
				} while(input != 999);
				
				this.cashIn = this.svm.mh.getCashIn();
				success = this.svm.mh.payment(selectedItem);
				
				if(success) {
					//Dispense item, print receipt, record transaction
					/*buttonSend("\nDispensing " + this.selectedItem.getName() + "...");*/
					this.svm.spir.removeItem(this.selectedItem);
					this.svm.setLastTotalSales(this.svm.getTotalSales());
					this.svm.addTotalSales(this.selectedItem.getPrice());
					this.transacHistory.add(new Transaction(this.selectedItem.getName(), this.svm.getLastTotalSales(), this.svm.getTotalSales()));
					
					/*buttonSend("============RECEIPT===========" +
							 "\nPurchased Item: " + this.selectedItem.getName() +
							 "\nTotal Calories: " + this.selectedItem.getCalories() +
							 "\nItem Price: " + this.selectedItem.getPrice() +
							 "\nAmount Paid: " + this.cashIn +
							 "\nIssued Change: " + this.cashIn - this.selectedItem.getPrice()\n\n);*/
							 
					if(this.svm.spir.getNumUnique() != 30) {
						this.restockMenu();
					}
				}
				
				else
					this.cashIn = 0;
			}
		}
	}
	
	public void specialTestMenu() {
		Recipe selectedRecipe = null;
		boolean success = false;
		boolean okay = false;
		int qty = 0;
		/*buttonSend("\nPurchase burger? Or single item?\n" +
					"Press Y for burgers and combos.\n" +
					"Press N for breads and meats.\n");
		userChoice = buttonCall;*/
		
		if(userChoice == 1) {
			/*buttonCall for burger or custom*/
			
			if(userChoice != 10) {
				/*selectedRecipe = this.svm.getRecipeAt(userChoice);*/
				
				if(selectedRecipe != null) {
					success = this.svm.buyRecipe(selectedRecipe);
				}
			}
			
			else if(userChoice == 10) {
				Recipe custom = new Recipe("Custom");
				
				do {
					okay = false;
					
					/*buttonSend(this.svm.spir.getItemsOnSale());
					userChoice = buttonCall;
					this.selectedItem = this.svm.spir.getItemAt(userChoice);
					if(this.svm.spir.getItemsOnSale().contains(this.selectedItem)) {
						custom.addIngredient(this.selectedItem.getName(), this.selectedItem.getCalories(), this.selectedItem.getStandalone(), this.selectedItem.getPrice());
					}*/
					
					//checks if there's at least 1 standalone item in the recipe
					if(userChoice == 999) {
						for(Ingredient i : custom.getIngredientList())
							if(i.getStandalone() == true)
								okay = true;
					}
					
					//if(okay == false)
						/*buttonSend("\nOops! You need at least 1 bread or meat in your custom order.");*/
					
				} while (userChoice != 999 && okay == false);
				
				/*success = this.svm.buyRecipe(custom);*/
			}
			
			if(success) {
			//Get money from the user
			int input = 0;
			success = false;
			
			do {
				/*buttonCall(value)
				buttonSend(this.svm.mh.inputDenominations(value));*/
			} while(input != 999);
			
			this.cashIn = this.vm.mh.getCashIn();
			success = this.svm.mh.payment(selectedRecipe);
			
			if(success) {
				//*buttonSend(this.selectedRecipe.getNarration());
				this.vm.setLastTotalSales(this.vm.getTotalSales());
				this.vm.addTotalSales(this.selectedItem.getPrice());
				this.transacHistory.add(new Transaction(selectedRecipe.getName(), this.vm.getLastTotalSales(), this.vm.getTotalSales()));
				
				/*buttonSend("============RECEIPT===========" +
						 "\nPurchased Item: " + this.selectedRecipe.getName() +
						 "\nTotal Calories: " + this.selectedRecipe.getCalories() +
						 "\nItem Price: " + this.selectedRecipe.getPrice() +
						 "\nAmount Paid: " + this.cashIn +
						 "\nIssued Change: " + this.cashIn - this.selectedRecipe.getPrice()\n\n);*/
						 
				if(this.svm.spir.getNumUnique() != 30) {
					this.restockMenu();
				}
			}
			
			else
				this.cashIn = 0;
		}
			
		//else
			/*buttonSend("\nOops! Not enough ingredients for the selected recipe.");*/
		
		} 
		
		else if(userChoice == 0) {
			this.testMenu();
		}
	}
	
	public void restockMenu() {
		boolean success = false;
		ArrayList<Item> temp = new ArrayList<Item>();
		
		//Temporary old inventory holder
		temp.clear();
		if(!isSpecial) {
			for(Item i : this.vm.ir.getItemsOnSale()) {
				temp.add(new Item(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice()));
			}
		}
		
		else {
			for(Item i : this.svm.spir.getItemsOnSale()) {
				temp.add(new Item(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice()));
			}
		}
			
		do {
			/*buttonSend("Please select the item you would like to restock!");
			buttonSend(this.vm.ir.getItemsOnSale);
			this.selectedItem(buttonCall);*/
			
			/*buttonSend("Input amount of stock to add.");
			int amountToAdd = s.nextInt();*/
			if(!isSpecial)
				success = this.vm.ir.addItem(this.selectedItem);
			
			else
				success = this.svm.spir.addItem(this.selectedItem);
			
			if(success) {
				//Sets old inventory to temp if restock is successful
				/*buttonSend("Restocking " + this.selectedItem.getName() + "...");
				("Restock success!");*/
				this.oldInventory.clear();
				this.oldInventory.addAll(temp);
			}
			
			else {
				/*buttonSend("Oops! Amount to add is too much.");*/
			}
			
		} while(userChoice != 999);
		
		if(!isSpecial) {
			this.vm.setLastTotalSales(0);
			this.vm.setTotalSales(0);
		}
		
		else {
			this.svm.setLastTotalSales(0);
			this.svm.setTotalSales(0);
		}
		
		success = false;
	}

	/** 
	  * Facilitates and conducts all maintenance features. 
	  * @param s 	The active scanner object
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
    public void maintainMenu() {
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
							 "(9) Exit Maintenance Menu\n");*/
			/*buttonCall*/
			
			//Item restock
			if(userChoice == 1) {
				this.restockMenu();
				/*buttonSend("Returning to Maintenance Menu...");*/
			}
			
			//Item re-price
			else if(userChoice == 2) {
				/*buttonSend("Please select the item you would like to re-price!");
				buttonSend(this.vm.ir.getItemsOnSale());
				buttonCall(index);
				
				if(!isSpecial)
					set this.selectedItem = this.vm.ir.getItemAt(index);
				
				else
					set this.selectedItem = this.svm.spir.getItemAt(index);
				
				buttonSend("Input new price for " + this.selectedItem.getName() + ":");
				newPrice = buttonCall()*/
				int newPrice = 0; //to be removed
				
				if(!isSpecial) {
					for(Item i : this.vm.ir.getItemsOnSale()) {
						if(i.getName().equals(this.selectedItem.getName()))
							i.setPrice(newPrice);
					}
				}
				
				else {
					for(Item i : this.svm.spir.getItemsOnSale()) {
						if(i.getName().equals(this.selectedItem.getName()))
							i.setPrice(newPrice);
					}
				}
				
				/*buttonSend("New price successfully set!");
				buttonSend("Returning to Maintenance Menu...");*/
			}
			
			//Take out money
			else if(userChoice == 3) {
				/*buttonSend(this.vm.mh.displayCashBox()); add else if here
				buttonSend("\nCash out all money? Or only specific bills?\n" +
								   "Press Y for cash out all money and\n" +
								   "Press N for cash out specific bills.\n");
				success = false;
				userChoice = buttonCall;*/
				
				//Take out all money
				if(userChoice == 1) {
					int moneyTotal = 0;
					String name = "";
					
					if(!isSpecial) {
						moneyTotal = this.vm.mh.getTotal();
						this.vm.mh.cashOut();
						name = this.vm.getName();
					}
					
					else {
						moneyTotal = this.svm.mh.getTotal();
						this.svm.mh.cashOut();
						name = this.vm.getName();
					}
					
					/*buttonSend("Successfully cashed out " + moneyTotal + " pesos. " + name + " is now cash-empty.");*/
				}
				
				//Take out specific bill/s
				else {
					/*buttonSend("Which bill would you like to cash out?\n");
					int bill = buttonCall();
					buttonSend("How many " + bill + " bills would you like to take?\n");
					int amount = buttonCall();
					
					if(!isSpecial)
						this.vm.mh(cashOne(bill, amount));
					
					else 
						this.svm.mh(cashOne(bill, amount));
					
					buttonSend("Successfully cashed out " + amount  + " of " + bill + " bills.\n"); */
				}
			}
			
			//Replenish money
			else if(userChoice == 4) {
				/*if(!isSpecial)
					buttonSend(this.vm.mh.displayCashBox());
				else
					buttonSend(this.svm.mh.displayCashBox());
				
				buttonSend("Which bill would you like to replenish?\n");
				int bill = buttonCall();
				buttonSend("How many " + bill + " bills would you like to add?\n");
				int amount = buttonCall();
					
				if(!isSpecial)
					success = this.vm.mh.refillOne(bill, amount);
				else
					success = this.svm.mh.refillOne(bill, amount);
				
				if(success) {
					buttonSend("Replenishing " + amount + " " + bill + " bills...");
					buttonSend("Replenish success!");
				}
				
				else
					buttonSend("Invalid bill value.\n");*/
				
				success = false;
			}
			
			//Print transaction history
			else if(userChoice == 5) {
				int count = 1;
				
				if(!isSpecial) {
					for(Transaction t : this.transacHistory) {
						/*buttonSend("================TRANSACTION#" + count + "=================" +
									   "\nPurchased Item:\t\t\t" + t.getName + 
									   "\nQty:\t\t\t\t" + 1 +
									   "\nTotal Sales At Last Restock:\t" + t.getLastTotalSales +
									   "\nCurrent Total Sales:\t\t" + t.getTotalSales + "\n");*/
					}
				}
				
				//else 
					//implement special transac histo AAAAAAAAAAAAAAAAAAAAAAAAAAA
			}
			
			//Print restock history
			else if(userChoice == 6) {
				/*buttonSend("==============STARTING INVENTORY===============" +
							"\nItem Name\t\tQuantity");
				
				for(Item i : oldInventory) {
					name = i.getName();
					qty = i.countStock(name);
					System.out.println(name + "\t\t" + qty + "\n");
				}
	
				buttonSend("===============ENDING INVENTORY================" +
							"\nItem Name\t\tQuantity");
				
				if(!isSpecial) {
					for(Item i : this.vm.ir.getItemsOnSale()) {
						name = i.getName();
						qty = i.countStock(name);
						System.out.println(name + "\t\t" + qty + "\n");
					}
				}
				
				else {
					for(Item i : this.svm.spir.getItemsOnSale()) {
						name = i.getName();
						qty = i.countStock(name);
						System.out.println(name + "\t\t" + qty + "\n");
					}
				}*/
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