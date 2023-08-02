import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/** 
  * Connects the events happening in the view to the respective logic in the model.
  */
public class VMController implements ActionListener {
	private boolean isSpecial;
	private Recipe selectedRecipe;
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
		this.selectedRecipe = null;
		this.oldInventory = new ArrayList<Item>();
		this.transacHistory = new ArrayList<Transaction>();
		this.vm = new VendingMachine(this, "The Classic Vending Machine", 0, 0);
		this.svm = new SpecialVM(this, "The Classic Vending Machine", 0, 0);
		this.vm.mh.newCashBox();
		this.vm.ir.newItemRack();
		this.svm.mh.newCashBox();
		this.svm.spir.newItemRack();
		
		//Add actionlisteners to specific gui buttons
		this.view = new VM_GUI();
		this.view.getCreateButton().addActionListener(this);
		this.view.getItemButton().addActionListener(this);
		this.view.getItemCancelButton().addActionListener(this);
		this.view.getRecipeButton().addActionListener(this);
		this.view.getRecipeCancelButton().addActionListener(this);
		this.view.getRestockButton().addActionListener(this);
		this.view.getRepriceButton().addActionListener(this);
		this.view.getDepositButton().addActionListener(this);
		this.view.getWithdrawButton().addActionListener(this);
		this.view.getWithdrawAllButton().addActionListener(this);
		this.view.getPrintTransacButton().addActionListener(this);
		this.view.getPrintRestockButton().addActionListener(this);
		
		for(JButton b : this.view.getRecipeButtons()) {
			b.addActionListener(this);
		}
		
		for(JButton b : this.view.getMoneyButtons()) {
			b.addActionListener(this);
		}
		
