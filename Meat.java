/*MAIN TASKS: exist
 */
 
public class Meat extends Ingredient {
	public Meat(String name, double calories, boolean standalone, int price, int grid) {
		super(name, calories, standalone, price, grid);
	}
	
	public Meat(String name, double calories, boolean standalone, int price, int grid, int quantity) {
		super(name, calories, standalone, price, grid, quantity);
	}
	
	@Override
	public String narrate() {
		String narration = "Cooking " + name + "...";
		return narration;
	}
}