/** 
  * Defines the logic for the narration feature from Ingredient
  */
public class Condiment extends Ingredient {
	/** 
	  * Creates an instance of the Condiment object
	  * @param name			The name of the Condiment
	  * @param calories 	The number of calories per serving
	  * @param standalone	Whether it can be sold individually
	  * @param price		The cost of one serving
	  */
	public Condiment(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	/** 
	  * Defines the narration specific to Condiments
	  * @return The string of the narration
	  */
	@Override
	public String narrate() {
		String narration = "Pouring " + name + "...";
		return narration;
	}
}