		this.updateItemStock();
		this.updatePrices();
		this.updateCashStock();
	}

	/** 
      * The main method of the program
	  * @param args Stores Java command-line arguments
      */
	public static void main(String[] args) {
			VMController c = new VMController();
			c.view.setVisible(true);
			c.displayText("Loading Vending Machine...");
			c.displayText("Done!\n");
	}
	
	/** 
	  * Triggers whenever one of the anticipated elements in view are pressed or interacted with 
	  * @param e The event that occurred
	  */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		if(clicked.equals(this.view.getCreateButton())) {
			boolean isSpecial = false;
			
			if(this.view.getSpeRadioButton().isSelected())
				isSpecial = true;
			
			String name = this.view.getVMNameText().getText();
			
			this.create(name, isSpecial);
		}
		
		else if(clicked.equals(this.view.getItemButton())) {
			//take item spinners and run buyItem + error msgs
			int count = 0;
			int i = 0;
			
			//Check if only one item was picked
			for(JSpinner sp : this.view.getItemSpinners()) {
				count += (int) sp.getValue();
			}
			
			if(!isSpecial) {
				if(count > 1)
					this.displayText("Oops! Regular Vending Machines only support single item purchases.\nPlease try again.");
				
				else if(count == 0)
					this.displayText("Please add +1 to the item you wish to purchase.");
				
				else if(count == 1) {
					//Identify what item was selected
					for(JSpinner sp : this.view.getItemSpinners()) {
						if(((int) sp.getValue()) == 1)
							i = this.view.getItemSpinners().indexOf(sp);
					}
					
					//Get the item object
					String name = this.vm.ir.getPresetItemName(i);
					if(this.vm.ir.getItemCalled(name) != null)
						this.buyItem(this.vm.ir.getItemCalled(name));
					
					else 
						this.displayText("Oops! The item is out of stock. Please try again.");
				}
			}
			
			else {
				if(count > 1) {
					this.displayText("Preparing your burger...\nHang in there!");
					
					int qty = 0;
					int index = 0;
					String name = null;
					Ingredient ingredient = null;
					Recipe custom = new Recipe("Custom Burger");
					
					//Get the ingredients per user selection
					for(JSpinner sp : this.view.getItemSpinners()) {
						qty = (int) sp.getValue();
						
						if(qty > 0) {
							//Get index then name
							index = this.view.getItemSpinners().indexOf(sp);
							name = this.svm.spir.getPresetItemName(index);
							ingredient = this.svm.spir.getIngredientCalled(name);
							
							while(qty > 0) {
								custom.addIngredient(ingredient);
								qty--;
							}
						}
					}
					
					//Order
					this.buyRecipe(custom);
				}
				
				else if(count == 0)
					this.displayText("Please add +1 to the item you wish to purchase.");
				
				else if(count == 1) {
					//Identify what item was selected
					for(JSpinner sp : this.view.getItemSpinners()) {
						if(((int) sp.getValue()) == 1)
							i = this.view.getItemSpinners().indexOf(sp);
					}
					
					//Get the item object
					String name = this.svm.spir.getPresetItemName(i);
					if(this.svm.spir.getItemCalled(name) != null)
						this.buyItem(this.svm.spir.getItemCalled(name));
					
					else 
						this.displayText("Oops! The item is out of stock. Please try again.");
				}
			}
		}
		
		else if(clicked.equals(this.view.getItemCancelButton())) {
			if(!isSpecial)
				this.vm.mh.releaseAll();
			
			else
				this.svm.mh.releaseAll();
			
			this.displayText("Cancelling transaction...\nReleasing full change...");
		}
		
		else if(this.view.getRecipeButtons().contains(clicked)) {
			//Identify the selected recipe name
			String unformatted = clicked.getText();
			String recipe = this.convert(unformatted);
			
			if(!isSpecial)
				this.displayText("Sorry! Regular Vending Machines can't support recipe purchases.");
			
			else {
				int index = this.svm.getRecipeIndex(recipe);
				this.selectedRecipe = this.svm.getRecipeAt(index);
				this.displayText("Selected: " + recipe);
				this.displayText("Cost of Selected: " + this.selectedRecipe.getPrice());
			}
		}
		
		else if(clicked.equals(this.view.getRecipeButton())) {
			if(!isSpecial)
				this.displayText("Sorry! Regular Vending Machines can't support recipe purchases.");
			
			else {
				//Buy the recipe
				this.buyRecipe(this. selectedRecipe);
			}
		}
		
		else if(clicked.equals(this.view.getRecipeCancelButton())) {
			if(!isSpecial)
				this.vm.mh.releaseAll();
			
			else
				this.svm.mh.releaseAll();
			
			this.displayText("Cancelling transaction...\nReleasing full change...");
		}
		
		else if(this.view.getMoneyButtons().contains(clicked)) {
			int amount = Integer.parseInt(clicked.getText());
			
			if(!isSpecial)
				this.vm.mh.inputDenominations(amount);
			
			else
				this.svm.mh.inputDenominations(amount);
		}
		
		else if(clicked.equals(this.view.getRestockButton())) {
			ArrayList<String> temp = new ArrayList<String>();
			ArrayList<String> userSelection = new ArrayList<String>();
			ArrayList<Item> presetItemList = this.vm.ir.getPresetItems();
			
			//Consolidate the selected items
			for(JRadioButton r : this.view.getRestockButtons()) {
				if(r.isSelected()) {
					temp.add(r.getText());
				}
			}
			
			//Reformat strings
			for(String s : temp) {
				userSelection.add(this.convert(s));
			}
			
			//Call function
			this.restock(userSelection);
			this.updateItemStock();
			this.displayText("Restocked successfully!");
		}
		
		else if(clicked.equals(this.view.getRepriceButton())) {
			String selected = null;
			String temp = null;
			int newPrice = Integer.parseInt(this.view.getNewPrice().getText());
			
			//Find the button
			for(JRadioButton r : this.view.getRepriceButtons()) {
				if(r.isSelected()) {
					temp = r.getText();
				}
			}
			
			//Reformat string
			selected = this.convert(temp);
			
			//Call function
			if(selected != null) {
				this.reprice(selected, newPrice);
				this.updatePrices();
				this.displayPrint("Repriced successfully!");
			}
				
			
			else
				this.displayText("Oops! An error occurred. Please try again.");
		}
		
		else if(clicked.equals(this.view.getDepositButton())) {
			int[][] selection = {
			  {1, 0},
			  {5, 0},
			  {10, 0},  
			  {20, 0},
			  {50, 0},
			  {100, 0},
			  {500, 0},
			  {1000, 0}
			};

			int i = 0;
			
			//Extract the user selection
			for(JSpinner sp : this.view.getMHSpinners()) {
				selection[i][1] = (int) sp.getValue();
				i++;
			}
			
			//Call the function
			this.deposit(selection);
			
			this.displayText("Deposited successfully!");
			this.updateCashStock();
		}
		
		else if(clicked.equals(this.view.getWithdrawButton())) {
			int[][] selection = {
			  {1, 0},
			  {5, 0},
			  {10, 0},  
			  {20, 0},
			  {50, 0},
			  {100, 0},
			  {500, 0},
			  {1000, 0}
			};
			
			int i = 0;
			
			//Extract the user selection
			for(JSpinner sp : this.view.getMHSpinners()) {
				selection[i][1] = (int) sp.getValue();
				i++;
			}
			
			//Call the function
			this.withdraw(selection);
			this.updateCashStock();
		}
		
		else if(clicked.equals(this.view.getWithdrawAllButton())) {
			if(!isSpecial)
				this.vm.mh.setCashBox();
			
			else
				this.svm.mh.setCashBox();
			
			this.updateCashStock();
		}
		
		else if(clicked.equals(this.view.getPrintTransacButton())) {
			this.printTransacHistory();
		}
		
		else if(clicked.equals(this.view.getPrintRestockButton())) {
			this.printRestockHistory();
		}
	}
	
	/** 
      * Converts a string from label form to item or recipe name form
	  * @param original The string to be trimmed
	  * @return The trimmed string text
      */
	public String convert(String original) {
		int count = 0;
		boolean found = false;
		String temp = null;
		
		//Reformat string
		for(char ch : original.toCharArray()) {
			if(!found) {
				if(ch == '-') {
					found = true;
				}
				
				else 
					count++;
			}
		}
		
		temp = original.substring(count + 1);
		original = temp.replace(" ", "");
		
		return original;
	}
	
	/** 
	  * Gets the stock of every item on sale and passes it to the view
	  */
	public void updateItemStock() {
		//First column is for item names, second is for stock
		ArrayList<ArrayList<Object>> itemStock = new ArrayList<>();
		int i = 0;
		String name = null;
		
		//Make the ArrayList 2D and populate
		if(!isSpecial) {
			for(i = 0; i < 30; i++) {
				ArrayList<Object> row = new ArrayList<Object>();
				name = this.vm.ir.getPresetItemName(i);
				row.add(name);
				row.add(this.vm.ir.countStock(name));
				itemStock.add(row);		
			}
		}
		
		else {
			for(Item item : this.svm.spir.getItemsOnSale()) {
				ArrayList<Object> row = new ArrayList<Object>();
				name = this.svm.spir.getPresetItemName(i);
				row.add(name);
				row.add(this.svm.spir.countStock(name));
				itemStock.add(row);
			}
		}
		
		this.view.updateItemStock(itemStock);
	}
	
	/** 
	  * Gets the stock of bill and passes it to the view
	  */
	public void updateCashStock() {
		int[][] cashStock = new int[8][2];
		
		if(!isSpecial)
			cashStock = this.vm.mh.getCashBox();
		
		else 
			cashStock = this.svm.mh.getCashBox();
		
		this.view.updateCashStock(cashStock);
	}

	/** 
	  * Gets the price  of every item on sale and passes it to the view
	  */
	public void updatePrices() {
		//First column is for stock, second is for item names, third is for item indices
		ArrayList<ArrayList<Object>> itemPrices = new ArrayList<>();
		int i = 0;
		String name = null;
		
		//Make the ArrayList 2D and populate
		if(!isSpecial) {
			for(i = 0; i < 30; i++) {
				ArrayList<Object> row = new ArrayList<Object>();
				name = this.vm.ir.getPresetItemName(i);
				row.add(name);
				row.add(this.vm.ir.getSaleItemPrice(name));
				itemPrices.add(row);
			}
		}
		
		else {
			for(Item item : this.svm.spir.getItemsOnSale()) {
				ArrayList<Object> row = new ArrayList<Object>();
				name = this.svm.spir.getPresetItemName(i);
				row.add(name);
				row.add(this.svm.spir.getSaleItemPrice(name));
				itemPrices.add(row);
			}
		}
		
		this.view.updatePrices(itemPrices);
	}

	/** 
	  * Display a string of text in the text area of the view
	  * @param text The text to be displayed
	  */
	public void displayText(String text) {
		this.view.displayText(text);
	}
	
	/** 
	  * Display a string of text in the print text area of the view
	  * @param text The text to be displayed
	  */
	public void displayPrint(String text) {
		this.view.displayPrint(text);
	}

	/** 
	  * Creates a new Vending Machine
	  * @param name			The name of the Vending Machine
	  * @param isSpecial	Whether the VM is special or not 
	  */
    public void create(String name, boolean isSpecial) {
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
		
		this.updateItemStock();
		this.updateCashStock();
		this.updatePrices();
    }
	
	/** 
	  * Facilitates the item purchasing process (get cash, dispense change, dispense item)
	  * @param item The user's selected item for purchase
	  */
	public void buyItem(Item item) {
		int cashIn = 0;
		boolean success = false;
		
		if(!item.getStandalone()) {
			this.displayText("Oops! You cannot buy that item alone. Please select a different item.");
			
			if(!isSpecial)
				this.vm.mh.releaseAll();
			
			else
				this.svm.mh.releaseAll();
		}
		
		else if(!isSpecial) {
			cashIn = this.vm.mh.getCashIn();
			success = this.vm.mh.payment(item);
			
			if(success) {
				//Dispense item, print receipt, record transaction
				this.displayText("\nDispensing " + item.getName() + "...");
				this.vm.ir.removeItem(item);
				this.vm.setLastTotalSales(this.vm.getTotalSales());
				this.vm.addTotalSales(item.getPrice());
				this.transacHistory.add(new Transaction(item.getName(), this.vm.getLastTotalSales(), this.vm.getTotalSales()));
	
				this.displayText("\n============RECEIPT===========" +
							 "\nPurchased Item: " + item.getName() +
							 "\nTotal Calories: " + item.getCalories() +
							 "\nItem Price: " + item.getPrice() +
							 "\nAmount Paid: " + cashIn +
							 "\nIssued Change: " + (cashIn - item.getPrice()) + 
							 "\n===============================\n");
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
	
				this.displayText("\n============RECEIPT===========" +
							 "\nPurchased Item: " + item.getName() +
							 "\nTotal Calories: " + item.getCalories() +
							 "\nItem Price: " + item.getPrice() +
							 "\nAmount Paid: " + cashIn +
							 "\nIssued Change: " + (cashIn - item.getPrice()) +
							 "\n===============================\n");
			}
		}
		
		this.updateItemStock();
		this.updateCashStock();
	}

	/** 
	  * Facilitates the recipe purchasing process (get cash, dispense change, dispense burger)
	  * @param item The user's selected recipe for purchase
	  */
	public void buyRecipe(Recipe selectedRecipe) {
		int cashIn = 0;
		boolean success = false;
		success = this.svm.buyRecipe(selectedRecipe);
		
		if(selectedRecipe == null)
			this.displayText("Oops! Something went wrong on my end. Please try that again.");
		
		//Assumes that this VM is special
		else if(success) {
			success = false;
			cashIn = this.svm.mh.getCashIn();
			success = this.svm.mh.payment(selectedRecipe);
			
			if(success) {
				this.displayText(selectedRecipe.getNarration());
				this.svm.setLastTotalSales(this.svm.getTotalSales());
				this.svm.addTotalSales(selectedRecipe.getPrice());
				this.transacHistory.add(new Transaction(selectedRecipe, this.svm.getLastTotalSales(), this.svm.getTotalSales()));
				
				this.displayText("\n============RECEIPT===========" +
						 "\nPurchased Item: " + selectedRecipe.getName() +
						 "\nTotal Calories: " + selectedRecipe.getCalories() +
						 "\nItem Price: " + selectedRecipe.getPrice() +
						 "\nAmount Paid: " + cashIn +
						 "\nIssued Change: " + (cashIn - selectedRecipe.getPrice()) + 
						 "\n===============================\n");
			}
		}
		
		else
			this.displayText("\nOops! Not enough ingredients for the selected recipe.");
		
		this.updateItemStock();
		this.updateCashStock();
	}

	/** 
	  * Facilitates restocking of an item to full capacity
	  * @param userSelection The arraylist of items the user selected for restocking
	  */
	public void restock(ArrayList<String> userSelection) {
		ArrayList<Item> temp = new ArrayList<Item>();
		ArrayList<Item> toAdd = new ArrayList<Item>();
		toAdd.clear();
		
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
		
		//Convert String list to Item list
		for(String s : userSelection) {
			if(this.vm.ir.getItemFrom(s) != null) {
				toAdd.add(this.vm.ir.getItemFrom(s));
			}
		}
		
		//Fully restock all items in userSelection
		for(Item i : toAdd) {
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
	
	/** 
	  * Facilitates the repricing of an item
	  * @param name		The name of the item
	  * @param newPrice	The new cost of the item
	  */
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
	
	/** 
	  * Facilitates the cash-in process
	  * @param userSelection The 2D int array of bills and corresponding amounts for cash-in
	  */
	public void deposit(int[][] userSelection) {
		int i = 0;
		
		for(i = 7; i >= 0; i--) {
			if(!isSpecial && userSelection[i][1] > 0) {
				this.vm.mh.cashIn(userSelection[i][0], userSelection[i][1]);
			}
			
			else if(isSpecial && userSelection[i][1] > 0) {
				this.svm.mh.cashIn(userSelection[i][0], userSelection[i][1]);
			}
		}
	}
	
	/** 
	  * Facilitates the cash-out process
	  * @param userSelection The 2D int array of bills and corresponding amounts for cash-out
	  */
	public void withdraw(int[][] userSelection) {
		int[][] cashStock = new int[8][2];
		boolean okay = false;
		
		if(!isSpecial)
			cashStock = this.vm.mh.getCashBox();
		
		else 
			cashStock = this.svm.mh.getCashBox();
		
		int i = 0;
		
		for(i = 7; i >= 0; i--) {
			if(!isSpecial && userSelection[i][1] <= cashStock[7 - i][1]) {
				this.vm.mh.cashOut(userSelection[i][0], userSelection[i][1]);
				okay = true;
			}
			
			else if(isSpecial && userSelection[i][1] <= cashStock[7 - i][1]) {
				this.svm.mh.cashOut(userSelection[i][0], userSelection[i][1]);
				okay = true;
			}
			
			else 
				this.displayText("Oops! Withdraw amount of " + userSelection[i][1] + " exceeds the current stock of " + cashStock[i][1] + " for the " + cashStock[7 - i][0] + " peso bill.\nCanceled withdrawal for this bill.");
		}
		
		if(okay)
			this.displayText("Withdrawn successfully!");
	}
	
	/** 
	  * Displays this Vending Machine's transaction history
	  */
	public void printTransacHistory() {
		int count = 1;
		int qty = 0;
		ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
		
		this.view.clearPrint();
		
		if(this.transacHistory == null) {
			this.displayPrint("No transaction history found.");
		}
		
		for(Transaction t : this.transacHistory) {
			this.displayPrint("================TRANSACTION#" + count + "=================" +
						   "\nPurchased Item:\t\t" + t.getName());
			
			if(t.getIngredientList() != null) {
				this.displayPrint("\nIngredient Breakdown: ");
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
					
					this.displayPrint(key.getName() + "\t\t\t" + qty);
				}
			}
			
			this.displayPrint("Total Sales At Last Restock:\t" + t.getLastTotalSales() +
							"\nCurrent Total Sales:\t\t" + t.getTotalSales() + "\n"); 
						   
			count++;
		}
	}
	
	/** 
	  * Displays this Vending Machine's restock history
	  */
	public void printRestockHistory() {
		int qty = 0;
		ArrayList<String> newItemNames = new ArrayList<String>();
		ArrayList<String> oldItemNames = new ArrayList<String>();
		ArrayList<Item> itemsOnSale = new ArrayList<Item>();
		
		this.view.clearPrint();
		
		if(this.oldInventory.size() == 0) {
			this.displayPrint("No restock history found.");
		}
		
		else {
			//Set up itemsOnSale
			if(!isSpecial)
				itemsOnSale.addAll(this.vm.ir.getItemsOnSale());
			
			else
				itemsOnSale.addAll(this.svm.spir.getItemsOnSale());
			
			//Set up oldItemNames
			for(Item i : oldInventory) {
				if(!oldItemNames.contains(i.getName()))
					oldItemNames.add(i.getName());
			}
			
			//Set up newItemNames
			for(Item i : itemsOnSale) {
				if(!newItemNames.contains(i.getName()))
					newItemNames.add(i.getName());
			}
			
			this.displayPrint("==============STARTING INVENTORY===============" +
						"\nItem Name\t\tQuantity");
			
			for(String name : oldItemNames) {
				for(Item item : oldInventory) {
					if(item.getName().equals(name))
						qty++;
				}
				
				this.displayPrint(name + "\t\t" + qty);
				qty = 0;
			}

			this.displayPrint("===============ENDING INVENTORY================" +
						"\nItem Name\t\tQuantity");
			
			for(String name : newItemNames) {
				for(Item item : itemsOnSale) {
					if(item.getName().equals(name))
						qty++;
				}
				
				this.displayPrint(name + "\t\t" + qty);
				qty = 0;
			}

		}
	}
}