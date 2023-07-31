import java.util.ArrayList;

/** 
  * Includes special Vending Machine features like recipe storage and sales
  */
public class SpecialVM extends VendingMachine {
	private ArrayList<Recipe> recipeList;
	protected SpecialIR spir;
	private String[] indexList = {"ClassicBurger", "CheesyCheeseburger", "BeyondBurger",
									"GourmetBurger", "JackBurger", "MeatOverloadBurger",
									"SpicyTapaBurger", "SalmonBurger", "TurkeyBurger"};
	
	/** 
	  * A constructor that creates an instance of a special VendingMachine object.
	  * @param c				The controller wherein the special Vending Machine was instantiated
	  * @param machineName		The name of this special Vending Machine
	  * @param totalSales		The current total sales since last restock
	  * @param lastTotalSales	The last total sales since last restock
	  */
	public SpecialVM(VMController c, String machineName, int totalSales, int lastTotalSales) {
		super(c, machineName, totalSales, lastTotalSales);
		this.recipeList = new ArrayList<Recipe>();
		this.loadRecipes();
		this.spir = new SpecialIR();
	}
	
	/** 
	  * Loads the preset recipes into the Recipe List
	  */
	private void loadRecipes() {
		this.newRecipe("ClassicBurger");
		this.addToRecipe("ClassicBurger", new Bread("SesameBread", 140.0, true, 20));
		this.addToRecipe("ClassicBurger", new Bread("SesameBread", 140.0, true, 20));
		this.addToRecipe("ClassicBurger", new Meat("AngusBeef", 164.0, true, 144));
		this.addToRecipe("ClassicBurger", new Topping("AmericanCheese", 177.0, false, 40));
		this.addToRecipe("ClassicBurger", new Topping("WhiteOnions", 40.0, false, 30));
		this.addToRecipe("ClassicBurger", new Condiment("BarbequeSauce", 172.0, false, 70));
		
		this.newRecipe("CheesyCheeseburger");
		this.addToRecipe("CheesyCheeseburger", new Bread("WholewheatBread", 265.0, true, 40));
		this.addToRecipe("CheesyCheeseburger", new Bread("WholewheatBread", 265.0, true, 40));
		this.addToRecipe("CheesyCheeseburger", new Meat("CheesedBeef", 373.0, true, 214));
		this.addToRecipe("CheesyCheeseburger", new Topping("MozzarelaCheese", 140.0, false, 75));
		this.addToRecipe("CheesyCheeseburger", new Topping("BlueCheese", 177.0, false, 105));
		this.addToRecipe("CheesyCheeseburger", new Condiment("JackSauce", 10.0, false, 10));
		this.addToRecipe("CheesyCheeseburger", new Topping("IcebergLettuce", 3.0, false, 45));
		this.addToRecipe("CheesyCheeseburger", new Topping("OnionRings", 205.5, false, 85));
		
		this.newRecipe("BeyondBurger");
		this.addToRecipe("BeyondBurger", new Bread("WholewheatBread", 265.0, true, 40));
		this.addToRecipe("BeyondBurger", new Bread("WholewheatBread", 265.0, true, 40));
		this.addToRecipe("BeyondBurger", new Meat("BeyondBeef", 210.0, true, 330));
		this.addToRecipe("BeyondBurger", new Meat("BeyondBeef", 210.0, true, 330));
		this.addToRecipe("BeyondBurger", new Topping("MozzarelaCheese", 140.0, false, 75));
		this.addToRecipe("BeyondBurger", new Topping("MozzarelaCheese", 140.0, false, 75));
		this.addToRecipe("BeyondBurger", new Topping("OnionRings", 205.5, false, 85));
		this.addToRecipe("BeyondBurger", new Topping("IcebergLettuce", 3.0, false, 45));
		this.addToRecipe("BeyondBurger", new Condiment("HotSauce", 11.0, false, 50));
		this.addToRecipe("BeyondBurger", new Condiment("JackSauce", 10.0, false, 10));
		
		this.newRecipe("GourmetBurger");
		this.addToRecipe("GourmetBurger", new Bread("BriocheBread", 346.0, true, 34));
		this.addToRecipe("GourmetBurger", new Bread("BriocheBread", 346.0, true, 34));
		this.addToRecipe("GourmetBurger", new Meat("WienerSchnitzel", 297.0, true, 175));
		this.addToRecipe("GourmetBurger", new Topping("TrappistCheese", 355.0, false, 140));
		this.addToRecipe("GourmetBurger", new Topping("BeefsteakTomato", 18.0, false, 50));
		this.addToRecipe("GourmetBurger", new Topping("IcebergLettuce", 3.0, false, 45));
		this.addToRecipe("GourmetBurger", new Topping("DillPickles", 11.0, false, 45));
		this.addToRecipe("GourmetBurger", new Topping("OnionRings", 205.5, false, 85));
		this.addToRecipe("GourmetBurger", new Topping("MeltedButter", 307.5, false, 60));
		
		this.newRecipe("JackBurger");
		this.addToRecipe("JackBurger", new Bread("JackBread", 100.0, true, 100));
		this.addToRecipe("JackBurger", new Bread("JackBread", 100.0, true, 100));
		this.addToRecipe("JackBurger", new Meat("JackBeef", 100.0, true, 100));
		this.addToRecipe("JackBurger", new Topping("TrappistCheese", 355.0, false, 140));
		this.addToRecipe("JackBurger", new Topping("MozzarelaCheese", 140.0, false, 75));
		this.addToRecipe("JackBurger", new Condiment("JackSauce", 10.0, false, 10));
		this.addToRecipe("JackBurger", new Topping("WhiteOnions", 40.0, false, 30));
		this.addToRecipe("JackBurger", new Topping("BeefsteakTomato", 18.0, false, 50));
		
		this.newRecipe("MeatOverloadBurger");
		this.addToRecipe("MeatOverloadBurger", new Bread("RyeBread", 259.0, true, 48));
		this.addToRecipe("MeatOverloadBurger", new Bread("RyeBread", 259.0, true, 48));
		this.addToRecipe("MeatOverloadBurger", new Meat("WagyuBeef", 250.0, true, 795));
		this.addToRecipe("MeatOverloadBurger", new Meat("WagyuBeef", 250.0, true, 795));
		this.addToRecipe("MeatOverloadBurger", new Meat("CanadianBacon", 185.0, true, 140));
		this.addToRecipe("MeatOverloadBurger", new Meat("CanadianBacon", 185.0, true, 140));
		this.addToRecipe("MeatOverloadBurger", new Topping("MozzarelaCheese", 140.0, false, 75));
		this.addToRecipe("MeatOverloadBurger", new Topping("MozzarelaCheese", 140.0, false, 75));
		this.addToRecipe("MeatOverloadBurger", new Condiment("BarbequeSauce", 172.0, false, 70));
		this.addToRecipe("MeatOverloadBurger", new Topping("IcebergLettuce", 3.0, false, 45));
		this.addToRecipe("MeatOverloadBurger", new Topping("DillPickles", 11.0, false, 45));
		
		this.newRecipe("SpicyTapaBurger");
		this.addToRecipe("SpicyTapaBurger", new Bread("PotatoBread", 266.0, true, 33));
		this.addToRecipe("SpicyTapaBurger", new Bread("PotatoBread", 266.0, true, 33));
		this.addToRecipe("SpicyTapaBurger", new Meat("TapaBeef", 187.75, true, 56));
		this.addToRecipe("SpicyTapaBurger", new Topping("TrappistCheese", 355.0, false, 140));
		this.addToRecipe("SpicyTapaBurger", new Topping("WhiteOnions", 40.0, false, 30));
		this.addToRecipe("SpicyTapaBurger", new Topping("IcebergLettuce", 3.0, false, 45));
		this.addToRecipe("SpicyTapaBurger", new Topping("DillPickles", 11.0, false, 45));
		this.addToRecipe("SpicyTapaBurger", new Topping("BeefsteakTomato", 18.0, false, 50));
		this.addToRecipe("SpicyTapaBurger", new Condiment("JackSauce", 10.0, false, 10));
		
		this.newRecipe("SalmonBurger");
		this.addToRecipe("SalmonBurger", new Bread("BriocheBread", 346.0, true, 34));
		this.addToRecipe("SalmonBurger", new Bread("BriocheBread", 346.0, true, 34));
		this.addToRecipe("SalmonBurger", new Meat("GrilledSalmon", 208.0, true, 300));
		this.addToRecipe("SalmonBurger", new Topping("MozzarelaCheese", 140.0, false, 75));
		this.addToRecipe("SalmonBurger", new Topping("IcebergLettuce", 3.0, false, 45));
		this.addToRecipe("SalmonBurger", new Condiment("CaviarSauce", 252.0, false, 330));
		
		this.newRecipe("TurkeyBurger");
		this.addToRecipe("TurkeyBurger", new Bread("RyeBread", 259.0, true, 48));
		this.addToRecipe("TurkeyBurger", new Bread("RyeBread", 259.0, true, 48));
		this.addToRecipe("TurkeyBurger", new Meat("BronzeTurkey", 189.0, true, 185));
		this.addToRecipe("TurkeyBurger", new Topping("AmericanCheese", 177.0, false, 40));
		this.addToRecipe("TurkeyBurger", new Topping("IcebergLettuce", 3.0, false, 45));
		this.addToRecipe("TurkeyBurger", new Condiment("BarbequeSauce", 172.0, false, 70));
		this.addToRecipe("TurkeyBurger", new Condiment("JackSauce", 10.0, false, 10));
	}
	
