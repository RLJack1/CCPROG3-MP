import java.util.Scanner;

public class MoneyHandler {
	private int[][] cashBox = {
	  {1000, 0},
	  {500, 0},
	  {200, 0},
	  {100, 0},
	  {50, 0},
	  {10, 0},
	  {5, 0},
	  {1, 0}
	};
	
	public MoneyHandler() {
		int amount = 10;
	
		for(int i = 0; i < cashBox.length; i++) {
			cashBox[i][1] = amount;
			amount += 15;
		}
		
		this.displayDenomList();
	}
	
	public void displayDenomList() {
		for(int i = 0; i < cashBox.length; i++) {
			System.out.println("P" + cashBox[i][0] + ": " + cashBox[i][1] + " stored.");
		}
	}
	
	public void inputDenominations(Scanner s) {
		
	}
	
	public boolean cashOut() {
		boolean success = false;
		
		return success;
	}
	
	public boolean cashOne(int denomination, int numOfDenom) {
		boolean success = false;
		
		return success;
	}
	
	public void refillOne(int denomination, int denomAdd) {
		
	}
	
	public boolean checkChange(int cashIn, int productPrice) {
		boolean success = false;
		
		return success;
	}
	
	public int getTotal() {
		int total = 0;
		
		for(int i = 0; i < cashBox.length; i++)
			total += (cashBox[i][0] * cashBox[i][1]);
		
		return total;
	}
}