/*MAIN TASKS: call view and model to interact with one another
 *			: prompt and perform menu processes (create, test, maintain)
 *			: write data into files
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/** 
  * Makes the initial function calls to start the interaction of classes.
  */
public class VMController implements ActionListener {
	private int cashIn;
	protected int userChoice;
	private boolean isSpecial;
	private Item selectedItem;
	private ArrayList<Item> oldInventory;
	private ArrayList<Transaction> transacHistory;
	private VendingMachine vm;
	private SpecialVM svm;
	private VM_GUI view;
	
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
		this.vm = new VendingMachine(this, "The Classic Vending Machine", 0, 0);
		this.vm.mh.newCashBox();
		this.vm.ir.newItemRack();
		
		this.view = new VM_GUI();
		this.view.getYButton().addActionListener(this);
		this.view.getNButton().addActionListener(this);
		this.view.getConfirmButton().addActionListener(this);
		this.view.getBreakButton().addActionListener(this);
	}

	/** 
      * The main method of the program
	  * @param args Stores Java command-line arguments
      */
	public static void main(String[] args) {
		VMController c = new VMController();
		c.view.CreateShowGUI(args); 
		c.displayText("Loading Vending Machine...\n");
		c.displayText("Done!\n");
		c.displayMenu();
	}

	// public void UpdateStockLabel(){ @megan WIP helper method to get the names from the ir so that 
	// 	int i = 0;
	// 	ArrayList <Item> items = this.vm.ir.getItemsOnSale();
	// 	ArrayList <String> names = new ArrayList<>();
	// 	for(Item item : items){
	// 		String extractedNames = item.getName();
	// 		names.add(extractedNames);
	// 	}

	// 	for (JLabel label : view.labelList) {
	// 		label.setText(""+ this.vm.ir.countStock(names.get(i)));
	// 		i++;
	// 	}
	// }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		String buttonText = clicked.getText();
		
		if(buttonText == "✓") {
			String textFieldText = view.jInputTextField.getText(); 
			if(textFieldText.length() <= 1)
				this.userChoice = Integer.parseInt(textFieldText.substring(0, 1));
			
			else {
				this.userChoice = Integer.parseInt(textFieldText.substring(0, 2));
				this.cashIn = Integer.parseInt(textFieldText); //@megan this fails to differentiate
			}
				
			
			this.cashIn = 0;
			
			if(!isSpecial) {}
				//@renzo pass in this.vm.ir.getItemsOnSale(); @megan i assume this is the part where the labels for stock is updated huhuhuhuh
				// WIP UpdateStockLabel();
			
			else {}
				//@renzo pass in this.svm.spir.getItemsOnSale();
				// WIP UpdateStockLabel();
		}
		
		else if(buttonText == "Break") {
			this.userChoice = 999;
		}
		
		else if(buttonText == "Y") {
			this.userChoice = 1;
		}
		
		else if(buttonText == "N") {
			this.userChoice = 0;
		}
	}
	
	public void displayText(String text) {
		if(this.view != null) {
			this.view.displayText(text);
		}
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
			this.displayText("==============================\n" +
						 "Vending Machine Features:\n" + 
						 "(1) Test Current Vending Machine Features\n" +
						 "(2) Perform Maintenance Features\n" +
						 "(3) Return to Main Menu\n");
			
			//Test
			if(userChoice == 1) {
				if(!this.isSpecial)
					this.testMenu();
				else
					this.specialTestMenu();
				
				this.displayText("\nTransaction complete. Returning to Features Menu...\n");
			}
			
			//Maintain
			else if(userChoice == 2) {
				this.maintainMenu();
				this.displayText("\nMaintenance complete. Returning to Features Menu...\n");
			}
			
			//Exit
			else if(userChoice == 3) {
				this.displayText("\nThank you for coming!\n" + "Exiting program...\n");
			}
			
			//Error catch
			else {
				this.displayText("\nInvalid input. Please try again.\n");
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
			this.vm = new VendingMachine(this, name, 0, 0);
			this.vm.mh.newCashBox();
			this.vm.ir.newItemRack();
		}
		
		else {
			this.svm = new SpecialVM(this, name, 0, 0);
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
		if(userChoice >= 0 && userChoice <= 30) {
			if(!isSpecial)
				this.selectedItem = this.vm.ir.getItemAt(userChoice);
			
			else
				this.selectedItem = this.svm.spir.getItemAt(userChoice);
		}
			
		if(this.selectedItem.getStandalone() == false) {
			this.displayText("\nOops! The selected item cannot be bought alone. Please try again.\n");
			this.selectedItem = null;
		}
		
		if(!(this.selectedItem == null)) {
			//Get money from the user
			int input = 0;
			boolean success = false;
			
			if(!isSpecial) {
				do {
					this.displayText(this.vm.mh.inputDenominations(this.cashIn));
					this.cashIn = 0;
				} while(input != 999);
				
				this.cashIn = this.vm.mh.getCashIn();
				success = this.vm.mh.payment(selectedItem);
				
				if(success) {
					//Dispense item, print receipt, record transaction
					this.displayText("\nDispensing " + this.selectedItem.getName() + "...");
					this.vm.ir.removeItem(this.selectedItem);
					this.vm.setLastTotalSales(this.vm.getTotalSales());
					this.vm.addTotalSales(this.selectedItem.getPrice());
					this.transacHistory.add(new Transaction(this.selectedItem.getName(), this.vm.getLastTotalSales(), this.vm.getTotalSales()));
					
					this.displayText("============RECEIPT===========" +
							 "\nPurchased Item: " + this.selectedItem.getName() +
							 "\nTotal Calories: " + this.selectedItem.getCalories() +
							 "\nItem Price: " + this.selectedItem.getPrice() +
							 "\nAmount Paid: " + this.cashIn +
							 "\nIssued Change: " + (this.cashIn - this.selectedItem.getPrice()) + "\n\n");
							 
					if(this.vm.ir.getNumUnique() != 30) {
						this.restockMenu();
					}
				}
				
				else
					this.cashIn = 0;
			}
			
			else {
				do {
					this.displayText(this.svm.mh.inputDenominations(this.cashIn));
					this.cashIn = 0;
				} while(input != 999);
				
				this.cashIn = this.svm.mh.getCashIn();
				success = this.svm.mh.payment(selectedItem);
				
				if(success) {
					//Dispense item, print receipt, record transaction
					this.displayText("\nDispensing " + this.selectedItem.getName() + "...");
					this.svm.spir.removeItem(this.selectedItem);
					this.svm.setLastTotalSales(this.svm.getTotalSales());
					this.svm.addTotalSales(this.selectedItem.getPrice());
					this.transacHistory.add(new Transaction(this.selectedItem.getName(), this.svm.getLastTotalSales(), this.svm.getTotalSales()));
					
					this.displayText("============RECEIPT===========" +
							 "\nPurchased Item: " + this.selectedItem.getName() +
							 "\nTotal Calories: " + this.selectedItem.getCalories() +
							 "\nItem Price: " + this.selectedItem.getPrice() +
							 "\nAmount Paid: " + this.cashIn +
							 "\nIssued Change: " + (this.cashIn - this.selectedItem.getPrice()) + "\n\n");
							 
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
		this.displayText("\nPurchase burger? Or single item?\n" +
					"Press Y for burgers and combos.\n" +
					"Press N for breads and meats.\n");
		
		if(userChoice == 1) {
			if(userChoice != 10) {
				selectedRecipe = this.svm.getRecipeAt(userChoice);
				
				if(selectedRecipe != null) {
					success = this.svm.buyRecipe(selectedRecipe);
				}
			}
			
			else if(userChoice == 10) {
				Recipe custom = new Recipe("Custom");
				
				do {
					okay = false;
					this.selectedItem = this.svm.spir.getItemAt(userChoice);
					if(this.svm.spir.getItemsOnSale().contains(this.selectedItem)) {
						custom.addIngredient((Ingredient) this.selectedItem);
					}
					
					//checks if there's at least 1 standalone item in the recipe
					if(userChoice == 999) {
						for(Ingredient i : custom.getIngredientList())
							if(i.getStandalone() == true)
								okay = true;
					}
					
					if(okay == false)
						this.displayText("\nOops! You need at least 1 bread or meat in your custom order.");
					
				} while (userChoice != 999 && okay == false);
				
				success = this.svm.buyRecipe(custom);
			}
			
			if(success) {
			//Get money from the user
			int input = 0;
			success = false;
			
			do {
				this.displayText(this.svm.mh.inputDenominations(this.cashIn));
				this.cashIn = 0;
			} while(input != 999);
			
			this.cashIn = this.svm.mh.getCashIn();
			success = this.svm.mh.payment(selectedRecipe);
			
			if(success) {
				this.displayText(selectedRecipe.getNarration());
				this.svm.setLastTotalSales(this.svm.getTotalSales());
				this.svm.addTotalSales(this.selectedItem.getPrice());
				this.transacHistory.add(new Transaction(selectedRecipe.getName(), this.svm.getLastTotalSales(), this.svm.getTotalSales()));
				
				this.displayText("============RECEIPT===========" +
						 "\nPurchased Item: " + selectedRecipe.getName() +
						 "\nTotal Calories: " + selectedRecipe.getCalories() +
						 "\nItem Price: " + selectedRecipe.getPrice() +
						 "\nAmount Paid: " + this.cashIn +
						 "\nIssued Change: " + (this.cashIn - selectedRecipe.getPrice()) + "\n\n");
						 
				if(this.svm.spir.getNumUnique() != 30) {
					this.restockMenu();
				}
			}
			
			else
				this.cashIn = 0;
		}
			
		else
			this.displayText("\nOops! Not enough ingredients for the selected recipe.");
		
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
			this.displayText("\nPlease select the item you would like to restock!");
			
			if(!isSpecial) {
				this.selectedItem = this.vm.ir.getItemAt(userChoice);
				this.vm.ir.addFullStock(this.selectedItem);
			}
				
			else {
				this.selectedItem = this.svm.spir.getItemAt(userChoice);
				this.svm.spir.addFullStock(this.selectedItem);
			}
	
			//Sets old inventory to temp 
			this.displayText("\nRestocking " + this.selectedItem.getName() + "...");
			this.displayText("\nRestock success!");
			this.oldInventory.clear();
			this.oldInventory.addAll(temp);
			
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
			this.displayText("\n==============================\n" +
							 "Maintenance Menu:\n" + 
							 "(1) Restock Items\n" +
							 "(2) Change Item Price\n" +
							 "(3) Take Out Money\n" +
							 "(4) Replenish Money\n" +
							 "(5) Print Transaction History\n" +
							 "(6) Print Restock History\n" +
							 "(7) Display CashBox Contents\n" +
							 "(8) Exit Maintenance Menu\n");
			
			//Item restock
			if(userChoice == 1) {
				this.restockMenu();
				this.displayText("\nReturning to Maintenance Menu...");
			}
			
			//Item re-price
			else if(userChoice == 2) {
				this.displayText("Please select the item you would like to re-price!");
				
				if(!isSpecial)
					this.selectedItem = this.vm.ir.getItemAt(userChoice);
				
				else
					this.selectedItem = this.svm.spir.getItemAt(userChoice);
				
				this.displayText("\nInput new price for " + this.selectedItem.getName() + ":");

				if(!isSpecial) {
					for(Item i : this.vm.ir.getItemsOnSale()) {
						if(i.getName().equals(this.selectedItem.getName()))
							i.setPrice(this.cashIn);
					}
				}
				
				else {
					for(Item i : this.svm.spir.getItemsOnSale()) {
						if(i.getName().equals(this.selectedItem.getName()))
							i.setPrice(this.cashIn);
					}
				}
				
				this.displayText("\nNew price successfully set!");
				this.displayText("\nReturning to Maintenance Menu...");
			}
			
			//Take out money
			else if(userChoice == 3) {
				if(!isSpecial)
					this.displayText(this.vm.mh.displayCashBox()); 
				else
					this.displayText(this.svm.mh.displayCashBox()); 
				
				this.displayText("\nCash out all money? Or only specific bills?\n" +
								   "Press Y for cash out all money and\n" +
								   "Press N for cash out specific bills.\n");
				success = false;
				
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
					
					this.displayText("\nSuccessfully cashed out " + moneyTotal + " pesos. " + name + " is now cash-empty.");
				}
				
				//Take out specific bill/s
				else {
					this.displayText("\nWhich bill would you like to cash out?\n");
					int bill = this.cashIn;
					this.displayText("\nHow many " + bill + " bills would you like to take?\n");
					int amount = this.cashIn;
					
					if(!isSpecial)
						this.vm.mh.cashOne(bill, amount);
					
					else 
						this.svm.mh.cashOne(bill, amount);
					
					this.displayText("\nSuccessfully cashed out " + amount  + " of " + bill + " bills.\n"); 
				}
			}
			
			//Replenish money
			else if(userChoice == 4) {
				if(!isSpecial)
					this.displayText(this.vm.mh.displayCashBox()); 
				else
					this.displayText(this.svm.mh.displayCashBox()); 
				
				this.displayText("\nWhich bill would you like to replenish?\n");
				int bill = this.cashIn;
				this.displayText("\nHow many " + bill + " bills would you like to add?\n");
				int amount = this.cashIn; //these parts feel iffy @megan
					
				if(!isSpecial)
					success = this.vm.mh.refillOne(bill, amount);
				else
					success = this.svm.mh.refillOne(bill, amount);
				
				if(success) {
					this.displayText("\nReplenishing " + amount + " " + bill + " bills...");
					this.displayText("\nReplenish success!");
				}
				
				else
					this.displayText("\nInvalid bill value.\n");
				
				success = false;
			}
			
			//Print transaction history
			else if(userChoice == 5) {
				int count = 1;
				
				if(!isSpecial) {
					for(Transaction t : this.transacHistory) {
						this.displayText("================TRANSACTION#" + count + "=================" +
									   "\nPurchased Item:\t\t\t" + t.getName() + 
									   "\nQty:\t\t\t\t" + 1 +
									   "\nTotal Sales At Last Restock:\t" + t.getLastTotalSales() +
									   "\nCurrent Total Sales:\t\t" + t.getTotalSales() + "\n"); 
					}
				}
				
				else {}
					//implement special transac histo AAAAAAAAAAAAAAAAAAAAAAAAAAA @megan
			}
			
			//Print restock history
			else if(userChoice == 6) {
				String name = "";
				int qty = 0;
				
				this.displayText("==============STARTING INVENTORY===============" +
							"\nItem Name\t\tQuantity");
				
				for(Item i : oldInventory) {
					name = i.getName();
				
					for(Item item : oldInventory) {
						if(item.getName().equals(name))
							qty++;
					}
					
					this.displayText(name + "\t\t" + qty + "\n");
					qty = 0;
				}
	
				this.displayText("===============ENDING INVENTORY================" +
							"\nItem Name\t\tQuantity");
				
				if(!isSpecial) {
					for(Item i : this.vm.ir.getItemsOnSale()) {
						name = i.getName();
						qty = this.vm.ir.countStock(name);
						this.displayText(name + "\t\t" + qty + "\n");
					}
				}
				
				else {
					for(Item i : this.svm.spir.getItemsOnSale()) {
						name = i.getName();
						qty = this.svm.spir.countStock(name);
						this.displayText(name + "\t\t" + qty + "\n");
					}
				}
			}
			
			else if(userChoice == 7) {
				this.displayText(this.vm.mh.displayCashBox());
			}
			
			//Exit
			else if(userChoice == 8) {
				this.displayText("\nReturning to Features Menu...");
			}
			
			//Error catch
			else {
				this.displayText("\nInvalid input. Please try again.");
				userChoice = 0;
			}
			
		} while(userChoice != 8);
					
		userChoice = 0;
    }
}