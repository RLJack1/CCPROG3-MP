import java.util.ArrayList;
import java.util.Scanner;

/** 
  * Aids in any process needing a display of current products and receiving user item selection
  */
public class ProductDisplay {
	/** 
	  * A constructor that creates an instance of the ProductDisplay object.
	  */
	public ProductDisplay() {
	}

	/** 
	  * Displays all predefined items and returns the user's selected input. 
	  * Called at Vending Machine creation.
	  * @param predefinedItems	The list of all predefined items
	  * @param s 				The active scanner object
	  * @return The ArrayList of item objects added by the user 
	  */
    public ArrayList<Item> populateItemList(ArrayList<Item> predefinedItems, Scanner s) {
        ArrayList<Item> userItemList = new ArrayList<Item>();
        int input = 0;
        int index = 0;

		//displays the predefined items
        for (Item item : predefinedItems) {
			if((item.getName().length() >= 12 && index > 9) || item.getName().length() >= 13) {
				System.out.println("\t\t\t" + (index + 1) + ": " + item.getName() + "\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
			}
			
			else {
				System.out.println("\t\t\t" + (index + 1) + ": " + item.getName() + "\t\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
			}
            
            index++;
        }

		//repeatedly takes in user input, error checks, and adds items
        do {
            System.out.print("Input the index of the item or type \"99\" to exit: ");
            input = s.nextInt();

            if (input == 99 || userItemList.size() == 12) {
                if(userItemList.size() < 8)
					System.out.println("Oops! You need a minimum of 8 items to initialize a Vending Machine.\n" + "You currently have " + userItemList.size() + ".");
				
				else {
					if(userItemList.size() == 12)
						System.out.println("Item capacity of 12 reached.");
					
					break;
				}
					
            }

            else if (input > 0 && input <= predefinedItems.size()) {
                Item selected = predefinedItems.get(input - 1);
                if (userItemList.contains(selected)) {
                    System.out.println(selected.getName() + " is already in the list.");
                } 
				
				else {
                    userItemList.add(selected);
                    System.out.println(selected.getName() + " successfully added!");
                }
            } 
			
			else {
                System.out.println("Invalid input. Please try again.");
            }
			
        } while (true);

        return userItemList;
    }		

	/** 
	  * Displays all items on sale and returns the user's selected input
	  * @param itemList	The list of all items on sale
	  * @param s 		The active scanner object
	  * @return The object instance of the user's selected item 
	  */
    public Item displayOnSale(ArrayList<Item> itemList, Scanner s){
        System.out.println("Items on Sale:\tName\t\t Calories\tPrice\tstock");
        Item toBuy = new Item(null, 0, false, 0, 0);
        boolean done = false;
		int index = 0;
		int input = 99;
		int avail = 1;
        
		//display items 
        for(Item item : itemList) 
        {	
			if(item.getStock() != 0 && ((item.getName().length() >= 12 && index > 9) || item.getName().length() >= 13)) {
				System.out.println("\t\t" + (index + 1) + ": " + item.getName() + "\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
			}
			
			else if (item.getStock() != 0) {
				System.out.println("\t\t" + (index + 1) + ": " + item.getName() + "\t\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
			}
            
			else
                System.out.println("\t\t" + (index + 1) + ": " + item.getName() + " is SOLD OUT.");
			
            index++;
        }
		
		//take input 
		do {
            System.out.print("Input the index of the item: ");
            input = s.nextInt();
			toBuy = itemList.get(input - 1);
			avail = toBuy.getStock();
			
            if(input >= 0 && input <= itemList.size() && avail > 0) {
				toBuy = itemList.get(input - 1);
				System.out.println("Successfully selected " + toBuy.getName() + "!\n");
				done = true;
			}
			
			else {
				System.out.println("Invalid input. Please try again.\n");
			}
			
        } while (done == false);

		return toBuy;
    }
}
