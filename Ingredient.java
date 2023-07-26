/*MAIN TASKS: contain ingredient quantity
 */
 
abstract public class Ingredient extends Item {
	protected int quantity = 0;
	
	public Ingredient(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	public Ingredient(String name, double calories, boolean standalone, int price, int quantity) {
		super(name, calories, standalone, price);
		this.quantity = quantity;
	}
	
	abstract public String narrate();
	
	public int getQuantity() {
		return this.quantity;
	}
}