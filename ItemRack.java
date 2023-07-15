/*MAIN TASKS: stores (available preset items, itemlist)
 *			: getters and setters
 */

public class ItemRack {
	private ArrayList<Item> presetItemList;
	private ArrayList<Item> itemList;
	

	public ItemRack() {
		this.presetItemList = new ArrayList<Item>();
		this.itemList = new ArrayList<Item>();
	}
	
	public void loadItems() {
		presetItemList.add(new Item("BriocheBread", 346.0, true, 34));
        presetItemList.add(new Item("SesameBread", 140.0, true, 20));
        presetItemList.add(new Item("RyeBread", 259.0, true, 48));
        presetItemList.add(new Item("WholewheatBread", 265.0, true, 40));
        presetItemList.add(new Item("PotatoBread", 266.0, true, 33));
        presetItemList.add(new Item("JackBread", 100.0, true, 100));
        presetItemList.add(new Item("AngusBeef", 164.0, true, 144));
        presetItemList.add(new Item("WagyuBeef", 250.0, true, 795));
        presetItemList.add(new Item("TapaBeef", 187.75, true, 56));
        presetItemList.add(new Item("CheesedBeef", 373.0, true, 214));
        presetItemList.add(new Item("CanadianBacon", 185.0, true, 140));
        presetItemList.add(new Item("WienerSchnitzel", 297.0, true, 175));
        presetItemList.add(new Item("GrilledSalmon", 208.0, true, 300));
        presetItemList.add(new Item("BronzeTurkey", 189.0, true, 185));
        presetItemList.add(new Item("BeyondBeef", 210.0, true, 330));
        presetItemList.add(new Item("JackBeef", 100.0, true, 100));
		
        presetItemList.add(new Item("WhiteOnions", 40.0, false, 30));
        presetItemList.add(new Item("OnionRings", 205.5, false, 85));
        presetItemList.add(new Item("TrappistCheese", 355.0, false, 140));
        presetItemList.add(new Item("MozzarelaCheese", 140.0, false, 75));
        presetItemList.add(new Item("BlueCheese", 177.0, false, 105));
        presetItemList.add(new Item("AmericanCheese", 177.0, false, 40));
        presetItemList.add(new Item("MeltedButter", 307.5, false, 60));
        presetItemList.add(new Item("BeefsteakTomato", 18.0, false, 50));
        presetItemList.add(new Item("IcebergLettuce", 3.0, false, 45));
        presetItemList.add(new Item("DillPickles", 11.0, false, 45));
        presetItemList.add(new Item("HotSauce", 11.0, false, 50));
        presetItemList.add(new Item("BarbequeSauce", 172.0, false, 70));
        presetItemList.add(new Item("CaviarSauce", 252.0, false, 330));
        presetItemList.add(new Item("JackSauce", 10.0, false, 10));
	}
	
	public void autoAddItems(ArrayList<Recipe> recipeList) {
		
	}
	
	public void convertToIngredient(Item item, int quantity) {
		
	}
	
	public void addItem(String name, double calories, boolean standalone, int price) {
		
	}
	
	public ArrayList<Item> getPresetItems() {
		
	}
	
	public ArrayList<Item> getItemsOnSale() {
		
	}
}