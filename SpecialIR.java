/*MAIN TASKS: handles recipes and ingredients
 *			: getters and setters
 */
 
public class SpecialIR extends ItemRack {
	public SpecialIR() {
	}
	
	@Override
	public void loadItems() {
		this.presetItemList.add(new Bread("BriocheBread", 346.0, true, 34));
        this.presetItemList.add(new Bread("SesameBread", 140.0, true, 20));
        this.presetItemList.add(new Bread("RyeBread", 259.0, true, 48));
        this.presetItemList.add(new Bread("WholewheatBread", 265.0, true, 40));
        this.presetItemList.add(new Bread("PotatoBread", 266.0, true, 33));
        this.presetItemList.add(new Bread("JackBread", 100.0, true, 100));
        this.presetItemList.add(new Meat("AngusBeef", 164.0, true, 144));
        this.presetItemList.add(new Meat("WagyuBeef", 250.0, true, 795));
        this.presetItemList.add(new Meat("TapaBeef", 187.75, true, 56));
        this.presetItemList.add(new Meat("CheesedBeef", 373.0, true, 214));
        this.presetItemList.add(new Meat("CanadianBacon", 185.0, true, 140));
        this.presetItemList.add(new Meat("WienerSchnitzel", 297.0, true, 175));
        this.presetItemList.add(new Meat("GrilledSalmon", 208.0, true, 300));
        this.presetItemList.add(new Meat("BronzeTurkey", 189.0, true, 185));
        this.presetItemList.add(new Meat("BeyondBeef", 210.0, true, 330));
        this.presetItemList.add(new Meat("JackBeef", 100.0, true, 100));
		
        this.presetItemList.add(new Topping("WhiteOnions", 40.0, false, 30));
        this.presetItemList.add(new Topping("OnionRings", 205.5, false, 85));
        this.presetItemList.add(new Topping("TrappistCheese", 355.0, false, 140));
        this.presetItemList.add(new Topping("MozzarelaCheese", 140.0, false, 75));
        this.presetItemList.add(new Topping("BlueCheese", 177.0, false, 105));
        this.presetItemList.add(new Topping("AmericanCheese", 177.0, false, 40));
        this.presetItemList.add(new Topping("MeltedButter", 307.5, false, 60));
        this.presetItemList.add(new Topping("BeefsteakTomato", 18.0, false, 50));
        this.presetItemList.add(new Topping("IcebergLettuce", 3.0, false, 45));
        this.presetItemList.add(new Topping("DillPickles", 11.0, false, 45));
        this.presetItemList.add(new Condiment("HotSauce", 11.0, false, 50));
        this.presetItemList.add(new Condiment("BarbequeSauce", 172.0, false, 70));
        this.presetItemList.add(new Condiment("CaviarSauce", 252.0, false, 330));
        this.presetItemList.add(new Condiment("JackSauce", 10.0, false, 10));
	}
	
	//assumes that i is from presetItemList
	public String findIngredientType(Ingredient i) {
		String type = "";
		
		if(i.narrate().equals("Baking " + i.getName() + "..."))
			type = "Bread";
		
		else if(i.narrate().equals("Cooking " + i.getName() + "..."))
			type = "Meat";
		
		else if(i.narrate().equals("Sprinkling " + i.getName() + "..."))
			type = "Topping";
		
		else if(i.narrate().equals("Pouring " + i.getName() + "..."))
			type = "Condiment";
		
		return type;
	}
	
	//assumes that i is input from the user, after seeing what's available in presetItemList
	@Override
	public void addFullStock(Ingredient i, int stock) {
		int j;
		String type = this.findIngredientType(i);
		
		if(type.equals("Bread"))
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Bread(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
			
		else if(type.equals("Meat"))
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Meat(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
			
		else if(type.equals("Topping"))
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Topping(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
			
		else if(type.equals("Condiment"))
			for(j = 0; j <= stock; j++) {
				this.itemList.add(new Condiment(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice(), i.getQuantity()));
			}
			
		else if(type.equals(""))
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