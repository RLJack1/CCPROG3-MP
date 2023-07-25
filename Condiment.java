/*MAIN TASKS: exist
 */
 
public class Condiment extends Ingredient {
	public Condiment(String name, double calories, boolean standalone, int price, int grid) {
		super(name, calories, standalone, price, grid);
	}
	
	public Condiment(String name, double calories, boolean standalone, int price, int grid, int quantity) {
		super(name, calories, standalone, price, grid, quantity);
	}
	
	@Override
	public String narrate() {
		String narration = "Pouring " + name + "...";
		return narration;
	}
}