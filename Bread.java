/*MAIN TASKS: exist
 */
 
public class Bread extends Ingredient {
	public Bread(String name, double calories, boolean standalone, int price, int grid) {
		super(name, calories, standalone, price, grid);
	}
	
	public Bread(String name, double calories, boolean standalone, int price, int grid, int quantity) {
		super(name, calories, standalone, price, grid, quantity);
	}
	
	@Override
	public String narrate() {
		String narration = "Baking " + name + "...";
		return narration;
	}
}