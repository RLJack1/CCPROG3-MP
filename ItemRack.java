/*MAIN TASKS: stores (available preset items, itemlist)
 *			: getters and setters
 */

import java.util.ArrayList;

public class ItemRack {
	protected ArrayList<Item> presetItemList;
	protected ArrayList<Item> itemList;

	public ItemRack() {
		this.presetItemList = new ArrayList<Item>();
		this.itemList = new ArrayList<Item>();
	}
	
	public void loadItems() {
		this.presetItemList.add(new Item("BriocheBread", 346.0, true, 34, 1));
        this.presetItemList.add(new Item("SesameBread", 140.0, true, 20, 2));
        this.presetItemList.add(new Item("RyeBread", 259.0, true, 48, 3));
        this.presetItemList.add(new Item("WholewheatBread", 265.0, true, 40, 4));
        this.presetItemList.add(new Item("PotatoBread", 266.0, true, 33, 5));
        this.presetItemList.add(new Item("JackBread", 100.0, true, 100, 6));
        this.presetItemList.add(new Item("AngusBeef", 164.0, true, 144, 7));
        this.presetItemList.add(new Item("WagyuBeef", 250.0, true, 795, 8));
        this.presetItemList.add(new Item("TapaBeef", 187.75, true, 56, 9));
        this.presetItemList.add(new Item("CheesedBeef", 373.0, true, 214, 10));
        this.presetItemList.add(new Item("CanadianBacon", 185.0, true, 140, 11));
        this.presetItemList.add(new Item("WienerSchnitzel", 297.0, true, 175, 12));
        this.presetItemList.add(new Item("GrilledSalmon", 208.0, true, 300, 13));
        this.presetItemList.add(new Item("BronzeTurkey", 189.0, true, 185, 14));
        this.presetItemList.add(new Item("BeyondBeef", 210.0, true, 330, 15));
        this.presetItemList.add(new Item("JackBeef", 100.0, true, 100, 16));
		
        this.presetItemList.add(new Item("WhiteOnions", 40.0, false, 30, 17));
        this.presetItemList.add(new Item("OnionRings", 205.5, false, 85, 18));
        this.presetItemList.add(new Item("TrappistCheese", 355.0, false, 140, 19));
        this.presetItemList.add(new Item("MozzarelaCheese", 140.0, false, 75, 20));
        this.presetItemList.add(new Item("BlueCheese", 177.0, false, 105, 21));
        this.presetItemList.add(new Item("AmericanCheese", 177.0, false, 40, 22));
        this.presetItemList.add(new Item("MeltedButter", 307.5, false, 60, 23));
        this.presetItemList.add(new Item("BeefsteakTomato", 18.0, false, 50, 24));
        this.presetItemList.add(new Item("IcebergLettuce", 3.0, false, 45, 25));
        this.presetItemList.add(new Item("DillPickles", 11.0, false, 45, 26));
        this.presetItemList.add(new Item("HotSauce", 11.0, false, 50, 27));
        this.presetItemList.add(new Item("BarbequeSauce", 172.0, false, 70, 28));
        this.presetItemList.add(new Item("CaviarSauce", 252.0, false, 330, 29));
        this.presetItemList.add(new Item("JackSauce", 10.0, false, 10, 30));
	}
	
	public void newItemRack() {
		this.itemList.add(new Item("BriocheBread", 346.0, true, 34, 1));
        this.itemList.add(new Item("SesameBread", 140.0, true, 20, 2));
		this.itemList.add(new Item("RyeBread", 259.0, true, 48, 3));
        this.itemList.add(new Item("WholewheatBread", 265.0, true, 40, 4));
		this.itemList.add(new Item("AngusBeef", 164.0, true, 144, 7));
        this.itemList.add(new Item("WagyuBeef", 250.0, true, 795, 8));
		this.itemList.add(new Item("TapaBeef", 187.75, true, 56, 9));
        this.itemList.add(new Item("CheesedBeef", 373.0, true, 214, 10));
		
		for(Item i : itemList) {
			this.addFullStock(i, 7);
		}
	}
	
	public void addFullStock(Item i, int stock) {
		int j;
		
		for(j = 0; j <= stock; j++) {
			this.itemList.add(new Item(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice()));
		}
	}
	
	public void addItem(String name, double calories, boolean standalone, int price) {
		this.itemList.add(new Item(name, calories, standalone, price));
	}
	
	public void addItem(Item item) {
		this.itemList.add(item);
	}
	
	public void removeItem(Item item) {
		this.itemList.remove(item);
	}
	
	public void clearItemList() {
		this.itemList.clear();
	}
	
	public Item getPresetItemAt(int index) {
		return this.presetItemList.get(index);
	}
	
	public Item getItemAt(int index) {
		return this.itemList.get(index);
	}
	
	public ArrayList<Item> getPresetItems() {
		return this.presetItemList;
	}
	
	public ArrayList<Item> getItemsOnSale() {
		return this.itemList;
	}
}