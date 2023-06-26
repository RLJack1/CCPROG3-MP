import java.util.ArrayList;
import java.util.Scanner;

/** 
  * Displays: all available preset products to add to the vending machine, and
  * all available items on sale.
  */
public class ProductDisplay {
	/** 
	  * A constructor that creates an instance of the ProductDisplay object.
	  */
	public ProductDisplay() {
	}

	/** 
	  * Gets the item's name from the user and return its corresponding item object
	  * @param itemList	The list of all available items for this list
	  * @param s 		The active scanner object
	  * @return The object instance of the user's selected item 
	  */
    public Item userChoice(ArrayList<Item> itemList, Scanner s) {
        /*@renzo not sure why but the for loop never seems to return true!
		  might need to print out what iteminput actually contains to see what's wrong*/
		Item userItem = null;
        String itemInput = s.nextLine();
        itemInput.toLowerCase();

        for (Item item : itemList) {
            if (itemInput != null && item.getName().toLowerCase().equals(itemInput)) {
                userItem = item;
                break;
            }
        }
        return userItem;
    }

	/** 
	  * Displays all items from this list and returns the user's selected input
	  * @param itemList	The list of all available items for this list
	  * @param s 		The active scanner object
	  * @return The object instance of the user's selected item 
	  */
    public Item displayOnSale(ArrayList<Item> itemList, Scanner s){
        System.out.println("Items on Sale:\tName\t Calories\tPrice\tstock");
        Item toBuy = new Item(null, 0, false, 0, 0);
        
        for(Item item : itemList) 
        {
            if(item.getStock() != 0)
                System.out.println("\t\t\t" + item.getName() + "\t"  + item.getCalories() + "\t" + item.getPrice()  + "\t" + item.getStock());
            else
                System.out.println("\t\t\t " + item.getName() + "is SOLD OUT.");
        }

        toBuy = userChoice(itemList, s);
        if(toBuy != null){
            return toBuy;
        }
        else{
            System.out.println("ERROR: yo there isn't an item here");
            return null;
        }
    }
}
