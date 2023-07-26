/*MAIN TASKS: exist
 */
 
public class Meat extends Ingredient {
	public Meat(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	@Override
	public String narrate() {
		String narration = "Cooking " + name + "...";
		return narration;
	}
}