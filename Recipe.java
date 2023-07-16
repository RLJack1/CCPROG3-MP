/*MAIN TASKS: contain recipe data
			: getters and setters
 */
 
import java.util.ArrayList;

public class Recipe {
	 private String name;
	 private ArrayList<Ingredient> ingredientList;
	 
	 public Recipe(String name) {
		 this.ingredientList = new ArrayList<Ingredient>();
	 }
	 
	 public void addIngredient(Ingredient i) {
		 this.ingredientList.add(i);
	 }
	 
	 public String getName() {
		 return this.name;
	 }
	 
	 public ArrayList<Ingredient> getIngredientList() {
		 return this.ingredientList;
	 }
 }