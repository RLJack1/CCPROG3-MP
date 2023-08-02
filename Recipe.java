import java.util.ArrayList;

/** 
  * Stores the list of ingredients for one recipe 
  */
public class Recipe {
	 private String name;
	 private ArrayList<Ingredient> ingredientList;
	 
	 /** 
      * A constructor that creates an instance of a Recipe object
	  * @param name The name of the Recipe
      */
	 public Recipe(String name) {
		 this.name = name;
		 this.ingredientList = new ArrayList<Ingredient>();
	 }
	 
	 /** 
      * Adds an ingredient to this Recipe
	  * @param i The ingredient object to be added
      */
	 public void addIngredient(Ingredient i) {
		 this.ingredientList.add(i);
	 }
	 
	 /** 
      * Gets and returns the name of this Recipe
	  * @return The name of the Recipe
      */
	 public String getName() {
		 return this.name;
	 }
	 
	 /** 
      * Gets and returns total number of calories this Recipe
	  * @return The total calories
      */
	 public double getCalories() {
		double totalCalories = 0;
		
		for(Ingredient i : this.ingredientList) {
			totalCalories += i.getCalories();
		}
		
		return totalCalories;
	 }
	 
	 /** 
      * Gets and returns price of this Recipe
	  * @return The price of this Recipe
      */
	 public int getPrice() {
		 int totalPrice = 0;
		 
		 for(Ingredient i : this.ingredientList) {
			 totalPrice += i.getPrice();
		 }
		 
		 return totalPrice;
	 }
	 
	 /** 
      * Gets and returns the recipe preparation
	  * @return The plain text of the narration
      */
	 public String getNarration() {
		StringBuilder toDisplay = new StringBuilder();
		
		toDisplay.append("\n");
		
		for (Ingredient i : this.ingredientList) {
            if (i instanceof Bread) {
                Bread x = (Bread) i;
                toDisplay.append(x.narrate()).append("\n");
            } 
		}
		
		for (Ingredient i : this.ingredientList) {
            if (i instanceof Meat) {
                Meat x = (Meat) i;
                toDisplay.append(x.narrate()).append("\n");
            } 
		}
		
		for (Ingredient i : this.ingredientList) {
            if (i instanceof Condiment) {
                Condiment x = (Condiment) i;
                toDisplay.append(x.narrate()).append("\n");
            } 
		}
		
		for (Ingredient i : this.ingredientList) {
            if (i instanceof Topping) {
                Topping x = (Topping) i;
                toDisplay.append(x.narrate()).append("\n");
            } 
		}
		
		toDisplay.append("Putting it all together...");
		
		return toDisplay.toString();
	 }
	 
	 /** 
      * Gets and returns list of ingredients for this Recipe
	  * @return The list of ingredients
      */
	 public ArrayList<Ingredient> getIngredientList() {
		 return this.ingredientList;
	 }
 }