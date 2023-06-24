import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class ProductDispenser {
		
		public ProductDispenser() {
		}
		
		public void releaseItem(boolean isSpecial, Item selectedItem) {
			if(!isSpecial) {
				boolean result = selectedItem.minusStock(selectedItem, 1);
				
				if(result) 
					System.out.println("Dispensing " + selectedItem.getName() + "...");
				
				else 
					System.out.println("Oops! Not enough stock.");
			}
		}
		
		public void printReceipt(Item selectedItem, int cashIn, int change) {
			System.out.println("============RECEIPT===========" +
							 "\nPurchased Item: " + selectedItem.getName() +
							 "\nTotal Calories: " + selectedItem.getCalories() +
							 "\nItem Price: " + selectedItem.getPrice() +
							 "\nAmount Paid: " + cashIn +
							 "\nIssued Change: " + change);
		}
		
		public void printTransacHistory() throws FileNotFoundException {
			try {
				File f = new File("Transac-History.txt");
				Scanner s = new Scanner(f);
				
				String name = null;
				double calories = 0.0;
				int price = 0;
				int cashIn = 0;
				int change = 0;
				int count = 1;
				
				while(s.hasNextLine()) {
					name = s.nextLine();
					calories = s.nextDouble();
					price = s.nextInt();
					cashIn = s.nextInt();
					change = cashIn - price;
					s.nextLine();
					
					System.out.println("=====TRANSACTION#" + count + "======" +
									   "\nPurchased Item: " + name +
									   "\nTotal Calories: " + calories +
									   "\nItem Price: " + price +
									   "\nAmount Paid: " + cashIn +
									   "\nIssued Change: " + change + "\n");
					
					count++;
				}
				
				s.close();
			} catch (IOException e) {
			System.out.println("Oops! An error occurred.");
            e.printStackTrace();
			}
		}
}