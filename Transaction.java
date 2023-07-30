import java.util.ArrayList;

/** 
  * Stores all information associated with one user purchase
  */
public class Transaction {
	private String name;
	private ArrayList<Ingredient> ingredientList;
	private int lastTotalSales;
	private int totalSales;
	
	/** 
	  * Creates an instance of the Transaction object for an individual item
	  * @param name				The name of the product purchased
	  * @param lastTotalSales	The last amount of sales since last restocking
	  * @param totalSales		The current amount of sales since last restocking
	  */
	public Transaction(String name, int lastTotalSales, int totalSales) {
		this.name = name;
		this.ingredientList = null;
		this.lastTotalSales = lastTotalSales;
		this.totalSales = totalSales;
	}
	
	/** 
	  * Creates an instance of the Transaction object for a recipe
	  * @param selectedRecipe	The recipe purchased
	  * @param lastTotalSales	The last amount of sales since last restocking
	  * @param totalSales		The current amount of sales since last restocking
	  */
	public Transaction(Recipe selectedRecipe, int lastTotalSales, int totalSales) {
		this.name = selectedRecipe.getName();
		this.ingredientList = selectedRecipe.getIngredientList();
		this.lastTotalSales = lastTotalSales;
		this.totalSales = totalSales;
	}
	
	/** 
	  * Gets and returns the name of the product purchased for this Transaction
	  * @return The name of the product purchased
	  */
	public String getName() {
		return this.name;
	}
	
	/** 
	  * Gets and returns the last amount of sales since last restocking
	  * @return The previous amount of sales
	  */
	public int getLastTotalSales() {
		return this.lastTotalSales;
	}
	
	/** 
	  * Gets and returns the amount of sales since last restocking
	  * @return The amount of sales
	  */
	public int getTotalSales() {
		return this.totalSales;
	}
	
	/** 
      * Gets and returns list of ingredients for this Transaction
	  * @return The list of ingredients
      */
	public ArrayList<Ingredient> getIngredientList() {
		return this.ingredientList;
	}
}