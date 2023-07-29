/** 
  * Adds the contract for narrate functionality
  */
abstract public class Ingredient extends Item {
	/** 
      * A constructor that creates an Ingredient instance
	  * @param name 		The ingredient's name
	  * @param calories		The decimal amount of calories the ingredient contains
	  * @param standalone	Whether or not the ingredient can be sold alone
	  * @param price		The cost of the ingredient
      */
	public Ingredient(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	/** 
	  * Sets up and returns the narration for a specific ingredient
	  * @return The plain text of narration to be displayed
	  */
	abstract public String narrate();
}