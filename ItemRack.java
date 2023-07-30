import java.util.ArrayList;

/** 
  * Stores the item presets and items on sale
  */
public class ItemRack {
	protected ArrayList<Item> itemList;
	protected String[] indexList = {"BriocheBread", "SesameBread", "RyeBread", "WholewheatBread", "PotatoBread",
									"JackBread", "AngusBeef", "WagyuBeef", "TapaBeef", "CheesedBeef", 
									"CanadianBacon", "WienerSchnitzel", "GrilledSalmon", "BronzeTurkey", "BeyondBeef", 
									"JackBeef", "WhiteOnions", "OnionRings", "TrappistCheese", "MozzarelaCheese",
									"BlueCheese", "AmericanCheese", "MeltedButter", "BeefsteakTomato", "IcebergLettuce",
									"DillPickles", "HotSauce", "BarbequeSauce", "CaviarSauce", "JackSauce"};

	/** 
      * Creates an instance of the ItemRack object
      */
	public ItemRack() {
		this.itemList = new ArrayList<Item>();
	}
	
	/** 
      * Loads all the preset items into the ItemRack
      */
	public void newItemRack() {
		this.itemList.add(new Item("BriocheBread", 346.0, true, 34));
        this.itemList.add(new Item("SesameBread", 140.0, true, 20));
        this.itemList.add(new Item("RyeBread", 259.0, true, 48));
        this.itemList.add(new Item("WholewheatBread", 265.0, true, 40));
        this.itemList.add(new Item("PotatoBread", 266.0, true, 33));
        this.itemList.add(new Item("JackBread", 100.0, true, 100));
        this.itemList.add(new Item("AngusBeef", 164.0, true, 144));
        this.itemList.add(new Item("WagyuBeef", 250.0, true, 795));
        this.itemList.add(new Item("TapaBeef", 187.75, true, 56));
        this.itemList.add(new Item("CheesedBeef", 373.0, true, 214));
        this.itemList.add(new Item("CanadianBacon", 185.0, true, 140));
        this.itemList.add(new Item("WienerSchnitzel", 297.0, true, 175));
        this.itemList.add(new Item("GrilledSalmon", 208.0, true, 300));
        this.itemList.add(new Item("BronzeTurkey", 189.0, true, 185));
        this.itemList.add(new Item("BeyondBeef", 210.0, true, 330));
        this.itemList.add(new Item("JackBeef", 100.0, true, 100));
		
        this.itemList.add(new Item("WhiteOnions", 40.0, false, 30));
        this.itemList.add(new Item("OnionRings", 205.5, false, 85));
        this.itemList.add(new Item("TrappistCheese", 355.0, false, 140));
        this.itemList.add(new Item("MozzarelaCheese", 140.0, false, 75));
        this.itemList.add(new Item("BlueCheese", 177.0, false, 105));
        this.itemList.add(new Item("AmericanCheese", 177.0, false, 40));
        this.itemList.add(new Item("MeltedButter", 307.5, false, 60));
        this.itemList.add(new Item("BeefsteakTomato", 18.0, false, 50));
        this.itemList.add(new Item("IcebergLettuce", 3.0, false, 45));
        this.itemList.add(new Item("DillPickles", 11.0, false, 45));
        this.itemList.add(new Item("HotSauce", 11.0, false, 50));
        this.itemList.add(new Item("BarbequeSauce", 172.0, false, 70));
        this.itemList.add(new Item("CaviarSauce", 252.0, false, 330));
        this.itemList.add(new Item("JackSauce", 10.0, false, 10));
		
		ArrayList<Item> addedItemList = new ArrayList<Item>();
		
		for(Item i : itemList) {
			for(int j = 0; j < 10; j++) 
			addedItemList.add(new Item(i.getName(), i.getCalories(), i.getStandalone(), i.getPrice()));	
		}
		
		this.itemList.addAll(addedItemList);
	}
		
	/** 
      * Fully refills the item's stock
	  * @param item The item to be fully restocked
      */
	public void addFullStock(Item item) {
		int count = 0;
		
		for(Item i : this.itemList) {
			if(i.getName().equals(item.getName()))
				count++;
		}
		
		int neededStock = 10 - count;
		
		for(int j = 0; j <= neededStock; j++)
			this.itemList.add(new Item(item.getName(), item.getCalories(), item.getStandalone(), item.getPrice()));
	}
	
	/** 
      * Adds all items from an array to ItemList
	  * @param temp The list of item objects to be added
      */
	public void addAll(ArrayList<Item> temp) {
		this.itemList.addAll(temp);
	}
	
	/** 
      * Removes an item from ItemList
	  * @param item The item object to be removed
      */
	public void removeItem(Item item) {
		this.itemList.remove(item);
	}
	
	/** 
      * Counts how many instances of an item exist in ItemList (basically stock)
	  * @param name The name of the item to count stock for
	  * @return The stock of the item
      */
	public int countStock(String name) {
		int stock = 0;
		
		for(Item i : itemList) {
			if(i.getName().equals(name))
				stock++;
		}
		
		return stock;
	}
	
	/** 
      * Removes all objects from ItemList
      */
	public void clearItemList() {
		this.itemList.clear();
	}
	
	/** 
      * Gets and returns the item at a given index of ItemList
	  * @param index The index of the item
	  * @return The item at the index
      */
	public Item getItemAt(int index) {
		String name = this.indexList[index];
		Item item = null;
		
		for(Item i : this.itemList) {
			if(i.getName().equals(name))
				item = i;
		}
		
		return item;
	}
	
	/** 
      * Gets and returns list of items on sale (in stock)
	  * @return The list of items on sale
      */
	public ArrayList<Item> getItemsOnSale() {
		return this.itemList;
	}
	
	/** 
      * Counts how many unique items exist in ItemList
	  * @return The number of unique items
      */
	public int getNumUnique() {
		int count = 0;
		boolean dupe = false;
		
		for(Item i : itemList) {
			for(Item j : itemList) {
				if(i.getName().equals(j.getName())) 
					dupe = true;
			}
			
			if(dupe ==  false)
				count++;
			
			dupe = false;
		}
		
		return count;
	}
}