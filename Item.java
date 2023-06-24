import java.util.ArrayList;

public class Item {
    private final String name;
    private final double calories;
    private final boolean standalone = false;
    private int price;
    private int stock;
    // create optionsList, arrayList that defines all of the items.

    private ArrayList<Item> optionsList = new ArrayList<Item>();

    public void populateOptionsList(){
        optionsList.add(new Item("BriocheBread", 346.0, true, 34, 8, 0));
        optionsList.add(new Item("SesameBread", 140.0, true, 20, 8, 0));
        optionsList.add(new Item("RyeBread", 259.0, true, 48, 8, 0));
        optionsList.add(new Item("WholewheatBread", 265.0, true, 40, 8, 0));
        optionsList.add(new Item("PotatoBread", 266.0, true, 33, 8, 0));
        optionsList.add(new Item("JackBread", 100.0, true, 100, 8, 0));
        optionsList.add(new Item("AngusBeef", 164.0, true, 144, 8, 0));
        optionsList.add(new Item("WagyuBeef", 250.0, true, 795, 8, 0));
        optionsList.add(new Item("TapaBeef", 187.75, true, 56, 8, 0));
        optionsList.add(new Item("CheesedBeef", 373.0, true, 214, 8, 0));
        optionsList.add(new Item("CanadianBacon", 185.0, true, 140, 8, 0));
        optionsList.add(new Item("ChickenSchnitzel", 297.0, true, 175, 8, 0));
        optionsList.add(new Item("SalmonPatty", 208.0, true, 300, 8, 0));
        optionsList.add(new Item("BronzeTurkey", 189.0, true, 185, 8, 0));
        optionsList.add(new Item("BeyondBeef", 210.0, true, 330, 8, 0));
        optionsList.add(new Item("JackBeef", 100.0, true, 100, 8, 0));
        optionsList.add(new Item("WhiteOnions", 40.0, false, 30, 8, 0));
        optionsList.add(new Item("OnionRings", 205.5, false, 85, 8, 0));
        optionsList.add(new Item("TrappistCheese", 355.0, false, 140, 8, 0));
        optionsList.add(new Item("MozzarelaCheese", 140.0, false, 75, 8, 0));
        optionsList.add(new Item("BlueCheese", 177.0, false, 105, 8, 0));
        optionsList.add(new Item("AmericanCheese", 177.0, false, 40, 8, 0));
        optionsList.add(new Item("MeltedButter", 307.5, false, 60, 8, 0));
        optionsList.add(new Item("BeefsteakTomato", 18.0, false, 50, 8, 0));
        optionsList.add(new Item("IcebergLettuce", 3.0, false, 45, 8, 0));
        optionsList.add(new Item("DillPickles", 11.0, false, 45, 8, 0));
        optionsList.add(new Item("HotSauce", 11.0, false, 50, 8, 0));
        optionsList.add(new Item("BarbequeSauce", 172.0, false, 70, 8, 0));
        optionsList.add(new Item("CaviarSauce", 252.0, false, 330, 8, 0));
        optionsList.add(new Item("JackSauce", 10.0, false, 10, 8, 0));
    }

    // create populateOptionsList(), decide whether if its thru code or text file. 
    // create checkStock(stock) to see if there is enough stock to be sold (stock < 0). might be in productdisp

    public Item(String name, double calories, boolean standalone, int price, int stock, int sold){ // Constructor for Item.
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