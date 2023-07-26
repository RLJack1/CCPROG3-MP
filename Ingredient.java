/*MAIN TASKS: contain ingredient quantity
 */
 
abstract public class Ingredient extends Item {
	public Ingredient(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	abstract public String narrate();
}