//import java.util.ArrayList; @megan probably don't need this here anymore.

public class Item {
    private final String name;
    private final double calories;
    private final boolean standalone = false;
    private int price;
    private int stock;

    // private ArrayList<Item> optionsList = new ArrayList<Item>();  @megan probably don't need this here anymore.

    public Item(String name, double calories, boolean standalone, int price, int stock){ // Constructor for Item.
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){
        return name;
    }

    public double getCalories(){
        return calories;
    }

    public boolean getStandalone(){
        return standalone;
    }

    public int getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public void setPrice(int newPrice){
        this.price = newPrice;   
    }

    public boolean addStock(Item item, int amountToAdd){
        if (this.stock + amountToAdd >= 10)
            return false;
        else
        {
            this.stock += amountToAdd;
            return true;
        }
    }

    public boolean minusStock(Item item, int amountToMinus) {
        if (this.stock - amountToMinus < 0)
            return false;
        else
        {
            this.stock -= amountToMinus;
            return true;
        }
    }
}