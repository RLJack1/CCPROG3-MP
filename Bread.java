/*MAIN TASKS: exist
 */
 
public class Bread extends Ingredient {
	public Bread(String name, double calories, boolean standalone, int price, int quantity) {
		super(name, calories, standalone, price, quantity);
	}
	
	@Override
	public String narrate() {
		String narration = "Baking " + name "...";
		return narration;
	}
}