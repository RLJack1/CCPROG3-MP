/** 
  * Defines the logic for the narration feature from Ingredient
  */
public class Meat extends Ingredient {
	/** 
	  * Creates an instance of the Meat object
	  * @param name			The name of this Meat 
	  * @param calories 	The number of calories per serving
	  * @param standalone	Whether it can be sold individually
	  * @param price		The cost of one serving
	  */
	public Meat(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	/** 
	  * Defines the narration specific to Meats
	  * @return The string of the narration
	  */
	@Override
	public String narrate() {
		String narration = "Cooking " + name + "...";
		return narration;
	}
}