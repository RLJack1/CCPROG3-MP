/** 
  * Defines the logic for the narration feature from Ingredient
  */
public class Bread extends Ingredient {
	/** 
	  * Creates an instance of the Bread object
	  * @param name			The name of the Bread
	  * @param calories 	The number of calories per serving
	  * @param standalone	Whether it can be sold individually
	  * @param price		The cost of one serving
	  */
	public Bread(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}

	/** 
	  * Defines the narration specific to Breads
	  * @return The string of the narration
	  */
	@Override
	public String narrate() {
		String narration = "Baking " + name + "...";
		return narration;
	}
}