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
          //@megan wdym by "true"? i thought userChoice would only return the item based on the user's input.
		Item userItem = null;
        String itemInput = s.nextLine();
        itemInput.toLowerCase();

        for (Item item : itemList) {
            if (item.getName().toLowerCase().equals(itemInput)) {
                userItem = item;
                break;
            }
        }

        System.out.println(userItem.getName()); // For testing 

        return userItem;
    }

    public ArrayList<Item> populateItemList(ArrayList<Item> predefinedItems, Scanner s) {
        ArrayList<Item> userItemList = new ArrayList<Item>();
        int input = 0;
        int index = 0;

        for (Item item : predefinedItems) {
            System.out.println("\t\t\t" + index+1 + ": " + item.getName() + "\t" + item.getCalories() + "\t" + item.getPrice() + "\t" + item.getStock());
            index++;
        }

        do {
            System.out.print("Input the index of the item or type \"30\" to exit: ");
            input = s.nextInt();

            if (input == 31) {
                break;
            }

            if (input >= 0 && input < predefinedItems.size()) {
                Item selected = predefinedItems.get(input);
                if (userItemList.contains(selected)) {
                    System.out.println(selected.getName() + " is already in the list.");
                } else {
                    userItemList.add(selected);
                    System.out.println(selected.getName() + " successfully added!");
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } while (true);

        return userItemList;
    }
    
            // if (exists) {
            //     for (Item item : predefinedItems) {
            //         if (!input.equals(item.getName().toLowerCase())) {
            //             continue;
            //         }
            //         userItemList.add(item);
            //         System.out.println(item.getName() + " successfully added!");
            //     }
            // } else {
            //     if (input.equals("done")) {
            //         System.out.println("Item stocking done.");
            //     } else {
            //         System.out.println("Error input, please try again.");
            //     }
            // }
			

	/** 
	  * Displays all items from this list and returns the user's selected input
	  * @param itemList	The list of all available items for this list
	  * @param s 		The active scanner object
	  * @return The object instance of the user's selected item 
	  */
    public Item displayOnSale(ArrayList<Item> itemList, Scanner s){
        System.out.println("Items on Sale:\tName\t Calories\tPrice\tstock");
        Item toBuy = new Item(null, 0, false, 0, 0);
        boolean done;
        
        for(Item item : itemList) 
        {
            if(item.getStock() != 0)
                System.out.println("\t\t\t" + item.getName() + "\t"  + item.getCalories() + "\t" + item.getPrice()  + "\t" + item.getStock());
            else
                System.out.println("\t\t\t " + item.getName() + "is SOLD OUT.");
        }

        do{
            toBuy = userChoice(itemList, s);

            if(toBuy != null){
                done = true;
                return toBuy;
            }
            else{
                System.out.println("ERROR: yo there isn't an item here, please try again");
                return null;
            }
        } while (!(done == true));


    }
}
