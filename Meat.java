/*MAIN TASKS: exist
 */
 
public class Meat extends Ingredient {
	public Meat(String name, double calories, boolean standalone, int price, int quantity) {
		super(name, calories, standalone, price, quantity);
	}
	
	@Override
	public String narrate() {
		String narration = "Cooking " + name + "...";
		return narration;
	}
}