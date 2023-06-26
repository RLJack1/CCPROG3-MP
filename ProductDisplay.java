import java.util.ArrayList;
import java.util.Scanner;

public class ProductDisplay {

    public Item userChoice(ArrayList<Item> itemList) {
        Item userItem = null;
        Scanner s = new Scanner(System.in);
        String itemInput = s.nextLine();
        itemInput.toLowerCase();

        for (Item item : itemList) {
            if (itemInput != null && item.getName().toLowerCase().equals(itemInput)) {
                userItem = item;
                break;
            }
        }

        s.close();

        return userItem;
    }

    public Item displayOnSale(ArrayList<Item> itemList){
        System.out.println("Items on Sale:\tName\t Calories\tPrice\tstock");
        Item toBuy = new Item(null, 0, false, 0, 0);
        
        for(Item item : itemList) 
        {
            if(item.getStock() != 0)
                System.out.println("\t\t\t" + item.getName() + "\t"  + item.getCalories() + "\t" + item.getPrice()  + "\t" + item.getStock());
            else
                System.out.println("\t\t\t " + item.getName() + "is SOLD OUT.");
        }

        toBuy = userChoice(itemList);
        if(toBuy != null){
            return toBuy;
        }
        else{
            System.out.println("ERROR: yo there isn't an item here");
            return null;
        }
    }
}
