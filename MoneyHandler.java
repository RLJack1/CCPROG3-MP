import java.util.Scanner;

/** 
  * Stores and conducts operations on all money stored
  */
public class MoneyHandler {
	private VMController c;
	private int[][] cashBox = {
	  {1000, 0},
	  {500, 0},
	  {100, 0},
	  {50, 0},
	  {20, 0},
	  {10, 0},
	  {5, 0},
	  {1, 0}
	};
	
	private int[][] holder = {
	  {1000, 0},
	  {500, 0},
	  {100, 0},
	  {50, 0},
	  {20, 0},
	  {10, 0},
	  {5, 0},
	  {1, 0}
	};
	
	private int[][] changeArray = {
	  {1000, 0},
	  {500, 0},
	  {100, 0},
	  {50, 0},
	  {20, 0},
	  {10, 0},
	  {5, 0},
	  {1, 0}
	};
	
	/** 
	  * A constructor that creates an instance of the ProductDispenser object.
	  * @param c The controller the that instantiated the Vending Machine that instantiated this Money Handler
	  */
	public MoneyHandler(VMController c) {
		this.c = c;
	}
	
	/** 
	  * Called to initialize the cashBox to default values.
	  * Only used when a new Vending Machine is created.
	  */
	public void newCashBox() {
		int amount = 100;
		
		for(int i = 0; i < this.cashBox.length; i++) {
			this.cashBox[i][1] = amount;
			amount += 150;
		}
	}
	
