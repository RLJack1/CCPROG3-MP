/*MAIN TASKS: exist
 */
 
public class Topping extends Ingredient {
	public Topping(String name, double calories, boolean standalone, int price, int grid) {
		super(name, calories, standalone, price, grid);
	}
	
	public Topping(String name, double calories, boolean standalone, int price, int grid, int quantity) {
		super(name, calories, standalone, price, grid, quantity);
	}
	
	@Override
	public String narrate() {
		String narration = "Sprinkling " + name + "...";
		return narration;
	}
}