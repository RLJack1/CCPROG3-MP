/*MAIN TASKS: contain ingredient quantity
 */
 
abstract public class Ingredient extends Item {
	final protected int quantity;
	
	public Ingredient(String name, double calories, boolean standalone, int price, int grid) {
		super(name, calories, standalone, price, grid);
	}
	
	public Ingredient(String name, double calories, boolean standalone, int price, int grid, int quantity) {
		super(name, calories, standalone, price, grid);
		this.quantity = quantity;
	}
	
	abstract public String narrate() {
		String narration = "Preparing " + name + "...";
		return narration;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
}