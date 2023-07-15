/*MAIN TASKS: exist
 */
 
public class Topping extends Ingredient {
	public Topping(String name, double calories, boolean standalone, int price, int quantity) {
		super(name, calories, standalone, price, quantity);
	}
	
	@Override
	public String narrate() {
		String narration = "Sprinkling " + name "...";
		return narration;
	}
}