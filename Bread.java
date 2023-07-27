/*MAIN TASKS: exist
 */
 
public class Bread extends Ingredient {
	public Bread(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}

	@Override
	public String narrate() {
		String narration = "Baking " + name + "...";
		return narration;
	}
}