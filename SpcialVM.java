/*MAIN TASKS: contains additional attributes to VM  (food type, recipelist and numIngredients each, available preset recipes)
 *			: getters and setters
 */
 
import java.util.ArrayList;

public class SpecialVM extends VendingMachine {
	private ArrayList<Recipe> presetRecpieList;
	private ArrayList<Recipe> recipeList;
	protected SpecialIR spir;
	
	public SpecialVM(String machineName, int totalSales, int lastTotalSales) {
		super(machineName, totalSales, lastTotalSales);
		this.presetRecpieList = new ArrayList<Recipe>();
		this.loadRecipes();
		this.recipeList = new ArrayList<Recipe>();
		this.spir = new SpecialIR();
	}
	
	private void loadRecipes() {
		this.newRecipe("ClassicBurger", 1);
		this.addToRecipe("ClassicBurger", new Bread("SesameBread", 140.0, true, 20, 2));
		this.addToRecipe("ClassicBurger", new Meat("AngusBeef", 164.0, true, 144, 1));
		this.addToRecipe("ClassicBurger", new Topping("AmericanCheese", 177.0, false, 40, 1));
		this.addToRecipe("ClassicBurger", new Topping("WhiteOnions", 40.0, false, 30, 1));
		this.addToRecipe("ClassicBurger", new Condiment("BarbequeSauce", 172.0, false, 70, 1));
		
		this.newRecipe("CheesyCheeseburger", 2);
		this.addToRecipe("CheesyCheeseburger", new Bread("WholewheatBread", 265.0, true, 40, 2));
		this.addToRecipe("CheesyCheeseburger", new Meat("CheesedBeef", 373.0, true, 214, 1));
		this.addToRecipe("CheesyCheeseburger", new Topping("MozzarelaCheese", 140.0, false, 75, 1));
		this.addToRecipe("CheesyCheeseburger", new Topping("BlueCheese", 177.0, false, 105, 1));
		this.addToRecipe("CheesyCheeseburger", new Condiment("JackSauce", 10.0, false, 10, 1));
		this.addToRecipe("CheesyCheeseburger", new Topping("IcebergLettuce", 3.0, false, 45, 1));
		this.addToRecipe("CheesyCheeseburger", new Topping("OnionRings", 205.5, false, 85, 1));
		
		this.newRecipe("BeyondBurger", 3);
		this.addToRecipe("BeyondBurger", new Bread("WholewheatBread", 265.0, true, 40, 2));
		this.addToRecipe("BeyondBurger", new Meat("BeyondBeef", 210.0, true, 330, 2));
		this.addToRecipe("BeyondBurger", new Topping("MozzarelaCheese", 140.0, false, 75, 2));
		this.addToRecipe("BeyondBurger", new Topping("OnionRings", 205.5, false, 85, 1));
		this.addToRecipe("BeyondBurger", new Topping("IcebergLettuce", 3.0, false, 45, 1));
		this.addToRecipe("BeyondBurger", new Condiment("HotSauce", 11.0, false, 50, 1));
		this.addToRecipe("BeyondBurger", new Condiment("JackSauce", 10.0, false, 10, 1));
		
		this.newRecipe("GourmetBurger", 4);
		this.addToRecipe("GourmetBurger", new Bread("BriocheBread", 346.0, true, 34, 2));
		this.addToRecipe("GourmetBurger", new Meat("WienerSchnitzel", 297.0, true, 175, 1));
		this.addToRecipe("GourmetBurger", new Topping("TrappistCheese", 355.0, false, 140, 1));
		this.addToRecipe("GourmetBurger", new Topping("BeefsteakTomato", 18.0, false, 50, 1));
		this.addToRecipe("GourmetBurger", new Topping("IcebergLettuce", 3.0, false, 45, 1));
		this.addToRecipe("GourmetBurger", new Topping("DillPickles", 11.0, false, 45, 1));
		this.addToRecipe("GourmetBurger", new Topping("OnionRings", 205.5, false, 85, 1));
		this.addToRecipe("GourmetBurger", new Topping("MeltedButter", 307.5, false, 60, 1));
		
		this.newRecipe("JackBurger", 5);
		this.addToRecipe("JackBurger", new Bread("JackBread", 100.0, true, 100, 2));
		this.addToRecipe("JackBurger", new Meat("JackBeef", 100.0, true, 100, 1));
		this.addToRecipe("JackBurger", new Topping("TrappistCheese", 355.0, false, 140, 1));
		this.addToRecipe("JackBurger", new Topping("MozzarelaCheese", 140.0, false, 75, 1));
		this.addToRecipe("JackBurger", new Condiment("JackSauce", 10.0, false, 10, 1));
		this.addToRecipe("JackBurger", new Topping("WhiteOnions", 40.0, false, 30, 1));
		this.addToRecipe("JackBurger", new Topping("BeefsteakTomato", 18.0, false, 50, 1));
		
		this.newRecipe("MeatOverloadBurger", 6);
		this.addToRecipe("MeatOverloadBurger", new Bread("RyeBread", 259.0, true, 48, 2));
		this.addToRecipe("MeatOverloadBurger", new Meat("WagyuBeef", 250.0, true, 795, 2));
		this.addToRecipe("MeatOverloadBurger", new Meat("CanadianBacon", 185.0, true, 140, 2));
		this.addToRecipe("MeatOverloadBurger", new Topping("MozzarelaCheese", 140.0, false, 75, 2));
		this.addToRecipe("MeatOverloadBurger", new Condiment("BarbequeSauce", 172.0, false, 70, 1));
		this.addToRecipe("MeatOverloadBurger", new Topping("IcebergLettuce", 3.0, false, 45, 1));
		this.addToRecipe("MeatOverloadBurger", new Topping("DillPickles", 11.0, false, 45, 1));
		
		this.newRecipe("SpicyTapaBurger", 7);
		this.addToRecipe("SpicyTapaBurger", new Bread("PotatoBread", 266.0, true, 33, 2));
		this.addToRecipe("SpicyTapaBurger", new Meat("TapaBeef", 187.75, true, 56, 1));
		this.addToRecipe("SpicyTapaBurger", new Topping("TrappistCheese", 355.0, false, 140, 1));
		this.addToRecipe("SpicyTapaBurger", new Topping("WhiteOnions", 40.0, false, 30, 1));
		this.addToRecipe("SpicyTapaBurger", new Topping("IcebergLettuce", 3.0, false, 45, 1));
		this.addToRecipe("SpicyTapaBurger", new Topping("DillPickles", 11.0, false, 45, 1));
		this.addToRecipe("SpicyTapaBurger", new Topping("BeefsteakTomato", 18.0, false, 50, 1));
		this.addToRecipe("SpicyTapaBurger", new Condiment("JackSauce", 10.0, false, 10, 1));
		
		this.newRecipe("SalmonBurger", 8);
		this.addToRecipe("SalmonBurger", new Bread("BriocheBread", 346.0, true, 34, 2));
		this.addToRecipe("SalmonBurger", new Meat("GrilledSalmon", 208.0, true, 300));
		this.addToRecipe("SalmonBurger", new Topping("MozzarelaCheese", 140.0, false, 75, 1));
		this.addToRecipe("SalmonBurger", new Topping("IcebergLettuce", 3.0, false, 45, 1));
		this.addToRecipe("SalmonBurger", new Condiment("CaviarSauce", 252.0, false, 330, 1));
		
		this.newRecipe("TurkeyBurger", 9);
		this.addToRecipe("TurkeyBurger", new Bread("RyeBread", 259.0, true, 48, 2));
		this.addToRecipe("TurkeyBurger", new Meat("BronzeTurkey", 189.0, true, 185, 1));
		this.addToRecipe("TurkeyBurger", new Topping("AmericanCheese", 177.0, false, 40, 1));
		this.addToRecipe("TurkeyBurger", new Topping("IcebergLettuce", 3.0, false, 45, 1));
		this.addToRecipe("TurkeyBurger", new Condiment("BarbequeSauce", 172.0, false, 70, 1));
		this.addToRecipe("TurkeyBurger", new Condiment("JackSauce", 10.0, false, 10, 1));
	}
	
	public void newRecipe(String name, int grid) {
		this.recipeList.add(new Recipe(name, grid));
	}
		
	public void addToRecipe(String name, Ingredient i) {
		Recipe temp;
		
		for(Recipe r : recipeList) {
			if(r.getName().equals(name)) {
				temp = r;
			}
		}
		
		temp.addIngredient(i);
	}
	
	public ArrayList<Recipe> getPresetRecipes() {
		return this.presetRecpieList;
	}
	
	public ArrayList<Recipe> getRecipeList() {
		return this.recipeList;
	}
}