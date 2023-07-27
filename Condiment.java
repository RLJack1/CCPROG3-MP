/*MAIN TASKS: exist
 */
 
public class Condiment extends Ingredient {
	public Condiment(String name, double calories, boolean standalone, int price) {
		super(name, calories, standalone, price);
	}
	
	@Override
	public String narrate() {
		String narration = "Pouring " + name + "...";
		return narration;
	}
}