	/** 
	  * Gets money input from the user and stores it into the holder (basically temp) array
	  * @param amount The bill or amount that was added by the user
	  */
	public void inputDenominations(int amount) {	
		String toDisplay = "";
		
		try { 
			for(int i = 0; i < holder.length; i++) {
				switch(amount){
					case 1000 -> {this.holder[0][1]++; toDisplay = "1000 inserted...";}
					case 500 -> {this.holder[1][1]++; toDisplay = "500 inserted...";}
					case 100 -> {this.holder[2][1]++; toDisplay = "100 inserted...";}
					case 50 -> {this.holder[3][1]++; toDisplay = "50 inserted...";}
					case 20 -> {this.holder[4][1]++; toDisplay = "20 inserted...";}
					case 10 -> {this.holder[5][1]++; toDisplay = "10 inserted...";}
					case 5 -> {this.holder[6][1]++; toDisplay = "5 inserted...";}
					case 1 -> {this.holder[7][1]++; toDisplay = "1 inserted...";}
					default -> toDisplay = "Denomination " + amount + " not recognized, skipping input...";
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		c.displayText(toDisplay);
	}
	
	/** 
	  * Conducts the payment process during product transaction for single items
	  * @param selectedItem	The item selected by the user for purchase
	  * @return Whether or not the payment was successfully performed
	  */
	public boolean payment(Item selectedItem) {
		boolean releaseAll = false;	
		boolean enoughStock = true;
		boolean success = false;
		int userChoice = 0;
		int cashIn = this.getCashIn();
		int price = selectedItem.getPrice();
		int change = cashIn - price;
		int i = 0;
		
		//transfer all holder money into cashBox
		for(i = 0; i < this.holder.length; i++) {
			this.cashBox[i][1] += this.holder[i][1];
		}

		//if the user gave enough
		if(change >= 0) {
			//break down change
			this.breakdownChange(change);
			
			//check enough
			enoughStock = checkChange();
			
			//if enough
			if(enoughStock) {
				//load money from cashBox to change
				this.c.displayText("Getting your change ready...");
				for(i = 0; i < this.changeArray.length; i++) {
					if(this.changeArray[i][1] > 0) 
						this.cashBox[i][1] -= this.changeArray[i][1];
				}
				
				//empty change array
				this.c.displayText("Ka-ching! Change has been dispensed.");
				for(i = 0; i < this.changeArray.length; i++) {
					this.changeArray[i][1] = 0;
				}

				for(i = 0; i < this.holder.length; i++) {
					if(this.holder[i][1] > 0) {
						this.cashBox[i][1] -= this.holder[i][1];
					}
					this.holder[i][1] = 0;
				}
				
				success = true;
			}
			
			//not enough stock
			else {
				this.c.displayText("Oh no! This Vending Machine doesn't have enough change.");
				releaseAll = true;
			}
		}
		
		//user didn't give enough
		else {
			this.c.displayText("Oops! Not enough money was inserted.");
			releaseAll = true;
		}
		
		//if anything failed
		if(releaseAll) {
			this.c.displayText("Canceling transaction...");
			this.c.displayText("Releasing full change...");
			for(i = 0; i < this.holder.length; i++) {
				if(this.holder[i][1] > 0) {
					this.cashBox[i][1] -= this.holder[i][1];
				}
				this.holder[i][1] = 0;
			}		
		}

		return success;
	}
	
	/** 
	  * Conducts the payment process during product transaction for recipes
	  * @param selectedRecipe The selected recipe by the user for purchase
	  * @return Whether or not the payment was successfully performed
	  */
	public boolean payment(Recipe selectedRecipe) {
		boolean releaseAll = false;	
		boolean enoughStock = true;
		boolean success = false;
		int cashIn = this.getCashIn();
		int price = selectedRecipe.getPrice();
		int change = cashIn - price;
		int i = 0;
		
		//transfer all holder money into cashBox
		for(i = 0; i < this.holder.length; i++) {
			this.cashBox[i][1] += this.holder[i][1];
		}
		
		//payment procedures
		//if the user gave enough
		if(change >= 0) {
			//break down change
			this.breakdownChange(change);
			
			//check enough
			enoughStock = checkChange();
			
			//if enough
			if(enoughStock) {
				//load money from cashBox to change
				this.c.displayText("Getting your change ready...");
				for(i = 0; i < this.changeArray.length; i++) {
					if(this.changeArray[i][1] > 0) 
						this.cashBox[i][1] -= this.changeArray[i][1];
				}
				
				//empty change array
				this.c.displayText("Ka-ching! Change has been dispensed.");
				for(i = 0; i < this.changeArray.length; i++) {
					this.changeArray[i][1] = 0;
				}

				for(i = 0; i < this.holder.length; i++) {
					if(this.holder[i][1] > 0) {
						this.cashBox[i][1] -= this.holder[i][1];
					}
					this.holder[i][1] = 0;
				}
				
				success = true;
			}
			
			//not enough stock
			else {
				this.c.displayText("Oh no! This Vending Machine doesn't have enough change.");
				releaseAll = true;
			}
		}
		
		//user didn't give enough
		else {
			this.c.displayText("Oops! Not enough money was inserted.");
			releaseAll = true;
		}
		
		//if anything failed
		if(releaseAll) {
			this.c.displayText("Canceling transaction...");
			this.c.displayText("Releasing full change...");
			for(i = 0; i < this.holder.length; i++) {
				if(this.holder[i][1] > 0) {
					this.cashBox[i][1] -= this.holder[i][1];
				}
				this.holder[i][1] = 0;
			}		
		}

		return success;
	}
	
	/** 
	  * Releases all cash in the holder
	  */
	public void releaseAll() {
		for(int i = 0; i < this.holder.length; i++) {
			this.holder[i][1] = 0;
		}
	}
	
	/** 
	  * Splits the user's given change into its separate bill form
	  * @param change The total amount of change to be issued
	  */
	public void breakdownChange(int change) {
		this.c.displayText("Breaking down change...");
		int numBills = 0;
		
		for(int i = 0; i < this.changeArray.length; i++) {
			numBills = change / this.changeArray[i][0];
			this.changeArray[i][1] += numBills;
			change %= this.changeArray[i][0];
		}
	}
	
	/** 
	  * Checks if the Vending Machine has sufficient bills to dispense needed change
	  * @return Whether there is enough bill stock for dispensing
	  */
	public boolean checkChange() {
		this.c.displayText("Checking if there are enough bills to give change...");
		boolean enoughChange = true;
		
		for(int i = 0; i < this.changeArray.length; i++) {
			if(cashBox[i][1] - this.changeArray[i][1] < 0)
				enoughChange = false;
		}

		return enoughChange;
	}
	
	/** 
	  * Computes for and returns the sum of money stored in this Vending Machine's cashBox
	  * @return The total amount of money stored in the cashBox of the Vending Machine
	  */
	public int getTotal() {
		int total = 0;
		
		for(int i = 0; i < this.cashBox.length; i++)
			total += (this.cashBox[i][0] * this.cashBox[i][1]);
		
		return total;
	}
	
	/** 
	  * Computes for and returns the sum of money stored in this Vending Machine's holder array
	  * @return The total amount of money stored in the holder array of the Vending Machine
	  */
	public int getCashIn() {
		int total = 0;
		
		for(int i = 0; i < this.holder.length; i++)
			total += (this.holder[i][0] * this.holder[i][1]);
		
		return total;
	}
	
	/** 
	  * Completely empties the CashBox
	  */
	public void setCashBox() {
		for(int i = 0; i < this.cashBox.length; i++)
			this.cashBox[i][1] = 0;
	}
	
	/** 
	  * Reduces a bill's stock 
	  * @param index	The index of the bill
	  * @param amount	The amount to reduce
	  */
	public void cashOut(int index, int amount) {
		this.cashBox[index][1] -= amount;
	}
	
	/** 
	  * Increases a bill's stock 
	  * @param index	The index of the bill
	  * @param amount	The amount to added
	  */
	public void cashIn(int index, int amount) {
		this.cashBox[index][1] += amount;
	}
	
	/** 
	  * Shows how many of each bill are stored
	  * @return The plain text equivalent of the values to display 
	  */
	public String displayCashBox() {
		String toDisplay = "";
		
		for(int i = 0; i < this.cashBox.length; i++) {
			toDisplay.concat("\nAmount of " + this.cashBox[i][0] + " bills stored: " + this.cashBox[i][1]);
		}
		
		return toDisplay;
	}
	
	/** 
	  * Gets and returns the CashBox of this Money Handler
	  * @return The 2D array of the CashBox contents
	  */
	public int[][] getCashBox() {
		return this.cashBox;
	}
}