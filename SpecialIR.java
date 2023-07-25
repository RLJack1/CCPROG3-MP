/*MAIN TASKS: handles recipes and ingredients
 *			: getters and setters
 */

import java.util.ArrayList;
 
public class SpecialIR extends ItemRack {
	public SpecialIR() {
	}
	
	@Override
	public void loadItems() {
		this.presetItemList.add(new Bread("BriocheBread", 346.0, true, 34, 1));
        this.presetItemList.add(new Bread("SesameBread", 140.0, true, 20, 2));
        this.presetItemList.add(new Bread("RyeBread", 259.0, true, 48, 3));
        this.presetItemList.add(new Bread("WholewheatBread", 265.0, true, 40, 4));
        this.presetItemList.add(new Bread("PotatoBread", 266.0, true, 33, 5));
        this.presetItemList.add(new Bread("JackBread", 100.0, true, 100, 6));
        this.presetItemList.add(new Meat("AngusBeef", 164.0, true, 144, 7));
        this.presetItemList.add(new Meat("WagyuBeef", 250.0, true, 795, 8));
        this.presetItemList.add(new Meat("TapaBeef", 187.75, true, 56, 9));
        this.presetItemList.add(new Meat("CheesedBeef", 373.0, true, 214, 10));
        this.presetItemList.add(new Meat("CanadianBacon", 185.0, true, 140, 11));
        this.presetItemList.add(new Meat("WienerSchnitzel", 297.0, true, 175, 12));
        this.presetItemList.add(new Meat("GrilledSalmon", 208.0, true, 300, 13));
        this.presetItemList.add(new Meat("BronzeTurkey", 189.0, true, 185, 14));
        this.presetItemList.add(new Meat("BeyondBeef", 210.0, true, 330, 15));
        this.presetItemList.add(new Meat("JackBeef", 100.0, true, 100, 16));
		
        this.presetItemList.add(new Topping("WhiteOnions", 40.0, false, 30, 17));
        this.presetItemList.add(new Topping("OnionRings", 205.5, false, 85, 18));
        this.presetItemList.add(new Topping("TrappistCheese", 355.0, false, 140, 19));
        this.presetItemList.add(new Topping("MozzarelaCheese", 140.0, false, 75, 20));
        this.presetItemList.add(new Topping("BlueCheese", 177.0, false, 105, 21));
        this.presetItemList.add(new Topping("AmericanCheese", 177.0, false, 40, 22));
        this.presetItemList.add(new Topping("MeltedButter", 307.5, false, 60, 23));
        this.presetItemList.add(new Topping("BeefsteakTomato", 18.0, false, 50, 24));
        this.presetItemList.add(new Topping("IcebergLettuce", 3.0, false, 45, 25));
        this.presetItemList.add(new Topping("DillPickles", 11.0, false, 45, 26));
        this.presetItemList.add(new Condiment("HotSauce", 11.0, false, 50, 27));
        this.presetItemList.add(new Condiment("BarbequeSauce", 172.0, false, 70, 28));
        this.presetItemList.add(new Condiment("CaviarSauce", 252.0, false, 330, 29));
        this.presetItemList.add(new Condiment("JackSauce", 10.0, false, 10, 30));
	}
	
	@Override
	public void addFullStock(Ingredient i, int stock) {
		int j;
		
		if(i instanceof Bread)
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Bread(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
			
		else if(i instanceof Meat)
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Meat(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
			
		else if(i instanceof Topping)
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Topping(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
			
		else if(i instanceof Condiment)
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Condiment(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
			
		else if(i instanceof Ingredient)
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Ingredient(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
	}
	
	public void autoAddItems(ArrayList<Recipe> recipeList) {
		for(Recipe r : recipeList) {
			for(Ingredient i : r.getIngredientList()) {
				this.addFullStock(i, 8);
			}
		}
	}
}