/*MAIN TASKS: contain ingredient quantity
 */
 
public class Ingredient extends Item {
	final private int quantity;
	
	public Ingredient(String name, double calories, boolean standalone, int price, int quantity) {
		super(name, calories, standalone, price);
		this.quantity = quantity;
	}
	
	public String narrate() {
		String narration = "Preparing " + name + "...";
		return narration;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
}