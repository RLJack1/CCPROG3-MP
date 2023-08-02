/** 
  * Stores Vending Machine information and conducts direct operations on VM attributes
  */
public class VendingMachine {
	private String machineName;
	private int totalSales;
	private int lastTotalSales;
	protected MoneyHandler mh;
	protected ItemRack ir;
	
	/** 
	  * A constructor that creates an instance of the VendingMachine object.
	  * @param c				The controller wherein the Vending Machine was instantiated
	  * @param machineName		The name of this Vending Machine
	  * @param totalSales		The current total sales since last restock
	  * @param lastTotalSales	The last total sales since last restock
	  */
	public VendingMachine(VMController c, String machineName, int totalSales, int lastTotalSales) {
		this.machineName = machineName;
		this.totalSales = totalSales;
		this.lastTotalSales = lastTotalSales;
		mh = new MoneyHandler(c);
		ir = new ItemRack();
	}
	
	/** 
      * Gets and returns the name of this Vending Machine
	  * @return The machine's name
      */
	public String getName() {
		return this.machineName;
	}
	
	/** 
      * Gets and returns the current total sales from the last restocking
	  * @return The current total sales
      */
	public int getTotalSales() {
		return this.totalSales;
	}
	
	/** 
      * Gets and returns the last saved total sales from the last restocking
	  * @return The last saved total sales
      */
	public int getLastTotalSales() {
		return this.lastTotalSales;
	}
	
	/** 
      * Changes the Vending Machine's name to a new one
	  * @param newName The new name of this VendingMachine object
      */
	public void setMachineName(String newName) {
		this.machineName = newName;
	}
	
	/** 
      * Changes the value of the saved total sales to a new value
	  * @param newAmount The new amount of total sales
      */
	public void setTotalSales(int newAmount) {
		this.totalSales = newAmount;
	}
	
	/** 
      * Increases the total sales since last restock by the specified amount
	  * @param amountToAdd The amount by which the total sales will increase
      */
	public void addTotalSales(int amountToAdd) {
		this.totalSales += amountToAdd;
	}
	
	/** 
      * Changes the value of the last saved total sales to a new value
	  * @param newAmount The new amount of last saved total sales
      */
	public void setLastTotalSales(int newAmount) {
		this.lastTotalSales = newAmount;
	}
}