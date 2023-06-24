import java.util.ArrayList;

public class ProductDisplay {
    //TODO: create methods that will "display all available products during creation (takes input from the user and returns selected item"
    //TODO: create methods that will "display all items currently on sale in the vending machine (and takes input to return selected item)"

    //TODO: userChoice() searches for and returns the name of the desired item.
    //TODO: displayOnSale() prints all of the items that are sold by the VM (NOT ALL PRE-DEFINED ITEMS)
    //TODO: note, displayOnSale will use optionList to hold held items.

    // String name, double calories, boolean standalone = false, price, int stock;

    public Item userChoice(ArrayList<Item> itemList){
        Item userItem = null;
        for(Item item : itemList)
        {
            if(item.getName().equals(userItem)){
                userItem = item;
            }
        }
        return userItem;
    }

    public void displayOnSale(ArrayList<Item> itemList){
        System.out.println("Items on Sale:\tName\t Calories\tPrice\tstock");
        
        for(Item item : itemList)
        {
            System.out.println("\t\t\t" + item.getName() + "\t"  + item.getCalories() + "\t" + item.getPrice()  + "\t" + item.getStock());
        }
    }
}
