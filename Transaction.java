/** 
  * Stores all information associated with one user purchase
  */
public class Transaction {
	private String name;
	private int lastTotalSales;
	private int totalSales;
	
	/** 
	  * Creates an instance of the Transaction object
	  * @param name				The name of the product purchased
	  * @param lastTotalSales	The last amount of sales since last restocking
	  * @param totalSales		The current amount of sales since last restocking
	  */
	public Transaction(String name, int lastTotalSales, int totalSales) {
		this.name = name;
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
}