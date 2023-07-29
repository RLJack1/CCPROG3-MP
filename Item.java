/** 
  * Stores and operates on Item attributes like name, calories, standalone status, and price
  */
public class Item {
    protected final String name;
    private final double calories;
    private final boolean standalone;
    private int price;

	/** 
      * A constructor that creates an Item instance given
	  * @param name 		The item's name
	  * @param calories		The decimal amount of calories the item contains
	  * @param standalone	Whether or not the item can be sold alone
	  * @param price		The cost of the item
      */
    public Item(String name, double calories, boolean standalone, int price) { 
        this.name = name;
        this.calories = calories;
		this.standalone = standalone;
        this.price = price;
    }

	/** 
      * Gets and returns the item's name
	  * @return The item's name
      */
    public String getName() {
        return this.name;
    }

	/** 
      * Gets and returns the item's calorie measurement
	  * @return The item's decimal calorie measurement
      */
    public double getCalories() {
        return this.calories;
    }

	/** 
      * Gets and returns the item's standalone status
	  * @return Whether or not the item can be sold alone
      */
    public boolean getStandalone() {
        return this.standalone;
    }

	/** 
      * Gets and returns the item's price
	  * @return The item's price
      */
    public int getPrice() {
        return this.price;
    }
	
	/** 
      * Changes the item's current price to a new amount
	  * @param newPrice The updated cost of the item
      */
    public void setPrice(int newPrice){
        this.price = newPrice;   
    }
}