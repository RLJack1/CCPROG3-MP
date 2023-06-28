import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/** 
  * Updates stock and prints details relative to the transaction conducted. 
  */
public class ProductDispenser {
	/** 
	  * A constructor that creates an instance of the ProductDispenser object.
	  */
	public ProductDispenser() {
	}
	
	/** 
	  * Narrates item dispense and subtracts its stock by 1
	  * @param isSpecial 	Whether the vending machine is a special vending machine
	  * @param selectedItem	The item to be dispensed
	  */
	public void releaseItem(boolean isSpecial, Item selectedItem) {
		if(!isSpecial) {
			boolean result = selectedItem.minusStock(selectedItem, 1);
			
			if(result) 
				System.out.println("Dispensing " + selectedItem.getName() + "...");
			
			else 
				System.out.println("Oops! Not enough stock.");
		}
	}
	
	/** 
	  * Displays all details of the transaction that just occurred
	  * @param selectedItem	The item that was sold
	  * @param cashIn		The total amount of money inputted by the user
	  * @param change		The amount of change given in the transaction
	  */
	public void printReceipt(Item selectedItem, int cashIn, int change) {
		System.out.println("============RECEIPT===========" +
						 "\nPurchased Item: " + selectedItem.getName() +
						 "\nTotal Calories: " + selectedItem.getCalories() +
						 "\nItem Price: " + selectedItem.getPrice() +
						 "\nAmount Paid: " + cashIn +
						 "\nIssued Change: " + change);
	}
	
	/** 
	  * Displays all details of all previous transactions on this vending machine
	  */
	public void printTransacHistory() throws FileNotFoundException {
		try {
			File f = new File("Transac-History.txt");
			Scanner s = new Scanner(f);
			
			String name = null;
			int qty = 1;
			int lastTotalSales = 0;
			int totalSales = 0;
			int count = 1;
			
			while(s.hasNextLine()) {
				name = s.nextLine();
				qty = Integer.parseInt(s.nextLine());
				lastTotalSales = Integer.parseInt(s.nextLine());
				totalSales = Integer.parseInt(s.nextLine());
				
				System.out.println("================TRANSACTION#" + count + "=================" +
								   "\nPurchased Item:\t\t\t" + name + 
								   "\nQty:\t\t\t\t" + qty +
								   "\nTotal Sales At Last Restock:\t" + lastTotalSales +
								   "\nCurrent Total Sales:\t\t" + totalSales + "\n");
				
				count++;
			}
			
			s.close();
		} catch (IOException e) {
		System.out.println("Oops! An error occurred.");
		e.printStackTrace();
		}
	}
}