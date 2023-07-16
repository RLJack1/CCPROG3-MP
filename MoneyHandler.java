import java.util.Scanner;
import java.io.NumberFormatException;

/** 
  * Stores and conducts operations on all money inside the Vending Machine
  */
public class MoneyHandler {
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
	  */
	public MoneyHandler() {
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
		
		this.displayDenomList();
	}
	
	/** 
	  * Displays the stock of all bills inside the Vending Machine
	  */
	public void displayDenomList() {
		for(int i = 0; i < this.cashBox.length; i++) {
			System.out.println("P" + this.cashBox[i][0] + ": " + this.cashBox[i][1] + " stored.");
		}
	}
	
	/** 
	  * Gets money input from the user and stores it into the holder (basically temp) array
	  * @param s The active scanner object
	  */
	public void inputDenominations(Scanner s) {	
		try { 
			System.out.println("Enter the denominations separated by spaces:");
			s.nextLine();
			String inputLine = s.nextLine();
			String[] denominations = inputLine.split(" ");
			
			for(int i = 0; i < denominations.length; i++) {
				switch(Integer.parseInt(denominations[i])){
					case 1000 -> {this.holder[0][1]++; System.out.println("1000 inserted...");}
					case 500 -> {this.holder[1][1]++; System.out.println("500 inserted...");}
					case 100 -> {this.holder[2][1]++; System.out.println("100 inserted...");}
					case 50 -> {this.holder[3][1]++; System.out.println("50 inserted...");}
					case 20 -> {this.holder[4][1]++; System.out.println("20 inserted...");}
					case 10 -> {this.holder[5][1]++; System.out.println("10 inserted...");}
					case 5 -> {this.holder[6][1]++; System.out.println("5 inserted...");}
					case 1 -> {this.holder[7][1]++; System.out.println("1 inserted...");}
					default -> System.out.println("Denomination " + denominations[i] + " not recognized, skipping input...");
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	  * Completely empties the cashBox
	  */
	public void cashOut() {
		for(int i = 0; i < this.cashBox.length; i++) {
			this.cashBox[i][1] = 0;
		}
	}
	
	/** 
	  * Deducts (or cashes out) a bill's stock by an amount
	  * @param denomination	The bill value to be cashed out
	  * @param numOfDenom	The number of bills to be cashed out
	  */
	public void cashOne(int denomination, int numOfDenom) {
		boolean success = false;
		int row = 99;
		
		//looks for the index where the bill blongs
		for(int i = 0; i < this.cashBox.length; i++) {
			if(this.cashBox[i][0] == denomination) {
				row = i;
				success = true;
			}
		}
		
		if(numOfDenom <= 0) {
			System.out.println("Invalid input.");
			success = false;
		}
		
		if(success) {
			if(numOfDenom > this.cashBox[row][1]) {
				success = false;
				System.out.println("Oops! Not enough biils to dispense.");
			}
				
			else {
				this.cashBox[row][1] -= numOfDenom;
				System.out.println("Cashing out " + numOfDenom + " " + this.cashBox[row][0] + " bills...");
				System.out.println("Cash out success!");
			}	
		}
		
		else
			System.out.println("Oops! Invalid bill input.");
	}
	
	/** 
	  * Replenishes a bill's stock by an amount
	  * @param denomination	The bill value to be replenished
	  * @param denomAdd		The number of bills to be replenished
	  * @return Whether or not the bill value was valid
	  */
	public boolean refillOne(int denomination, int denomAdd) {
		boolean success = true;
		
		switch(denomination){
            case 1000 -> cashBox[0][1] += denomAdd;
            case 500 -> cashBox[1][1] += denomAdd;
            case 100 -> cashBox[2][1] += denomAdd;
            case 50 -> cashBox[3][1] += denomAdd;
			case 20 -> cashBox[4][1] += denomAdd;
            case 10 -> cashBox[5][1] += denomAdd;
            case 5 -> cashBox[6][1] += denomAdd;
            case 1 -> cashBox[7][1] += denomAdd;
			default -> success = false;
        }
		
		return success;
	}
	
	/** 
	  * Conducts the payment process during product transaction
	  * @param selectedItem	The item selected by the user for purchase
	  * @param s			The active scanner object
	  * @return Whether or not the payment was successfully performed
	  */
	public boolean payment(Item selectedItem, Scanner s) {
		boolean releaseAll = false;	
		boolean enoughStock = true;
		boolean success = false;
		char c = '\0';
		int cashIn = this.getCashIn();
		int price = selectedItem.getPrice();
		int change = cashIn - price;
		int i = 0;
		
		System.out.print("Proceed with transaction? Type Y to proceed and N to cancel. Y/N\n" + "Input: ");
		
		//gets input
		if(s.hasNextLine()) {
			c = s.next().charAt(0);
			c = Character.toLowerCase(c);
			s.nextLine();
		}
		
		//transfer all holder money into cashBox
		System.out.println("Loading money into the cashbox...");
		for(i = 0; i < this.holder.length; i++) {
			this.cashBox[i][1] += this.holder[i][1];
		}
		
		//payment procedures
		if(c == 'y') {
			//if the user gave enough
			if(change >= 0) {
				//break down change
				this.breakdownChange(change);
				
				//check enough
				enoughStock = checkChange();
				
				//if enough
				if(enoughStock) {
					//load money from cashBox to change
					System.out.println("Getting your change ready...");
					for(i = 0; i < this.changeArray.length; i++) {
						if(this.changeArray[i][1] > 0) 
							this.cashBox[i][1] -= this.changeArray[i][1];
					}
					
					//empty change array
					System.out.println("Ka-ching! Change has been dispensed.");
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
					System.out.println("Oh no! This Vending Machine doesn't have enough change.");
					releaseAll = true;
				}
			}
			
			//user didn't give enough
			else {
				System.out.println("Oops! Not enough money was inserted.");
				releaseAll = true;
			}
		}
		
		//the user wants to cancel
		else 
			releaseAll = true;
		
		//if anything failed
		if(releaseAll) {
			System.out.println("Canceling transaction...");
			System.out.println("Releasing full change...");
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
	  * Splits the user's given change into its separate bill form
	  * @param change The total amount of change to be issued
	  */
	public void breakdownChange(int change) {
		System.out.println("Breaking down change...");
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
		System.out.println("Checking if there are enough bills to give change...");
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
	  * Finds the number of bill stock given the bill's index
	  * @param index	The index of the bill
	  * @return The available stock of the bill
	  */
	public int getCashBoxAmount(int index) {
		return this.cashBox[index][1];
	}
	
	/** 
	  * Sets the stock of a certain bill to a new amount
	  * @param index	The index of the bill
	  * @param amount	The new amount of stock
	  */
	public void setCashBox(int index, int amount) {
		this.cashBox[index][1] = amount;
	}
}