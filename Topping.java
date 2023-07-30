/** 
  * Defines the logic for the narration feature from Ingredient
  */
public class Topping extends Ingredient {
	/** 
	  * Creates an instance of the Topping object
	  * @param name			The name of the Topping
	  * @param calories 	The number of calories per serving
	  * @param standalone	Whether it can be sold individually
	  * @param price		The cost of one serving
	  */
	public Topping(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	/** 
	  * Defines the narration specific to Toppings
	  * @return The string of the narration
	  */
	@Override
	public String narrate() {
		String narration = "Sprinkling " + name + "...";
		return narration;
	}
}