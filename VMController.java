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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

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

		this.getYButton().addActionListener(this);
		this.getNButton().addActionListener(this);
		this.getConfirmButton().addActionListener(this);
		this.view.getBreakButton().addActionListener(this);
	}

	/** 
      * The main method of the program
	  * @param args Stores Java command-line arguments
      */
	public static void main(String[] args) {
			VMController c = new VMController();
			c.displayText("Loading Vending Machine...\n");
			c.displayText("Done!\n");
			c.updateStockLabel();
	}

	public void updateStockLabel(){ //@megan WIP helper method to get the names from the ir so that 
		int i = 0;
		ArrayList <Item> items = new ArrayList<>();
		if (!isSpecial){
			items = this.vm.ir.getItemsOnSale();
		}
		else{
			items = this.svm.ir.getItemsOnSale();
		}

		ArrayList <String> names = new ArrayList<>();
		for(Item item : items){
			String extractedNames = item.getName();
			names.add(extractedNames);
		}

		for (JLabel label : view.labelList) {
			label.setText(""+ this.vm.ir.countStock(names.get(i)));
			i++;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		String buttonText = clicked.getText();
		
		if(buttonText.equals("✓")) {
			String textFieldText = view.jInputTextField.getText();
			this.userChoice = Integer.parseInt(textFieldText.substring(0, 2));
			this.cashIn = Integer.parseInt(textFieldText); 
			
			if(!isSpecial) {}
				//@renzo pass in this.vm.ir.getItemsOnSale(); @megan i assume this is the part where the labels for stock is updated huhuhuhuh
				// WIP UpdateStockLabel();
			
			else {}
				//@renzo pass in this.svm.spir.getItemsOnSale();
				// WIP UpdateStockLabel();
		}
		
		else if(buttonText.equals("Break")) {
			this.userChoice = 999;
		}
		
		else if(buttonText.equals("Y")) {
			this.userChoice = 1;
		}
		
		else if(buttonText.equals("N")) {
			this.userChoice = 0;
		}
		
		/* @megan todo
		 * add buttons and calls for :
		 * menu choices / tabs
		 * money buttons
		 * item and stock buttons
		 * if cash, input directly into holder and give feedback
		 * if menu, just go there 
		 * if recipe building, immediately add to custom.ingredientList
		 * if menu choices, idk
		 */
	}

	public JButton getYButton() {
		return this.view.jButtonClearY;
	}
	
	public JButton getNButton() {
		return this.view.jButtonClearN;
	}
	
	public JButton getConfirmButton() {
		return this.view.jButtonClearY;
	}
	
	public JButton getBreakButton() {
		return this.view.jButtonBreak;
	}

	public void displayText(String text) {
		this.view.jTextAreaConsole.append(text + "\n");
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
		this.selectedItem = null;
		this.isSpecial = isSpecial;
		this.transacHistory.clear();
		this.oldInventory.clear();
		this.cashIn = 0;
    }

	/** 
	  * Facilitates the product transaction process
	  * @param s 	The active scanner object
	  * @throws FileNotFoundException if the file does not exist in this directory
	  */
    public void testMenu() {
		this.displayText("Please select an item to purchase!");
		
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
				//add implementation here
				success = this.svm.buyRecipe(custom);
			}
			
			if(success) {
			//Get money from the user
			int input = 0;
			success = false;
			
			this.cashIn = this.svm.mh.getCashIn();
			success = this.svm.mh.payment(selectedRecipe);
			
			if(success) {
				this.displayText(selectedRecipe.getNarration());
				this.svm.setLastTotalSales(this.svm.getTotalSales());
				this.svm.addTotalSales(this.selectedItem.getPrice());
				this.transacHistory.add(new Transaction(selectedRecipe, this.svm.getLastTotalSales(), this.svm.getTotalSales()));
				
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

	public void repriceMenu() {
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
	
	public void cashOut() {
		if(!isSpecial)
			this.displayText(this.vm.mh.displayCashBox()); 
		else
			this.displayText(this.svm.mh.displayCashBox()); 
		
		this.displayText("\nCash out all money? Or only specific bills?\n" +
						   "Press Y for cash out all money and\n" +
						   "Press N for cash out specific bills.\n");
		boolean success = false;
		
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
				
	public void cashIn() {
		boolean success = false;

		if(!isSpecial)
			this.displayText(this.vm.mh.displayCashBox()); 
		else
			this.displayText(this.svm.mh.displayCashBox()); 
		
		this.displayText("\nWhich bill would you like to replenish?\n");
		int bill = this.cashIn;
		this.displayText("\nHow many " + bill + " bills would you like to add?\n");
		int amount = this.cashIn;
			
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
	}
				
	public void printTransacHistory() {
		int count = 1;
		int qty = 0;
		ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
		
		for(Transaction t : this.transacHistory) {
			this.displayText("================TRANSACTION#" + count + "=================" +
						   "\nPurchased Item:\t\t\t" + t.getName());
			
			if(t.getIngredientList() != null) {
				this.displayText("\nIngredient Breakdown: ");
				temp.clear();
				
				//Fill the temp arraylist with only unique ingredients
				for(Ingredient i : t.getIngredientList()) {
					if(!(temp.contains(i)))
						temp.add(i);
				}
				
				//Print out every ingredient in the unique temp list and cross check ingredient list for qty
				for(Ingredient key : temp) {
					qty = 0;
					
					for(Ingredient i : t.getIngredientList()) {
						if(i.getName().equals(key.getName()))
							qty++;
					}
					
					this.displayText(key.getName() + "\t\t\t" + qty);
				}
			}
			
			this.displayText("\nTotal Sales At Last Restock:\t" + t.getLastTotalSales() +
							"\nCurrent Total Sales:\t\t" + t.getTotalSales() + "\n"); 
						   
			count++;
		}
	}
	
	public void printRestockHistory() {
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
}