/*MAIN TASKS: contains additional attributes to VM  (food type, recipelist and numIngredients each, available preset recipes)
 *			: getters and setters
 */

public class SpecialVM extends VendingMachine {
	private ArrayList<Recipe> presetRecpieList;
	private ArrayList<Recipe> recipeList;
	
	public SpecialVM(String machineName, int totalSales, int lastTotalSales) {
		super(machineName, totalSales, lastTotalSales);
		this.presetRecpieList = loadRecipes();
		this.recipeList = new ArrayList<Recipe>();
	}
	
	private void loadRecipes() {
		ArrayList<Recipe> presetRecpieList = new ArrayList<Recipe>();
		
		//load everything into here
	}
	
	public void addToRecipe(String name, Ingredient i) {
		boolean exists = false;
		private Recipe temp;
		
		for(Recipe r : recipeList) {
			if(r.getName().equals(name)) {
				exists = true;
				temp = r;
			}
				
		}
		
		if(exists == false) {
			this.recipeList.add(new Recipe(name));
		}
		
		else
			temp.addIngredient(i);
	}
	
	public void autoAddItems() {
		ir.loadItems(recipeList);
	}
	
	public ArrayList<Recipe> getPresetRecipes() {
		return this.presetRecpieList;
	}
	
	public ArrayList<Recipe> getRecipeList() {
		return this.recipeList;
	}
}