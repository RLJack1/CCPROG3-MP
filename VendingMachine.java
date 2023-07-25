/*MAIN TASKS: stores the basic details of the vending machine (done)
 *			: stores all the objects needed 
 *			: getters and setters
 */

public class VendingMachine {
	private String machineName;
	private int totalSales;
	private int lastTotalSales;
	protected MoneyHandler mh;
	protected ItemRack ir;
	
	public VendingMachine() {
		this.machineName = null;
		this.totalSales = 0;
		this.lastTotalSales = 0;
		mh = new MoneyHandler();
		ir = new ItemRack();
	}
	
	public VendingMachine(String machineName, int totalSales, int lastTotalSales) {
		this.machineName = machineName;
		this.totalSales = totalSales;
		this.lastTotalSales = lastTotalSales;
		mh = new MoneyHandler();
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