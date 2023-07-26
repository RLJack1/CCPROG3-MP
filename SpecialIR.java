/*MAIN TASKS: handles recipes and ingredients
 *			: getters and setters
 */
 
public class SpecialIR extends ItemRack {
	public SpecialIR() {
	}
	
	@Override
	public void newItemRack() {
		this.itemList.add(new Bread("BriocheBread", 346.0, true, 34));
        this.itemList.add(new Bread("SesameBread", 140.0, true, 20));
        this.itemList.add(new Bread("RyeBread", 259.0, true, 48));
        this.itemList.add(new Bread("WholewheatBread", 265.0, true, 40));
        this.itemList.add(new Bread("PotatoBread", 266.0, true, 33));
        this.itemList.add(new Bread("JackBread", 100.0, true, 100));
        this.itemList.add(new Meat("AngusBeef", 164.0, true, 144));
        this.itemList.add(new Meat("WagyuBeef", 250.0, true, 795));
        this.itemList.add(new Meat("TapaBeef", 187.75, true, 56));
        this.itemList.add(new Meat("CheesedBeef", 373.0, true, 214));
        this.itemList.add(new Meat("CanadianBacon", 185.0, true, 140));
        this.itemList.add(new Meat("WienerSchnitzel", 297.0, true, 175));
        this.itemList.add(new Meat("GrilledSalmon", 208.0, true, 300));
        this.itemList.add(new Meat("BronzeTurkey", 189.0, true, 185));
        this.itemList.add(new Meat("BeyondBeef", 210.0, true, 330));
        this.itemList.add(new Meat("JackBeef", 100.0, true, 100));
		
        this.itemList.add(new Topping("WhiteOnions", 40.0, false, 30));
        this.itemList.add(new Topping("OnionRings", 205.5, false, 85));
        this.itemList.add(new Topping("TrappistCheese", 355.0, false, 140));
        this.itemList.add(new Topping("MozzarelaCheese", 140.0, false, 75));
        this.itemList.add(new Topping("BlueCheese", 177.0, false, 105));
        this.itemList.add(new Topping("AmericanCheese", 177.0, false, 40));
        this.itemList.add(new Topping("MeltedButter", 307.5, false, 60));
        this.itemList.add(new Topping("BeefsteakTomato", 18.0, false, 50));
        this.itemList.add(new Topping("IcebergLettuce", 3.0, false, 45));
        this.itemList.add(new Topping("DillPickles", 11.0, false, 45));
        this.itemList.add(new Condiment("HotSauce", 11.0, false, 50));
        this.itemList.add(new Condiment("BarbequeSauce", 172.0, false, 70));
        this.itemList.add(new Condiment("CaviarSauce", 252.0, false, 330));
        this.itemList.add(new Condiment("JackSauce", 10.0, false, 10));
		
		for(Item i : itemList) {
			this.addFullStock(i, 9);
		}
	}
}