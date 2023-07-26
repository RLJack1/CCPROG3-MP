/*MAIN TASKS: contain recipe data
			: getters and setters
 */
 
import java.util.ArrayList;

public class Recipe {
	 private String name;
	 private ArrayList<Ingredient> ingredientList;
	 
	 public Recipe(String name) {
		 this.name = name;
		 this.ingredientList = new ArrayList<Ingredient>();
	 }
	 
	 public void addIngredient(Ingredient i) {
		 this.ingredientList.add(i);
	 }
	 
	 public String getName() {
		 return this.name;
	 }
	 
	 public double getCalories() {
		double totalCalories = 0;
		
		for(Ingredient i : this.ingredientList) {
			totalCalories += i.getCalories();
		}
		
		return totalCalories;
	 }
	 
	 public int getPrice() {
		 int totalPrice = 0;
		 
		 for(Ingredient i : this.ingredientList) {
			 totalPrice += i.getPrice();
		 }
		 
		 return totalPrice;
	 }
	 
	 public String getNarration() {
		String toDisplay = "";
		
		//this currently goes in the order of the ingredients in the list, so there's a chance na maging weird ung order -> tofix
		for (Ingredient i : this.ingredientList) {
            if (i instanceof Bread) {
                Bread b = (Bread) i;
                toDisplay.concat(b.narrate());
            } 
			
			else if (i instanceof Meat) {
                Meat m = (Meat) i;
                toDisplay.concat(m.narrate());
            } 
			
			else if (i instanceof Condiment) {
                Condiment c = (Condiment) i;
                toDisplay.concat(c.narrate());
            } 
			
			else if (i instanceof Topping) {
                Topping t = (Topping) i;
                toDisplay.concat(t.narrate());
            }
        }
		
		return toDisplay;
	 }
	 
	 public ArrayList<Ingredient> getIngredientList() {
		 return this.ingredientList;
	 }
 }