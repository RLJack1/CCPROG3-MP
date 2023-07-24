public class Transaction {
	private String name;
	private int lastTotalSales;
	private int totalSales;
	private boolean isSpecial;
	
	public Transaction(String name, int lastTotalSales, int totalSales, boolean isSpecial) {
		this.name = name;
		this.lastTotalSales = lastTotalSales;
		this.totalSales = totalSales;
		this.isSpecial = isSpecial;
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
	
	public boolean getIsSpecial() {
		return this.isSpecial;
	}
}