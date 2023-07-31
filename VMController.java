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
	private boolean isSpecial;
	private ArrayList<Item> oldInventory;
	private ArrayList<Transaction> transacHistory;
	private VendingMachine vm;
	private SpecialVM svm;
	private VM_GUI view;
	
	/** 
      * A constructor that creates an instance of the VMController object.
      */
	public VMController() {
		this.isSpecial = false;
		this.oldInventory = new ArrayList<Item>();
		this.transacHistory = new ArrayList<Transaction>();
		this.vm = new VendingMachine(this, "The Classic Vending Machine", 0, 0);
		this.vm.mh.newCashBox();
		this.vm.ir.newItemRack();
		this.view = new VM_GUI();
	}

	/** 
      * The main method of the program
	  * @param args Stores Java command-line arguments
      */
	public static void main(String[] args) {
			VMController c = new VMController();
			c.displayText("Loading Vending Machine...\n");
			c.displayText("Done!\n");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public ArrayList<ArrayList<Object>> getItemStock() {
		ArrayList<ArrayList<Object>> itemStock = new ArrayList<>();
		int i = 0;
		
		//Make the ArrayList 2D
		for(i = 0; i < 30; i++) {
			ArrayList<Object> row = new ArrayList<>();
			itemStock.add(row);
		}
		
		i = 0;
		
		//Populate the 2D ArrayList
		if(!isSpecial) {
			for(Item item : this.vm.ir.getItemsOnSale()) {
				itemStock.get(i).add(this.vm.ir.countStock(item.getName()));
				itemStock.get(i).add(item.getName());
				itemStock.get(i).add(i);
				i++;
			}
		}
		
		else {
			for(Item item : this.svm.spir.getItemsOnSale()) {
				itemStock.get(i).add(this.svm.spir.countStock(item.getName()));
				itemStock.get(i).add(item.getName());
				itemStock.get(i).add(i);
				i++;
			}
		}
		
		return itemStock;
	}
	
	public int[][] getCashStock() {
		int[][] cashStock = new int[8][2];
		
		if(!isSpecial)
			cashStock = this.vm.mh.getCashBox();
		
		else 
			cashStock = this.svm.mh.getCashBox();
		
		return cashStock;
	}

	public void displayText(String text) {
		//this.view.jTextAreaConsole.append(text + "\n");
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
		
		this.isSpecial = isSpecial;
		this.transacHistory.clear();
		this.oldInventory.clear();
    }
	
	public void buyItem(Item item) {
		int cashIn = 0;
		boolean success = false;
		
		if(!isSpecial) {
			cashIn = this.vm.mh.getCashIn();
			success = this.vm.mh.payment(item);
			
			if(success) {
				//Dispense item, print receipt, record transaction
				this.displayText("\nDispensing " + item.getName() + "...");
				this.vm.ir.removeItem(item);
				this.vm.setLastTotalSales(this.vm.getTotalSales());
				this.vm.addTotalSales(item.getPrice());
				this.transacHistory.add(new Transaction(item.getName(), this.vm.getLastTotalSales(), this.vm.getTotalSales()));
	
				this.displayText("============RECEIPT===========" +
							 "\nPurchased Item: " + item.getName() +
							 "\nTotal Calories: " + item.getCalories() +
							 "\nItem Price: " + item.getPrice() +
							 "\nAmount Paid: " + cashIn +
							 "\nIssued Change: " + (cashIn - item.getPrice()) + "\n\n");
			}
		}
		
		else {
			cashIn = this.svm.mh.getCashIn();
			success = this.svm.mh.payment(item);
			
			if(success) {
				//Dispense item, print receipt, record transaction
				this.displayText("\nDispensing " + item.getName() + "...");
				this.svm.ir.removeItem(item);
				this.svm.setLastTotalSales(this.svm.getTotalSales());
				this.svm.addTotalSales(item.getPrice());
				this.transacHistory.add(new Transaction(item.getName(), this.svm.getLastTotalSales(), this.svm.getTotalSales()));
	
				this.displayText("============RECEIPT===========" +
							 "\nPurchased Item: " + item.getName() +
							 "\nTotal Calories: " + item.getCalories() +
							 "\nItem Price: " + item.getPrice() +
							 "\nAmount Paid: " + cashIn +
							 "\nIssued Change: " + (cashIn - item.getPrice()) + "\n\n");
			}
		}
	}

	public void buyRecipe(Recipe selectedRecipe) {
		int cashIn = 0;
		boolean success = this.svm.buyRecipe(selectedRecipe);
		
		//Assumes that this VM is special
		if(success) {
			success = false;
			cashIn = this.svm.mh.getCashIn();
			success = this.svm.mh.payment(selectedRecipe);
			
			if(success) {
				this.displayText(selectedRecipe.getNarration());
				this.svm.setLastTotalSales(this.svm.getTotalSales());
				this.svm.addTotalSales(selectedRecipe.getPrice());
				this.transacHistory.add(new Transaction(selectedRecipe, this.svm.getLastTotalSales(), this.svm.getTotalSales()));
				
				this.displayText("============RECEIPT===========" +
						 "\nPurchased Item: " + selectedRecipe.getName() +
						 "\nTotal Calories: " + selectedRecipe.getCalories() +
						 "\nItem Price: " + selectedRecipe.getPrice() +
						 "\nAmount Paid: " + cashIn +
						 "\nIssued Change: " + (cashIn - selectedRecipe.getPrice()) + "\n\n");
			}
		}
		
		else
			this.displayText("\nOops! Not enough ingredients for the selected recipe.");
	}

	public void restock(ArrayList<Item> userSelection) {
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
		
		//Fully restock all items in userSelection
		for(Item i : userSelection) {
			if(!isSpecial) {
				this.vm.ir.addFullStock(i);
			}
			
			else {
				this.svm.spir.addFullStock(i);
			}
		}
		
		//Set old inventory to temp
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
	}
	
	public void reprice(String name, int newPrice) {
		if(!isSpecial) {
			for(Item i : this.vm.ir.getItemsOnSale()) {
				if(i.getName().equals(name)) {
					i.setPrice(newPrice);
				}
			}
		}
		
		else {
			for(Item i : this.svm.spir.getItemsOnSale()) {
				if(i.getName().equals(name)) {
					i.setPrice(newPrice);
				}
			}
		}
	}
	
	public void deposit(int[][] userSelection) {
		int i = 0;
		
		for(i = userSelection.length; i > 0; i--) {
			if(!isSpecial && userSelection[i][1] > 0) {
				this.vm.mh.cashIn(userSelection[i][0], userSelection[i][1]);
			}
			
			else if(isSpecial && userSelection[i][1] > 0) {
				this.svm.mh.cashIn(userSelection[i][0], userSelection[i][1]);
			}
		}
	}
	
	public void withdraw(int[][] userSelection) {
		int[][] cashStock = this.getCashStock();
		int i = 0;
		
		for(i = userSelection.length; i > 0; i--) {
			if(!isSpecial && cashStock[i][1] > userSelection[i][1]) {
				this.vm.mh.cashOut(userSelection[i][0], userSelection[i][1]);
			}
			
			else if(isSpecial && cashStock[i][1] > userSelection[i][1]) {
				this.svm.mh.cashOut(userSelection[i][0], userSelection[i][1]);
			}
			
			else 
				this.displayText("Oops! Withdraw amount of " + userSelection[i][1] + " exceeds the current stock of " + cashStock[i][1] + " for the " + userSelection[i][0] + " peso bill. Canceled withdrawal for this bill.");
		}
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