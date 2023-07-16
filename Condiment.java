/*MAIN TASKS: exist
 */
 
public class Condiment extends Ingredient {
	public Condiment(String name, double calories, boolean standalone, int price, int quantity) {
		super(name, calories, standalone, price, quantity);
	}
	
	@Override
	public String narrate() {
		String narration = "Pouring " + name + "...";
		return narration;
	}
}