	/** 
      * Creates a new recipe in Recipe List
	  * @param name The name of the recipe
      */
	public void newRecipe(String name) {
		this.recipeList.add(new Recipe(name));
	}
		
	/** 
      * Adds an ingredient to an existing recipe
	  * @param name The name of the recipe to be added to
	  * @param i	The ingredient object to be added
      */
	public void addToRecipe(String name, Ingredient i) {
		Recipe temp = new Recipe("");
		
		for(Recipe r : recipeList) {
			if(r.getName().equals(name)) {
				temp = r;
			}
		}
		
		temp.addIngredient(i);
	}
	
	/** 
      * Gets and returns the recipe at the given index
	  * @param index The index of the recipe in Recipe List
	  * @return The recipe at the given index
      */
	public Recipe getRecipeAt(int index) {
		Recipe recipe = null;
		if(this.indexList[index] != null) {
			String name = this.indexList[index];
			
			for(Recipe r : recipeList) {
				if(r.getName().equals(name))
					recipe = r;
			}
		}
		
		return recipe;
	}
	
	/** 
      * Subtracts the needed ingredients for this recipe from the special Item Rack
	  * @param selectedRecipe The recipe the user wants to purchase
	  * @return Whether there was enough stock for the purchase
      */
	public boolean buyRecipe(Recipe selectedRecipe) {
		boolean success = true;
		ArrayList<Item> temp = new ArrayList<Item>();
		
		//Checks if there exist enough stock of every item for every ingredient in the recipe
		//If yes, subtract all
		for(Item i : selectedRecipe.getIngredientList()) {
			if(this.spir.getItemsOnSale().contains(i)) {
				temp.add(i);
				this.spir.removeItem(i);
			}
				
			else
				success = false;
		}
		
		//If stock is insufficient, return all items back
		if(!success)
			this.spir.getItemsOnSale().addAll(temp);
		
		return success;
	}
	
	/** 
      * Gets and returns the list of stored recipes
	  * @return The list of stored recipes
      */
	public ArrayList<Recipe> getRecipeList() {
		return this.recipeList;
	}
}