public class Transaction {
	private String name;
	private int lastTotalSales;
	private int totalSales;
	
	public Transaction(String name, int lastTotalSales, int totalSales) {
		this.name = name;
		this.lastTotalSales = lastTotalSales;
		this.totalSales = totalSales;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLastTotalSales() {
		return this.lastTotalSales;
	}
	
	public int getTotalSales() {
		return this.totalSales;
	}
}