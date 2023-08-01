import java.util.ArrayList;
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
  * Connects the events happening in the view to the respective logic in the model.
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
		
		this.view.getCreateButton().addActionListener(this);
		this.view.getItemButton().addActionListener(this);
		this.view.getRecipeButton().addActionListener(this);
		this.view.getRestockButton().addActionListener(this);
		this.view.getRepriceButton().addActionListener(this);
		this.view.getDepositButton().addActionListener(this);
		this.view.getWithdrawButton().addActionListener(this);
		this.view.getWithdrawAllButton().addActionListener(this);
		this.view.getPrintTransacButton().addActionListener(this);
		this.view.getPrintRestockButton().addActionListener(this);
	}

	/** 
      * The main method of the program
	  * @param args Stores Java command-line arguments
      */
	public static void main(String[] args) {
			VMController c = new VMController();
			c.view.secondInit();
			c.displayText("Loading Vending Machine...\n");
			c.displayText("Done!\n");
	}
	
	/** 
	  * TEXT 
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
			
		}
		
		else if(clicked.equals(this.view.getRecipeButton())) {
			
		}
		
		else if(clicked.equals(this.view.getRestockButton())) {
			
		}
		
		else if(clicked.equals(this.view.getRepriceButton())) {
			
		}
		
		else if(clicked.equals(this.view.getDepositButton())) {
			
		}
		
		else if(clicked.equals(this.view.getWithdrawButton())) {
			
		}
		
		else if(clicked.equals(this.view.getWithdrawAllButton())) {
			if(!isSpecial)
				this.vm.mh.setCashBox();
			
			else
				this.svm.mh.setCashBox();
		}
		
		else if(clicked.equals(this.view.getPrintTransacButton())) {
			this.printTransacHistory();
		}
		
		else if(clicked.equals(this.view.getPrintRestockButton())) {
			this.printRestockHistory();
		}
	}
	
	/** 
	  * Gets and returns the stock of every item on sale
	  * @return A 2D ArrayList of items on sale and their respective stock counts
	  */
	public ArrayList<ArrayList<Object>> getItemStock() {
		//First column is for stock, second is for item names, third is for item indices
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
	
	/** 
	  * Gets and returns the stock of every bill in storage
	  * @return A 2D int array of bills and their respective stock counts
	  */
	public int[][] getCashStock() {
		int[][] cashStock = new int[8][2];
		
		if(!isSpecial)
			cashStock = this.vm.mh.getCashBox();
		
		else 
			cashStock = this.svm.mh.getCashBox();
		
		return cashStock;
	}

	/** 
	  * Display a string of text in the text area of the view
	  * @param text The text to be displayed
	  */
	/*public void displayText(String text) {
		this.view.jTextAreaConsole.append("AAAAAAAA" + "\n");
    }*/
	
	/** 
	  * Display a string of text in the print text area of the view
	  * @param text The text to be displayed
	  */
	/*public void displayPrint(String text) {
		this.view.getTextAreaReceipt().append("AAAAAAAAAAAAAAAAAAA" + "\n");
	}*/
	
	public void displayText(String text) {
    this.view.displayText("AAAAAAAA");
}

public void displayPrint(String text) {
    this.view.displayPrint("AAAAAAAAAAAAAAAAAAA");
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
    }
	
	/** 
	  * Facilitates the item purchasing process (get cash, dispense change, dispense item)
	  * @param item The user's selected item for purchase
	  */
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

	/** 
	  * Facilitates the recipe purchasing process (get cash, dispense change, dispense burger)
	  * @param item The user's selected recipe for purchase
	  */
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

	/** 
	  * Facilitates restocking of an item to full capacity
	  * @param userSelection The arraylist of items the user selected for restocking
	  */
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
		
		for(i = userSelection.length; i > 0; i--) {
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
	
	/** 
	  * Displays this Vending Machine's transaction history
	  */
	public void printTransacHistory() {
		int count = 1;
		int qty = 0;
		ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
		
		if(this.transacHistory == null) {
			this.displayPrint("No transaction history found.");
		}
		
		for(Transaction t : this.transacHistory) {
			this.displayPrint("================TRANSACTION#" + count + "=================" +
						   "\nPurchased Item:\t\t\t" + t.getName());
			
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
			
			this.displayPrint("\nTotal Sales At Last Restock:\t" + t.getLastTotalSales() +
							"\nCurrent Total Sales:\t\t" + t.getTotalSales() + "\n"); 
						   
			count++;
		}
	}
	
	/** 
	  * Displays this Vending Machine's restock history
	  */
	public void printRestockHistory() {
		String name = "";
		int qty = 0;
		
		if(this.oldInventory == null) {
			this.displayPrint("No restock history found.");
		}
		
		this.displayPrint("==============STARTING INVENTORY===============" +
					"\nItem Name\t\tQuantity");
		
		for(Item i : oldInventory) {
			name = i.getName();
		
			for(Item item : oldInventory) {
				if(item.getName().equals(name))
					qty++;
			}
			
			this.displayPrint(name + "\t\t" + qty + "\n");
			qty = 0;
		}

		this.displayPrint("===============ENDING INVENTORY================" +
					"\nItem Name\t\tQuantity");
		
		if(!isSpecial) {
			for(Item i : this.vm.ir.getItemsOnSale()) {
				name = i.getName();
				qty = this.vm.ir.countStock(name);
				this.displayPrint(name + "\t\t" + qty + "\n");
			}
		}
		
		else {
			for(Item i : this.svm.spir.getItemsOnSale()) {
				name = i.getName();
				qty = this.svm.spir.countStock(name);
				this.displayPrint(name + "\t\t" + qty + "\n");
			}
		}
	}
}