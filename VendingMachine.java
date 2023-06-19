import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    private String machineName;
    private boolean isSpecial;
    default ArrayList<Item> itemList;
	private int cashIn;
	private Item selectedItem;
	
	public VendingMachine(String machineName, boolean isSpecial) {
		this.machineName = machineName;
		this.isSpecial = isSpecial;
		this.cashIn = 0;
		this.selectedItem = null;
		itemList = new ArrayList<Item>;
	}
    
	public void displayMenu() {
		int userChoice = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Welcome to The Founding Fathers' Vending Pantry!\n" + 
							 "(1) Build a Vending Machine\n" +
							 "(2) Test a Vending Machine\n" +
							 "(3) Leave and Exit" +
							 "Select: ");
			userChoice = input.nextInt();
			
			//Create VM
			if(userChoice == 1) {
				VendingMachine.createMenu();
			}
			
			//Test or Maintain
			else if(userChoice == 2) {
				int menuChoice = 0;
				
				do {
					System.out.print("=============================="
								 "Welcome to The Founding Fathers' Vending Pantry!\n" + 
								 "(1) Test Current Vending Machine Features\n" +
								 "(2) Perform Maintenance Features\n" +
								 "(3) Return to Main Menu" +
								 "Select: ")
					
					//Test
					if(menuChoice == 1) {
						
					}
					
					//Maintain
					else if(menuChoice == 2) {
						
					}
					
					//Return to main menu
					else if(menuChoice == 3) {
						System.out.println("Returning to Main Menu...");
						System.out.println("==============================");
					}
					
					//Error catch
					else {
						System.out.println("Invalid input. Please try again.");
						userChoice == 0;
					}
					
				} (while menuChoice != 3);
				
			}
			
			//Exit
			else if(userChoice == 3) {
				System.out.println("Thank you for coming!\n" +
								   "Exiting program...");
			}
			
			//Error catch
			else {
				System.out.println("Invalid input. Please try again.");
				System.out.println("==============================");
				userChoice == 0;
			}
			
		} while(userChoice != 3);
	}

    public void createMenu(String machineName, boolean machineType){
        
    }

    public void testMenu() {

    }

    public void maintainMenu() {

    }

	public static void main(String[] args) {
		VendingMachine.displayMenu();
	}
}
