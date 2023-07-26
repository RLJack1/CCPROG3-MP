/*MAIN TASKS: exist
 */
 
public class Topping extends Ingredient {
	public Topping(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	@Override
	public String narrate() {
		String narration = "Sprinkling " + name + "...";
		return narration;
	}
}