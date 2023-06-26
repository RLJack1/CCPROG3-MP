import java.util.ArrayList;

public class ProductDisplay {

    public Item userChoice(ArrayList<Item> itemList) {
        Item userItem = null;
        for (Item item : itemList) {
            if (userItem != null && item.getName().toLowerCase().equals(userItem.getName().toLowerCase())) {
                userItem = item;
                break;
            }
        }
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
